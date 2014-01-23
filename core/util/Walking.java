package core.util;

import org.powerbot.script.util.Random;
import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.Tile;

import core.Context;
import core.Provider;

public class Walking extends Provider{
	public final Area DRAYNOR_TREE_ZONE = new Area(new Tile[] { new Tile(3080, 3238, 0), new Tile(3103, 3238, 0), 
													new Tile(3103, 3207, 0), new Tile(3090, 3208, 0) }),
						DRAYNOR_BANK_ZONE = new Area(new Tile[] { new Tile(3086, 3247, 0), new Tile(3086, 3239, 0), 
											new Tile(3097, 3239, 0), new Tile(3097, 3247, 0) }),
						RIMMINGTON_YEW_TREES = new Area(new Tile[]{ new Tile(2945, 3239, 0), new Tile(2945, 3224, 0),
																	new Tile(2920, 3224, 0), new Tile(2920, 3239, 0)}),
						FALLY_YEW_BANK = new Area(new Tile[] { new Tile(3007, 3351, 0), new Tile(3007, 3360, 0), 
																new Tile(3022, 3360, 0), new Tile(3022, 3351, 0) });
	public final Tile[] DRAYNOR_BANK_TO_TREES, RIMMINGTON_YEWS_TO_BANK;
	
	public Walking(Context ctx) {
		super(ctx);
		DRAYNOR_BANK_TO_TREES = new Tile[] { 
				new Tile(Random.nextInt(3093-2, 3093+2), Random.nextInt(3244-2, 3244+2), 0),
				new Tile(Random.nextInt(3089-2, 3089+2), Random.nextInt(3231-2, 3231+2), 0) };
		RIMMINGTON_YEWS_TO_BANK = new Tile[] { new Tile(2932, 3230, 0), new Tile(2935, 3231, 0), new Tile(2936, 3234, 0), 
				new Tile(2939, 3234, 0), new Tile(2942, 3236, 0), new Tile(2945, 3238, 0), 
				new Tile(2948, 3241, 0), new Tile(2951, 3242, 0), new Tile(2954, 3243, 0), 
				new Tile(2956, 3246, 0), new Tile(2959, 3249, 0), new Tile(2962, 3251, 0), 
				new Tile(2964, 3254, 0), new Tile(2966, 3257, 0), new Tile(2969, 3260, 0), 
				new Tile(2971, 3263, 0), new Tile(2974, 3265, 0), new Tile(2976, 3268, 0), 
				new Tile(2977, 3271, 0), new Tile(2978, 3274, 0), new Tile(2980, 3277, 0), 
				new Tile(2982, 3280, 0), new Tile(2984, 3283, 0), new Tile(2986, 3286, 0), 
				new Tile(2987, 3289, 0), new Tile(2989, 3292, 0), new Tile(2992, 3295, 0), 
				new Tile(2993, 3298, 0), new Tile(2995, 3301, 0), new Tile(2997, 3304, 0), 
				new Tile(2999, 3307, 0), new Tile(3001, 3310, 0), new Tile(3002, 3313, 0), 
				new Tile(3003, 3316, 0), new Tile(3003, 3319, 0), new Tile(3003, 3322, 0), 
				new Tile(3004, 3325, 0), new Tile(3005, 3327, 0), new Tile(3005, 3330, 0), 
				new Tile(3005, 3333, 0), new Tile(3005, 3336, 0), new Tile(3006, 3339, 0), 
				new Tile(3006, 3342, 0), new Tile(3007, 3345, 0), new Tile(3007, 3348, 0), 
				new Tile(3006, 3351, 0), new Tile(3006, 3354, 0), new Tile(3006, 3357, 0), 
				new Tile(3008, 3360, 0), new Tile(3011, 3360, 0), new Tile(3013, 3357, 0), 
				new Tile(3014, 3354, 0) };
	}
}
