package com.src.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;

public class Menu {

	public Rectangle playButton = new Rectangle (Game.WIDTH / 2 +120 , 150 ,100 ,50);
	public Rectangle quitButton = new Rectangle (Game.WIDTH / 2 +120 , 250 ,100 ,50);
	public Rectangle SoundButton = new Rectangle (Game.WIDTH / 2 +120 , 350 ,100 ,50);
	
	public void render (Graphics g)
	{
		Graphics2D g2d =(Graphics2D) g;
		
		Font fnt0 = new Font ("arial" , Font.BOLD ,50);
		g.setFont(fnt0);
		g.setColor(Color.WHITE);
		g.drawString("SPACE GAME", Game.WIDTH /2 , 100);
		
		
		
		Font fnt1 = new Font ("arial" , Font.BOLD ,30);
		g.setFont(fnt1);
		
		g.drawString("PLAY", playButton.x + 10,playButton.y + 34 );
		g2d.draw(playButton);
		
		g.drawString("QUIT", quitButton.x + 13 ,quitButton.y + 35 );
		g2d.draw(quitButton);
		
		g.drawString("Sound", quitButton.x + 4 ,quitButton.y + 135 );
		g2d.draw(SoundButton);
		
		
		
	}
}
