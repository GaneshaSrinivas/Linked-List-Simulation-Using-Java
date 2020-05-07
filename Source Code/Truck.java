/*
 * Developed By Ganesha S
 * http://ganeshas.azurewebsites.net/
 * 
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;


/**
 * The Class Truck.
 */
public class Truck extends Vehicle {


	/** The Constant WIDTH. */
	private static final double WIDTH = 35 ;
	
	/** The Constant UNIT. */
	private static final double UNIT = WIDTH / 7 ;
	
	/** The Constant U_3. */
	private static final double U_3 = 0.3 * UNIT ; 
	
	/** The Constant U3. */
	private static final double U3 = 3 * UNIT ; 
	
	/** The Constant U4. */
	private static final double U4 = 4 * UNIT ; 
	
	/** The Constant U10. */
	private static final double U10 = 10 * UNIT ; 
	
	/** The Constant U10_7. */
	private static final double U10_7 = 10.7 * UNIT ; 
	
	/** The Constant U12. */
	private static final double U12 = 12 * UNIT ; 	


	/**
	 * Instantiates a new truck.
	 * 
	 * @param xPos the x pos
	 * @param yPos the y pos
	 */
	public Truck(int xPos, int yPos) {
		super(xPos, yPos, null);
	}

	/**
	 * Gets the rectangle
	 *
	 * @return the rect
	 */
	public Rectangle getRect() {
		return new Rectangle(x, y, VEHICLE_WIDTH, VEHICLE_HEIGHT);
	}

	/**
	 * Checks for has next
	 *
	 * @return true, if has next
	 */
	public boolean hasN() {
		return (next != null);
	}

	/**
	 * Gets the next
	 *
	 * @return the next
	 */
	public Vehicle getN() {
		if(!hasN()) return null;
		else return next;
	}

	/**
	 * Sets the next
	 *
	 * @param next the new next
	 */
	public void setN(Vehicle next) {
		this.next = next;
	}

	/**
	 * Checks for previous
	 *
	 * @return true, if has previous
	 */
	public boolean hasP() {
		return (previous != null);
	}

	/**
	 * Gets the previous
	 *
	 * @return the previous
	 */
	public Vehicle getP() {
		if(!hasP()) return null;
		else return previous;
	}

	/**
	 * Sets the previous
	 *
	 * @param previous the new previous
	 */
	public void setP(Vehicle previous) {
		this.previous = previous;
	}

	/**
	 * Move to.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Checks if is truck.
	 *
	 * @return true, if is truck
	 */
	public boolean isTruck() {
		return true;
	}

	/**
	 * Gets the x point
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y point
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Draws the method
	 *
	 * @param g2 the graphic
	 */
	public void draw(Graphics2D g2) {
		int x1 = x;
		int y1 = y;
		Rectangle2D.Double hood = new Rectangle2D.Double(x1, y1 + UNIT, U3, U3 ) ;
		g2.setColor(Color.red) ;
		g2.fill(hood) ;

		Rectangle2D.Double body = new Rectangle2D.Double(x1 + U3,y1,U10, U4) ;
		g2.setColor(Color.blue) ;
		g2.fill(body) ;


		Ellipse2D.Double wheel1 = new Ellipse2D.Double(x1 + U_3, y1 + U4, UNIT, UNIT) ;
		g2.setColor(Color.black) ;
		g2.fill(wheel1) ;

		Ellipse2D.Double wheel2 = new Ellipse2D.Double(x1 + U3, y1 + U4, UNIT, UNIT) ;
		g2.setColor(Color.black) ;
		g2.fill(wheel2) ;

		Ellipse2D.Double wheel3 = new Ellipse2D.Double(x1 + 4 * UNIT, y1 + 4 * UNIT, UNIT, UNIT) ;
		g2.setColor(Color.black) ;
		g2.fill(wheel3) ;

		Ellipse2D.Double wheel4 = new Ellipse2D.Double(x1 + U10_7, y1 + U4, UNIT, UNIT) ;
		g2.setColor(Color.black) ;
		g2.fill(wheel4) ;

		Ellipse2D.Double wheel5 = new Ellipse2D.Double(x1 + U12, y1 + U4, UNIT, UNIT) ;
		g2.setColor(Color.black) ;
		g2.fill(wheel5) ;

		if(hasN())
		{
			g2.drawLine(getRect().x+60, getRect().y+15, getN().getRect().x, getN().getRect().y+15);	
			getN().draw(g2);
		}
	}

}
