package core.scripting.yewCutter;
import core.Context;
import core.util.execService.Task;
public class BankTask extends Task {

	public BankTask(Context ctx) {
		super(ctx);
	}

	@Override
	public boolean validate() {
		return (ctx.bank.isOnScreen() || ctx.walking.FALLY_YEW_BANK.contains(ctx.players.local()))
				&& ctx.backpack.select().count() > 27;
	}

	@Override
	public void operate() {
		
		if(ctx.bank.open()){
			tickSleep();
			if(ctx.bank.depositInventory()){
				tickSleep();
				if(ctx.bank.withdraw(1359, 1)){
					tickSleep();
				}
				if(ctx.bank.close()){
					tickSleep();
				}
			}
		}
	}

}
