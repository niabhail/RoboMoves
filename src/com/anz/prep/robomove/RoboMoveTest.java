package com.anz.prep.robomove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.anz.prep.robomove.controller.RoboMoveEngine;

public class RoboMoveTest {

    /*
     * Test Class to run basic scenarios.
     * 
     * @param args
     */
    public static void main(String[] args) {

	RoboMoveEngine roboMove = new RoboMoveEngine();

	try {
	    // trial cases
	    roboMove.executeAction(Action.PLACE, 0, 0, Direction.NORTH);
	    roboMove.executeAction(Action.MOVE);
	    roboMove.executeAction(Action.REPORT);

	    roboMove.executeAction(Action.PLACE, 0, 0, Direction.NORTH);
	    roboMove.executeAction(Action.LEFT);
	    roboMove.executeAction(Action.REPORT);

	    roboMove.executeAction(Action.PLACE, 1, 2, Direction.EAST);
	    roboMove.executeAction(Action.MOVE);
	    roboMove.executeAction(Action.MOVE);
	    roboMove.executeAction(Action.LEFT);
	    roboMove.executeAction(Action.MOVE);
	    roboMove.executeAction(Action.REPORT);

	    // test for boundary cases
	    roboMove.executeAction(Action.PLACE, 0, 0, Direction.NORTH);
	    roboMove.executeAction(Action.MOVE); // y = 1
	    roboMove.executeAction(Action.MOVE); // y = 2
	    roboMove.executeAction(Action.MOVE); // y = 3
	    roboMove.executeAction(Action.MOVE); // y = 4
	    roboMove.executeAction(Action.MOVE); // no effect
	    roboMove.executeAction(Action.MOVE); // no effect
	    roboMove.executeAction(Action.REPORT);

	    roboMove.executeAction(Action.PLACE, -1, 8, Direction.NORTH);

	} catch (Exception e) {
	    System.out.println("Could not place the robot on surface - "
		    + e.getLocalizedMessage());
	}

	// Interactive user inputs from console
	try {
	    StringTokenizer tokenizer;
	    int x = 0, y = 0;
	    Direction direction = null;
	    Action action;
	    BufferedReader br = new BufferedReader(new InputStreamReader(
		    System.in));

	    String input;
	    System.out
		    .println("Enter commands - on new line (type 'exit' to break):");

	    while ((input = br.readLine()) != null) {

		if (input.equalsIgnoreCase("exit")) {
		    break;
		}

		try {

		    // Format: Command <space> Args
		    tokenizer = new StringTokenizer(input, " ,");
		    Action command = Action.valueOf(tokenizer.nextToken()
			    .toUpperCase());

		    if (tokenizer.countTokens() > 1) {

			while (tokenizer.hasMoreTokens()) {
			    x = Integer.parseInt(tokenizer.nextToken());
			    y = Integer.parseInt(tokenizer.nextToken());
			    direction = Direction.valueOf(tokenizer.nextToken()
				    .toUpperCase());
			}

			roboMove.executeAction(command, x, y, direction);

		    } else {
			roboMove.executeAction(command);
		    }

		} catch (IllegalArgumentException ex) {
		    // INVALID COMMAND
		    System.out.println("Invalid command -- "
			    + ex.getLocalizedMessage());
		    continue;
		} catch (Exception e) {
		    System.out.println("Invalid command -- "
			    + e.getLocalizedMessage());
		}
	    }

	} catch (IOException io) {
	    io.printStackTrace();
	} catch (Exception e) {
	    System.err
		    .println("Issue with io stream, please rerun the program --  "
			    + e.getLocalizedMessage());
	}

    }

}
