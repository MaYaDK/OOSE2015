package testOOSE;

//Access keyboard
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//Access window
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
//Access graphics
import java.awt.Color;
import java.awt.Graphics;
//Import picture
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
//
import java.net.*;
import java.io.*;
//Delete
//Animation
import javax.swing.JLabel;

public class SimpleSlickGame extends JPanel implements ActionListener, KeyListener
{
	//Delete
	JLabel imageLabel = new JLabel(); //animation
	//
	Timer tm = new Timer(5, this); //for animation
	int xRect = 300, yRect = 400, rectWidth = 100, rectHeight = 20, velX = 0, velY = 0; //vel = speed;
	int blockPlaceX = 0, blockPlaceY = 10, blockwidth = 100, blockheight = 30;
	private BufferedImage ball;
    int xBall = 320, yBall = 360, ballWidth = 20, ballHeight = 20, ballVelX = 2, ballVelY = -2; //vel = speed;
    int xBallCenter = xBall - ballWidth / 2;
    int yBallCenter = yBall - ballHeight / 2;

	//URL imageURL = this.getClass().getResource("/resources/Ball.png");
	
	public SimpleSlickGame() //
	{
		tm.start(); //start timer
		addKeyListener(this); //Not interfering
		setFocusable(true);
		setFocusTraversalKeysEnabled(false); //Wont be using shift, tab.. keys
		try{
			ball = ImageIO.read(new File("src/testOOSE/Ball.png"));
		}catch(IOException ex){
	}
}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//Draw ball
		g.drawImage(ball, 300, 300, 50, 50, null);
        //g.drawImage(ball, xBall, yBall, ballWidth, ballHeight, null);

        g.fillOval(xBall, yBall, ballWidth, ballHeight);

		//Draw player
		g.setColor(Color.BLUE);
		g.fillRect(xRect,yRect,rectWidth,rectHeight);
		//Draw blocks
	    for( blockPlaceX = 0; blockPlaceX < 640; blockPlaceX = blockPlaceX+blockwidth+20) {
	        for(blockPlaceY = 0; blockPlaceY < 250; blockPlaceY=blockPlaceY+blockheight+20){
	            g.drawRect (blockPlaceX, blockPlaceY, blockwidth, blockheight);
	            g.setColor(Color.BLACK);
	            g.fillRect(blockPlaceX, blockPlaceY, blockwidth, blockheight);
	            }  
	    	}
        }

	public void actionPerformed(ActionEvent e){
		//Move player
		xRect = xRect + velX; //Initialize x = 0. If press 1 x = 1. 0+1 = 1. Create movement by increasing x with the amount of velX.
		yRect = yRect + velY;
        //Move ball
        moveBall();
        xBall = xBall + ballVelX;
        yBall = yBall + ballVelY;
		repaint();
	}
    public void moveBall(){
        //wall bouncing
        if ((xBall + 10)  >= 640 || (xBall + 10) <= 0){
            ballVelX = ballVelX*-1;
            System.out.println(xBall);
        }
        if ((yBall + 10) >= 420 || (yBall + 10) <= 0){
            ballVelY = ballVelY*-1;
            System.out.println(yBall);
        }
    }

	public void keyPressed(KeyEvent e){
		int c = e.getKeyCode();
		//Player movement by pressing key
		if(c == KeyEvent.VK_LEFT){ //Moving player left
			velX = -1;
			velY = 0;
		}
		if(c == KeyEvent.VK_RIGHT){ //Moving player right
			velX = 1;
			velY = 0;
		}
	}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){
		//Stops the player movement when key released.
		velX = 0;
		velY = 0;
	}
	public static void main(String[] args)
	{
		SimpleSlickGame t = new SimpleSlickGame();
		JFrame jf = new JFrame();
		jf.setTitle("Breakout"); //Displaying the title on the frame
		jf.setSize(640, 480); //Setting size of frame (x,y);
		jf.setVisible(true); //Display the frame.
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		jf.add(t);
	}
}
