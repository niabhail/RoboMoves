package com.anz.prep.robomove;

import com.anz.prep.robomove.model.Surface;

public class RightCommand implements Command {

    Surface tableTop;

    public RightCommand(Surface tableTop) {
	super();
	this.tableTop = tableTop;
    }

    @Override
    public void execute() {
	tableTop.getRobot().turnRight();
    }

}
