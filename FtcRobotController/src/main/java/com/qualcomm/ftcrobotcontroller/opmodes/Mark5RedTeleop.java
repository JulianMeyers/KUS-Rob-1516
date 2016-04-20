package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.MotorController;

/**
 * Created by johnchuray on 4/20/16.
 */
public class Mark5RedTeleop extends Mark5BlueTeleop
{

    @Override
    public void init()
    {
        // Call the init function of the Blue teleop to set everything up
        super.init();

        MotorController.setActiveSideRed();
    }
}
