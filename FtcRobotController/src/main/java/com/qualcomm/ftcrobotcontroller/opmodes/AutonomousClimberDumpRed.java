package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.MotorController;

/**
 * Created by johnchuray on 4/23/16.
 */
public class AutonomousClimberDumpRed extends AutonomousClimberDumpBlue {

    public AutonomousClimberDumpRed()
    {
        super();
        MotorController.setActiveSideRed();
    }
}
