import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PizzaMenu
	{
	// radio buttons and button group
	private JRadioButton regularCrustButton;
	private JRadioButton thinCrustButton;
	private JRadioButton handCrustButton;
	private JRadioButton deepCrustButton;
	private ButtonGroup crustButtonGroup;
	// check boxes
	private JCheckBox pepperoniBox;
	private JCheckBox sausageBox;
	private JCheckBox cheeseBox;
	private JCheckBox pepperBox;
	private JCheckBox onionBox;
	private JCheckBox mushroomBox;
	private JCheckBox oliveBox;
	private JCheckBox anchovyBox;

	// text fields
	private JTextField breadSticksText;
	private JTextField buffaloWingsText;
	private JTextField nameText;
	private JTextField addressText;
	private JTextField cityText;

	private JPanel contentPane;

	// window frame
	private JFrame frame;

	public static void main(String[] args)
		{
		PizzaMenu gui = new PizzaMenu();
		gui.start();
		}

	public void start()
		{
		frame = new JFrame("GUI Pizza");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		makeMenus();
		makeContent();
		frame.pack();
		frame.setVisible(true);
		}

	private void makeMenus()
		{
		JMenuBar menuBar;

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		// set up menus
		menuBar.add(makeFileMenu());
		menuBar.add(makeHelpMenu());
		}

	private void makeContent()
		{
		contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout(6, 6));
		
	    makeWestRegion();
	    makeCenterRegion();
	    makeEastRegion();
		}

	private JMenu makeFileMenu()
		{
		JMenu menu;
		JMenuItem menuItem; // set up the File menu
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);

		// add New menu item
		menuItem = new JMenuItem("New Order");
		menuItem.setMnemonic(KeyEvent.VK_N);
		menuItem.addActionListener(new NewListener());
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				Event.CTRL_MASK));
		menu.add(menuItem);

		// add Save menu item
		menuItem = new JMenuItem("Save Order");
		menuItem.setMnemonic(KeyEvent.VK_S);
		menuItem.addActionListener(new SaveListener());
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				Event.CTRL_MASK));
		menu.add(menuItem); // add Exit menu item
		menu.addSeparator();
		menuItem = new JMenuItem("Exit");
		menuItem.setMnemonic(KeyEvent.VK_X);
		menuItem.addActionListener(new ExitListener());
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				Event.CTRL_MASK));
		menu.add(menuItem);

		return menu;
		}

	private JMenu makeHelpMenu()
		{
		JMenu menu;
		JMenuItem menuItem; // set up the Help menu
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);

		// add About menu item
		menuItem = new JMenuItem("About GUI Pizza");
		menuItem.setMnemonic(KeyEvent.VK_A);
		menuItem.addActionListener(new AboutListener());
		menu.add(menuItem);

		return menu;
		}

	private void makeWestRegion()
		{
		// set up Crust options with radio buttons in WEST
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Choose a Crust"));
		crustButtonGroup = new ButtonGroup();
		regularCrustButton = new JRadioButton("Regular Crust", true);
		crustButtonGroup.add(regularCrustButton);
		panel.add(regularCrustButton);
		thinCrustButton = new JRadioButton("Thin Crust", false);
		crustButtonGroup.add(thinCrustButton);
		panel.add(thinCrustButton);
		handCrustButton = new JRadioButton("Hand-Tossed Crust", false);
		crustButtonGroup.add(handCrustButton);
		panel.add(handCrustButton);
		deepCrustButton = new JRadioButton("Deep-Dish Crust", false);
		crustButtonGroup.add(deepCrustButton);
		panel.add(deepCrustButton);

		contentPane.add(panel, BorderLayout.WEST);
		}

	private void makeCenterRegion()
		{
		// set up toppings with check boxes in CENTER
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Select Toppings"));

		pepperoniBox = new JCheckBox("Pepperoni", false);
		panel.add(pepperoniBox);
		sausageBox = new JCheckBox("Sausage", false);
		panel.add(sausageBox);
		cheeseBox = new JCheckBox("Extra Cheese", false);
		panel.add(cheeseBox);
		pepperBox = new JCheckBox("Bell Peppers", false);
		panel.add(pepperBox);
		onionBox = new JCheckBox("Onions", false);
		panel.add(onionBox);
		mushroomBox = new JCheckBox("Mushrooms", false);
		panel.add(mushroomBox);
		oliveBox = new JCheckBox("Olives", false);
		panel.add(oliveBox);
		anchovyBox = new JCheckBox("Anchovies", false);
		panel.add(anchovyBox);
		contentPane.add(panel, BorderLayout.CENTER);
		}

	private void makeEastRegion()
		{
		// set up side orders with quantities in EAST
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory
				.createTitledBorder("Sides (Enter Quantity)"));
		panel.setPreferredSize(new Dimension(150, 0));

		JPanel smallPanel = new JPanel();
		smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.X_AXIS));
		breadSticksText = new JTextField("", 2);
		breadSticksText.setMaximumSize(new Dimension(20, 24));
		smallPanel.add(breadSticksText);
		smallPanel.add(new JLabel(" Bread Sticks"));
		smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(smallPanel);

		smallPanel = new JPanel();
		smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.X_AXIS));
		buffaloWingsText = new JTextField("", 2);
		buffaloWingsText.setMaximumSize(new Dimension(20, 24));
		smallPanel.add(buffaloWingsText);
		smallPanel.add(new JLabel(" Buffalo Wings"));
		smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(smallPanel);

		contentPane.add(panel, BorderLayout.EAST);
		}

	private class AboutListener implements ActionListener
		{
		public void actionPerformed(ActionEvent e)
			{
			JOptionPane
					.showMessageDialog(
							frame,
							"GUI Pizza\n\nVersion 1.0\nBuild B20080226-1746\n\n"
									+ "(c) Copyright Merrill Hall 2008\nAll rights reserved\n\n"
									+ "Visit /\nEducation To Go\n"
									+ "Intermediate Java Course",
							"About GUI Pizza", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	private class ExitListener implements ActionListener
		{
		public void actionPerformed(ActionEvent e)
			{
			System.exit(0);
			}
		}

	private class NewListener implements ActionListener
		{
		public void actionPerformed(ActionEvent e)
			{
			JOptionPane.showMessageDialog(frame,
					"The  File > New  menu option was clicked", "GUI Pizza",
					JOptionPane.INFORMATION_MESSAGE);
			}
		}

	private class SaveListener implements ActionListener
		{
		public void actionPerformed(ActionEvent ae)
			{
			JOptionPane.showMessageDialog(frame,
					"The  File > Save  menu option was clicked", "GUI Pizza",
					JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
