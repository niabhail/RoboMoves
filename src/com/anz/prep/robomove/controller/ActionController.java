/**
 * 
 */
package com.anz.prep.robomove.controller;

import com.anz.prep.robomove.Direction;
import com.anz.prep.robomove.model.Robot;
import com.anz.prep.robomove.model.Surface;

/**
 * Business Logic for the actions
 * 
 * @author neville_fernandes
 * 
 */
public class ActionController {

    private final Surface tableTop;

    public ActionController(Surface tableTop) {
	// We need surface to act on. The robot will be placed on this surface.
	this.tableTop = tableTop;
    }

    /**
     * Places the robot on the surface specified by location and direction.
     * 
     * @param x
     *            x-coordinate of the location
     * @param y
     *            y-cordinate of the location
     * @param face
     *            the direction the robot faces
     */
    public void place(int x, int y, Direction face) {

	if (tableTop.getRobot() != null) {
	    // looks like there is already a robot placed on the surface

	    // TODO: call cleanup actions for grid, will place a new robot or
	    // same robot again at new location.
	}

	tableTop.place(x, y, face);
    }

    /**
     * Makes the robot move by one step in the direction specified by robot
     * face. It does nothing if the robot is at boundary and executed action is
     * not available.
     */
    public void move() {

	Robot robot = tableTop.getRobot();
	if (robot == null)
	    return; // do nothing

	Direction currentDirection = robot.getFace();
	if (currentDirection == Direction.NORTH) {
	    if ((int) robot.getPoint().getY() < tableTop.getMaxY() - 1) {
		tableTop.getRobot()
			.getPoint()
			.move((int) robot.getPoint().getX(),
				(int) robot.getPoint().getY() + 1);
	    }
	} else if (currentDirection == Direction.SOUTH) {
	    if ((int) robot.getPoint().getY() > 0) {
		tableTop.getRobot()
			.getPoint()
			.move((int) robot.getPoint().getX(),
				(int) robot.getPoint().getY() - 1);
	    }
	} else if (currentDirection == Direction.EAST) {
	    if ((int) robot.getPoint().getX() < tableTop.getMaxX() - 1) {
		tableTop.getRobot()
			.getPoint()
			.move((int) robot.getPoint().getX() + 1,
				(int) robot.getPoint().getY());
	    }
	} else if (currentDirection == Direction.WEST) {
	    if ((int) robot.getPoint().getX() > 0) {
		tableTop.getRobot()
			.getPoint()
			.move((int) robot.getPoint().getX() - 1,
				(int) robot.getPoint().getY());
	    }
	}

    }

    /**
     * Turns the robot left by 90 deg.
     */
    public void left() {
	Robot robot = tableTop.getRobot();
	if (robot == null)
	    return;

	int bearing = robot.getFace().getBearingValue();
	bearing--; // turn left

	if (bearing == -1) {
	    bearing = 3;
	}

	tableTop.getRobot().setFace(Direction.getDirection(bearing));
    }

    /**
     * Turns the robot right by 90 deg.
     */
    public void right() {

	Robot robot = tableTop.getRobot();
	if (robot == null)
	    return;

	int bearing = robot.getFace().getBearingValue();
	bearing++; // turn right

	if (bearing == 4) {
	    bearing = 0;
	}

	tableTop.getRobot().setFace(Direction.getDirection(bearing));
    }

}
