package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.InputController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.ftcrobotcontroller.MotorController;

/**
 * Created by johnchuray on 4/20/16.
 */
public class Mark5BlueTeleop extends OpMode {

    // Boolean value used to reset the servos to their initial position
    // only when the match has started
    private boolean hasResetServos = false;

    private InputController input;

    // Function called as soon as the OpMode has been selected on the android app
    @Override
    public void init()
    {
        // Initialize motor controller and its motors using this opmode
        MotorController.init(this.hardwareMap, this);

        input = new InputController(gamepad1, gamepad2);

        MotorController.setActiveSideBlue();
    }

    @Override
    public void loop()
    {
        // Called on the first pass of loop to set the servos to their initial positions
        // This is done to keep the robot within boundaries after init is called and before
        // the match actually begins.
        if (!hasResetServos)
        {
            MotorController.resetServos();
            MotorController.setLeftMotors(0);
            MotorController.setRightMotors(0);
            hasResetServos = true;
        }

        // Update the input values for this tick of the loop
        input.updateValues();

        // Determine if the left bumper on gamepad1 was just released (true -> false)
        if (input.buttonReleased(InputController.LEFT_BUMPER_1_ID))
        {
            MotorController.switchFacing();
        }

        // Update motor values
        MotorController.setLeftMotors(input.leftY1);
        MotorController.setRightMotors(input.rightY1);

        if (input.dPadUp1)
        {
            MotorController.setTriggerUp();
        }
        else if (input.dPadLeft1)
        {
            MotorController.setTriggerMid();
        }
        else if (input.dPadDown1)
        {
            MotorController.setTriggerLow();
        }

        if (input.rightBumper2)
        {
            MotorController.setClimberDepositorDown();
        }
        else if (input.leftBumper2)
        {
            MotorController.setClimberDepositorRest();
        }

        if (input.buttonX1)
        {
            MotorController.setRearCowcatchersUp();
        }
        else if (input.buttonB1)
        {
            MotorController.setRearCowcatchersDown();
        }

        if (input.buttonY1)
        {
            MotorController.setFrontCowcatchersUp();
        }
        else if (input.buttonA1)
        {
            MotorController.setFrontCowcatchersDown();
        }

        MotorController.setElbowServo(input.rightTrigger2);
        MotorController.setShoulderServo(input.leftTrigger2);

        if (input.buttonA2)
        {
            MotorController.setLiftSpinnerOut();
        }
        else if (input.buttonY2)
        {
            MotorController.setLiftSpinnerIn();
        }
        else
        {
            MotorController.setLiftSpinnerFloat();
        }

        //Debris Collection Controls
        if (input.leftTrigger1Bool)
        {
            MotorController.setDebrisCollectionSpinner(-1);
        }
        else if (input.rightTrigger1Bool)
        {
            MotorController.setDebrisCollectionSpinner(1);
        }
        else
        {
            MotorController.setDebrisCollectionSpinnerFloat();
        }

        //Debris Depositor Controls

        if (input.buttonB2)
        {
            //forward at full speed (deposit button)
            MotorController.setDebrisDepositorSpinner(-0.25);
        }

        if (input.buttonX2) {

            //forward at half speed (return button)
            MotorController.setDebrisDepositorSpinner(0);
        }

        if (input.dPadLeft2) {

            //backward at full speed (deposit button)
            MotorController.setDebrisDepositorSpinner(0.25);
        }

        if (input.dPadRight2) {

            //backward at half speed (return button)
            MotorController.setDebrisDepositorSpinner(0);
        }

        //Debris Ramp controls (Right only for blue side)

        if (input.dPadUp2) {

            //Moves ramp to up position
            MotorController.setDebrisRampForSideUp();
        }

        if (input.dPadDown2) {

            //moves ramp to down position
            MotorController.setDebrisRampForSideDown();
        }
    }
}
