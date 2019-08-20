package com.kirpich.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Money {
	public float x;
	public float y;
	public float g; //скорость падения
	public int type;
	
	//Константы
	public static final int NORMAL_GEM = 0;
	public static final int BLUE_GEM = 1;
	
	Texture img;
	
	Money(){
		x=(int)(Math.random()*(Gdx.graphics.getWidth()+3000))-2000;
		y=(int)(Math.random()*Gdx.graphics.getHeight()+Gdx.graphics.getHeight());
		float temp=(float)Math.random();
		if(temp<0.5) type=0;
		else type=1;
		img = new Texture("gems/"+type+".png");
	}
	
	public void draw(SpriteBatch batch, Camera camera){
		batch.draw(img, x+camera.x, y+camera.y);
		
	}
	public void fall(){
		if (y<-50){ 
			y=Gdx.graphics.getHeight();
			g=0;
			x=(int)(Math.random()*(Gdx.graphics.getWidth()+3000))-2000;
			y=(int)(Math.random()*Gdx.graphics.getHeight()+Gdx.graphics.getHeight());
		}
	    y=y-g;
		g=g+(float)0.008;
	}
}
