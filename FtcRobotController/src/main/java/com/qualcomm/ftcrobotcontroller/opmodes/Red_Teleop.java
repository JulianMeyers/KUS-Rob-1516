package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Julian on 1/7/16.
 * Optimized by John on 3/5/16
 * Test
 */
//this code is our basic code we will run during competitions

public class Red_Teleop extends OpMode {

    private DcMotor Upper_Right_Motor;
    private DcMotor Lower_Right_Motor;
    private DcMotor Upper_Left_Motor;
    private DcMotor Lower_Left_Motor;
    private DcMotor Lift_SpinnerR;
    private DcMotor Lift_SpinnerL;
    private DcMotor DebrisCollectionSpinner;
    private DcMotor DebrisDepositorSpinner;
    private Servo Left_Trigger;
    private Servo Right_Trigger;
    private Servo Climber_Depositor;
    private Servo RF_CowCatcher;
    private Servo LF_CowCatcher;
    private Servo Shoulder_Servo;
    private Servo Elbow_Servo;
    private Servo Left_DebrisRamp;
    private Servo Right_DebrisRamp;

    //Variables for Positions and Speeds
    private final static double ClmbDepRest = 1;
    private final static double ClmbDepUp = 0;
    private final static double RTUp = 0.8;
    private final static double RTMid = 0.2;
    private final static double RTLow = 0;
    private final static double LTUp = 0.2;
    private final static double LTMid = 0.8;
    private final static double LTLow = 1;
    private final static double ElbwPosGoalMinVal = 0;
    private final static double ElbwPosGoalMaxVal = 1;
    private final static double ElbwPosMinVal = 0.7;
    private final static double ElbwPosMaxVal = 0.9;
    private final static double ShldrPosGoalMinVal = 0;
    private final static double ShldrPosGoalMaxVal = 1;
    private final static double ShldrPosMinVal = 0.15;
    private final static double ShldrPosMaxVal = 0.5;
    private final static double LeftFrontCowCatcherUp = 0.35; //changed from 0.3
    private final static double LeftFrontCowCatcherDown = 0.8; //changed from 0.65
    private final static double RightFrontCowCatcherUp = 0.75;//changed from 0.8
    private final static double RightFrontCowCatcherDown = 0.2;//changed from 0.35
    private final static double LSRPwrOut = -1;
    private final static double LSRPwrIn = 1;
    private final static double LSLPwrIn = 1;
    private final static double LSLPwrOut = -1;
    private final static double LRampUp = 0.1;
    private final static double LRampDown = 0.5;
    private final static double RRampUp = 1;
    private final static double RRampDown = 0.6;

    @Override
    public void init() {
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


    }

    private boolean toggle = true;
    private boolean previousToggleButtonState = false;

    @Override
    public void loop() {
        Right_DebrisRamp.setPosition(RRampUp);


        //Which Name Correlates to Which Button
        float LeftY1 = -gamepad1.left_stick_y;
        float RightY1 = -gamepad1.right_stick_y;
        float RightTrigger1 = gamepad1.right_trigger;
        float LeftTrigger1 = gamepad1.left_trigger;
        float RightTrigger2 = gamepad2.right_trigger;
        float LeftTrigger2 = gamepad2.left_trigger;
        boolean ButtonY1 = gamepad1.y;
        boolean ButtonA1 = gamepad1.a;
        boolean ButtonB1 = gamepad1.b;
        boolean ButtonY2 = gamepad2.y;
        boolean ButtonA2 = gamepad2.a;
        boolean LeftBumper1 = gamepad1.left_bumper;
        boolean RightBumper1 = gamepad1.right_bumper;
        boolean DPadDown1 = gamepad1.dpad_down;
        boolean DPadUp1 = gamepad1.dpad_up;
        boolean ButtonX1 = gamepad1.x;
        boolean DPadLeft1 = gamepad1.dpad_left;
        boolean ButtonB2 = gamepad2.b;
        boolean ButtonX2 = gamepad2.x;
        boolean DPadLeft2 = gamepad2.dpad_left;
        boolean DPadRight2 = gamepad2.dpad_right;
        boolean DPadUp2 = gamepad2.dpad_up;
        boolean DPadDown2 = gamepad2.dpad_down;
        boolean LeftBumper2 = gamepad2.left_bumper;
        boolean RightBumper2 = gamepad2.right_bumper;

        //Drive Motor Controls

        if (LeftBumper1 && !previousToggleButtonState) // Detect when the left bumper goes from pressed to not pressed
        {
            toggle = !toggle;
        }
        previousToggleButtonState = LeftBumper1; // Update the previous state of the left bumper

        if (toggle) // If you are heading forwards, work like normal tank drive
        {
            Upper_Right_Motor.setPower(RightY1 * Math.abs(RightY1));
            Lower_Right_Motor.setPower(RightY1 * Math.abs(RightY1));
            Upper_Left_Motor.setPower(LeftY1 * Math.abs(LeftY1));
            Lower_Left_Motor.setPower(LeftY1 * Math.abs(LeftY1));
        }
        else // If you are heading backwards, flip which motors are controlled by which joystick and invert motor values
        {
            Upper_Right_Motor.setPower(LeftY1 * -Math.abs(LeftY1));
            Lower_Right_Motor.setPower(LeftY1 * -Math.abs(LeftY1));
            Upper_Left_Motor.setPower(RightY1 * -Math.abs(RightY1));
            Lower_Left_Motor.setPower(RightY1 * -Math.abs(RightY1));
        }

        //Trigger Controls


        if (DPadUp1) {
            Right_Trigger.setPosition(RTUp);
            //if dpad 1 Up is pressed Right Trigger moves to Up position
        }
        if (DPadLeft1) {
            Right_Trigger.setPosition(RTMid);
            //if dpad 1 Left is pressed Right Trigger moves to mid position
        }
        if (DPadDown1) {
            Right_Trigger.setPosition(RTLow);
            //if dpad 1 down is pressed Right Trigger moves to low position
        }


//Climber Depositor Controls

        if (RightBumper2) {
            Climber_Depositor.setPosition(ClmbDepUp);
            //moves climber depositor to Depositing position
        }

        if (LeftBumper2) {
            Climber_Depositor.setPosition(ClmbDepRest);
            //moves climber depositor to Storage position
        }

        //Elbow Controls

        double ElbowPosition = (RightTrigger2 - ElbwPosGoalMinVal) * (ElbwPosMaxVal - ElbwPosMinVal) / (ElbwPosGoalMaxVal - ElbwPosGoalMinVal) + ElbwPosMinVal;
        Elbow_Servo.setPosition(ElbowPosition);


        //Shoulder Controls

        double ShoulderPosition = (LeftTrigger2 - ShldrPosGoalMinVal) * (ShldrPosMaxVal - ShldrPosMinVal) / (ShldrPosGoalMaxVal - ShldrPosGoalMinVal) + ShldrPosMinVal;
        Shoulder_Servo.setPosition(ShoulderPosition);
        telemetry.addData("Shoulder Position", ShoulderPosition);

        //Front Cow Catcher Controls

        if (ButtonY1) {
            LF_CowCatcher.setPosition(LeftFrontCowCatcherUp);
            RF_CowCatcher.setPosition(RightFrontCowCatcherUp);
            //if Y1 is pressed CowCatchers go to up position
        }
        if (ButtonA1) {
            LF_CowCatcher.setPosition(LeftFrontCowCatcherDown);
            RF_CowCatcher.setPosition(RightFrontCowCatcherDown);
            //if A1 is pressed CowCatchers got to down position
        }


        //Lift Spinner Controls
        if (ButtonA2) {
            Lift_SpinnerR.setPower(LSRPwrOut);
            Lift_SpinnerL.setPower(LSLPwrOut);
        }

        if (ButtonY2) {
            Lift_SpinnerR.setPower(LSRPwrIn);
            Lift_SpinnerL.setPower(LSLPwrIn);
        }

        if (!ButtonA2 && !ButtonY2) {
            Lift_SpinnerR.setPower(0);
            Lift_SpinnerL.setPower(0);
        }


        //Debris Collection Controls
        if (LeftTrigger1 > 0.9) {
            DebrisCollectionSpinner.setPower(-1);
        }
        if (RightTrigger1 > 0.9) {
            DebrisCollectionSpinner.setPower(1);
        }

        if (!(RightTrigger1 > 0.9) && !(LeftTrigger1 > 0.9)) {
            DebrisCollectionSpinner.setPowerFloat();
        }
        telemetry.addData("Left Trigger 1", LeftTrigger1);
        telemetry.addData("Right Trigger 1", RightTrigger1);

        //Debris Depositor Controls

        if (ButtonB2) {

            //forward at full speed (deposit button)
            DebrisDepositorSpinner.setPower(-0.25);

        }

        if (ButtonX2) {

            //forward at half speed (return button)
            DebrisDepositorSpinner.setPower(0);
        }

        if (DPadLeft2) {

            //backward at full speed (deposit button)
            DebrisDepositorSpinner.setPower(0.25);
        }

        if (DPadRight2) {

            //backward at half speed (return button)
            DebrisDepositorSpinner.setPower(0);
        }

        if (DPadUp2) {

                //Moves ramp to up position
                Left_DebrisRamp.setPosition(LRampUp);
        }

        if (DPadDown2) {

                //moves ramp to down position
                Left_DebrisRamp.setPosition(LRampDown);
        }
        }


    }
