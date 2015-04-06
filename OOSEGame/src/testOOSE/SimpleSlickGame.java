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
	//Initialize the classes.
	Ball b; 
	Block bl;
	Player p;
	Timer tm = new Timer(5, this); //For animation
	
	public SimpleSlickGame()
	{
		//Declaring the classes.
		b = new Ball(); 
		bl = new Block();
		p = new Player();
		tm.start(); //Start timer
		addKeyListener(this); //Not interfering
		setFocusable(true);
		setFocusTraversalKeysEnabled(false); //Wont be using shift, tab.. keys	
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		b.drawBall(g); //Receiving the draw Ball method from Ball class.
		bl.drawBlock(g);
		p.drawPlayer(g);
        }

	public void actionPerformed(ActionEvent e)
	{
        b.moveBall(); //Receiving the moveBall method from Ball class.
        b.collisionScreen(); //Receiving the collision with screen method from Ball class.
        p.movePlayer();
        collisionPlayerBall();
		repaint();
	}
	
	public void collisionPlayerBall(){
        if(b.yBall > p.yRect && b.yBall < p.yRect + p.rectHeight && b.xBall > p.xRect && b.xBall < p.xRect + p.rectWidth){ //if there is the ball is within the players position.
			System.out.println("Collision Player/Ball!"); //Debug
			b.ballVelY = b.ballVelY*-1;
			//b.playsound();
    	}
	}
	
	public void keyPressed(KeyEvent e)
	{
		int c = e.getKeyCode();
		//Player movement by pressing key
		if(c == KeyEvent.VK_LEFT){ //Moving player left
			p.velX = -1;
			p.velY = 0;
		}
		if(c == KeyEvent.VK_RIGHT){ //Moving player right
			p.velX = 1;
			p.velY = 0;
		}
	}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e)
	{
		//Stops the player movement when key released.
		p.velX = 0;
		p.velY = 0;
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
