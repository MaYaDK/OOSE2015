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

public class SimpleSlickGame extends JPanel implements ActionListener, KeyListener{
	Timer tm = new Timer(5, this); //for animation
	int xRect = 300, yRect = 400, rectWidth = 100, rectHeight = 20, velX = 0, velY = 0; //vel = speed;
	
	public SimpleSlickGame() //
	{
		tm.start(); //start timer
		addKeyListener(this); //Not interfering
		setFocusable(true);
		setFocusTraversalKeysEnabled(false); //Wont be using shift, tab.. keys
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(xRect,yRect,rectWidth,rectHeight);
		
		int blockPlaceX = 10;
		int blockPlaceY = 10;
		int blockwidth = 100;
		int blockheight = 40;
		
		g.drawRect (blockPlaceX, blockPlaceY, blockwidth, blockheight);
		
		
		}
	//public void DrawBlocks(int blockPlaceX, int blockPlaceY,int blockwidth, int blockheight) {
	
		 
	//}
	
	public void actionPerformed(ActionEvent e){
		//Player one
		xRect = xRect + velX; //Initialize x = 0. If press 1 x = 1. 0+1 = 1. Create movement by increasing x with the amount of velX.
		yRect = yRect + velY;
		repaint();
	}
	public void keyPressed(KeyEvent e){
		int c = e.getKeyCode();
		//Player movement
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