package testOOSE;

import java.awt.Color;
import java.awt.Graphics;

public class Player 
{
	int xRect = 300, yRect = 400, rectWidth = 100, rectHeight = 20, velX = 0, velY = 0; //vel = speed;
	
	public void drawPlayer(Graphics g)
	{
		//Draw player
		g.setColor(Color.BLUE);
		g.fillRect(xRect,yRect,rectWidth,rectHeight);
	
	}
	public void movePlayer()
	{
		//Move player
		xRect = xRect + velX*3; //Initialize x = 0. If press 1 x = 1. 0+1 = 1. Create movement by increasing x with the amount of velX.
		yRect = yRect + velY*3;
	}
	public static void main(String[] args) 
	{
	}
}
