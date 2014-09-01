/**
 * 
 */
package com.anz.prep.robomove.tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.anz.prep.robomove.Action;
import com.anz.prep.robomove.Direction;
import com.anz.prep.robomove.controller.RoboMoveEngine;

/**
 * @author neville_fernandes
 * 
 */
public class RoboMoveEngineTest {

    private static final Action TEST = null;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    RoboMoveEngine roboMove;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	roboMove = new RoboMoveEngine();
	System.setOut(new PrintStream(outContent));
    }

    /**
     * Test method for
     * {@link com.anz.prep.robomove.controller.RoboMoveEngine#executeAction(com.anz.prep.robomove.Action, java.lang.Object[])}
     * .
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testExecuteAction() {

	// valid case
	roboMove.executeAction(Action.PLACE, 3, 4, Direction.SOUTH);
	roboMove.executeAction(Action.REPORT);
	Assert.assertEquals("3,4,SOUTH", outContent.toString().trim());

	// exception conditions
	Assert.assertEquals("Action:PLACE expects arguments x,y,direction.",
		roboMove.executeAction(Action.PLACE));
    }

}
