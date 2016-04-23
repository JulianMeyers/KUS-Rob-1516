package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.MotorController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by the nikitasaurus on 4/16/16.
 */
public class AutonomousClimberDumpBlue extends LinearOpMode {

    public AutonomousClimberDumpBlue()
    {
        super();
        MotorController.setActiveSideBlue();
    }

    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();
        MotorController.init(hardwareMap, this);
        MotorController.resetServos();

        MotorController.dumpClimbers();
    }


}
