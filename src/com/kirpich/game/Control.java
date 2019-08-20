package com.kirpich.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;


public class Control implements InputProcessor{
	/*public float left;
	public float right;*/
	public Fingers fingers[];
	
	Control(){
		super();
		/*left=0;
		right=0;*/
		fingers = new Fingers[3];
		for(int i=0;i<3;i++) fingers[i] = new Fingers();
		
	}
	
	public void gsensor(){
		
	}
	

	@Override
	public boolean keyDown(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int scrx, int scry, int fng, int btn) {
		// TODO Auto-generated method stub
		fingers[fng].x = scrx;
		fingers[fng].y = scry;
		fingers[fng].touched = true;
		
		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int scrx, int scry, int fng, int btn) {
		// TODO Auto-generated method stub
		fingers[fng].xu = scrx;
		fingers[fng].yu = scry;
		fingers[fng].touched = false;
		return false;
	}
	
	private class Fingers{
		int x,y;
		int xu,yu;
		boolean touched;
	}
	
	boolean everything_up;
	
	public void tap(){
		
		Player p = KirpichMain.me.player;

		p.speed+=((float)Gdx.input.getAccelerometerY()*0.3);
		everything_up=true;
		for (int i=0;i<3;i++){
			if (fingers[i].touched){
				everything_up=false;
				if (fingers[i].x>(Gdx.graphics.getWidth()/2)){p.speed=(float) (p.speed+0.5);}
				if (fingers[i].x<(Gdx.graphics.getWidth()/2)){p.speed=(float) (p.speed-0.5);}
				break;
			}

			if (everything_up){
				if (p.speed<0){p.speed=(float) (p.speed+0.1);}
				if (p.speed>0){p.speed=(float) (p.speed-0.1);}
				if(Math.abs(p.speed)<0.1) p.speed=0;
			}
		}
	}

}
