package core.userGraphics.interfaceUnits.transparentBox;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.util.*;

import org.powerbot.script.AbstractScript;

import core.Context;
import core.userGraphics.*;
import core.userGraphics.interfaceUnits.button.*;
public class TransparentBox extends InterfaceUnit {
	private ArrayList<InterfaceUnit> components;
	private boolean isShown = true, isLoaded = false;
	private Image image;
	public Context ctx;
	public TransparentBox(Dimension plane, Context ctx){
		super(plane);
		this.ctx = ctx;
		components = new ArrayList<InterfaceUnit>();
		submitComponent(
				new HideButton(new Dimension(this.plane.getWidth()-20,0,20,20), this));
		
	}

	@Override
	public void draw(Graphics g) {
		if(isLoaded){
			for(InterfaceUnit component : components){
				if(component != null){
					if(component instanceof Button){
						component.draw(g);
					} else {
						if(isShown){
							component.draw(g);
						}
					}
				}
			}
			if(isShown){
				if(getPlane().getWidth() == -1){
					g.drawImage(image, getPlane().getX(), getPlane().getY(), null);
				} else {
					g.drawImage(image, getPlane().getX(), getPlane().getY(), getPlane().getWidth(), getPlane().getHeight(), null);
				}
			}
		}
	}

	public void drawImageOn(Image image, Graphics g, int x, int y, int width, int height){
		g.drawImage(image, (getPlane().getX() + x), (getPlane().getY() + y), width, height, null);
	}

	public void drawStringOn(String string, Graphics g, int x, int y){
		int stringWidth;
		if((stringWidth = g.getFontMetrics().stringWidth(string)) >= getPlane().getWidth()){
			getPlane().setWidth(stringWidth + 10);
		}
		g.drawString(string, (getPlane().getX() + x), (getPlane().getY() + y +10));
	}

	public void submitComponent(InterfaceUnit...components){
		Collections.addAll(this.components, components);
	}

	public boolean show(boolean show){
		return isShown = show;
	}

	public boolean isShown(){
		return isShown;
	}

	public void mousePressed(MouseEvent e){
		for(InterfaceUnit component : components){
			if(component instanceof Button){
				((Button)component).mousePressed(e);
			}
		}
	}
	
	public void mouseReleased(){
		for(InterfaceUnit component : components){
			if(component instanceof Button){
				((Button)component).mouseReleased();
			}
		}
	}

	public void load(AbstractScript script){
		image = script.downloadImage("http://imageshack.us/a/img829/7638/r5ga.png");
		for(InterfaceUnit component : components){
			if(component instanceof Button){
				((Button)component).load(script);
			}
		}
		isLoaded = true;
	}
}
