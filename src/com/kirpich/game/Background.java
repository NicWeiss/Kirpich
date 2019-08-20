package com.kirpich.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {

	Texture fonfar;
	Texture fonmidle;
	Texture fonclose;
	
	Texture fire[];
	int fire_frame,fire_temp;
	float xf,xm,xc,yf,ym,yc,xsf,xsm,xsc;
	
	Background(){
		fonfar = new Texture("background000.png");
		fonmidle = new Texture("back2.png");
		fonclose = new Texture("back1.png");
		xsf=300;
		xsm=300;
		xsc=300;
		yf=0;
		ym=0;
		yc=0;
		
		fire_frame=0;
		fire=new Texture[7];
		for(int i=0;i<7;i++){
			fire[i]=new Texture("bg_fire/"+i+".png");
		}
	}
	
	
	public void draw(SpriteBatch batch, Camera camera){
		xf=(float) (camera.x*0.1);
		xm=(float) (camera.x*0.17);
		xc=(float) (camera.x*0.5);
		
		batch.draw(fonfar, xf-xsf, yf);
		batch.draw(fonmidle, xm-xsm, ym);
		batch.draw(fire[fire_frame], xm+90-xsm, ym+90);
		batch.draw(fonclose, xc-xsc, yc);
		batch.draw(fonclose, xc-xsc-fonclose.getWidth(), yc);
		batch.draw(fonclose, xc-xsc+fonclose.getWidth(), yc);
		
		
		fire_temp++;
		
		if(fire_temp>5){
			fire_frame++;
			fire_temp=0;
			if(fire_frame>6) fire_frame=0;
		}
		
	}

}
