package com.kirpich.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Physic {
	float px,py,px1,py1;
	int i;
	public int totalmoney,life;
	BitmapFont font;
	public float x,y,speed;
	Sound sound = Gdx.audio.newSound(Gdx.files.internal("audio/money_collection.wav"));
	Sound kirp = Gdx.audio.newSound(Gdx.files.internal("audio/kirpichfall.wav"));
	public int type; /*  0 = money
						 1 = kirpich
						 2 = ...
	*/
	
	Physic(){
		px=0;
		px1=0;
		py1=0;
		type = 0;
		totalmoney=0;
		life=3;
	}
	
	
	public void colision(){
		//money
		px = KirpichMain.me.player.x;
		py = KirpichMain.me.player.y;
		px1= KirpichMain.me.player.getWidth();
		py1= KirpichMain.me.player.getHeight();
		
		for ( i=0; i<30; i++){
			type = 0;
			if(Hittest(KirpichMain.me.money.get(i).x,KirpichMain.me.money.get(i).y,KirpichMain.me.money.get(i).img.getWidth(),KirpichMain.me.money.get(i).img.getHeight())){
				getmoney();
			}
		}
		
		//kirpich
		for ( i=0; i<KirpichMain.me.kirpich.size(); i++){			
				type = 1;
				if(Hittest(KirpichMain.me.kirpich.get(i).x,KirpichMain.me.kirpich.get(i).y,KirpichMain.me.kirpich.get(i).img.getWidth(),KirpichMain.me.kirpich.get(i).img.getHeight())){
					kirpichfall();
				}
			
			}
	}
	
	private boolean Hittest(float mx,float my ,float mx1,float my1){
		if((((px>mx)&&(px<mx+mx1))||((px+px1>mx)&&(px+px1<mx+mx1)))&&(((py>my)&&(py<my+my1))||((py+py1>my)&&(py+py1<my+my1)))){
			return true;
		}else 
			return false;
	}	

	
	private void getmoney(){
		KirpichMain.me.money.get(i).x=-9999;
		totalmoney=totalmoney+1;
		KirpichMain.me.player.mode=KirpichMain.me.money.get(i).type;
		sound.play(1.0f);
	}
	private void kirpichfall(){
		KirpichMain.me.kirpich.get(i).x=-9999;
		life=life-1;
		kirp.play(1.0f);
		Gdx.input.vibrate(200);
	}

}
