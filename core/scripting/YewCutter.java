package core.scripting;
import java.awt.Graphics;
import java.awt.event.*;

import org.powerbot.event.PaintListener;
import org.powerbot.script.*;

import core.Context;
import core.scripting.yewCutter.*;
import core.userGraphics.Dimension;
import core.userGraphics.interfaceUnits.Label;
@Manifest(description = "SimpleWC", name = "SimpleWC")
public class YewCutter extends PollingScript implements PaintListener, MouseListener{
	Context ctx;
	Label titleLbl, timeLbl, xpLbl, profitLbl;
	public YewCutter(){
		ctx = new Context(super.ctx);
		ctx.newPanel(new Dimension(10,10,150,100));
		ctx.ui.submitComponent(titleLbl = new Label(new Dimension(5,5), ctx.ui, "Jays SimpleWC"),
									timeLbl = new Label(new Dimension(5,20), ctx.ui, ""));
		ctx.operator.submit(new BankTask(ctx), new CutWoodTask(ctx), 
								new WalkBankTask(ctx), new WalkTreesTask(ctx),
								new XpTrackerTask(ctx));
		ctx.ui.load(this);
		//ctx.antiban.setEnabled(Skills.WOODCUTTING);
		
	}
	@Override
	public int poll() {
		ctx.operator.operate();
		return ctx.timeUtil.tickTime();
	}
	
	@Override
	public void repaint(Graphics g) {
		timeLbl.setLabel(ctx.timeUtil.timeRunning() + " " + ctx.players.local().getAnimation());
		ctx.ui.draw(g);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		ctx.ui.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) { 
		ctx.ui.mouseReleased();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) { }

	@Override
	public void mouseEntered(MouseEvent arg0) { }

	@Override
	public void mouseExited(MouseEvent arg0) { }
	
}
