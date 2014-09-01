/**
 * 
 */
package com.anz.prep.robomove.tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.anz.prep.robomove.Action;
import com.anz.prep.robomove.Direction;
import com.anz.prep.robomove.controller.RoboMoveEngine;

/**
 * @author neville_fernandes
 * 
 */
public class ActionControllerTest {

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
     * {@link com.anz.prep.robomove.controller.ActionController#ActionController(com.anz.prep.robomove.model.Surface)}
     * .
     */
    @Test
    public final void testActionController() {
    }

    /**
     * Test method for
     * {@link com.anz.prep.robomove.controller.ActionController#place(int, int, com.anz.prep.robomove.Direction)}
     * .
     */
    @Test
    public final void testPlace() {
	roboMove.executeAction(Action.PLACE, 0, 0, Direction.EAST);
	roboMove.executeAction(Action.REPORT);
	Assert.assertEquals("0,0,EAST", outContent.toString().trim());

    }

    /**
     * Test method for
     * {@link com.anz.prep.robomove.controller.ActionController#move()}.
     */
    @Test
    public final void testMove() {
	roboMove.executeAction(Action.PLACE, 0, 0, Direction.EAST);
	roboMove.executeAction(Action.MOVE);
	roboMove.executeAction(Action.MOVE);
	roboMove.executeAction(Action.REPORT);
	Assert.assertEquals("2,0,EAST", outContent.toString().trim());

    }

    /**
     * Test method for
     * {@link com.anz.prep.robomove.controller.ActionController#left()}.
     */
    @Test
    public final void testLeft() {
	roboMove.executeAction(Action.PLACE, 0, 0, Direction.EAST);
	roboMove.executeAction(Action.LEFT);
	roboMove.executeAction(Action.MOVE);
	roboMove.executeAction(Action.REPORT);
	Assert.assertEquals("0,1,NORTH", outContent.toString().trim());
    }

    /**
     * Test method for
     * {@link com.anz.prep.robomove.controller.ActionController#right()}.
     */
    @Test
    public final void testRight() {
	roboMove.executeAction(Action.PLACE, 0, 0, Direction.NORTH);
	roboMove.executeAction(Action.RIGHT);
	roboMove.executeAction(Action.MOVE);
	roboMove.executeAction(Action.REPORT);
	Assert.assertEquals("1,0,EAST", outContent.toString().trim());
    }

}
