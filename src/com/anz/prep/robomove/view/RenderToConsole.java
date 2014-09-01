package com.anz.prep.robomove.view;

import com.anz.prep.robomove.model.Surface;

/**
 * 
 * @author neville_fernandes
 * 
 */
public class RenderToConsole implements Renderer {

    Surface tableTop;

    public RenderToConsole(Surface tableTop) {
	this.tableTop = tableTop;
    }

    @Override
    public void render() {
	if (tableTop.getRobot() != null) {
	    System.out.println(tableTop.getRobot().toString());
	} else {
	    System.err
		    .println("Robot not found, ensure that robot is placed on the surface");
	}
    }

}
