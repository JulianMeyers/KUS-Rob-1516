package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.MotorController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by the nikitasaurus on 4/17/16.
 */
public class Autonomous_Evil_Climber_Dump extends LinearOpMode {

    // Variables for Positions and Speeds
    private final static double CLMB_DEP_REST = 1;
    private final static double CLMB_DEP_UP = 0;

    private final static double RIGHT_TRIGGER_UP = 0.8;
    private final static double RIGHT_TRIGGER_MID = 0.2;
    private final static double RIGHT_TRIGGER_LOW = 0;
    private final static double LEFT_TRIGGER_UP = 0.2;
    private final static double LEFT_TRIGGER_MID = 0.8;
    private final static double LEFT_TRIGGER_LOW = 1;

    private final static double ELBOW_POS_GOAL_MIN_VAL = 0;
    private final static double ELBOW_POS_GOAL_MAX_VAL = 1;
    private final static double ELBOW_POS_MIN_VAL = 0.7;
    private final static double ELBOW_POS_MAX_VAL = 0.9;

    private final static double SHOULDER_POS_GOAL_MIN_VAL = 0;
    private final static double SHOULDER_POS_GOAL_MAX_VAL = 1;
    private final static double SHOULDER_POS_MIN_VAL = 0.15;
    private final static double SHOULDER_POS_MAX_VAL = 0.5;

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

    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();
        MotorController.init(hardwareMap, this);


        MotorController.goForwards(1, 1.12);
        MotorController.turn(0.5, 45);
        MotorController.goForwards(1, 0.3);
        MotorController.turn(0.5, 45);
        MotorController.goForwards(1, 1.27);

        MotorController.setClimberDepositor(CLMB_DEP_UP);
        MotorController.setClimberDepositor(CLMB_DEP_REST);

        MotorController.turn(0.5, 45);
        MotorController.goForwards(1, 4);


    }
}
