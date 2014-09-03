package com.anz.prep.robomove;

import com.anz.prep.robomove.model.Surface;

public class LeftCommand implements Command {

    Surface tableTop;

    public LeftCommand(Surface tableTop) {
	super();
	this.tableTop = tableTop;
    }

    @Override
    public void execute() {
	tableTop.getRobot().turnLeft();
    }

}
