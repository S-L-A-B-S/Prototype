package core;
import org.powerbot.script.methods.MethodProvider;
import org.powerbot.script.util.Random;
public class Provider extends MethodProvider{
	protected Context ctx;
	
	public Provider(Context ctx) {
		super(ctx);
		this.ctx = ctx;
	}
	public int tickTime(){
		int ran = Random.nextInt(600, 700);
		int ran1 = Random.nextInt(ran+600, ran+700);
		return Random.nextInt(ran, ran1);
	}
	
	
	public void sleep(int ranStart, int ranEnd, int modifier){//randomized according to the modifier
		sleep(Random.nextInt(ranStart-modifier, ranStart+modifier), Random.nextInt(ranEnd-modifier, ranEnd+modifier));
	}
	
	public void tickSleep(){
		sleep(tickTime());
	}
}
