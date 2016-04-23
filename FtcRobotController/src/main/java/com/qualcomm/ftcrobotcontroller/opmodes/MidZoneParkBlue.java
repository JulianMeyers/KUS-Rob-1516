package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.MotorController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by the nikitasaurus on 4/22/16.
 */
public class MidZoneParkBlue extends LinearOpMode {

    public MidZoneParkBlue()
    {
        super();
        MotorController.setActiveSideBlue();
    }

    @Override
    public void runOpMode() throws InterruptedException {

        MotorController.goForwards(1, 10);
        MotorController.sidedTurn(0.5, 10);
        MotorController.goForwards(1, 10);

    }
}
