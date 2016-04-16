package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.MotorController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by nikita on 2/12/16.
 * Completely redone by John 3/5/16
 */
public class Encoder_Test extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();
        MotorController.init(hardwareMap, this);

        double distanceMoved = MotorController.goForwards(1, 1, true, 100);

        double angleMoved = MotorController.turn(1, 180, true, 100);
    }

}