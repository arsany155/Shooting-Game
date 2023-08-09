package com.src.game.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Controller {

	public LinkedList<Bullet> b = new LinkedList<Bullet>();
	
	Bullet Tempbullet;
	Game game;
	
	public Controller(Game game)
	{
		this.game=game;
	}
	
	public void tick()
	{
		for(int i =0 ; i < b.size() ; i++)
		{
			Tempbullet = b.get(i);
			
			if(Tempbullet.gety() < 0)
			{
				removeBullet(Tempbullet);
			}
			Tempbullet.tick();
		}
	}
	
	public void render (Graphics g)
	{
		for(int i =0 ; i < b.size() ; i++)
		{
			Tempbullet = b.get(i);
			Tempbullet.render(g);
		}
	}
	
	public void addBullet (Bullet block)
	{
		b.add(block);
	}
	public void removeBullet (Bullet block)
	{
		b.remove(block);
	}
} 
