package com.qualcomm.ftcrobotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Julian on 3/9/2016.
 */
public class Pregame_Setup extends OpMode{

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
    private final static double LeftFrontCowCatcherUp = 0.1; //changed from 0.3
    private final static double LeftFrontCowCatcherDown = 0.8; //changed from 0.65
    private final static double RightFrontCowCatcherUp = 1;//changed from 0.8
    private final static double RightFrontCowCatcherDown = 0.2;//changed from 0.35
    private final static double LSRPwrOut = -1;
    private final static double LSRPwrIn = 1;
    private final static double LSLPwrIn = 1;
    private final static double LSLPwrOut = -1;
    private final static double LRampUp = 0.1;
    private final static double LRampDown = 0.5;
    private final static double RRampUp = 1;
    private final static double RRampDown = 0.4;

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
    //Robot Preparing for Movement-in-game
        Climber_Depositor.setPosition(ClmbDepRest);
        Left_Trigger.setPosition(LTUp);
        Right_Trigger.setPosition(RTUp);
        LF_CowCatcher.setPosition(LeftFrontCowCatcherUp);
        RF_CowCatcher.setPosition(RightFrontCowCatcherUp);
        Elbow_Servo.setPosition(ElbwPosMinVal);
        Shoulder_Servo.setPosition(ShldrPosMinVal);


}

}
