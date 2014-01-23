package core.util.execService;
public class IndependantOperator extends Operator{
	@Override
	public void cycle(){
		if(operation != null && operation.validate()){
			operation.operate();
		} else {
			for(Operation operation : operations){
				if(operation != null && operation.validate()){
					invoke(operation);
				}
			}
		}
	}
}
