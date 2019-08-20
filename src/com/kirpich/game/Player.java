package com.kirpich.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {

	public float x;
	public float y;
	public float speed;
	
	public int mode; 
	
	Texture heart;
	ArrayList<Texture> img;
	
	BitmapFont font;
	
	Player(){
		img = new ArrayList<Texture>();
		for(int i=0;i<2;i++){
			img.add(new Texture("player/"+i+".png"));
		}
		heart = new Texture("heart.png");
		x=Gdx.graphics.getWidth()/2;
		y=0;
		speed=0;
		
		font=new BitmapFont();
	}
	
	public void draw(SpriteBatch batch, Camera camera){
		x=x+speed;
		//x=x+Gdx.input.getAccelerometerY();
		if(x<-1770) {
			x=-1770;
			speed=0;
		}
		
		if(x>494+Gdx.graphics.getWidth()-img.get(mode).getWidth()){
			x=494+Gdx.graphics.getWidth()-img.get(mode).getWidth();
			speed=0;
		}

		batch.draw(img.get(mode), x+camera.x, y+camera.y);
		

		font.draw(batch, ""+KirpichMain.me.physic.totalmoney , 50, Gdx.graphics.getHeight()-70);
		font.draw(batch, ""+KirpichMain.me.physic.life , 50, Gdx.graphics.getHeight()-30);
		
		batch.draw(KirpichMain.me.money.get(0).img, 15, Gdx.graphics.getHeight()-90);
		batch.draw(heart, 10, Gdx.graphics.getHeight()-50);
		
		font.draw(batch, "x="+x , x+camera.x, y+50+camera.y);
		font.draw(batch, "camera_nx="+camera.nx , x+camera.x, y+70+camera.y);
		//font.draw(batch, KirpichMain.me.physic.col+" | "+KirpichMain.me.physic.px+" | "+KirpichMain.me.physic.mx , x+camera.x, y+70+camera.y);
		
		/*font.draw(batch, "y="+Gdx.input.getAccelerometerY() , x, y+100);
		font.draw(batch, "z="+Gdx.input.getAccelerometerZ() , x, y+150);*/
	}
	
	public int getWidth(){
		return img.get(mode).getWidth();
	}
	
	public int getHeight(){
		return img.get(mode).getHeight();
	}

}
