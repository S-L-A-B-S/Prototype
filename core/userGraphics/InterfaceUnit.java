package core.userGraphics;
import java.awt.Graphics;
import java.awt.Image;

import org.powerbot.script.AbstractScript;

import core.userGraphics.interfaceUnits.transparentBox.TransparentBox;

public abstract class InterfaceUnit {
	protected Dimension plane;
	private InterfaceUnit container;
	private TransparentBox panel;
	public InterfaceUnit(Dimension plane){
		this.plane = setPlane(plane);
	}
	
	public InterfaceUnit(Dimension plane, InterfaceUnit container){
		this(plane);
		if(container instanceof TransparentBox){
			setPanel((TransparentBox)container);
		}
		setContainer(container);
	}
	
	public Image getImage(String url, AbstractScript script){
		return script.downloadImage(url);
	}

	public Dimension setPlane(Dimension plane){
		return this.plane = plane;
	}
	
	public Dimension getPlane(){
		return plane;
	}
	
	public InterfaceUnit setContainer(InterfaceUnit container){
		return this.container = container;
	}
	
	public InterfaceUnit getContainer(){
		return container;
	}
	
	public abstract void draw(Graphics g);
	

	public TransparentBox getPanel(){
		if(panel == null){
			if(container != null){
				if(container instanceof TransparentBox){
					return setPanel((TransparentBox)container);
				} else {
					if(container.getContainer() != null){
						getPanel();
					}
				}
			}
		} else {
			return panel;
		}
		return null;
	}
	
	public TransparentBox setPanel(TransparentBox panel){
		return this.panel = panel;
	}
}
