package com.src.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	 
  //private static final long serialVersionUID = 1L;
  public static final int WIDTH  = 320;
  public static final int HEIGHT  = WIDTH / 12 * 9;
  public static final int SCALE = 2;
  public final String TITLE = "2D Space Game";
  
  
  private boolean running =false;
  Thread thread;
  
  
  private BufferedImage image = new BufferedImage(WIDTH , HEIGHT , BufferedImage.TYPE_INT_RGB);
  private BufferedImage spriteSheet = null;
  private BufferedImage background = null;
  private BufferedImage win = null;
  private BufferedImage lose = null;
  
  public static int HEALTH =200;
  
  double z = (Math.random()*606);
  double y = (Math.random()*435);
  
  double t = (Math.random()*606);
  double e = (Math.random()*435);
  
  double r = (Math.random()*606);
  double l = (Math.random()*435);
  
  double h = (Math.random()*606);
  double g = (Math.random()*435);
  
  double w = (Math.random()*606);
  double q = (Math.random()*435);
  
  
  
  double a = (Math.random()*606);
  double k = (Math.random()*435);
  
  private boolean is_shooting = false;

  int score=0;
  int count1=20;
  private Player p;
  private Controller c;
  
  private Ball1 b1;
  private Ball2 b2;
  private Ball3 b3;
  private Ball4 b4;
  private Ball5 b5;
  private Ball6 b6;
 
  private Textures tex;
  private Menu menu;
  
  public static enum STATE
  { 
	  MENU,
	  GAME,
	  winner,
	  GameOver,
  }
  public static STATE State = STATE.MENU;
  
  public void init() throws IOException
  {
	  BufferedImageLoader loader = new BufferedImageLoader();
	  spriteSheet = loader.loadImage("/sprite_sheet.png");
	  background = loader.loadImage("/space-cartoon-010.png");
	  win = loader.loadImage("/winner.png");
	  lose = loader.loadImage("/gameover.png");
	  

	  this.addKeyListener(new KeyInput(this));
	  
	  tex = new Textures(this);
	  
	  p=new Player(295 , 410 , tex);
	  c=new Controller(this);
	  b1= new Ball1(z,y,tex,c, p,this);
	  b2= new Ball2(t,e,tex,c,p);
	  b3= new Ball3(r,l,tex,c,p);
	  b4= new Ball4(h,g,tex,c,p);
	  b5= new Ball5(w,q,tex,c,p);
	  b6= new Ball6(a,k,tex,c,p);
	  
	  menu = new Menu();
	  
	  this.addMouseListener(new MouseInput());
	  
    //b1.start();
    
  }
  
  
  private synchronized void start()
  {
	  if(running)
		  return;
	  running = true;
	  thread = new Thread(this);
	  thread.start();
  }
  

  
  
  
  public void run()
  {
	  try {
		  requestFocus();
		init();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	  long lastTime = System.nanoTime();
	  final double amountOfTicks = 60.0 ; 
	  double ns = 1000000000 / amountOfTicks ;
	  double delta =0;
	  int updates =0;
	  int frames=0;
	  long timer = System.currentTimeMillis();
	  while(running)
	  {
		  long now  = System.nanoTime();
		  delta += (now - lastTime) / ns;
		  lastTime = now;
		  if(delta > 1)
		  {
			  tick();
			  updates++;
			  delta-- ;
		  }
		  render ();

		  
		  frames++;
		  
		  if(System.currentTimeMillis() - timer >1000) 
		  {
			  timer += 1000;
			  System.out.println(updates + "Ticks , Fps" +  frames);
			  updates=0;
			  frames=0;
		  }
	  }
	  
  }
  
  public void tick()
  {
	  if(State == STATE.GAME) 
	  {
	  p.tick();
	  c.tick();
	  if(!b1.flag2)
	   {
		   b1.tick(); 
	   }
	   if(!b2.flag2)
	   {
		   b2.tick(); 
	   }
	   if(!b3.flag2)
	   {
		   b3.tick(); 
	   }
	   if(!b4.flag2)
	   {
		   b4.tick(); 
	   }
	   if(!b5.flag2)
	   {
		   b5.tick(); 
	   }
	   if(!b6.flag2)
	   {
		   b6.tick(); 
	   }
	   
	 
	  score=b1.score + b2.score + b3.score + b4.score + b5.score + b6.score;
	  
	  }
	  
  }
  
  public void render()
  {
	  BufferStrategy bs = this.getBufferStrategy();
	  if (bs==null)
	  {
		  createBufferStrategy(3);
		  return;
	  }
	  Graphics g = bs.getDrawGraphics();
	 //0 g.drawImage(image,0, 0, getWidth(), getHeight(), this);
	  
	  g.drawImage(background ,0,0,null);
	  
	  if(State == STATE.GAME) 
	  {
		  
	  g.drawImage(background ,0,0,null);
	   p.render(g);
	   c.render(g);
	  
	   
	   
	   if(!b1.flag2)
	   {
		   b1.render(g); 
	   }
	   if(!b2.flag2)
	   {
		   b2.render(g); 
	   }
	   if(!b3.flag2)
	   {
		   b3.render(g); 
	   }
	   if(!b4.flag2)
	   {
		   b4.render(g); 
	   }
	   if(!b5.flag2)
	   {
		   b5.render(g); 
	   }
	   if(!b6.flag2)
	   {
		   b6.render(g); 
	   }
	   if(score >=17)
	   {
		   State = STATE.winner;
	   }
	   
	    g.setColor(Color.green);
	    g.fillRect(5,5,HEALTH,25);
	    
	    g.setColor(Color.white);
	    g.drawRect(5,5,200,25);
	    
	    
	    
	    if( HEALTH <= 0)
	    {
	    	State=STATE.GameOver;
	    }
	   
	   
	   Font fnt3 = new Font ("arial" , Font.BOLD ,20);
		g.setFont(fnt3);
		g.setColor(Color.WHITE);
		g.drawString("Score :"+ score, 50 , 50);
			
		
	  }else if (State == STATE.MENU) {
		  
		  g.drawImage(image,0, 0, getWidth(), getHeight(), this);
		  menu.render(g);
		  
	  }
	  else if(State == STATE.winner)
	  {
		  g.drawImage(win, 50, 50, null);
	  }
	  else if(State == STATE.GameOver)
	  {
		  g.drawImage(lose, 50, 50, null);
	  }
	  
	  g.dispose();
	  bs.show();
	  
  }
  public void keyPressed (KeyEvent e)
	{
		int key = e.getKeyCode();
		if(State == STATE.GAME)
		{
 		    if(key == KeyEvent.VK_RIGHT) 
		    {
			  p.setspeedX(6);
		    }
		    else if(key == KeyEvent.VK_LEFT) 
		    {
			  p.setspeedX(-6);
		    } 
		    else if(key == KeyEvent.VK_DOWN)
		    {
			  p.setspeedY(6);
		    }
		    else if(key == KeyEvent.VK_UP) 
		    {
		      p.setspeedY(-6);
		    }
		    else if (key == KeyEvent.VK_SPACE && !is_shooting)
		    {
		 	  is_shooting = true;
			  c.addBullet(new Bullet (p.getX() , p.gety() , tex ));
		    }
		}
	}
	
	public void keyReleased (KeyEvent e)
	{
       int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT) 
		{
			p.setspeedX(0);
		}
		else if(key == KeyEvent.VK_LEFT) {
			p.setspeedX(0);
		}
		else if(key == KeyEvent.VK_DOWN)
		{
			p.setspeedY(0);
		}
		else if(key == KeyEvent.VK_UP) 
		{
			p.setspeedY(0);
		} 
		else if (key == KeyEvent.VK_SPACE )
		{
			is_shooting = false;
		}
	}
 
  
  public static void main (String args [])
  {
	Game game = new Game();
	
	game.setPreferredSize(new Dimension(WIDTH*SCALE , HEIGHT*SCALE));
	game.setMaximumSize(new Dimension(WIDTH*SCALE , HEIGHT*SCALE));
	game.setMinimumSize(new Dimension(WIDTH*SCALE , HEIGHT*SCALE));
	  
	JFrame frame = new JFrame (game.TITLE);
	frame.add(game);	
	frame.pack();   
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setLocation(400,160);
	frame.setVisible(true);
	 
	//frame.setIconImage(logo.getImage());
	
	
	game.start();
  }
  
  public BufferedImage getSpriteSheet()
  {
	  return spriteSheet;
  }
  
}



/*
 *
 * 
 * 
 * 
 * Sound music = new Sound ();
	 File sound = new File("C:\\Users\\ARSANY\\Desktop\\Space Game\\res\\music.wav");
	 music.PlaySound(sound);
 * */
