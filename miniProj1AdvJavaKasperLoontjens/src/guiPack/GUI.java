package guiPack;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import brainPack.Brain;

public class GUI extends Brain{
	
	// Creates GUI elements
	JFrame frame = new JFrame("Clock");
	JPanel panel = new JPanel();
	JButton switchButton = new JButton("switch");
	JButton setButton = new JButton("set");
	JTextPane textPane = new JTextPane();
	JTextField firstResponseField = new JTextField();
	JTextField secondResponseField = new JTextField();
	JTextField thirdResponseField = new JTextField();

	public void createAndDisplay() {
		// Adds and positions GUI elements
		
		//To position as I want
		panel.setLayout(null);
		
		switchButton.setBounds(100, 200, 100, 30);
		switchButton.addActionListener(actionListenerSwitch);
		setButton.setBounds(400, 200, 100, 30);
		setButton.addActionListener(actionListenerSet);
		panel.add(setButton);
		
		firstResponseField.setBounds(100, 60, 100, 30);	
		secondResponseField.setBounds(250, 60, 100, 30);	
		thirdResponseField.setBounds(400, 60, 100, 30);	
		
		textPane.setBounds(100, 10, 400, 40);
		panel.add(textPane);
		textPane.setBorder(BorderFactory.createLineBorder(Color.black));
		
		textPane.setEditable(false);
		StyledDocument doc = textPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		frame.setSize(600,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
		updateGUI();
		
	 }
	
	public void removeForChange() {
		// When display is changed this will remove unnecessary elements
		panel.remove(switchButton);
		panel.remove(firstResponseField);
		panel.remove(secondResponseField);
		panel.remove(thirdResponseField);

	}
	
	protected void updateGUI() {
		removeForChange();
		
		// Adds and changes GUI to show elements according to DisplayState controlled by brain class
		
		switch (getDisplayState()) {
		case DISPLAYTIME: 
			panel.add(switchButton);
			textPane.setText("Current time: \n"
					+ timeClass.getHour() + " : "
					+ timeClass.getMinute() + " : "
					+ timeClass.getSecond());
			break;
		case DISPLAYDATE:
			panel.add(switchButton);
			textPane.setText("Current date: \n"
					+ dateClass.getYear() + " : "
					+ dateClass.getMonth() + " : "
					+ dateClass.getDay());
			break;
		case CHANGETIME:
			textPane.setText("Set new time");
			panel.add(firstResponseField);
			panel.add(secondResponseField);
			panel.add(thirdResponseField);
			firstResponseField.setText("Hour");
			secondResponseField.setText("Minute");
			thirdResponseField.setText("Second");

			break;
		case CHANGEDATE:
			textPane.setText("Set new date");
			panel.add(firstResponseField);
			panel.add(secondResponseField);
			panel.add(thirdResponseField);
			firstResponseField.setText("Year");
			secondResponseField.setText("Month");
			thirdResponseField.setText("Day");
			break;
		default:
		}
		paintMe();
	}
	
	ActionListener actionListenerSwitch = new ActionListener() {
		// Switches from displaying time to date and vice versa 
		public void actionPerformed(ActionEvent e) {
			switchClicked();
		}
	};
	
	ActionListener actionListenerSet = new ActionListener() {
		
		// When "Set" button is pressed will run code in either timesClass or dateClass 
		// which determines if user wrote correct dates/times, if it is so then dates/times will be updated.
		public void actionPerformed(ActionEvent e) {
			switch (getDisplayState()) {
			case CHANGETIME: 
				if (timeClass.readyToSet(firstResponseField.getText(), secondResponseField.getText(), thirdResponseField.getText())) {
					setClicked();
				}else {
					textPane.setText("Incorrect input, Set new time.");

				}
				break;
			case CHANGEDATE: 
				if (dateClass.readyToSet(firstResponseField.getText(), secondResponseField.getText(), thirdResponseField.getText())) {
					setClicked();
				}else {
					textPane.setText("Incorrect input, Set new date.");
				}
				break;
			case DISPLAYTIME: 
				setClicked();
				break;
			case DISPLAYDATE: 
				setClicked();
				break;
			default:
				System.out.println("something went wrong");
			}
		}
	};

	public void paintMe(){
		frame.repaint();
		frame.revalidate();
	}
	

}
