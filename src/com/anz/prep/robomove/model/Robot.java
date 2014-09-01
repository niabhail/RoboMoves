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

}
