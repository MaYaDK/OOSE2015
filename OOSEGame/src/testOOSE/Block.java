package testOOSE;

import java.awt.Color;
import java.awt.Graphics;

public class Block 
{
	int blockPlaceX = 0, blockPlaceY = 10, blockwidth = 100, blockheight = 30;

	public void drawBlock(Graphics g)
	{
		//Draw blocks
	    for( blockPlaceX = 0; blockPlaceX < 640; blockPlaceX = blockPlaceX+blockwidth+20) {
	        for(blockPlaceY = 0; blockPlaceY < 250; blockPlaceY=blockPlaceY+blockheight+20){
	            g.drawRect (blockPlaceX, blockPlaceY, blockwidth, blockheight);
	            g.setColor(Color.BLACK);
	            g.fillRect(blockPlaceX, blockPlaceY, blockwidth, blockheight);
	            }  
	    	}	
	}
	public static void main(String[] args) 
	{
	}
}
