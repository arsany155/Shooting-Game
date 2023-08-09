package com.src.game.main;

import java.awt.image.BufferedImage;

public class Textures {

	public BufferedImage player , missile , ball1 , ball2 , ball3 , ball4 , ball5 , ball6 ;
	private SpriteSheet ss;
	
	public Textures(Game game )
	{
		ss = new SpriteSheet (game.getSpriteSheet());
		
		getTextures();
	}
	
	private void getTextures()
	{
		player   = ss.garbImage(1, 1, 32, 32);
		missile  = ss.garbImage(2, 1 ,32, 32);
		ball1    = ss.garbImage(3, 1, 32, 32);
		ball2    = ss.garbImage(4, 1, 32, 32);
		ball3    = ss.garbImage(5, 1, 32, 32);
		ball4    = ss.garbImage(6, 1, 32, 32);
		ball5    = ss.garbImage(7, 1, 32, 32);
		ball6    = ss.garbImage(8, 1, 32, 32);
	}
}
