package core.util;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import core.Context;
import core.Provider;
public class TimeUtil extends Provider{
	public final long START_TIME;
	public DecimalFormat figureFormatter;
	public TimeUtil(Context ctx) {
		super(ctx);
		START_TIME = System.currentTimeMillis();
		figureFormatter = new DecimalFormat("###,###,###");
	}

	public String timeFormat(long millis){
		return String.format("%02d:%02d:%02d", 
			    TimeUnit.MILLISECONDS.toHours(millis),
			    TimeUnit.MILLISECONDS.toMinutes(millis) - 
			    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
			    TimeUnit.MILLISECONDS.toSeconds(millis) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
	}
	
	public String timeRunning(){
		return timeFormat(System.currentTimeMillis()-START_TIME);
	}
	
	public int  perHour(int amount){
		return (int) ((amount) * 3600000D / (System.currentTimeMillis() - START_TIME));
	}

	
	
}
