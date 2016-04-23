package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.MotorController;

/**
 * Created by johnchuray on 4/23/16.
 */
public class MidZoneParkRed extends MidZoneParkBlue {

    public MidZoneParkRed()
    {
        super();
        MotorController.setActiveSideRed();
    }
}
