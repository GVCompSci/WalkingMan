import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Ball extends JComponent
{
	private static int dX = 5;
	public Ball(int x, int y)
	{
		setLocation(x, y);
		setSize(20, 20);
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double ball = new Ellipse2D.Double(0, 0, 20, 20);
		g2.fill(ball);
	}
	public void update()
	{
		setLocation(getX() + dX, getY());
	}
	public static void setDX(int x)
	{
		dX = x;
	}
	public static int getDX()
	{
		return dX;
	}
}