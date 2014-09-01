package com.anz.prep.robomove.model;

import com.anz.prep.robomove.Direction;

/**
 * 
 * @author neville_fernandes
 * 
 */
public class Surface {

    private final int maxX;
    private final int maxY;

    private final Object[][] grid;
    private Robot robo;

    public Surface(int maxX, int maxY) {
	this.maxX = maxX;
	this.maxY = maxY;

	this.grid = new Object[maxX][maxY];

	// initialize the surface - its empty
	for (int i = 0; i < maxX; i++) {
	    for (int j = 0; j < maxY; j++) {
		grid[i][j] = null;
	    }
	}
    }

    public Object[][] getGrid() {
	return grid;
    }

    public int getMaxY() {
	return maxY;
    }

    public int getMaxX() {
	return maxX;
    }

    /**
     * @return the robot placed on the surface
     */
    public Robot getRobot() {
	return robo;
    }

    /**
     * Place the robot on the surface.
     * 
     * @param x
     *            int x cordinate of the location.
     * @param y
     *            int y cordinates of the location.
     * @param face
     *            the direction of the robot
     */
    public void place(int x, int y, Direction face) {
	// we need a new robot;
	robo = new Robot(x, y, face);
	// place the robot on grid;
	grid[(int) robo.getPoint().getX()][(int) robo.getPoint().getY()] = robo;
    }

}
