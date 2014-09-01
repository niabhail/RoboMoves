/**
 * 
 */
package com.anz.prep.robomove;

import java.util.HashMap;
import java.util.Map;

/**
 * Available directions for movements.
 * 
 * @author neville_fernandes
 */

public enum Direction {
    NORTH(0), EAST(1), SOUTH(2), WEST(3);

    private final int bearingValue;

    private Direction(int bearingValue) {
	this.bearingValue = bearingValue;
    }

    public Integer getBearingValue() {
	return bearingValue;
    }

    // Reverse-lookup bearing value to direction
    private static final Map<Integer, Direction> lookup = new HashMap<Integer, Direction>();
    static {
	for (Direction d : Direction.values())
	    lookup.put(d.getBearingValue(), d);
    }

    public static Direction getDirection(int bearingValue) {
	return lookup.get(bearingValue);
    }

}
