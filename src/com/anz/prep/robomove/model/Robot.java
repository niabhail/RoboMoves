package com.anz.prep.robomove.model;

import java.awt.Point;

import com.anz.prep.robomove.Direction;

/**
 * 
 * @author neville_fernandes
 * 
 */
public class Robot {

    private Direction face;
    private Point point;

    public Robot() {
	// default value
	// this(0, 0, Direction.NORTH);
    }

    public Robot(int x, int y, Direction face) {
	this.point = new Point(x, y);
	this.face = face;
    }

    /**
     * @return the face
     */
    public Direction getFace() {
	return face;
    }

    /**
     * @param face
     *            the face to set
     */
    public void setFace(Direction face) {
	this.face = face;
    }

    /**
     * @return the point
     */
    public Point getPoint() {
	return point;
    }

    /**
     * @param point
     *            the point to set
     */
    public void setPoint(Point point) {
	this.point = point;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuilder output = new StringBuilder();
	output.append((int) this.getPoint().getX()).append(",")
		.append((int) this.getPoint().getY()).append(",")
		.append(this.getFace().name());

	return output.toString();
    }

    // Actions performed by robot.

    public void move() {

	if (face.equals(Direction.NORTH)) {
	    point.move((int) point.getX(), (int) point.getY() + 1);
	    // robot.getPoint().getY() < tableTop.getMaxY() - 1
	} else if (face.equals(Direction.EAST)) {
	    point.move((int) point.getX() + 1, (int) point.getY());
	    // robot.getPoint().getX() < tableTop.getMaxX() - 1
	} else if (face.equals(Direction.SOUTH)) {
	    point.move((int) point.getX(), (int) point.getY() - 1);
	    // robot.getPoint().getY() > 0
	} else if (face.equals(Direction.WEST)) {
	    point.move((int) point.getX() - 1, (int) point.getY());
	    // robot.getPoint().getX() > 0
	}

    }

    public void turnLeft() {

	int bearing = this.face.getBearingValue();
	bearing--; // turn left

	if (bearing == -1) {
	    bearing = 3;
	}

	setFace(Direction.getDirection(bearing));
    }

    public void turnRight() {
	int bearing = this.face.getBearingValue();
	bearing++; // turn left

	if (bearing == 4) {
	    bearing = 0;
	}

	setFace(Direction.getDirection(bearing));
    }

}
