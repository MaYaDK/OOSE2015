package testOOSE;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Ball 
{
	Sound s;//initialize class
	int xBall = 320, yBall = 360, ballWidth = 20, ballHeight = 20, ballVelX = 2, ballVelY = -2; //vel = speed;
    int xBallCenter = xBall - ballWidth / 2, yBallCenter = yBall - ballHeight / 2;
    private BufferedImage ball;
    int lifeCounter = 3;
    
    public Ball()
    {
    	s = new Sound(); //declare class	
    	try{
			ball = ImageIO.read(getClass().getResource("/Ball.png"));
		}catch(IOException ex){
		}
    }
    	
    public void drawBall(Graphics g)
    {
        g.drawImage(ball, xBall, yBall, ballWidth, ballHeight, null);
        g.setColor(Color.RED);
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
