package com.kirpich.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class KirpichMain extends ApplicationAdapter {
	SpriteBatch batch;
	
	ArrayList<Kirpich> kirpich;
	ArrayList<Money> money;
	Player player;
	Control control;
	Background background;
	Camera camera;
	Physic physic;
	Boolean gameplay,menu,gameover,logo;
	Startmenu startmenu;
	
	public static KirpichMain me;
	
	@Override
	public void create () {
		me=this;
		batch = new SpriteBatch();
		startmenu = new Startmenu();
		kirpich = new ArrayList<Kirpich>();
		money = new ArrayList<Money>();
		player = new Player();
		control = new Control();
		background = new Background();
		camera=new Camera();
		physic=new Physic();
		Gdx.input.setInputProcessor(startmenu);
		logo=false;
		menu = true;
		gameover = false;
		gameplay = false;
		for(int i=0;i<10;i++){kirpich.add(new Kirpich());		}
		for(int i=0;i<30;i++){money.add(new Money());}
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		if (menu){
		startmenu.punction(batch);	
		}
		
		if (gameplay){
			physic.colision();
			Gdx.gl.glClearColor((float)127/(float)255, (float)201/(float)255, (float)255/(float)255, 1);
			background.draw(batch,camera);
			
			for(int i=0;i<kirpich.size();i++){kirpich.get(i).draw(batch,camera);kirpich.get(i).fall();}
			for(int i=0;i<money.size();i++){money.get(i).draw(batch,camera);money.get(i).fall();}
			
			player.draw(batch,camera);
			camera.update();
			control.tap();
		}

		batch.end();
	}
}


