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

        MotorController.displayMovementEncoderValues();
        double distanceMoved = MotorController.goForwards(1, 1);
        telemetry.addData("Distance Moved = ", distanceMoved);
        if (distanceMoved < 0.99)
            telemetry.addData("Moved Enough = ", false);
        else
            telemetry.addData("Moved Enough = ", true);
        MotorController.displayMovementEncoderValues();

        double angleMoved = MotorController.turn(1, 180);
        telemetry.addData("Angle Moved Through = ", angleMoved);
        if (angleMoved < 179.9)
            telemetry.addData("Turned Enough = ", false);
        else
            telemetry.addData("Turned Enough = ", true);
    }

}