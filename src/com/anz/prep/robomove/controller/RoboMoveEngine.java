/**
 * 
 */
package com.anz.prep.robomove.controller;

import com.anz.prep.robomove.Action;
import com.anz.prep.robomove.Direction;
import com.anz.prep.robomove.model.Surface;
import com.anz.prep.robomove.view.RenderToConsole;
import com.anz.prep.robomove.view.Renderer;

/**
 * Class takes user input and changes the states of model.
 * 
 * @author neville_fernandes
 * 
 */
public class RoboMoveEngine {

    // dimensions of table top surface
    public static int MX = 5;
    public static int MY = 5;

    private final Surface tableTop;
    private final Renderer renderer;
    private final ActionController controller;

    /**
     * Setup the required environment. Its a small glue framework that ties all
     * together.
     * 
     */
    public RoboMoveEngine() {

	// Setup Actors (Model)
	// Prepare the surface
	this.tableTop = new Surface(MX, MY);

	// Place Robot at default position - south west corner of grid marked
	// with (0,0) bearing NORTH.
	// tableTop.place(0, 0, Direction.NORTH); //No default for now

	// Setup Controller
	this.controller = new ActionController(tableTop);

	// Setup view.
	this.renderer = new RenderToConsole(tableTop);

    }

    /** Handle the user inputs **/
    // Option1: Read the commands from file and call controller action
    // Option2: Create a Applet, handle events and call appropriate action
    // Option3: [Easy One] Read from System stdin

    // TODO: Implement the actions as Command pattern.
    public boolean executeAction(Action action, Object... args) {
	// TODO: add action to queue, read first remove last and execute
	if (action == Action.PLACE) {
	    validate(args);
	    controller.place((Integer) args[0], (Integer) args[1],
		    (Direction) args[2]);
	    return true;
	}

	if (tableTop.getRobot() != null) {
	    switch (action) {
	    case MOVE:
		controller.move();
		break;
	    case LEFT:
		controller.left();
		break;
	    case RIGHT:
		controller.right();
		break;
	    case REPORT:
		renderer.render();
		break;
	    default:
		// do nothing
		break;
	    }

	    return true;
	}

	// no action was executed.
	return false;

    }

    /**
     * Validate the extra args required to process the action PLACE.
     * 
     * @param args
     *            requires location x,y and direction
     */
    private void validate(Object[] args) {

	// check if args are passed
	if (args.length == 0) {
	    throw new IllegalArgumentException(
		    "Action:PLACE expects arguments x,y,direction.");
	}

	// Range validator
	if ((Integer) args[0] < 0 || (Integer) args[0] > tableTop.getMaxX()) {
	    throw new IllegalArgumentException(
		    "Invalid range for x cordinate, available values - 0 to "
			    + (tableTop.getMaxX() - 1));
	}

	if ((Integer) args[1] < 0 || (Integer) args[1] > tableTop.getMaxY()) {
	    throw new IllegalArgumentException(
		    "Invalid range for y cordinate, available values - 0 to "
			    + (tableTop.getMaxY() - 1));

	}

	// Direction enum validate check
	if (!args[2].getClass().isEnum()) {
	    throw new IllegalArgumentException("Invalid direction argument");
	}

    }
}
