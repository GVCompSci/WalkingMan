import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkingFrame extends JFrame implements ActionListener
{
	private Man man;
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	public WalkingFrame()
	{
		setBounds(100, 100, 600, 400);
		setLayout(null);
		man = new Man(0, 0);
		add(man);
		setVisible(true);
		Timer timer = new Timer(10, this);
		timer.start();
		addKeyListener(new KeyListener()
				{
					public void keyPressed(KeyEvent e)
					{
						if(e.getKeyCode() == e.VK_W)
						{
							man.setDY(-2);
						}
						if(e.getKeyCode() == e.VK_A)
						{
							man.setDX(-2);
						}
						if(e.getKeyCode() == e.VK_S)
						{
							man.setDY(2);
						}
						if(e.getKeyCode() == e.VK_D)
						{
							man.setDX(2);
						}
						if(e.getKeyCode() == e.VK_SPACE)
						{
							Ball ball = new Ball(man.getX(), man.getY());
							balls.add(ball);
							add(ball);
						}
						if(e.getKeyCode() == e.VK_E)
						{
							if(Ball.getDX() == 0)
							{
								Ball.setDX(10);
							}
							else
							{
								Ball.setDX(0);
							}
						}
					}
					public void keyReleased(KeyEvent e)
					{
						if(e.getKeyCode() == e.VK_W)
						{
							man.setDY(0);
						}
						if(e.getKeyCode() == e.VK_A)
						{
							man.setDX(0);
						}
						if(e.getKeyCode() == e.VK_S)
						{
							man.setDY(0);
						}
						if(e.getKeyCode() == e.VK_D)
						{
							man.setDX(0);
						}
					}
					public void keyTyped(KeyEvent e)
					{
					}
					
				});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		man.update();
		for(int i = 0; i < balls.size(); i++)
		{
			balls.get(i).update();
			if(balls.get(i).getX() > 620)
			{
				this.remove(balls.get(i));
				balls.remove(i);
			}
		}
		repaint();
	}
	public static void main(String[] args)
	{
		new WalkingFrame();
		
	}
}
