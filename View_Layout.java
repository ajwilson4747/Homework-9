import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
import javax.swing.SwingConstants;
import java.awt.Font;

public class View_Layout {
	public JFrame appWindow;
	public int bugs;
	public File selected;
	public static String key;
	public static String value;
	public static HashMap<Integer, Integer> myHashMap = new HashMap<Integer, Integer>();
	private JTextField myFile1;
	private JTextField myResults1;
	private JTextField myHours1;

	public View_Layout() {

		// CREATE THE APPLICATION WINDOW
		appWindow = new JFrame();
		appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appWindow.setBounds(495, 0, 543, 487);
		appWindow.setForeground(Color.black);

		// create JPanel for JFrame
		JPanel panel = new JPanel();
		// panel.setBackground(new Color(0, 0, 0));
		panel.setForeground(Color.WHITE);
		panel.setPreferredSize(new Dimension(543, 487));
		panel.setLayout(null);

		JTextField myFileField1 = new JTextField();

		JButton findFile11 = new JButton("Find a File");
		findFile11.setBounds(349, 71, 105, 39);
		panel.add(findFile11);

		findFile11.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// @param JFileChooser opens up home directory of the user's computer so that
				// they can
				// look for a specific file to use
				JFileChooser myFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				// @param returnValue is the number that will change depending on the whether
				// the user selects anything
				int returnValue = myFile.showOpenDialog(myFile);

				// if value is approved/bigger than zero?
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					// set the approve directory location as a string
					// @param selected with equal the file directory
					// @param textPane will hold the directory as a string and display it for the
					// user to see
					selected = myFile.getSelectedFile();
					myFile1.setText(selected.toString());
					// set a method for that file to be read and interpreted
					Main.myLRFile = selected;
					readMyFile(Main.myLRFile);
				}
			}

		});

		JButton mySubmitBtn11 = new JButton("Predict Linear Regression");
		mySubmitBtn11.setBounds(190, 223, 166, 39);
		panel.add(mySubmitBtn11);
		
		mySubmitBtn11.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bugs = Main.myLR.computeLSRL(Integer.valueOf(myHours1.getText()));
				myResults1.setText(bugs + " bugs are predicted for " + myHours1.getText() + " hours. ");
			}
		});

		

		// add panel to frame
		appWindow.getContentPane().add(panel);

		myFile1 = new JTextField();
		myFile1.setBounds(66, 71, 223, 39);
		panel.add(myFile1);
		myFile1.setColumns(10);

		JLabel myHoursLabel1 = new JLabel("Hours that will used for the prediction: ");
		myHoursLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		myHoursLabel1.setBounds(66, 149, 260, 21);
		panel.add(myHoursLabel1);

		

		myResults1 = new JTextField();
		myResults1.setBounds(101, 312, 337, 39);
		panel.add(myResults1);
		myResults1.setColumns(10);

		myHours1 = new JTextField();
		myHours1.setBounds(349, 144, 96, 31);
		panel.add(myHours1);
		myHours1.setColumns(10);

		// make app window visible
		appWindow.pack();
		appWindow.setVisible(true);

	}

	private void readMyFile(File myLRFile) {
		String line = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(myLRFile));

			while ((line = reader.readLine()) != null) {
				// split line into two parts based on character of ','
				String[] parts = line.split(",", 2);
				if (parts.length >= 2) {
					{
						key = parts[0];
						value = parts[1];
						myHashMap.put(Integer.valueOf(key), Integer.valueOf(value)); // convert into integers so they
																						// can be used within the linear
																						// regression class
					}
				} else {
					throw new IllegalStateException("Datasets must be equal in size!!!");
				}
			}

			/*
			 * for (Integer key : myHashMap.keySet()) { System.out.println(key + " " +
			 * myHashMap.get(key)); }
			 */
			reader.close();

		} catch (IOException | NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
