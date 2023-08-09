package com.src.game.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Bullet {

	public double x;
	public double y;
	
	private Textures tex;
	
	
	public Bullet (double x ,double y , Textures tex)
	{
		this.x=x;
		this.y=y;		
		this.tex=tex;
	}
	
	@SuppressWarnings("deprecation")
	public void tick()
	{
		y-=10;
		
	}
	
	public Rectangle getbounds (int width , int height)
	{
		return new Rectangle ((int) x , (int)y ,  32,32);
	}
	public void render(Graphics g)
	{
		g.drawImage(tex.missile ,(int)x , (int)y , null);
	}
	
	public double gety()
	{
		return y ;
	}
}
