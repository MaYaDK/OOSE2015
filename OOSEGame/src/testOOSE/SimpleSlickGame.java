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
	Sound s = new Sound();
	Timer tm = new Timer(5, this); //For animation
	
	boolean is1Hit = false;
	boolean is2Hit = false;
	boolean is3Hit = false;
	boolean is4Hit = false;
	boolean is5Hit = false;
	
	boolean is6Hit = false;
	boolean is7Hit = false;
	boolean is8Hit = false;
	boolean is9Hit = false;
	boolean is10Hit = false;
	
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
		p.drawPlayer(g);
		
		//Draw each as long as it is not hit.
		if(is1Hit == false){
			bl.drawBlock1(g);
		}
		if(is2Hit == false){
			bl.drawBlock2(g);
		}
		if(is3Hit == false){
			bl.drawBlock3(g);
		}
		if(is4Hit == false){
			bl.drawBlock4(g);
		}
		if(is5Hit == false){
			bl.drawBlock5(g);
		}
		//Row 2
		if(is6Hit == false){
			bl.drawBlock6(g);
		}
		if(is7Hit == false){
			bl.drawBlock7(g);
		}
		if(is8Hit == false){
			bl.drawBlock8(g);
		}
		if(is9Hit == false){
			bl.drawBlock9(g);
		}
		if(is10Hit == false){
			bl.drawBlock10(g);
		}
	}

	public void actionPerformed(ActionEvent e)
	{
        b.moveBall(); //Receiving the moveBall method from Ball class.
        b.collisionScreen(); //Receiving the collision with screen method from Ball class.
        p.movePlayer();
        collisionPlayerBall();
        collisionBlockBall();
		repaint();
	}
	
	public void collisionPlayerBall(){
        if(b.xBall > p.xRect && b.xBall < p.xRect + p.rectWidth && b.yBall > p.yRect && b.yBall < p.yRect + p.rectHeight){ //if there is the ball is within the players position.
			System.out.println("Collision Player/Ball!"); //Debug
			b.ballVelY = b.ballVelY*-1;
			s.playerSound();
    	}
	}
	public void collisionBlockBall(){
        if(b.xBall > bl.blockPlaceX1 && b.xBall < bl.blockPlaceX1 + bl.blockwidth && b.yBall > bl.blockPlaceY1 && b.yBall < bl.blockPlaceY1 + bl.blockheight){ //if there is the ball is within the players position.
			is1Hit = true;
    	}
        if(b.xBall > bl.blockPlaceX2 && b.xBall < bl.blockPlaceX2 + bl.blockwidth && b.yBall > bl.blockPlaceY2 && b.yBall < bl.blockPlaceY2 + bl.blockheight){ //if there is the ball is within the players position.
        	is2Hit = true;
    	}
        if(b.xBall > bl.blockPlaceX3 && b.xBall < bl.blockPlaceX3 + bl.blockwidth && b.yBall > bl.blockPlaceY3 && b.yBall < bl.blockPlaceY3 + bl.blockheight){ //if there is the ball is within the players position.
        	is3Hit = true;
    	}
        if(b.xBall > bl.blockPlaceX4 && b.xBall < bl.blockPlaceX4 + bl.blockwidth && b.yBall > bl.blockPlaceY4 && b.yBall < bl.blockPlaceY4 + bl.blockheight){ //if there is the ball is within the players position.
        	is4Hit = true;
    	}
        if(b.xBall > bl.blockPlaceX5 && b.xBall < bl.blockPlaceX5 + bl.blockwidth && b.yBall > bl.blockPlaceY5 && b.yBall < bl.blockPlaceY5 + bl.blockheight){ //if there is the ball is within the players position.
        	is5Hit = true;
    	}
      //Row 2
        if(b.xBall > bl.blockPlaceX1_2 && b.xBall < bl.blockPlaceX1_2 + bl.blockwidth && b.yBall > bl.blockPlaceY1_2 && b.yBall < bl.blockPlaceY1_2 + bl.blockheight){ //if there is the ball is within the players position.
        	is6Hit = true;
    	}
        if(b.xBall > bl.blockPlaceX2_2 && b.xBall < bl.blockPlaceX2_2 + bl.blockwidth && b.yBall > bl.blockPlaceY2_2 && b.yBall < bl.blockPlaceY2_2 + bl.blockheight){ //if there is the ball is within the players position.
        	is7Hit = true;
    	}
        if(b.xBall > bl.blockPlaceX3_2 && b.xBall < bl.blockPlaceX3_2 + bl.blockwidth && b.yBall > bl.blockPlaceY3_2 && b.yBall < bl.blockPlaceY3_2 + bl.blockheight){ //if there is the ball is within the players position.
        	is8Hit = true;
    	}
        if(b.xBall > bl.blockPlaceX4_2 && b.xBall < bl.blockPlaceX4_2 + bl.blockwidth && b.yBall > bl.blockPlaceY4_2 && b.yBall < bl.blockPlaceY4_2 + bl.blockheight){ //if there is the ball is within the players position.
        	is9Hit = true;
    	}
        if(b.xBall > bl.blockPlaceX5_2 && b.xBall < bl.blockPlaceX5_2 + bl.blockwidth && b.yBall > bl.blockPlaceY5_2 && b.yBall < bl.blockPlaceY5_2 + bl.blockheight){ //if there is the ball is within the players position.
        	is10Hit = true;
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