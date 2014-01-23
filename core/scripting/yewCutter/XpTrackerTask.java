package core.scripting.yewCutter;

import org.powerbot.script.methods.Skills;

import core.Context;
import core.Provider;
import core.userGraphics.Dimension;
import core.userGraphics.interfaceUnits.Label;
import core.util.execService.Task;

public class XpTrackerTask extends Task{
	Label xpLbl, profitLbl;
	final int SKILL_TO_TRACK = Skills.WOODCUTTING;
	int startXp = 0, xpGained = 0, lastXp = 0, profit = 0;
	public XpTrackerTask(Context ctx) {
		super(ctx);
		ctx.ui.submitComponent(xpLbl = new Label(new Dimension(5,35), ctx.ui, ""),
				profitLbl = new Label(new Dimension(5,50), ctx.ui, ""));
		
		new Thread(new XpTracker(ctx)).start();
		
	}
	
	class XpTracker extends Provider implements Runnable{

		public XpTracker(Context ctx) {
			super(ctx);
		}

		@Override
		public void run() {
			while(!ctx.getBot().isStopping()){
				if(ctx.game.isLoggedIn()){
					if(startXp == 0){
						startXp = ctx.skills.getExperience(SKILL_TO_TRACK); 
					} else {
						xpGained = ctx.skills.getExperience(SKILL_TO_TRACK) - startXp;
					}
					tickSleep();
				}
			}
		}	
	}

	@Override
	public boolean validate() {
		return ctx.game.isLoggedIn()
			   && startXp != 0
			   && xpGained != lastXp;
	}

	@Override
	public void operate() {
		
		lastXp = xpGained;
		profit = (int) ((xpGained/175) * 592);
		xpLbl.setLabel("XP(/h): " + xpGained + " (" + ctx.timeUtil.perHour(xpGained) + ")");
		profitLbl.setLabel("Profit(/h): " + profit + " (" + ctx.timeUtil.perHour(profit) + ")");
	}

}
