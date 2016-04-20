package com.qualcomm.ftcrobotcontroller;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by johnchuray on 4/20/16.
 */
public class InputController {

    // Values for different axes on the gamepads

        public float leftY1 = 0;
        public float rightY1 = 0;
        public float rightTrigger1 = 0;
        public float leftTrigger1 = 0;
        public float rightTrigger2 = 0;
        public float leftTrigger2 = 0;

        // Constants for thresholds on each axis

            public static final float LEFT_Y1_THRESHOLD = 0.05f;
            public static final float RIGHT_Y1_THRESHOLD = 0.05f;
            public static final float RIGHT_TRIGGER_1_THRESHOLD = 0.9f;
            public static final float LEFT_TRIGGER_1_THRESHOLD = 0.9f;
            public static final float RIGHT_TRIGGER_2_THRESHOLD = 0.0f;
            public static final float LEFT_TRIGGER_2_THRESHOLD = 0.0f;

        // Values for treating the triggers as boolean  values

            public boolean rightTrigger1Bool = false;
            public boolean prevRightTrigger1Bool = false;
            public static final int RIGHT_TRIGGER_1_ID = 21;

            public boolean leftTrigger1Bool = false;
            public boolean prevLeftTrigger1Bool = false;
            public static final int LEFT_TRIGGER_1_ID = 22;

            public boolean rightTrigger2Bool = false;
            public boolean prevRightTrigger2Bool = false;
            public static final int RIGHT_TRIGGER_2_ID = 23;

            public boolean leftTrigger2Bool = false;
            public boolean prevLeftTrigger2Bool = false;
            public static final int LEFT_TRIGGER_2_ID = 24;

    // Values for different buttons on the gamepads
    // Values for their previous state
    // Constants for their IDs

        // Bumper values for the 1st controller
        public boolean leftBumper1 = false;
        public boolean prevLeftBumper1 = false;
        public static final int LEFT_BUMPER_1_ID = 1;

        public boolean rightBumper1 = false;
        public boolean prevRightBumper1 = false;
        public static final int RIGHT_BUMPER_1_ID = 2;

        // Button values for the 1st controller
        public boolean buttonY1 = false;
        public boolean prevButtonY1 = false;
        public static final int BUTTON_Y1_ID = 3;

        public boolean buttonA1 = false;
        public boolean prevButtonA1 = false;
        public static final int BUTTON_A1_ID = 4;

        public boolean buttonB1 = false;
        public boolean prevButtonB1 = false;
        public static final int BUTTON_B1_ID = 5;

        public boolean buttonX1 = false;
        public boolean prevButtonX1 = false;
        public static final int BUTTON_X1_ID = 6;

        // DPad values for the 1st controller
        public boolean dPadDown1 = false;
        public boolean prevDPadDown1 = false;
        public static final int DPAD_DOWN_1_ID = 7;

        public boolean dPadLeft1 = false;
        public boolean prevDPadLeft1 = false;
        public static final int DPAD_LEFT_1_ID = 8;

        public boolean dPadUp1 = false;
        public boolean prevDPadUp1 = false;
        public static final int DPAD_UP_1_ID = 9;

        public boolean dPadRight1 = false;
        public boolean prevDPadRight1 = false;
        public static final int DPAD_RIGHT_1_ID = 10;

        // Bumpers on the 2nd controller
        public boolean leftBumper2 = false;
        public boolean prevLeftBumper2 = false;
        public static final int LEFT_BUMPER_2_ID = 11;

        public boolean rightBumper2 = false;
        public boolean prevRightBumper2 = false;
        public static final int RIGHT_BUMPER_2_ID = 12;

        // Button values for the 2nd controller
        public boolean buttonY2 = false;
        public boolean prevButtonY2 = false;
        public static final int BUTTON_Y2_ID = 13;

        public boolean buttonA2 = false;
        public boolean prevButtonA2 = false;
        public static final int BUTTON_A2_ID = 14;

        public boolean buttonB2 = false;
        public boolean prevButtonB2 = false;
        public static final int BUTTON_B2_ID = 15;

        public boolean buttonX2 = false;
        public boolean prevButtonX2 = false;
        public static final int BUTTON_X2_ID = 16;

        // Dpad values for the 2nd controller
        public boolean dPadDown2 = false;
        public boolean prevDPadDown2 = false;
        public static final int DPAD_DOWN_2_ID = 17;

        public boolean dPadLeft2 = false;
        public boolean prevDPadLeft2 = false;
        public static final int DPAD_LEFT_2_ID = 18;

        public boolean dPadUp2 = false;
        public boolean prevDPadUp2 = false;
        public static final int DPAD_UP_2_ID = 19;

        public boolean dPadRight2 = false;
        public boolean prevDPadRight2 = false;
        public static final int DPAD_RIGHT_2_ID = 20;

    // Gamepads used in updating values

    private Gamepad gamepad1;
    private Gamepad gamepad2;

    public InputController(Gamepad gamepad1, Gamepad gamepad2)
    {
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
    }

    /**
     * Function called once per loop to update the input values for each button and axis
     * for their current state. Also keeps tracks of previous states for all buttons
     */
    public void updateValues()
    {
        // Set the previous values of each digital button to be what it was after the last call
        // of this function (aka what it is now)
        prevRightTrigger1Bool = rightTrigger1Bool;
        prevLeftTrigger1Bool = leftTrigger1Bool;

        prevRightTrigger2Bool = rightTrigger2Bool;
        prevLeftTrigger2Bool = leftTrigger2Bool;

        prevLeftBumper1 = leftBumper1;
        prevRightBumper1 = rightBumper1;

        prevButtonY1 = buttonY1;
        prevButtonA1 = buttonA1;
        prevButtonB1 = buttonB1;
        prevButtonX1 = buttonX1;

        prevDPadDown1 = dPadDown1;
        prevDPadLeft1 = dPadLeft1;
        prevDPadUp1 = dPadUp1;
        prevDPadRight1 = dPadRight1;

        prevLeftBumper2 = leftBumper2;
        prevRightBumper2 = rightBumper2;

        prevButtonY2 = buttonY2;
        prevButtonA2 = buttonA2;
        prevButtonB2 = buttonB2;
        prevButtonX2 = buttonX2;

        prevDPadDown2 = dPadDown2;
        prevDPadLeft2 = dPadLeft2;
        prevDPadUp2 = dPadUp2;
        prevDPadRight2 = dPadRight2;

        // Update left and right axis values
        leftY1 = -gamepad1.left_stick_y;
        rightY1 = -gamepad1.right_stick_y;

        // If values on each axis are less than the threshold, set them to zero

        if (Math.abs(leftY1) < LEFT_Y1_THRESHOLD)
            leftY1 = 0;

        if (Math.abs(rightY1) < RIGHT_Y1_THRESHOLD)
            rightY1 = 0;

        // Update trigger values
        rightTrigger1 = gamepad1.right_trigger;
        leftTrigger1 = gamepad1.left_trigger;

        // If values on each trigger are less than the threshold, set them to zero and
        // set the boolean value representing if the trigger is down to false.
        // Otherwise set the boolean value representing that trigger to true

        if (rightTrigger1 < RIGHT_TRIGGER_1_THRESHOLD)
        {
            rightTrigger1 = 0;
            rightTrigger1Bool = false;
        }
        else
        {
            rightTrigger1Bool = true;
        }

        if (leftTrigger1 < LEFT_TRIGGER_1_THRESHOLD)
        {
            leftTrigger1 = 0;
            leftTrigger1Bool = false;
        }
        else
        {
            leftTrigger1Bool = true;
        }

        // Update trigger values
        rightTrigger2 = gamepad2.right_trigger;
        leftTrigger2 = gamepad2.left_trigger;

        // If values on each trigger are less than the threshold, set them to zero and
        // set the boolean value representing if the trigger is down to false.
        // Otherwise set the boolean value representing that trigger to true

        if (rightTrigger2 < RIGHT_TRIGGER_2_THRESHOLD)
        {
            rightTrigger2 = 0;
            rightTrigger2Bool = false;
        }
        else
        {
            rightTrigger2Bool = true;
        }

        if (leftTrigger2 < LEFT_TRIGGER_2_THRESHOLD)
        {
            leftTrigger2 = 0;
            leftTrigger2Bool = false;
        }
        else
        {
            leftTrigger2Bool = true;
        }

        // Update bumper, button, and Dpad values

        leftBumper1 = gamepad1.left_bumper;
        rightBumper1 = gamepad1.right_bumper;

        buttonY1 = gamepad1.y;
        buttonA1 = gamepad1.a;
        buttonB1 = gamepad1.b;
        buttonX1 = gamepad1.x;

        dPadDown1 = gamepad1.dpad_down;
        dPadLeft1 = gamepad1.dpad_left;
        dPadUp1 = gamepad1.dpad_up;
        dPadRight1 = gamepad1.dpad_right;

        leftBumper2 = gamepad2.left_bumper;
        rightBumper2 = gamepad2.right_bumper;

        buttonY2 = gamepad2.y;
        buttonA2 = gamepad2.a;
        buttonB2 = gamepad2.b;
        buttonX2 = gamepad2.x;

        dPadDown2 = gamepad2.dpad_down;
        dPadLeft2 = gamepad2.dpad_left;
        dPadUp2 = gamepad2.dpad_up;
        dPadRight2 = gamepad2.dpad_right;
    }

    /**
     * Takes in the id of a button and returns whether or not that button was just pressed down
     * @param buttonID
     * @return
     */
    public boolean buttonPressed(int buttonID)
    {
        // The logic is the following. If a button is pressed down, then last tick the button was
        // up (false) and now it is down (true)

        // A switch statement compares the value in parenthesis with each case value (the variable
        // after the case statement) and executes the code after the case statement if the switch
        // value equals the case value
        switch (buttonID)
        {
            case LEFT_BUMPER_1_ID:
                return leftBumper1 && !prevLeftBumper1;
            case RIGHT_BUMPER_1_ID:
                return rightBumper1 && !prevRightBumper1;

            case BUTTON_Y1_ID:
                return buttonY1 && !prevButtonY1;
            case BUTTON_A1_ID:
                return buttonA1 && !prevButtonA1;
            case BUTTON_B1_ID:
                return buttonB1 && !prevButtonB1;
            case BUTTON_X1_ID:
                return buttonX1 && !prevButtonX1;

            case DPAD_DOWN_1_ID:
                return dPadDown1 && !prevDPadDown1;
            case DPAD_LEFT_1_ID:
                return dPadLeft1 && !prevDPadLeft1;
            case DPAD_UP_1_ID:
                return dPadUp1 && !prevDPadUp1;

            case LEFT_BUMPER_2_ID:
                return leftBumper2 && !prevLeftBumper2;
            case RIGHT_BUMPER_2_ID:
                return rightBumper2 && !prevRightBumper2;

            case BUTTON_Y2_ID:
                return buttonY2 && !prevButtonY2;
            case BUTTON_A2_ID:
                return buttonA2 && !prevButtonA2;
            case BUTTON_B2_ID:
                return buttonB2 && !prevButtonB2;
            case BUTTON_X2_ID:
                return buttonX2 && !prevButtonX2;

            case DPAD_DOWN_2_ID:
                return dPadDown2 && !prevDPadDown2;
            case DPAD_LEFT_2_ID:
                return dPadLeft2 && !prevDPadLeft2;
            case DPAD_UP_2_ID:
                return dPadUp2 && !prevDPadUp2;
            case DPAD_RIGHT_2_ID:
                return dPadRight2 && !prevDPadRight2;

            case LEFT_TRIGGER_1_ID:
                return leftTrigger1Bool && !prevLeftTrigger1Bool;
            case RIGHT_TRIGGER_1_ID:
                return rightTrigger1Bool && !prevRightTrigger1Bool;

            case LEFT_TRIGGER_2_ID:
                return leftTrigger2Bool && !prevLeftTrigger2Bool;
            case RIGHT_TRIGGER_2_ID:
                return rightTrigger2Bool && !prevRightTrigger2Bool;
        }
        return false;
    }

    /**
     * Takes in the id of a button and returns whether or not that button was just released
     * @param buttonID
     * @return
     */
    public boolean buttonReleased(int buttonID)
    {
        // The logic is the following. If a button is released, then last tick the button was
        // down (true) and now it is up (false)

        // A switch statement compares the value in parenthesis with each case value (the variable
        // after the case statement) and executes the code after the case statement if the switch
        // value equals the case value
        switch (buttonID)
        {
            case LEFT_BUMPER_1_ID:
                return !leftBumper1 && prevLeftBumper1;
            case RIGHT_BUMPER_1_ID:
                return !rightBumper1 && prevRightBumper1;

            case BUTTON_Y1_ID:
                return !buttonY1 && prevButtonY1;
            case BUTTON_A1_ID:
                return !buttonA1 && prevButtonA1;
            case BUTTON_B1_ID:
                return !buttonB1 && prevButtonB1;
            case BUTTON_X1_ID:
                return !buttonX1 && prevButtonX1;

            case DPAD_DOWN_1_ID:
                return !dPadDown1 && prevDPadDown1;
            case DPAD_LEFT_1_ID:
                return !dPadLeft1 && prevDPadLeft1;
            case DPAD_UP_1_ID:
                return !dPadUp1 && prevDPadUp1;

            case LEFT_BUMPER_2_ID:
                return !leftBumper2 && prevLeftBumper2;
            case RIGHT_BUMPER_2_ID:
                return !rightBumper2 && prevRightBumper2;

            case BUTTON_Y2_ID:
                return !buttonY2 && prevButtonY2;
            case BUTTON_A2_ID:
                return !buttonA2 && prevButtonA2;
            case BUTTON_B2_ID:
                return !buttonB2 && prevButtonB2;
            case BUTTON_X2_ID:
                return !buttonX2 && prevButtonX2;

            case DPAD_DOWN_2_ID:
                return !dPadDown2 && prevDPadDown2;
            case DPAD_LEFT_2_ID:
                return !dPadLeft2 && prevDPadLeft2;
            case DPAD_UP_2_ID:
                return !dPadUp2 && prevDPadUp2;
            case DPAD_RIGHT_2_ID:
                return !dPadRight2 && prevDPadRight2;

            case LEFT_TRIGGER_1_ID:
                return !leftTrigger1Bool && prevLeftTrigger1Bool;
            case RIGHT_TRIGGER_1_ID:
                return !rightTrigger1Bool && prevRightTrigger1Bool;

            case LEFT_TRIGGER_2_ID:
                return !leftTrigger2Bool && prevLeftTrigger2Bool;
            case RIGHT_TRIGGER_2_ID:
                return !rightTrigger2Bool && prevRightTrigger2Bool;
        }
        return false;
    }

}
