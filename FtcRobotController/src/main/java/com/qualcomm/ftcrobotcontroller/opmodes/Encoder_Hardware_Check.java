package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Julian on 3/5/2016.
 * Test
 */
public class Encoder_Hardware_Check extends OpMode {

    private DcMotor Upper_Right_Motor;
    private DcMotor Upper_Left_Motor;





    @Override
    public void init() {
        //Naming which motors and servos are which
        Upper_Right_Motor = hardwareMap.dcMotor.get("Upper_Right_Drive_Spinner");
        Upper_Left_Motor = hardwareMap.dcMotor.get("Upper_Left_Drive_Spinner");




        //Reversing the direction of the left motors due to positioning
        Upper_Left_Motor.setDirection(DcMotor.Direction.REVERSE);

        Upper_Left_Motor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        Upper_Right_Motor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        Upper_Left_Motor.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        Upper_Right_Motor.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
    }

    @Override
    public void loop() {
        Upper_Right_Motor.setPower(1);
        Upper_Left_Motor.setPower(1);
        float upperRightMotorPos = Upper_Right_Motor.getCurrentPosition();
        float upperLeftMotorPos = Upper_Left_Motor.getCurrentPosition();
        telemetry.addData("Right Side Encoder = ", upperRightMotorPos);
        telemetry.addData("Left Side Encoder = ", upperLeftMotorPos);
    }
}
