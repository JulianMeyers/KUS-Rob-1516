package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.Pregame_Setup;
import com.qualcomm.robotcore.eventloop.opmode.OpModeManager;
import com.qualcomm.robotcore.eventloop.opmode.OpModeRegister;

/**
 * Register Op Modes
 */
public class FtcOpModeRegister implements OpModeRegister {

  /**
   * The Op Mode Manager will call this method when it wants a list of all
   * available op modes. Add your op mode to the list to enable it.
   *
   * @param manager op mode manager
   */
  public void register(OpModeManager manager) {

    /*
     * register your op modes here.
     * The first parameter is the name of the op mode
     * The second parameter is the op mode class property
     *
     * If two or more op modes are registered with the same name, the app will display an error.
     */

    manager.register("NullOp", NullOp.class);
    //manager.register("Blue TeleOp", Blue_Teleop.class);
    //manager.register("Red TeleOp", Red_Teleop.class);
    manager.register("Mark 5 Blue Teleop", Mark5BlueTeleop.class);
    manager.register("Mark 5 Red Teleop", Mark5RedTeleop.class);
    //manager.register("Auto Red Mount", Autonomous_Red_Mountain.class);
    //manager.register("Encoder Test", Encoder_Test.class);
    //manager.register("Encoder Hardware Check", Encoder_Hardware_Check.class);
    manager.register("Pregame_Setup", Pregame_Setup.class);
    manager.register("Encoder_Test", Encoder_Test.class);
    manager.register("Autonomous Defensive Climber Dump Blue", AutonomousDefensiveClimberDumpBlue.class);
    manager.register("Autonomous Defensive Climber Dump Red", AutonomousDefensiveClimberDumpRed.class);
    manager.register("Autonomous Climber Dump Blue", AutonomousClimberDumpBlue.class);
    manager.register("Autonomous Climber Dump Red", AutonomousClimberDumpRed.class);
    manager.register("Mid Zone Park Red", MidZoneParkRed.class);
    manager.register("Mid Zone Park Blue", MidZoneParkBlue.class);
  }
}