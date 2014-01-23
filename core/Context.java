package core;
import org.powerbot.script.methods.MethodContext;

import core.userGraphics.Dimension;
import core.userGraphics.interfaceUnits.transparentBox.TransparentBox;
import core.util.*;
import core.util.execService.IndependantOperator;
public class Context extends MethodContext {
	public TimeUtil timeUtil;
	public IndependantOperator operator;
	public TransparentBox ui;
	public Walking walking;
	public Context(MethodContext ctx) {
		super(ctx);
		operator = new IndependantOperator();
		timeUtil = new TimeUtil(this);
		walking = new Walking(this);
		antipatterns.setEnabled(false);
	}
	
	public void newPanel(Dimension plane){
		this.ui = new TransparentBox(plane, this);
	}		
}
