package core.scripting.yewCutter;
import org.powerbot.script.wrappers.*;

import core.*;
import core.util.execService.Task;
public class CutWoodTask extends Task {
	public final int[] WILLOW_TREES = {38616, 38627, 58006},
			YEW_TREES = {38755};
	public CutWoodTask(Context ctx) {
		super(ctx);	
	}

	@Override
	public boolean validate() {
		return ctx.players.local().isIdle()
				&& ctx.backpack.select().count() < 28 
				&& ctx.walking.RIMMINGTON_YEW_TREES.contains(ctx.players.local());
	}
	
	
	@Override 
	public void operate() {
		
		GameObject tree;
		if((tree = ctx.objects.select().id(YEW_TREES).nearest().poll()) != null){
			ctx.camera.turnTo(tree);
			if(tree.click()){
				System.out.println(tree.getName() + ", " + tree.getId() + ", confirmed");
				tickSleep();
				return;
			} else {
				System.out.println(tree.getName() + ", " + tree.getId() + ", interaction failure");
				ctx.camera.setAngle(ctx.camera.getYaw() + 5);
				ctx.movement.newTilePath(new Tile(tree.getLocation().x - 1, tree.getLocation().y, 0)).traverse();
			}
		
			
		}
	}
}
