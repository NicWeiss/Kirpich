package com.kirpich.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Kirpich {
	
	public float x;
	public float y;
	public float g; //скорость падения
	
	
	
	Texture img;
	
	Kirpich(){
		img = new Texture("k.png");
		x=(int)(Math.random()*(Gdx.graphics.getWidth()+3000))-2000;
		y=(int)(Math.random()*Gdx.graphics.getHeight()+Gdx.graphics.getHeight());
		
	}
	
	public void draw(SpriteBatch batch, Camera camera){
		batch.draw(img, x+camera.x, y+camera.y);
		
	}
	public void fall(){
		if (y<-50){ 
			y=Gdx.graphics.getHeight();
			g=0;
			if(Math.random()>0.1){
				x=(int)(Math.random()*(Gdx.graphics.getWidth()+3000))-2000;
			}else{
				x=(float) (KirpichMain.me.player.x-img.getWidth()/2+KirpichMain.me.player.getWidth()/2+((Math.random()*300)-150));
			}
			y=(int)(Math.random()*Gdx.graphics.getHeight()+Gdx.graphics.getHeight());
		}
	    y=y-g;
		g=g+(float)0.08;
	}

}
