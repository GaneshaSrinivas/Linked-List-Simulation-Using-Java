/*
 * Name: Bilawal Sheikh
 * Student Number: 500563972
 * Date: Tuesday April 8, 2014
 * 
 */
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * The Class Vehicle.
 */
abstract class Vehicle {

	/** The Constant VEHICLE_WIDTH. */
	public static final int VEHICLE_WIDTH = 75;
	
	/** The Constant VEHICLE_HEIGHT. */
	public static final int VEHICLE_HEIGHT = 50;
	
	/** The x position */
	public int x;
	
	/** The y position */
	public int y;
	
	/** The previous vehicle's */
	public Vehicle next, previous;


	/**
	 * Instantiates a new vehicle.
	 *
	 * @param xPos the x pos
	 * @param yPos the y pos
	 * @param next the next vehicle
	 */
	public Vehicle(int xPos, int yPos, Vehicle next) {
		x = xPos;
		y = yPos;
		this.next = next;
		previous = null;
	}
	
	/**
	 * Draws the method
	 *
	 * @param g2 the graphic
	 */
	abstract public void draw(Graphics2D g2);

	/**
	 * Gets the rectangle
	 *
	 * @return the rect
	 */
	abstract public Rectangle getRect();

	/**
	 * Checks for has next
	 *
	 * @return true, if has next
	 */
	abstract public boolean hasN();

	/**
	 * Gets the next
	 *
	 * @return the next
	 */
	abstract public Vehicle getN();

	/**
	 * Sets the next
	 *
	 * @param next the new next
	 */
	abstract public void setN(Vehicle next);

	/**
	 * Checks for previous
	 *
	 * @return true, if has previous
	 */
	abstract public boolean hasP();

	/**
	 * Gets the previous
	 *
	 * @return the previous
	 */
	abstract public Vehicle getP();

	/**
	 * Gets the x point
	 *
	 * @return the x
	 */
	abstract public int getX();

	/**
	 * Gets the y point
	 *
	 * @return the y
	 */
	abstract public int getY();

	/**
	 * Sets the previous
	 *
	 * @param previous the new previous
	 */
	abstract public void setP(Vehicle previous);

	/**
	 * Move to.
	 *
	 * @param x the x
	 * @param y the y
	 */
	abstract public void moveTo(int x, int y);

	/**
	 * Checks if is truck.
	 *
	 * @return true, if is truck
	 */
	abstract public boolean isTruck();
}
