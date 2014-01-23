package core.userGraphics.interfaceUnits.button;
import java.awt.Image;

import org.powerbot.script.AbstractScript;

import core.userGraphics.Dimension;
import core.userGraphics.InterfaceUnit;
public class PauseButton extends Button {
	public Image pauseImg, playImg;
	public boolean paused = false;
	public PauseButton(Dimension plane, InterfaceUnit container) {
		super(plane, container);
		
	}

	@Override
	public void onAction() {
		paused = !paused;
		if(paused){
			setImage(playImg);
		} else {
			setImage(pauseImg);
		}
	}

	@Override
	public void load(AbstractScript script) {
		
		pauseImg = script.downloadImage("http://imageshack.us/photo/my-images/34/im93.png");
		playImg = script.downloadImage("http://imageshack.us/a/img20/7601/sb5e.png");
		setImage(pauseImg);
		
	}


}
