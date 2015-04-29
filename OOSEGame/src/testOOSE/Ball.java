package testOOSE;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
//Sound
import java.io.*;
import javax.sound.sampled.*;
import java.net.URL;

public class Ball 
{
	//Player p; //initialize class
	Sound s;//initialize class
	int xBall = 320, yBall = 360, ballWidth = 20, ballHeight = 20, ballVelX = 2, ballVelY = -2; //vel = speed;
    int xBallCenter = xBall - ballWidth / 2, yBallCenter = yBall - ballHeight / 2;
    private BufferedImage ball;
    int lifeCounter = 5;
    
    public Ball()
    {
    	//p = new Player(); //declare class
    	s = new Sound(); //declare class
    			
    	try{
			//ball = ImageIO.read(new File("src/testOOSE/Ball.png"));
			ball = ImageIO.read(getClass().getResource("/Ball.png"));
		}catch(IOException ex){
		}
    }
    	
    public void drawBall(Graphics g)
    {
        g.drawImage(ball, xBall, yBall, ballWidth, ballHeight, null);
        g.drawString("Life "+lifeCounter, 10, 400);
    }
    public void moveBall()
    {
    	xBall = xBall + ballVelX;
        yBall = yBall + ballVelY;
    }
    public void collisionScreen(){
        //wall bouncing
        if ((xBall + 10)  >= 640 || (xBall + 10) <= 0){
            ballVelX = ballVelX*-1;
            System.out.println(xBall); //Debug purpose
            s.wallSound();
        }
        if ((yBall + 10) >= 420 || (yBall + 10) <= 0){
            ballVelY = ballVelY*-1;
            System.out.println(yBall); //Debug purpose
            s.wallSound();
        }
        if ((yBall + 10) >= 420){
        	if (lifeCounter > 0){
        	lifeCounter = lifeCounter - 1;
        	}
        }
        
        
        }
    }
    /*
  public void collisionPlayer(){
        if(yBall > p.yRect && yBall < p.yRect + p.rectHeight && xBall > p.xRect && xBall < p.xRect + p.rectWidth){ //if there is the ball is within the players position.
			System.out.println("Collision!");
			ballVelY = ballVelY*-1;
    	}
	}
	*/
