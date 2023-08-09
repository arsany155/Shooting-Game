package com.src.game.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import com.src.game.main.Game.STATE;

public class MouseInput implements MouseListener{

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mousePressed(MouseEvent e) 
	{
		int mx = e.getX();
		int my = e.getY();
		
		//play button
		if (mx >= Game.WIDTH / 2 +120 && mx <= Game.WIDTH / 2+220)
		{
		  if(my >= 150 && my <=200)
		  {
		   	Game.State = Game.STATE.GAME;
		  }
		}
		
		//quit button
				if (mx >= Game.WIDTH / 2 +120 && mx <= Game.WIDTH / 2+220)
				{
				  if(my >= 250 && my <= 300)
				  {
				   System.exit(1);
				  }
				}
				//sound button
				if (mx >= Game.WIDTH / 2 +120 && mx <= Game.WIDTH / 2+220)
				{
				  if(my >= 350 && my <= 400 )
				  {
					Sound music = new Sound ();
					File sound = new File("C:\\Users\\ARSANY\\Desktop\\Space Game\\res\\music.wav");
					music.PlaySound(sound);
						 
				  }
				}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
