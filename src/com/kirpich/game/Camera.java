package com.kirpich.game;

import com.badlogic.gdx.Gdx;

public class Camera {
	
	float x,y;
	float nx,ny;
	float taget_x,taget_y, tx,ty;
	
	float camera_speed=5;
	
	Camera(){
		x=0;
		y=0;
	}
	
	public void update(){
		Player p = KirpichMain.me.player;
		
		/*if(p.x>Gdx.graphics.getWidth()-x-350){
			if(p.speed>0) x-=p.speed;
		}
		if(p.x<-x+350){
			if(p.speed<0) x-=p.speed;
		}*/
		
		taget_x=(p.x-Gdx.graphics.getWidth()/2);
		tx=taget_x-nx;
		
		nx+=tx/camera_speed;
		
		if(nx<-1770) nx=-1770;
		if(nx>494) nx=494;
		
		x=-nx;
	}

}
