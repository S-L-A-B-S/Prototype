package core.util;

public class Timer {
	long start;
	public Timer(){
		start = System.currentTimeMillis();
	}
	
	public long getTimeRunning(){
		return System.currentTimeMillis()-start;
	}
	
	public void reset(){
		start = System.currentTimeMillis();
	}
}
