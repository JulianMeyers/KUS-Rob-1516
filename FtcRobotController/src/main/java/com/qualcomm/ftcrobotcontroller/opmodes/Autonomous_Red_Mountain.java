package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Julian on 1/15/16.
 */
public class Autonomous_Red_Mountain extends LinearOpMode {
    //Naming DcMotors and Servos

    DcMotor Upper_Right_Motor;
    DcMotor Lower_Right_Motor;
    DcMotor Upper_Left_Motor;
    DcMotor Lower_Left_Motor;
    DcMotor Lift_SpinnerR;
    DcMotor Lift_SpinnerL;
    DcMotor DebrisCollectionSpinner;
    DcMotor DebrisDepositorSpinner;
    Servo Left_Trigger;
    Servo Right_Trigger;
    Servo Climber_Depositor;
    Servo RF_CowCatcher;
    Servo LF_CowCatcher;
    Servo RR_CowCatcher;
    Servo LR_CowCatcher;
    Servo Shoulder_Servo;
    Servo Elbow_Servo;
    Servo Left_DebrisRamp;
    Servo Right_DebrisRamp;

    //Variables for Positions and Speeds
    final static double ClmbDepRest = 1;
    final static double ClmbDepUp = 0;
    final static double RTUp = 0.8;
    final static double RTMid = 0.2;
    final static double RTLow = 0;
    final static double LTUp = 0.2;
    final static double LTMid = 0.8;
    final static double LTLow = 1;
    private final static double ElbwPosGoalMinVal = 0;
    private final static double ElbwPosGoalMaxVal = 1;
    private final static double ElbwPosMinVal = 0.7;
    private final static double ElbwPosMaxVal = 0.9;
    private final static double ShldrPosGoalMinVal = 0;
    private final static double ShldrPosGoalMaxVal = 1;
    private final static double ShldrPosMinVal = 0.15;
    private final static double ShldrPosMaxVal = 0.5;
    final static double LeftFrontCowCatcherUp = 0.2;
    final static double LeftFrontCowCatcherDown = 0.65;
    final static double RightFrontCowCatcherUp = 0.8;
    final static double RightFrontCowCatcherDown = 0.35;
    final static double LeftRearCowCatcherUp = 0;
    final static double RightRearCowCatcherUp = 1;
    final static double LeftRearCowCatcherDown = 1;
    final static double RightRearCowCatcherDown = 0;
    final static double LSRPwrOut = -1;
    final static double LSRPwrIn = 1;
    final static double LSLPwrIn = 1;
    final static double LSLPwrOut = -1;
    final static double LSRPwrStop = 0;
    final static double LSLPwrStop = 0;
    final static double LRampUp = 0.1;
    final static double LRampDown = 0.5;
    final static double RRampUp = 1;
    final static double RRampDown = 0.4;

    @Override
    public void runOpMode() throws InterruptedException {

        //Naming which motors and servos are which
        Upper_Right_Motor = hardwareMap.dcMotor.get("Upper_Right_Drive_Spinner");
        Lower_Right_Motor = hardwareMap.dcMotor.get("Lower_Right_Drive_Spinner");
        Upper_Left_Motor = hardwareMap.dcMotor.get("Upper_Left_Drive_Spinner");
        Lower_Left_Motor = hardwareMap.dcMotor.get("Lower_Left_Drive_Spinner");
        Lift_SpinnerR = hardwareMap.dcMotor.get("Right_Lift_Spinner");
        Lift_SpinnerL = hardwareMap.dcMotor.get("Left_Lift_Spinner");
        DebrisCollectionSpinner = hardwareMap.dcMotor.get("Intake_Spinner");
        DebrisDepositorSpinner = hardwareMap.dcMotor.get("Debris_Depositor_Spinner");
        Left_Trigger = hardwareMap.servo.get("Left_Trigger_Activator_Servo");
        Right_Trigger = hardwareMap.servo.get("Right_Trigger_Activator_Servo");
        Climber_Depositor = hardwareMap.servo.get("Climber_Depositor_Servo");
        RF_CowCatcher = hardwareMap.servo.get("Right_Cow_Catcher_Servo");
        LF_CowCatcher = hardwareMap.servo.get("Left_Cow_Catcher_Servo");
        Shoulder_Servo = hardwareMap.servo.get("Shoulder_Servo");
        Elbow_Servo = hardwareMap.servo.get("Elbow_Servo");
        Left_DebrisRamp = hardwareMap.servo.get("Left_Ramp_Servo");
        Right_DebrisRamp = hardwareMap.servo.get("Right_Ramp_Servo");

        //Reversing the direction of the left motors due to positioning
        Upper_Left_Motor.setDirection(DcMotor.Direction.REVERSE);
        Lower_Left_Motor.setDirection(DcMotor.Direction.REVERSE);
        Lift_SpinnerL.setDirection(DcMotor.Direction.REVERSE);

        //Robot Preparing for Movement-in-game
        Climber_Depositor.setPosition(ClmbDepRest);
        Left_Trigger.setPosition(LTUp);
        Right_Trigger.setPosition(RTUp);
        LF_CowCatcher.setPosition(LeftFrontCowCatcherDown);
        RF_CowCatcher.setPosition(RightFrontCowCatcherDown);
        Elbow_Servo.setPosition(ElbwPosMinVal);
        Shoulder_Servo.setPosition(ShldrPosMinVal);
        Left_DebrisRamp.setPosition(LRampUp);
        Right_DebrisRamp.setPosition(RRampUp);

        waitForStart();

        for(int i=0; i<1; i++) {
            Upper_Right_Motor.setPower(1.0);
            Lower_Right_Motor.setPower(1.0);
            Upper_Left_Motor.setPower(1.0);
            Lower_Left_Motor.setPower(1.0);

            sleep(3500);
        }

        Upper_Right_Motor.setPowerFloat();
        Lower_Right_Motor.setPowerFloat();
        Upper_Left_Motor.setPowerFloat();
        Lower_Left_Motor.setPowerFloat();

    }

    private void moveForwards(float power, int distance)
    {

    }
}