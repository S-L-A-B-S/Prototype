package core.scripting.yewCutter;
import org.powerbot.script.wrappers.TilePath;

import core.Context;
import core.util.execService.Task;

public class WalkTreesTask extends Task{
	TilePath path;
	public WalkTreesTask(Context ctx) {
		super(ctx);
		path = new TilePath(ctx, ctx.walking.RIMMINGTON_YEWS_TO_BANK).reverse();
	}

	@Override
	public boolean validate() {
		return ctx.backpack.select().count() < 2 
				&& !ctx.walking.RIMMINGTON_YEW_TREES.contains(ctx.players.local());
	}

	@Override
	public void operate() {
		if(path.traverse()){
			sleep(250, 500);
		}
	}
}
