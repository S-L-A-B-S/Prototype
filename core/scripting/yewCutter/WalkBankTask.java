package core.scripting.yewCutter;

import org.powerbot.script.wrappers.TilePath;

import core.Context;
import core.util.execService.Task;

public class WalkBankTask extends Task{
	TilePath path;
	public WalkBankTask(Context ctx) {
		super(ctx);
		path = new TilePath(ctx, ctx.walking.RIMMINGTON_YEWS_TO_BANK);
	}

	@Override
	public boolean validate() {
		return ctx.backpack.select().count() > 27 
				&& (!ctx.bank.isOnScreen() || !ctx.walking.FALLY_YEW_BANK.contains(ctx.players.local()));
	}

	@Override
	public void operate() {
		
		if(path.traverse()){
			sleep(250,500);
		}
		
	}

}
