package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.MotorController;

/**
 * Created by johnchuray on 4/23/16.
 */
public class AutonomousDefensiveClimberDumpRed extends AutonomousDefensiveClimberDumpBlue {

    public AutonomousDefensiveClimberDumpRed()
    {
        super();
        MotorController.setActiveSideRed();
    }

}
