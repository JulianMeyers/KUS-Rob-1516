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

        MotorController.init(hardwareMap, this);
        waitForStart();
        MotorController.resetServos();

        double distanceMoved = MotorController.goForwards(1, 1, true, 100);

        telemetry.addData("Distance Moved = ", distanceMoved);

        double angleMoved = MotorController.turn(1, 45, true, 100);

        telemetry.addData("Angle Moved = ", angleMoved);
    }

}