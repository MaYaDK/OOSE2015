package testOOSE;

import java.awt.Color;
import java.awt.Graphics;

public class Block 
{
	public int blockPlaceX1 = 0, blockPlaceY1 = 10, blockwidth = 100, blockheight = 30;
	public int blockPlaceX2 = blockPlaceX1+125, blockPlaceY2 = 10;
	public int blockPlaceX3 = blockPlaceX1+125*2, blockPlaceY3 = 10;
	public int blockPlaceX4 = blockPlaceX1+125*3, blockPlaceY4 = 10;
	public int blockPlaceX5 = blockPlaceX1+125*4, blockPlaceY5 = 10;
	
	public int blockPlaceX1_2 = 0, blockPlaceY1_2 = 60;
	public int blockPlaceX2_2 = blockPlaceX1+125, blockPlaceY2_2 = 60;
	public int blockPlaceX3_2 = blockPlaceX1+125*2, blockPlaceY3_2 = 60;
	public int blockPlaceX4_2 = blockPlaceX1+125*3, blockPlaceY4_2 = 60;
	public int blockPlaceX5_2 = blockPlaceX1+125*4, blockPlaceY5_2 = 60;
	
	//Row 1
	public void drawBlock1(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(blockPlaceX1, blockPlaceY1, blockwidth, blockheight);          
	}
	public void drawBlock2(Graphics g)
	{
		g.fillRect(blockPlaceX2, blockPlaceY2, blockwidth, blockheight);
	}
	public void drawBlock3(Graphics g)
	{
		g.fillRect(blockPlaceX3, blockPlaceY3, blockwidth, blockheight);
	}
	public void drawBlock4(Graphics g)
	{
		g.fillRect(blockPlaceX4, blockPlaceY4, blockwidth, blockheight);
	}
	public void drawBlock5(Graphics g)
	{
		g.fillRect(blockPlaceX5, blockPlaceY5, blockwidth, blockheight);
	}
    
    //Row 2
	public void drawBlock6(Graphics g)
	{
		g.setColor(Color.DARK_GRAY);
		g.fillRect(blockPlaceX1_2, blockPlaceY1_2, blockwidth, blockheight);
	}
	public void drawBlock7(Graphics g)
	{
		g.fillRect(blockPlaceX2_2, blockPlaceY2_2, blockwidth, blockheight);
	}
	public void drawBlock8(Graphics g)
	{
		g.fillRect(blockPlaceX3_2, blockPlaceY3_2, blockwidth, blockheight);
	}
	public void drawBlock9(Graphics g)
	{
		g.fillRect(blockPlaceX4_2, blockPlaceY4_2, blockwidth, blockheight);
	}
	public void drawBlock10(Graphics g)
	{
		g.fillRect(blockPlaceX5_2, blockPlaceY5_2, blockwidth, blockheight);
	}
	public static void main(String[] args) 
	{
	}
}
