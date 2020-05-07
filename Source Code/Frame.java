/*
 * Developed By Ganesha S
 * http://ganeshas.azurewebsites.net/
 * 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * The Class Frame.
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {

	/** The selected vehicle. */
	public Vehicle selectedVehicle;
	
	/** The panel. */
	public Panel panel;
	
	/**
	 * Instantiates a new frame.
	 */
	public Frame() {
		
		setTitle("Sinlgly Linked List | Anitha Peris");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 650);
		setResizable(false);
		setLocationRelativeTo(null);
		panel = new Panel();
		add(panel);
		
		//MENU
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//FILE
		JMenu file = new JMenu("File");
		menuBar.add(file);
		
		JMenuItem restart = new JMenuItem("New");
		file.add(restart);
		restart.setActionCommand("New");
		restart.addActionListener(new FileListener());
		
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit);
		exit.setActionCommand("Exit");
		exit.addActionListener(new FileListener());
		//FILE DONE
		
		//EDIT
		JMenu edit = new JMenu("Edit");
		menuBar.add(edit);
		
		JMenu move = new JMenu("Move");
		edit.add(move);
		
		JMenuItem left = new JMenuItem("Left");
		move.add(left);
		left.setActionCommand("Left");
		left.addActionListener(new EditListener());
		
		JMenuItem right = new JMenuItem("Right");
		move.add(right);
		right.setActionCommand("Right");
		right.addActionListener(new EditListener());
		
		JMenuItem up = new JMenuItem("Up");
		move.add(up);
		up.setActionCommand("Up");
		up.addActionListener(new EditListener());
	
		JMenuItem down = new JMenuItem("Down");
		move.add(down);
		down.setActionCommand("Down");
		down.addActionListener(new EditListener());
		
		JMenuItem randomize = new JMenuItem("Randomize");
		edit.add(randomize);
		randomize.setActionCommand("Randomize");
		randomize.addActionListener(new EditListener());
		// EDIT DONE
		
		
		//LIST
		JMenu list = new JMenu("List");
		menuBar.add(list);

		JMenuItem addFirst = new JMenuItem("Add First");
		list.add(addFirst);
		addFirst.setActionCommand("Add First");
		addFirst.addActionListener(new ListListener());
		
		JMenuItem addLast = new JMenuItem("Add Last");
		list.add(addLast);
		addLast.setActionCommand("Add Last");
		addLast.addActionListener(new ListListener());
		
		JMenuItem removeFirst = new JMenuItem("Remove First");
		list.add(removeFirst);
		removeFirst.setActionCommand("Remove First");
		removeFirst.addActionListener(new ListListener());
		
		JMenuItem removeLast = new JMenuItem("Remove Last (Does Not Work)");
		list.add(removeLast);
		removeLast.setActionCommand("Remove Last");
		removeLast.addActionListener(new ListListener());
		//LIST DONE
		
		setVisible(true);

	}
	
	/**
	 * The listener interface for receiving list events.
	 */
	class ListListener implements ActionListener {
		
		/**
		 * Action Performed when a certain menu item is clicked on
		 */
		public void actionPerformed(ActionEvent e) {
			String eventName = e.getActionCommand();
			
			if (eventName.equals("Add First")) {
				panel.addFirst();
			} else if (eventName.equals("Add Last")) {
				panel.addLast();
			} else if (eventName.equals("Remove First")) {
				panel.removeFirst();
			} else if (eventName.equals("Remove Last")) {
				panel.removeLast();
			}
		}
	}
	
	
	/**
	 * The listener interface for receiving file events.
	 */
	class FileListener implements ActionListener {
		
		/**
		 * Action Performed when a certain menu item is clicked on
		 */
		public void actionPerformed(ActionEvent e) {
			String eventName = e.getActionCommand();
			
			if (eventName.equals("New")) {
				panel.resetVehicles();
			} else if (eventName.equals("Exit")) {
				System.exit(0);
			}
			
		}
	}
	
	/**
	 * The listener interface for receiving edit events.
	 */
	class EditListener implements ActionListener {
		
		/**
		 * Action Performed when a certain menu item is clicked on
		 */
		public void actionPerformed(ActionEvent e) {
			String eventName = e.getActionCommand();
			
			if (eventName.equals("Left")) {
				panel.moveTruck("Left");
			} else if (eventName.equals("Right")) {
				panel.moveTruck("Right");
			} else if (eventName.equals("Up")) {
				panel.moveTruck("Up");
			} else if (eventName.equals("Down")) {
				panel.moveTruck("Down");
			} else if (eventName.equals("Randomize")) {
				panel.moveTruck("Randomize");
			}
			
		}
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Frame frame = new Frame();
	}
}
