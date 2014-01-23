package core.util.execService;

public class Operator{
	public static int tick;
	public static final int MAX_STATES = 50;
	protected Operation operation;
	protected Operation[] operations;
	
	public Operator(){
		operations = new Operation[MAX_STATES];
	}
	
	public void operate() {
		cycle();
	}
	
	public void cycle(){
		for(Operation iter : operations){
			if(invoke(iter) && operation.validate()){
				operation.operate();
			}
		}
	}
	
	public boolean submit(Operation state){
		int slot;
		return (slot = getEmptySlot()) != -1 && (operations[slot] = state) != null;
	}
	
	public boolean invoke(Operation state){
		return (this.operation = state) != null;
	}
	
	public void submit(Operation...states){
		for(Operation state : states){
			submit(state);
		}
	}
	
	private int getEmptySlot(){
		int slot = -1;
		for(int i = 0; i < operations.length; i++){
			if(operations[i] == null){
				slot = i;
				break;
			}
		}
		return slot;
	}
}
