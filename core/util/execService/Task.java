package core.util.execService;
import core.Context;
import core.Provider;
public abstract class Task extends Provider implements Operation{
	public Task(Context ctx) {
		super(ctx);
	}
}
