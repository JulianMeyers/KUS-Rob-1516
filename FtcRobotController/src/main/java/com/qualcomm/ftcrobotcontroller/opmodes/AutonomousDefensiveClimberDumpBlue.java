package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.MotorController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by the nikitasaurus on 4/17/16.
 */
public class AutonomousDefensiveClimberDumpBlue extends LinearOpMode {

    public AutonomousDefensiveClimberDumpBlue()
    {
        super();
        MotorController.setActiveSideBlue();
    }

    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();
        MotorController.init(hardwareMap, this);

        MotorController.goForwards(1, 1.12);
        MotorController.sidedTurn(0.5, 45);
        MotorController.goForwards(1, 0.3);
        MotorController.sidedTurn(0.5, 45);
        MotorController.goForwards(1, 1.27);

        MotorController.setClimberDepositorDown();
        wait(500);
        MotorController.setClimberDepositorRest();

        MotorController.sidedTurn(0.5, 45);
        MotorController.goForwards(1, 4);
    }
}
