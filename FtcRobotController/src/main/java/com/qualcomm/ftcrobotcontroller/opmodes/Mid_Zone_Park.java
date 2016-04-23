package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.MotorController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by the nikitasaurus on 4/22/16.
 */
public class Mid_Zone_Park extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        MotorController.goForwards(1, 10);
        MotorController.turn(0.5, 10);
        MotorController.goForwards(1, 10);

    }
}
