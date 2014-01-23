package core.scripting;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.powerbot.event.PaintListener;
import org.powerbot.script.*;

import core.Context;
import core.scripting.alcher.AlchingTask;
import core.userGraphics.Dimension;
import core.userGraphics.interfaceUnits.Label;
@Manifest(description = "Will alch everything but nature runes in your inventory.", name = "Simple Alcher")
public class Alcher extends PollingScript implements PaintListener, MouseListener{
	private Context ctx;
	private Label titleLbl, timeLbl;
	public Alcher(){
		ctx = new Context(super.ctx);
		ctx.newPanel(new Dimension(5,5,175,80));
		titleLbl = new Label(new Dimension(5,5), ctx.ui, "Jays Simple Alcher");
		timeLbl = new Label(new Dimension(5,20), ctx.ui, "" + ctx.timeUtil.timeRunning());
		ctx.ui.submitComponent(titleLbl, timeLbl);
		ctx.ui.load(this);
		ctx.operator.submit(new AlchingTask(ctx));
	}
	
	@Override
	public int poll() {
		ctx.operator.operate();
		return ctx.timeUtil.tickTime();
	}
	
	@Override
	public void repaint(Graphics g) {
		ctx.ui.draw(g);
		timeLbl.setLabel(ctx.timeUtil.timeRunning());
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
	public void mouseClicked(MouseEvent e) {	}

	@Override
	public void mouseEntered(MouseEvent e) {	}

	@Override
	public void mouseExited(MouseEvent e) {	}
}
