package com.anz.prep.robomove;

import com.anz.prep.robomove.model.Surface;

public class ReportCommand implements Command {

    Surface tableTop;

    public ReportCommand(Surface tableTop) {
	super();
	this.tableTop = tableTop;
    }

    @Override
    public void execute() {

    }

}
