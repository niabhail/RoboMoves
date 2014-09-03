/**
 * 
 */
package com.anz.prep.robomove;

import com.anz.prep.robomove.model.Surface;

/**
 * @author neville_fernandes
 * 
 */
public class MoveCommand implements Command {

    Surface tableTop;

    public MoveCommand(Surface tableTop) {
	super();
	this.tableTop = tableTop;
    }

    @Override
    public void execute() {
	tableTop.getRobot().move();
    }

}
