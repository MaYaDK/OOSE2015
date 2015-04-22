package testOOSE;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.Timer;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class SimpleSlickGame2 extends BasicGame
{
	int xRect = 300, yRect = 400, rectWidth = 100, rectHeight = 20, velX = 0, velY = 0; //vel = speed;
	public SimpleSlickGame2(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		//g.setColor(Color.BLUE);
		g.fillRect(xRect,yRect,rectWidth,rectHeight);
	}
	public static void main(String[] args)
	{	
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame2("Breakout"));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlickGame2.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}