package com.src.game.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player {
  public double x;
  public double y;
  
  private double speedx = 0;
  private double speedy = 0;
      
  private Textures tex;
  
  public Player (double x, double y, Textures tex)
  {
	  this.x=x;
	  this.y=y;  
	  this.tex=tex;
  }
  
  public void tick()
  {
	  x+=speedx;
	  y+=speedy;
	  
	  if(x <= 0)
	  {
		  x=0;
	  }
	  if(x >= 640 -34)
	  {
		  x=640-34;
	  }
	  
	  if(y <= 260)
	  {
		  y=260;
	  }
	  if(y >= 480 -45)
	  {
		  y=480 -45;
	  }
  }
  
  public void render(Graphics g)
  {
	g.drawImage(tex.player, (int)x, (int)y, null);  
  }
  
  public Rectangle getbounds (int width , int height)
	{
		return new Rectangle ((int) x , (int)y ,  32,32);
	}
  
  public double getX() 
  {
	  return x;
  }
  public void setX(double x)
  {
	  this.x=x;
  }
  
  public double gety() 
  {
	  return y;
  }
  public void sety(double y)
  {
	  this.y=y;
  }
  
  
  public void setspeedX(double speedx)
  {
	  this.speedx=speedx;
  }
  public void setspeedY(double speedy)
  {
	  this.speedy=speedy;
  }
}
