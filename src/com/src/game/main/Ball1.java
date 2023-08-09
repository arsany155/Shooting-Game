package com.src.game.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball1 extends Thread{

	private double x ;
	private double y ;
	private double speedx=2;
	private double speedy=2;
	
	
    Textures tex ;
	Controller c;
	Player player;
	Game game;
	Bullet bullet;
	
	
	int count=0;
	int score=0;
	
	
	boolean flag = false;
	boolean flag2=false;
	boolean flag3=false;
	boolean temp1=false;
	boolean temp2=false;
	
	
	
	public Ball1(double x , double y ,  Textures tex , Controller c , Player p , Game game)
	{
		this.x=x;
		this.y=y;
		this.tex=tex;
		this.c=c;
		this.player=p;
		this.game=game;
		
	}
	
	
	public void tick()
	{
		 if(x + speedx <= 0)
		  {
			  speedx=2;
		  }
		  if(x +speedx >= 670 -34)
		  {
			  
				  
			  
			  this.x=0;
			  this.y=0;
			  
			   speedx = +2;
			   
			  
			  
		  }
		  
		  if(y+speedy <= 0)
		  {
			  speedy= 2;
		  } 
		  if(y >= 380 -45)
		  {
			  //this.x=0;
			  
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
		  //game.HEALTH-=10;
		 }
	  }
	  
	  if(flag && count <= 2)
	  {
		  x=(Math.random()*606);
		  y=(Math.random()*435);
		  count++;
		  flag=false;
	  }
	  if(count >= 2)
	  {
		  flag2=true;
	  }
	  
	  if(this.getbounds((int) x , (int)y).intersects(player.getbounds((int) player.x , (int) player.y)))
	  {
		  game.HEALTH -=1;
		  flag3=false;
		  
	  }

	}
	
	public void render(Graphics g)
	{
		g.drawImage(tex.ball1, (int) x, (int) y , null);
	}
	
	public Rectangle getbounds (int width , int height)
	{
		return new Rectangle ((int) x , (int)y ,  32,32);
	}
	
	public double getx()
	{
		return x+speedx;
	}
	public double gety()
	{
		return y+speedy;
	}
	
	public void run()
	{
		
		
	}
	
}
