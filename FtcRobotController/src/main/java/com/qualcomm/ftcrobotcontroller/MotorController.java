package com.qualcomm.ftcrobotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Julian on 3/5/2016.
 * Test
 */
public class MotorController {

    // Motor Variables
        // Variables for DCMotors
        private static DcMotor upperRightMotor;
        private static DcMotor lowerRightMotor;
        private static DcMotor upperLeftMotor;
        private static DcMotor lowerLeftMotor;
        private static DcMotor liftSpinnerR;
        private static DcMotor liftSpinnerL;
        private static DcMotor debrisCollectionSpinner;
        private static DcMotor debrisDepositorSpinner;

        // Variables for Servos
        private static Servo leftTrigger;
        private static Servo rightTrigger;
        private static Servo climberDepositor;
        private static Servo rfCowCatcher;
        private static Servo lfCowCatcher;
        private static Servo shoulderServo;
        private static Servo elbowServo;
        private static Servo leftDebrisRamp;
        private static Servo rightDebrisRamp;

        // Variables for Positions and Speeds
        private final static double CLMB_DEP_REST = 1;
        private final static double CLMB_DEP_UP = 0;

        private final static double RIGHT_TRIGGER_UP = 0.8;
        private final static double RT_MID = 0.2;
        private final static double RT_LOW = 0;
        private final static double LEFT_TRIGGER_UP = 0.2;
        private final static double LT_MID = 0.8;
        private final static double LT_LOW = 1;

        private final static double ELBW_POS_GOAL_MIN_VAL = 0;
        private final static double ELBW_POS_GOAL_MAX_VAL = 1;
        private final static double ELBW_POS_MIN_VAL = 0.7;
        private final static double ELBW_POS_MAX_VAL = 0.9;

        private final static double SHLDR_POS_GOAL_MIN_VAL = 0;
        private final static double SHLDR_POS_GOAL_MAX_VAL = 1;
        private final static double SHLDR_POS_MIN_VAL = 0.15;
        private final static double SHLDR_POS_MAX_VAL = 0.5;

        private final static double LEFT_FRONT_COW_CATCHER_UP = 0.2;
        private final static double LEFT_FRONT_COW_CATCHER_DOWN = 0.65;
        private final static double RIGHT_FRONT_COW_CATCHER_UP = 0.8;
        private final static double RIGHT_FRONT_COW_CATCHER_DOWN = 0.35;
        private final static double LEFT_REAR_COW_CATCHER_UP = 0;
        private final static double RIGHT_REAR_COW_CATCHER_UP = 1;
        private final static double LEFT_REAR_COW_CATCHER_DOWN = 1;
        private final static double RIGHT_REAR_COW_CATCHER_DOWN = 0;

        private final static double LIFT_SPINNER_RIGHT_PWR_OUT = -1;
        private final static double LIFT_SPINNER_RIGHT_PWR_IN = 1;
        private final static double LIFT_SPINNER_LEFT_PWR_IN = 1;
        private final static double LIFT_SPINNER_LEFT_PWR_OUT = -1;

        private final static double LEFT_RAMP_UP = 0.1;
        private final static double LEFT_RAMP_DOWN = 0.5;
        private final static double RIGHT_RAMP_UP = 1;
        private final static double RIGHT_RAMP_DOWN = 0.4;

    // Variables for motor orientation
    private static boolean isFacingForwards = true;
    private static boolean activateTriggerIsLeft = true;

    // Variables for Autonomous Motion

        // Variables for getting distances and circumferences
        // Used in autonomous motion
        private static double PULSES_PER_REVOLUTION = 1120;
        private static double PULLEY_RADIUS = 0.048813; //Radius in m
        private static double PULLEY_CIRCUMFERENCE = PULLEY_RADIUS * 2 * Math.PI;
        private static double DISTANCE_FROM_CENTER_TO_TREAD = 192.0875;
        private static int TOO_MANY_TICKS_WITHOUT_MOVING = 50;

    private static OpMode currentOperator;

    public static void init(HardwareMap hardwareMap, OpMode operator)
    {
        //Naming which motors and servos are which
        upperRightMotor = hardwareMap.dcMotor.get("Upper_Right_Drive_Spinner");
        lowerRightMotor = hardwareMap.dcMotor.get("Lower_Right_Drive_Spinner");
        upperLeftMotor = hardwareMap.dcMotor.get("Upper_Left_Drive_Spinner");
        lowerLeftMotor = hardwareMap.dcMotor.get("Lower_Left_Drive_Spinner");
        liftSpinnerR = hardwareMap.dcMotor.get("Right_Lift_Spinner");
        liftSpinnerL = hardwareMap.dcMotor.get("Left_Lift_Spinner");
        debrisCollectionSpinner = hardwareMap.dcMotor.get("Intake_Spinner");
        debrisDepositorSpinner = hardwareMap.dcMotor.get("Debris_Depositor_Spinner");
        leftTrigger = hardwareMap.servo.get("Left_Trigger_Activator_Servo");
        rightTrigger = hardwareMap.servo.get("Right_Trigger_Activator_Servo");
        climberDepositor = hardwareMap.servo.get("Climber_Depositor_Servo");
        rfCowCatcher = hardwareMap.servo.get("Right_Cow_Catcher_Servo");
        lfCowCatcher = hardwareMap.servo.get("Left_Cow_Catcher_Servo");
        shoulderServo = hardwareMap.servo.get("Shoulder_Servo");
        elbowServo = hardwareMap.servo.get("Elbow_Servo");
        leftDebrisRamp = hardwareMap.servo.get("Left_Ramp_Servo");
        rightDebrisRamp = hardwareMap.servo.get("Right_Ramp_Servo");

        //Reversing the direction of the left motors due to positioning
        upperLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        lowerLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        liftSpinnerL.setDirection(DcMotor.Direction.REVERSE);

        isFacingForwards = true;

        currentOperator = operator;
    }

    /**
     * Call this function to reset all Servos to their initial position
     */
    public static void resetServos()
    {
        //Robot Preparing for Movement-in-game
        climberDepositor.setPosition(CLMB_DEP_REST);
        leftTrigger.setPosition(LEFT_TRIGGER_UP);
        rightTrigger.setPosition(RIGHT_TRIGGER_UP);
        lfCowCatcher.setPosition(LEFT_FRONT_COW_CATCHER_DOWN);
        rfCowCatcher.setPosition(RIGHT_FRONT_COW_CATCHER_DOWN);
        elbowServo.setPosition(ELBW_POS_MIN_VAL);
        shoulderServo.setPosition(SHLDR_POS_MIN_VAL);
        rightDebrisRamp.setPosition(RIGHT_RAMP_UP);
        leftDebrisRamp.setPosition(LEFT_RAMP_UP);
    }

    public static void displayMovementEncoderValues()
    {
        currentOperator.telemetry.addData("Left Motor Connection Info = ", upperLeftMotor.getConnectionInfo());
        currentOperator.telemetry.addData("Left Motor Encoder Value = ", upperLeftMotor.getCurrentPosition());

        currentOperator.telemetry.addData("Right Motor Connection Info = ", upperRightMotor.getConnectionInfo());
        currentOperator.telemetry.addData("Right Motor Encoder Value = ", upperRightMotor.getCurrentPosition());
    }

    public static void displayMovmentMotorValues()
    {
        currentOperator.telemetry.addData("Left Front Motor Power = ", upperLeftMotor.getPower());
        currentOperator.telemetry.addData("Left Back Motor Power = ", lowerLeftMotor.getPower());
        currentOperator.telemetry.addData("Right Front Motor Power = ", upperRightMotor.getPower());
        currentOperator.telemetry.addData("Right Back Motor Power = ", lowerRightMotor.getPower());
    }

    public static void setFacing(boolean facingDirection)
    {
        isFacingForwards = facingDirection;
    }

    public static void switchFacing()
    {
        isFacingForwards = !isFacingForwards;
    }

    // =======================================================================================
    // = DCMotor Functions === DCMotor Functions === DCMotor Functions === DCMotor Functions =
    // =======================================================================================

    /**
     * Sets "left" motors according to the direction you are facing
     * @param power
     */
    public static void setLeftMotors(double power)
    {
        if (isFacingForwards) // If you are heading forwards, work like normal tank drive
        {
            upperLeftMotor.setPower(power);
            lowerLeftMotor.setPower(power);
        }
        else // If you are heading backwards, flip which motors are controlled by which joystick and invert motor values
        {
            upperRightMotor.setPower(-power);
            lowerRightMotor.setPower(-power);
        }
    }

    /**
     * Sets "right" motors according to the direction you are facing
     * @param power
     */
    public static void setRightMotors(double power)
    {
        if (isFacingForwards) // If you are heading forwards, work like normal tank drive
        {
            upperRightMotor.setPower(power);
            lowerRightMotor.setPower(power);
        }
        else // If you are heading backwards, flip which motors are controlled by which joystick and invert motor values
        {
            upperLeftMotor.setPower(-power);
            lowerLeftMotor.setPower(-power);
        }
    }

    /**
     * A method for going forwards at a certain power
     * @param power
     */
    public static void setPowerForForwards(double power)
    {
        setLeftMotors(power);
        setRightMotors(power);
    }

    /**
     * A method for turning at a certain power.
     * Positive power turns towards the right
     * @param power
     */
    public static void setPowerForTurn(double power)
    {
        setLeftMotors(power);
        setRightMotors(-power);
    }

    // =======================================================================================================
    // = SERVO MOTOR FUNCTIONS === SERVO MOTOR FUNCTIONS === SERVO MOTOR FUNCTIONS === SERVO MOTOR FUNCTIONS =
    // =======================================================================================================

    /**
     * A method for setting the Servo that controls the deposition of climbers
     * to the position where it will deposit the climbers
     */
    public static void depositClimbers()
    {
        climberDepositor.setPosition(CLMB_DEP_UP);
    }

    /**
     * A method for setting the Servo that controls the deposition of climbers
     * to its resting position
     */
    public static void resetClimberDepositor()
    {
        climberDepositor.setPosition(CLMB_DEP_REST);
    }

    /**
     * A method for setting the position of the climberDepositor servo explicitly
     * @param position - What percentage of the range of the servo should the servo move to
     */
    public static void setClimberDepositor(double position)
    {
        climberDepositor.setPosition(position);
    }

    /**
     * A method for setting the trigger defined by the teleop to be up
     */
    public static void setTriggerUp()
    {
        if (activateTriggerIsLeft)
        {
            leftTrigger.setPosition(LEFT_TRIGGER_UP);
        }
        else
        {
            rightTrigger.setPosition(RIGHT_TRIGGER_UP);
        }
    }

    // ===================================================================================================================================
    // = Autonomous Utility Functions === Autonomous Utility Functions === Autonomous Utility Functions === Autonomous Utility Functions =
    // ===================================================================================================================================

    /**
     * Tell the robot to move a certain number of meters at a certain power level
     * @param power - The rate at which you are moving forwards
     * @param distance - The distance in meters to move
     * @return The distance successfully moved by the robot
     */
    public static double goForwards(double power, double distance)
    {
        int encoderDistance = (int)((PULSES_PER_REVOLUTION * distance)/(PULLEY_CIRCUMFERENCE));

        // Controls for setting power direction
        if (distance < 0)
            power = - Math.abs(power);
        else
            power = Math.abs(power);

        if (distance == 0)
            return 0;

        // Variables for determining when the robot gets stuck
        int prevDistanceLeft = 0;
        int ticksWithNoMovementLeft = 0;
        int prevDistanceRight = 0;
        int ticksWithNoMovementRight = 0;

        // Reset encoders and set motors to keep track of distance moved
        upperLeftMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        upperLeftMotor.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        upperRightMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        upperRightMotor.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        int initialPositionUpperRightMotor = upperRightMotor.getCurrentPosition();
        int initialPositionUpperLeftMotor = upperLeftMotor.getCurrentPosition();

        setPowerForForwards(power);

        // A loop for moving the wheels until they move the required distance
        // Will stop the wheels when they get stuck
        while ((upperLeftMotor.getCurrentPosition()-initialPositionUpperLeftMotor) < encoderDistance || (upperRightMotor.getCurrentPosition()-initialPositionUpperRightMotor) < encoderDistance)
        {
            if ((upperLeftMotor.getCurrentPosition()-initialPositionUpperLeftMotor) >= encoderDistance)
            {
                setLeftMotors(0); // Stop Motor if left side is in position
            }
            else if ((upperLeftMotor.getCurrentPosition()-initialPositionUpperLeftMotor) == prevDistanceLeft)
            {
                ticksWithNoMovementLeft++; // Wow you aren't moving, add to the number of ticks you aren't in position
            }
            else
            {
                ticksWithNoMovementLeft = 0; // Good job, you ain't stuck left side. Set the variable keeping track of that to zero
            }


            if ((upperRightMotor.getCurrentPosition() - initialPositionUpperRightMotor) >= encoderDistance)
            {
                setRightMotors(0);  // Stop Motor if left side is in position
            }
            else if ((upperRightMotor.getCurrentPosition() - initialPositionUpperRightMotor) == prevDistanceRight)
            {
                ticksWithNoMovementRight++; // Wow you aren't moving, add to the number of ticks you aren't in position
            }
            else
            {
                ticksWithNoMovementRight = 0; // Good job, you ain't stuck right side. Set the variable keeping track of that to zero
            }

            if (ticksWithNoMovementLeft > TOO_MANY_TICKS_WITHOUT_MOVING || ticksWithNoMovementRight > TOO_MANY_TICKS_WITHOUT_MOVING)
            {
                break;
            }

            prevDistanceLeft = upperLeftMotor.getCurrentPosition(); // Update the previous position variable
            prevDistanceRight = upperRightMotor.getCurrentPosition(); // Update the previous position variable

            // Fancy code for putting in a delay
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }

        // Turn off the motors
        setLeftMotors(0);
        setRightMotors(0);

        // Average left and right encoder distances
        double averageOfLeftAndRightEncoderDistance = ((upperLeftMotor.getCurrentPosition()- initialPositionUpperLeftMotor) + (upperRightMotor.getCurrentPosition() - initialPositionUpperRightMotor))/2D;

        // Convert encoder distance to meter and give back that value
        return (averageOfLeftAndRightEncoderDistance/PULSES_PER_REVOLUTION) * (PULLEY_CIRCUMFERENCE);
    }

    /**
     * Tell the robot to move through a certain angle at a certain power level
     * @param power - The rate at which you are moving forwards
     * @param angle - The angle through which to turn to the right
     * @return The angle successfully moved through by the robot
     */
    public static double turn(double power, double angle)
    {
        double distanceAlongCircleToTurn = Math.toRadians(angle) * DISTANCE_FROM_CENTER_TO_TREAD;
        int encoderDistance = (int)((PULSES_PER_REVOLUTION * distanceAlongCircleToTurn)/(PULLEY_CIRCUMFERENCE));

        currentOperator.telemetry.addData("Encoder Distance = ", encoderDistance);

        // Controls for setting power direction
        if (angle < 0)
            power = - Math.abs(power);
        else
            power = Math.abs(power);

        if (angle == 0)
            return 0;

        // Variables for determining when the robot gets stuck
        int prevDistanceLeft = 0;
        int ticksWithNoMovementLeft = 0;
        int prevDistanceRight = 0;
        int ticksWithNoMovementRight = 0;

        // Reset encoders and set motors to keep track of distance moved
        upperLeftMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        upperLeftMotor.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        upperRightMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        upperRightMotor.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);

        setPowerForTurn(power);

        // A loop for moving the wheels until they move the required distance
        // Will stop the wheels when they get stuck
        while (upperLeftMotor.getCurrentPosition() <= encoderDistance || upperRightMotor.getCurrentPosition() >= -encoderDistance)
        {
            if (upperLeftMotor.getCurrentPosition() >= encoderDistance)
            {
                setLeftMotors(0); // Stop Motor if left side is in position
            }
            else if (upperLeftMotor.getCurrentPosition() == prevDistanceLeft)
            {
                ticksWithNoMovementLeft++; // Wow you aren't moving, add to the number of ticks you aren't in position
            }
            else
            {
                ticksWithNoMovementLeft = 0; // Good job, you ain't stuck left side. Set the variable keeping track of that to zero
            }


            if (upperRightMotor.getCurrentPosition() <= -encoderDistance)
            {
                setRightMotors(0);  // Stop Motor if left side is in position
            }
            else if (upperRightMotor.getCurrentPosition() == prevDistanceRight)
            {
                ticksWithNoMovementRight++; // Wow you aren't moving, add to the number of ticks you aren't in position
            }
            else
            {
                ticksWithNoMovementRight = 0; // Good job, you ain't stuck right side. Set the variable keeping track of that to zero
            }

            if (ticksWithNoMovementLeft > TOO_MANY_TICKS_WITHOUT_MOVING || ticksWithNoMovementRight > TOO_MANY_TICKS_WITHOUT_MOVING)
            {
                break;
            }

            prevDistanceLeft = upperLeftMotor.getCurrentPosition(); // Update the previous position variable
            prevDistanceRight = upperRightMotor.getCurrentPosition(); // Update the previous position variable

            displayMovementEncoderValues();

            // Fancy code for putting in a delay
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }

        // Turn off the motors
        setLeftMotors(0);
        setRightMotors(0);

        // Average left and right encoder distances
        double averageOfLeftAndRightEncoderDistance = (upperLeftMotor.getCurrentPosition() - upperRightMotor.getCurrentPosition())/2D;

        // Convert encoder distance to meter and give back that value
        double distanceMovedAlongCircle = (averageOfLeftAndRightEncoderDistance/PULSES_PER_REVOLUTION) * (PULLEY_CIRCUMFERENCE);

        return Math.toDegrees(distanceMovedAlongCircle / DISTANCE_FROM_CENTER_TO_TREAD);
    }
}
