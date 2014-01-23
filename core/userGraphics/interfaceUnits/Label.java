package core.userGraphics.interfaceUnits;
import java.awt.Graphics;

import core.userGraphics.Dimension;
import core.userGraphics.InterfaceUnit;
public class Label extends InterfaceUnit {
	private String label;
	
	public Label(Dimension plane, InterfaceUnit container, String label) {
		super(plane, container);
		setLabel(label);
	}

	@Override
	public void draw(Graphics g) {
		if(getPanel() != null){
			getPanel().drawStringOn(label, g, getPlane().getX(), getPlane().getY());
		}
	}
	
	public String setLabel(String label){
		return this.label = label;
	}
	
	public String getLabel(){
		return label;
	}

}
