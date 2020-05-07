/*
 * Name: Bilawal Sheikh
 * Student Number: 500563972
 * Date: Tuesday April 8, 2014
 * 
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.JPanel;

/**
 * The Class Panel.
 */
@SuppressWarnings("serial")
public class Panel extends JPanel {

	/** The vehicle objects. */
	public ArrayList<Vehicle> vehicleObjects;
	
	/** The selected vehicle. */
	public Vehicle selectedVehicle;
	
	/** The first time ran. */
	public boolean firstTime = true;
	
	/** The first vehicle. */
	public Vehicle firstVehicle = null; 
	
	/** The delay. */
	public final int DELAY = 30;



	/**
	 * Instantiates a new panel.
	 */
	public Panel() {
		this.setBackground(Color.WHITE);

		Handlerclass handler = new Handlerclass();
		ActionListener timeListener = new TimeListener();

		this.addMouseListener(handler);
		this.addMouseMotionListener(handler);

		Timer timer = new Timer(DELAY, timeListener);

		vehicleObjects = new ArrayList<Vehicle>();
		timer.start();

	}


	/**
	 * Sets the up vehicle's
	 *
	 * @param event mouseevent when pressed
	 */
	public void setUpVehicle(MouseEvent event) {
		if(vehicleObjects.size() == 0) {
			vehicleObjects.add(new Truck(event.getX(), event.getY()));
		} else if(vehicleObjects.size() < 6){
			vehicleObjects.add(new Car(event.getX(), event.getY()));
		}
	}

	/**
	 * Check's if the vehicle have been added
	 *
	 * @return true, if successful 6 vehicle's have been added
	 */
	public boolean setUpVehicleDone() {
		if (vehicleObjects.size() >= 6) {
			selectedVehicle = null; 
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Adds the first car to the truck
	 */
	public void addFirst() {

		Vehicle v2;
		if(vehicleObjects.size() >= 6){
			for(int i=0; i<vehicleObjects.size(); i++){
				if(vehicleObjects.get(i).equals(selectedVehicle)&&!vehicleObjects.get(i).hasP()){
					if(!vehicleObjects.get(0).hasN()){
						vehicleObjects.get(0).setN(vehicleObjects.get(i));
						vehicleObjects.get(i).setP(vehicleObjects.get(0));
					} else{
						v2 = vehicleObjects.get(0).getN();
						v2.setP(null);
						vehicleObjects.get(0).setN(vehicleObjects.get(i));
						vehicleObjects.get(i).setP(vehicleObjects.get(0));
						vehicleObjects.get(0).setN(vehicleObjects.get(i));
						Vehicle v = vehicleObjects.get(i);
						while(v.hasN()){
							v = v.getN();
						}
						v.setN(v2);
						v2.setP(v);
					}
					selectedVehicle = null;
				}
			}
		}                                    
	}

	/**
	 * Adds the last car to the truck
	 */
	public void addLast() {
		if(vehicleObjects.size()>=6){
			for(int i=0; i<vehicleObjects.size(); i++){
				if(vehicleObjects.get(i).equals(selectedVehicle)&&!vehicleObjects.get(i).hasP()){
					Vehicle v = vehicleObjects.get(0);
					while(v.hasN()){
						v = v.getN();
					}
					v.setN(vehicleObjects.get(i));
					vehicleObjects.get(i).setP(v);
				}
			}
		}
	}

	/**
	 * Removes the first car in the truck
	 */
	public void removeFirst() {

		if(vehicleObjects.size()>=6){
			Vehicle truck = vehicleObjects.get(0);
			Vehicle chainAfterTruck = truck.getN();
			if (chainAfterTruck != null) {
				if (chainAfterTruck.getN() != null) {
					Vehicle chainAfterTruck2 = chainAfterTruck.getN();
					chainAfterTruck.setN(null);
					chainAfterTruck.setP(null);;
					truck.setN(chainAfterTruck2);
				} else {
					chainAfterTruck.setN(null);
					chainAfterTruck.setP(null);
					truck.setN(null);
				}

				int max = 500;
				int min = 80;
				int randomX = min + (int) (Math.random() * ((max - (min)) + 1));
				int randomY = min + (int) (Math.random() * ((max - (min)) + 1));
				chainAfterTruck.moveTo(randomX, randomY);
			}
		}		
	}

	/**
	 * Removes the last car in the truck (Does not work)
	 */
	public void removeLast() {
		if(vehicleObjects.size()>=6){
			Vehicle truck = vehicleObjects.get(0);
			Vehicle carAfterTruck = truck.getN();
			if (truck.getN() == null) {
			} else {
				truck.setN(null);
				carAfterTruck.setN(null);
				carAfterTruck.setP(null);
			}
		}
	}

	/**
	 * The Class Handlerclass that takes care of mouse events
	 */
	public class Handlerclass implements MouseListener, MouseMotionListener {

		/**
		 * Mouse being dragged. Moves Vehicle
		 */
		@Override
		public void mouseDragged(MouseEvent e) {
			if (selectedVehicle != null && !selectedVehicle.isTruck()) {
				selectedVehicle.moveTo(e.getX(), e.getY());
				for (Vehicle v : vehicleObjects) {
					if (v.hasN()) {
						v.getN().moveTo(v.getX()+80, v.getY());
					}
				}
			}
		}

		/**
		 * Mouse Pressed. Selects or Add's Vehicle
		 */
		@Override
		public void mousePressed(MouseEvent e) {
			setUpVehicle(e);
			if (setUpVehicleDone()){
				for (Vehicle v : vehicleObjects) {
					if (v.hasP() == false && v.getRect().contains(e.getPoint())) {
						selectedVehicle = v;
						break;
					} else {
						selectedVehicle = null;
					}

				}

			}
		}

		/**
		 * Mouse Released. Connects with another car if close enough
		 */
		@Override
		public void mouseReleased(MouseEvent e) {

			if (selectedVehicle != null) {
				for(Vehicle vehicle : vehicleObjects) { 
					if(vehicle.equals(selectedVehicle) == false) {
						if(vehicle.getRect().intersects(selectedVehicle.getRect())) {
							if(vehicle.getN() == null)  {
								vehicle.setN(selectedVehicle); 
								if (firstTime) {
									firstVehicle = vehicle;
									firstTime = false;
									repaint();
								}
							}
						}
					}
				}
			}
		}

		//Do-Nothing Methods
		@Override
		public void mouseMoved(MouseEvent e) {}
		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}

	/**
	 * Reset vehicles and removes cars/trucks to to New.
	 */
	public void resetVehicles() {
		for (Vehicle v: vehicleObjects) {
			v.setN(null);
			v.setP(null);
		}
		vehicleObjects.clear();
	}

	/**
	 * Move's the truck.
	 *
	 * @param whereTo Where to move the truck
	 */
	public void moveTruck(String whereTo) {

		int counter = 0;
		if (whereTo.equals("Left")) {
			if (vehicleObjects.get(0).getX() > 50) {
				vehicleObjects.get(0).moveTo(vehicleObjects.get(0).getX() - 50, vehicleObjects.get(0).getY());
				counter = 0;
				for (Vehicle v : vehicleObjects) {
					if (v.hasN()) {
						v.getN().moveTo(vehicleObjects.get(0).getX()+70 + counter, vehicleObjects.get(0).getY());
						counter+= 70;
					}
				}
				counter = 0;
			}
		} else if (whereTo.equals("Right")) {
			if (vehicleObjects.get(0).getX() < 550) {
				vehicleObjects.get(0).moveTo(vehicleObjects.get(0).getX() + 50, vehicleObjects.get(0).getY());
				counter = 0;
				for (Vehicle v : vehicleObjects) {
					if (v.hasN()) {
						v.getN().moveTo(vehicleObjects.get(0).getX()+70 + counter, vehicleObjects.get(0).getY());
						counter+= 70;
					}
				}
				counter = 0;
			}
		} else if (whereTo.equals("Up")) {
			vehicleObjects.get(0).moveTo(vehicleObjects.get(0).getX(), vehicleObjects.get(0).getY()-50);
			counter = 0;
			for (Vehicle v : vehicleObjects) {
				if (v.hasN()) {
					v.getN().moveTo(vehicleObjects.get(0).getX()+70 + counter, vehicleObjects.get(0).getY());
					counter+= 70;
				}
			}
			counter = 0;
		} else if (whereTo.equals("Down")) {
			vehicleObjects.get(0).moveTo(vehicleObjects.get(0).getX(), vehicleObjects.get(0).getY() + 50);
			counter = 0;
			for (Vehicle v : vehicleObjects) {
				if (v.hasN()) {
					v.getN().moveTo(vehicleObjects.get(0).getX()+70 + counter, vehicleObjects.get(0).getY());
					counter+= 70;
				}
			}
			counter = 0;
		} else if (whereTo.equals("Randomize")) {

			int max = 500;
			int min = 80;
			int randomX = min + (int) (Math.random() * ((max - (min)) + 1));
			int randomY = min + (int) (Math.random() * ((max - (min)) + 1));

			vehicleObjects.get(0).moveTo(randomX, randomY);
			counter = 0;
			for (Vehicle v : vehicleObjects) {
				if (v.hasN()) {
					v.getN().moveTo(vehicleObjects.get(0).getX()+70 + counter, vehicleObjects.get(0).getY());
					counter+= 70;
				}
			}
			counter = 0;
		}
	}


	/**
	 * Paints the panel to display various objects
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		for (Vehicle v : vehicleObjects) {
			if(v.hasP() == false) {
				if(v.equals(selectedVehicle)) {
					g2.setColor(Color.red);
				} else {
					g2.setColor(Color.black);
				}

				v.draw(g2);
			}

		}
		if (vehicleObjects.size() >= 6) {
			for (Vehicle v : vehicleObjects) {
				if (v.equals(selectedVehicle) && selectedVehicle.hasN() && selectedVehicle.getP() !=  vehicleObjects.get(0)) {
					g2.setColor(Color.red);
					v.draw(g2);
				} 
			}
		}
	}

	/**
	 * The listener interface for receiving time events.
	 */
	class TimeListener implements ActionListener {
		
		/**
		 * Action Performed after every time that passes by
		 */
		public void actionPerformed(ActionEvent event) {
			repaint();
		}
	}
}
