package com.kirpich.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Startmenu implements InputProcessor{
	Texture m1,m2,m3,m4;
	int x,y,y1;
	int tmpx,tmpy;
	
	
	Startmenu(){
		m1 = new Texture("menu/start.png");
		m2 = new Texture("menu/rating.png");
		m3 = new Texture("menu/buy.png");
		m4 = new Texture("menu/options.png");
		
	}

	public void punction(SpriteBatch batch){
		x=(Gdx.graphics.getWidth()/2)-(m1.getWidth()/2);
		y=(Gdx.graphics.getHeight()/4);
		y1=y/4;
		batch.draw(m1, x, Gdx.graphics.getHeight()-y-y1);
		tmpy=y-y1+10;
		y=y+(Gdx.graphics.getHeight()/6);
		batch.draw(m2, x, Gdx.graphics.getHeight()-y-y1);
		y=y+(Gdx.graphics.getHeight()/6);
		batch.draw(m3, x, Gdx.graphics.getHeight()-y-y1);
		y=y+(Gdx.graphics.getHeight()/6);
		batch.draw(m4, x, Gdx.graphics.getHeight()-y-y1);
		
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
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		if (arg0>x){if(arg0<(x+m1.getWidth())){	if(arg1>tmpy){if(arg1<(tmpy+m1.getHeight())){
			Gdx.input.setInputProcessor(KirpichMain.me.control);
			KirpichMain.me.menu=false;
			KirpichMain.me.gameplay=true;
			}}}}
		return false;
	}

}
