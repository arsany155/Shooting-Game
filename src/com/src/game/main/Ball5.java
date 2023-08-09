package com.src.game.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball5 extends Thread{

	private double x ;
	private double y ;
	private double speedx=2;
	private double speedy=2;
	
	
	private Textures tex ;
	Bullet bullet;
    Player player;
	Controller c;
	Game game;
	
	
	int count =0;
	int score;
	
	
	boolean flag = false;
	boolean flag2=false;
	boolean flag3=false;
	
	
	public Ball5(double x , double y ,  Textures tex , Controller c , Player p)
	{
		this.x=x;
		this.y=y;
		this.tex=tex;
		this.c=c;
		this.player=p;
	}
	
	
	public void tick()
	{
		    
		  if(x + speedx <= 0)
		  {
			  speedx=2;
		  }
		  if(x +speedx >= 640 -34)
		  {
			  speedx = -2;
		  }
		  
		  if(y+speedy <= 0)
		  {
			  speedy= 2;
		  }
		  if(y >= 380 -45)
		  {
			 speedy = -2;
		  }
		  x+=speedx;
		  y+=speedy;
		  
		  for(int i=0 ;i< c.b.size() ; i++)
		  {
			  bullet=c.b.get(i);
			 if( this.getbounds((int) x , (int)y).intersects(bullet.getbounds((int)bullet.x , (int) bullet.y)))
			 {
			  flag=true;
			  c.removeBullet(bullet);
			  score++;
			 }
		  }
		  
		  if(flag && count <3)
		  {
			  x=(Math.random()*606);
			  y=(Math.random()*435);
			  flag=false;
			  count++;
			  //c.removeBullet(bullet);
		  }
		  if(count >= 3)
		  {
			  flag2=true;
		  }
		  if(this.getbounds((int) x , (int)y).intersects(player.getbounds((int) player.x , (int) player.y)))
		  {
			  flag3=false;
			  game.HEALTH -=1;
		  }
	}
	
	public void render(Graphics g)
	{
		g.drawImage(tex.ball5, (int) x, (int) y , null);
	}
	
	public Rectangle getbounds (int width , int height)
	{
		return new Rectangle ((int) x , (int)y ,  32,32);
	}
	public void run()
	{
		
		try {
			//render(g);
			tick();
			sleep(2);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
