import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
 import javax.swing.JPanel;
 import javax.swing.JFrame;
 import javax.swing.ImageIcon;
  import javax.swing.Timer;
 
public class preethi extends JPanel implements KeyListener,ActionListener
{
	int z=1;
	int x=290;
	int move=0;
	int score=0,lives=5;
	int y1=200;
	int y2=200;
     int y3=200;
	int y4=200;
	int y5=200;
	
	
	
	private int [] p1={60,110,160,210,260,310,360,410,460,510,560,610,660,};
	private int [] p2={80,130,180,230,280,330,380,430};
    private int [] p3={70,120,170,220,270,320,370,420,470,520,570,620,670};
	private int [] p4={480,530,580,630,680,40,90,140,190};
	private int [] p5={240,290,340,390,440,490,540,590,640,690};
		private boolean left=false;
	private boolean right=true;
	
	private Random r1=new Random();
	private Random r2=new Random();
private Random r3=new Random();
private Random r4=new Random();
private Random r5=new Random();
	
	private int pos1=r1.nextInt(13);
	private int pos2=r2.nextInt(8);
private int pos3=r3.nextInt(13);
private int pos4=r4.nextInt(9);
private int pos5=r5.nextInt(10);
	
	 private ImageIcon e1;
	 private ImageIcon e2;
 private ImageIcon e3;
 private ImageIcon e4;
private ImageIcon e5;
	 private ImageIcon car;
	  private ImageIcon d1;
	  private ImageIcon d2;
	 private ImageIcon t1;
	  private ImageIcon t2;
	   private ImageIcon t3;
	    private ImageIcon l1;
	    private ImageIcon l2;
	    private ImageIcon l3;
	     private ImageIcon l4;
	 private Timer timer;
	 private int delay=1;
	 
public preethi()
{
	addKeyListener(this);
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);
	timer =new Timer(delay,this);
	timer.start();
	 this.requestFocusInWindow();
}

public void paintComponent(Graphics g)
{ 
	right=true;
	 this.requestFocusInWindow();
	
	// background colour
	g.setColor(Color.black);
	g.fillRect(0,0,860,700);
	
	//logo
	l4=new ImageIcon("logo2.png");
	l4.paintIcon(this,g,750,550);
	
	//inserting bottle
		l2=new ImageIcon("beer.png");
	l2.paintIcon(this,g,15,0);
	
	//inserting tanks
	e1=new ImageIcon("e1.png");
	e1.paintIcon(this,g,60,0);
	
	e2=new ImageIcon("beer.png");
	e2.paintIcon(this,g,260,0);
	
	e3=new ImageIcon("e1.png");
	e3.paintIcon(this,g,360,0);
	
	e4=new ImageIcon("beer.png");
	e4.paintIcon(this,g,560,0);
	
	e5=new ImageIcon("e1.png");
	e5.paintIcon(this,g,650,0);
	

	
	g.setColor(Color.red);
	g.setFont(new Font("arial",Font.BOLD,18));
	g.drawString("SCORE",3,200);
	g.drawString(""+score,30,230);

	
	
	g.setColor(Color.red);
	g.drawRect(0,0,73,700);
	
		g.setColor(Color.red);
	g.setFont(new Font("arial",Font.BOLD,18));
	g.drawString("LIFE",5,300);
	g.drawString(""+lives,30,330);
	
	
	g.setColor(Color.GREEN);
	g.setFont(new Font("arial",Font.BOLD,18));
	g.drawString("RIGHT",5,400);
	g.drawString("---->",30,420);
	
	g.setColor(Color.YELLOW);
	g.setFont(new Font("arial",Font.BOLD,18));
	g.drawString("LEFT",5,500);
	g.drawString("<----",30,520);
	
	
	
	
	
	
	
	
	
	
d1=new ImageIcon("b.png");
t1=new ImageIcon("b2.png");
t2=new ImageIcon("b2.png");
t3=new ImageIcon("b2.png");
d2=new ImageIcon("b.png");

d1.paintIcon(this,g,p1[pos1],y1);
d2.paintIcon(this,g,p3[pos3],y2);
t1.paintIcon(this,g,p2[pos2],y4);
t2.paintIcon(this,g,p4[pos4],y3);
t3.paintIcon(this,g,p5[pos5],y5);

//inserting car
	if(move==0&&lives>0)
	{
	car=new ImageIcon("p.png");
	car.paintIcon(this,g,290,450);
}
else if(move>0&&lives>0)
{
	if(right)
	{
		car=new ImageIcon("p.png");
	car.paintIcon(this,g,x,450);
	}
	if(left)
	{
		car=new ImageIcon("p.png");
	car.paintIcon(this,g,x,450);
	}
}



if(z%7==0)
{
y1++;
y4++;
}
if(z%13==0)
{
	y2++;
	y3++;

	
}
if(z%18==0)
{
y5++;
}
z++;


if((p1[pos1]>=x+10&&p1[pos1]<=x+80) && y1+20==530)
{
	pos1=r1.nextInt(13);
	score++;
	y1=200;
}

if((p2[pos2]>=x+10&&p2[pos2]<=x+80) && y4==450)
{
	pos2=r2.nextInt(8);
    lives--;
    y4=200;
}
if((p4[pos4]>=x+10&&p4[pos4]<=x+80) && y3==450)
{
	pos4=r4.nextInt(9);
    lives--;
    y3=200;
}
if((p5[pos5]>=x+10&&p5[pos5]<=x+80) && y5==450)
{
	pos5=r5.nextInt(10);
    lives--;
    y5=200;
}
if((p3[pos3]>=x+10&&p3[pos3]<=x+80) && y2+20==530)
{
	pos3=r3.nextInt(13);
	score++;
	y2=200;
}


if(y1==600)
{
	pos1=r1.nextInt(13);
	y1=200;
	lives--;
}
if(y2==600)
{
	pos3=r3.nextInt(13);
	
	y2=200;
	lives--;
}
if(y4==600)
{
	pos2=r2.nextInt(8);
	
	y4=200;

}
if(y3==600)
{
	pos4=r4.nextInt(9);
	
	y3=200;
	
}
if(y5==600)
{
	pos5=r5.nextInt(10);
	
	y5=200;

}

if(lives<=0)
{
		
	left=false;
	right=false;
	g.setColor(Color.black);
	g.fillRect(0,0,860,700);
	l1=new ImageIcon("beer.png");
	l1.paintIcon(this,g,350,400);
	l3=new ImageIcon("logo.png");
	l3.paintIcon(this,g,300,0);
	g.setColor(Color.RED);
g.setFont(new Font("arial",Font.BOLD,50));
g.drawString("GAME OVER",250,250);
	g.setColor(Color.yellow);
	g.setFont(new Font("arial",Font.BOLD,20));
	g.drawString("SCORE :  "+score,350,310);
	g.setColor(Color.green);
	g.setFont(new Font("arial",Font.BOLD,45));
	g.drawString("PRESS SPACE TO PLAY AGAIN",80,400);
}
	
repaint();

	g.dispose();
	
	
}

	

public void actionPerformed(ActionEvent e)
 {
 }

public void keyPressed(KeyEvent k)
    {
		if(k.getKeyCode()== KeyEvent.VK_SPACE)
   {
	   move=0;
	   z=1;
	   score=0;
	   lives=5;
	   y1=200;
	   y2=200;
	   y3=200;
	   y5=200;
	    y4=200;
	    x=290;
	}
	   

   if(k.getKeyCode()== KeyEvent.VK_RIGHT)
   {
	   move++;
	   x=x+10;
	   if(x>700)
	   {
		   x=0;
	   }
	   right=true;
	   left=false;
   }
    if(k.getKeyCode()== KeyEvent.VK_LEFT)
   {
	   move++;
	   x=x-10;
	    if(x<0)
	   {
		   x=700;
	   }
	   right=false;
	   left=true;
   }
   
    }
    public void keyReleased(KeyEvent e)
    {
       
    }
    public void keyTyped(KeyEvent e)
    {
      
    }
public static void main(String[] args) 
{
            JFrame mainFrame = new JFrame();
            preethi w=new preethi();
            mainFrame.setBounds(0,0,860,700);
            mainFrame.setBackground(Color.WHITE);
            mainFrame.setTitle("MINTU");
            mainFrame.setResizable(false);
            mainFrame.setVisible(true);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.add(new preethi());
   }
   
 }      
