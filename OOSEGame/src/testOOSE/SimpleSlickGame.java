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

public class SimpleSlickGame extends JPanel implements ActionListener, KeyListener
{
	Ball b; //Initialize the Ball class
	Timer tm = new Timer(5, this); //For animation
	int xRect = 300, yRect = 400, rectWidth = 100, rectHeight = 20, velX = 0, velY = 0; //vel = speed;
	int blockPlaceX = 0, blockPlaceY = 10, blockwidth = 100, blockheight = 30;
	
	public SimpleSlickGame()
	{
		b = new Ball(); //Declaring the Ball class.
		tm.start(); //Start timer
		addKeyListener(this); //Not interfering
		setFocusable(true);
		setFocusTraversalKeysEnabled(false); //Wont be using shift, tab.. keys	
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		b.drawBall(g); //Receiving the draw Ball method from Ball class.
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

	public void actionPerformed(ActionEvent e)
	{
		//Move player
		xRect = xRect + velX*3; //Initialize x = 0. If press 1 x = 1. 0+1 = 1. Create movement by increasing x with the amount of velX.
		yRect = yRect + velY*3;
        //Move ball and bounce when hitting end of screen.
        b.moveBall(); //Receiving the moveBall method from Ball class.
        b.collisionScreen(); //Receiving the collision with screen method from Ball class.
		repaint();
	}

	public void keyPressed(KeyEvent e)
	{
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
	public void keyReleased(KeyEvent e)
	{
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
