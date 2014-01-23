package core.scripting.alcher;
import org.powerbot.script.lang.Filter;
import org.powerbot.script.util.Random;
import org.powerbot.script.wrappers.Item;

import core.Context;
import core.userGraphics.Dimension;
import core.userGraphics.interfaceUnits.Label;
import core.util.execService.Task;
public class AlchingTask extends Task{
	private int alchsCast = 0, profit = 0, xpGained = 0;
	private Label alchsLbl, profitLbl, xpLbl;
	public AlchingTask(Context ctx) {
		super(ctx);
		alchsLbl = new Label(new Dimension(5,35), ctx.ui, "");
		profitLbl = new Label(new Dimension(5,50), ctx.ui, "");
		xpLbl = new Label(new Dimension(5, 65), ctx.ui, "");
		ctx.ui.submitComponent(alchsLbl, profitLbl, xpLbl);
	}

	@Override
	public boolean validate() {
		return ctx.game.isLoggedIn() && ctx.backpack.select().poll() != null;
	}
	
	
	Item alchItem;
	@Override
	public void operate() {
		if(alchItem != null){
			alchsCast++;
			profit = alchsCast * 15;
			xpGained+=65;
			alchsLbl.setLabel("Alchs Cast(/hr): " + alchsCast 
					+ "(" + ctx.timeUtil.figureFormatter.format(ctx.timeUtil.perHour(alchsCast)) + ")");
			profitLbl.setLabel("Profit(/h): " + ctx.timeUtil.figureFormatter.format(profit)
					+ "(" + ctx.timeUtil.figureFormatter.format(ctx.timeUtil.perHour(profit)) + ")");
			xpLbl.setLabel("XP(/h): "  + ctx.timeUtil.figureFormatter.format(xpGained) 
					+ "(" + ctx.timeUtil.figureFormatter.format(ctx.timeUtil.perHour(xpGained)) + ")");
			if(ctx.combatBar.select().poll().select()){
				alchItem.click();
 				do{
					sleep(Random.nextInt(10, 100));
				}while(ctx.players.local().getAnimation() != -1);
			}
		} else {
			alchItem = ctx.backpack.select().select(natFilter).poll();
		}
	}
	
	
	
	Filter<Item> natFilter = new Filter<Item>(){

		@Override
		public boolean accept(Item item) {
			return item.getId() != 561;
		}
		
	};

}
