package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class Frame extends JFrame implements ActionListener {
	
	JPanel panel1 = new JPanel(); //panel on top left of frame
	JPanel panel2 = new JPanel(); //panel on top right of frame
	JPanel panel3 = new JPanel(); //panel on bottom of frame spanning the entire width of frame
	
	JLabel title = new JLabel(); //Used for the title on any page
	JLabel inputFN = new JLabel(); //label for inputing first name on Student Input page
	JLabel inputLN = new JLabel(); //label for inputting last name on Student Input page
	
	JButton addStudent = new JButton(); //button to add a student. This button should only exist on the home page.
	JButton homeButton = new JButton(); //button to get back to the home page. This button should not exist on the home page. 
	JButton enrollment = new JButton(); 
	JButton submit = new JButton(); //button used to submit student data on the Student Input page
	
	ImageIcon home = new ImageIcon("Home.png"); //image for the home button
	
	JTextField firstName = new JTextField();
	JTextField lastName = new JTextField();
	
	
	
	
	
	//constructor that creates a blank frame with 3 panels
	Frame(){
		
		//JPanel panel1 = new JPanel(); //panel on bottom left of frame
		panel1.setBounds(0,250,250,250); //x, y, width, height
		panel1.setBackground(new Color(253,253,150));
		
		//JPanel panel2 = new JPanel(); //panel on bottom right of frame
		panel2.setBounds(250,250,250,250); //x, y, width, height
		panel2.setBackground(new Color(253,253,150));
		
		//JPanel panel3 = new JPanel(); //panel on top of frame spanning the entire width of frame
		panel3.setBounds(0,0,500,250); //x, y, width, height
		panel3.setBackground(new Color(253,253,150));
		
		
		this.setSize(500,500);
		this.setVisible(true);
		this.setTitle("School Management System");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(253,253,150)); //sets the background color and returns the value of the Content Pane allowing us to see the background
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		
		//components on each panel
		this.getPanel1().add(addStudent); //adding the addStudent button to panel 1 (the bottom left panel)
		addStudent.addActionListener(this);
		this.getPanel2().add(enrollment);
		this.getPanel3().add(title); //adding lbel1 to top of the frame(panel 3)
		this.getPanel3().add(homeButton); //button to return to  the home page
		homeButton.addActionListener(this);
		this.getPanel3().add(title); //label for title of page
		this.getPanel1().add(inputFN); //label for student first name
		this.getPanel1().add(firstName); //The text field for student's first name
		this.getPanel1().add(inputLN); //label for student last name
		this.getPanel1().add(lastName); //The text field for student's last name
		this.getPanel2().add(submit); //button to save inputed data to a text file
		submit.addActionListener(this);
		
	}//end constructor
	
	
	//getters
	public JPanel getPanel1(){
		return panel1;
	}//end getPanel1
	
	public JPanel getPanel2() {
		return panel2;
	}//end getPanel2
	
	public JPanel getPanel3() {
		return panel3;
	}//end getPanel3
	
	
	
	
	
	public void homeScreen(){  //creates a home screen UI
		
		//buttons
		addStudent.setText("Add Student");
		addStudent.setBounds(45, 135, 150, 55); //x, y, width, height
		addStudent.setFocusable(false);
		
		enrollment.setText("Place Holder");
		enrollment.setBounds(45,135,150,55); //x, y ,width, height
		enrollment.setFocusable(false);
		
		//label
		title.setText("HOME PAGE");
		title.setFont(new Font("Garamond", Font.PLAIN, 35)); //name of font, style of font(plain, bold, italic), font size
		title.setBounds(140, 0, 300, 200);
		title.setForeground(Color.black);
		title.setBackground(new Color(253,253,150)); //sets the background color of the label
		title.setOpaque(true); //allows the background to be seen
		
		//deciding what is used for Home Screen
		homeButton.setVisible(false);
		addStudent.setVisible(true);
		enrollment.setVisible(true);
		firstName.setVisible(false);
		lastName.setVisible(false);
		inputFN.setVisible(false);
		inputLN.setVisible(false);
		submit.setVisible(false);
		
		
		//adding to panels
		/*this.getPanel1().add(addStudent); //adding the addStudent button to panel 1 (the bottom left panel)
		this.getPanel2().add(enrollment);
		this.getPanel3().add(title); //adding lbel1 to top of the frame(panel 3) */
		
	}//end homeScreen
	
	
	
	public void studentInput() {  //brings user to a page to input student data
		//title on UI page
		title.setText("Input New Student Data");
		title.setFont(new Font("Garamond", Font.PLAIN, 25));
		title.setBounds(getBounds());
		title.setBounds(125,0,300,200);
		title.setForeground(Color.black);
		title.setBackground(new Color(253,253,150));
		title.setOpaque(true);
		
		//buttons on Student Input Page
		homeButton.setPreferredSize(new Dimension(40,40)); //x,y,width,height
		homeButton.setFocusable(false);
		homeButton.setIcon(home);
		
		submit.setText("Submit");
		submit.setLocation(0,200);
		submit.setPreferredSize(new Dimension(90,30));
		
		
		//Labels
		inputFN.setText("Enter Student's First Name: ");
		inputFN.setForeground(Color.black);
		inputFN.setOpaque(true);
		inputFN.setBackground(new Color(253,253,150));
		
		
		inputLN.setText("Enter Student's Last Name: ");
		inputLN.setForeground(Color.black);
		inputLN.setOpaque(true);
		inputLN.setBackground(new Color(253,253,150));
		
		
		//text fields on Student Input page
		firstName.setPreferredSize(new Dimension(150,40));
		lastName.setPreferredSize(new Dimension(150,40));
		
		
		//deciding what is used for Student Input page
		addStudent.setVisible(false);
		enrollment.setVisible(false);
		homeButton.setVisible(true);
		firstName.setVisible(true);
		lastName.setVisible(true);
		inputFN.setVisible(true);
		inputLN.setVisible(true);
		submit.setVisible(true);
		
	}//end studentInput
	
	//creates a text file and writes student info to file. If file already exists, it will add to existing file
	public void file() {
		
		try {
			File txtFile = new File("Enrollment.txt");
			if (txtFile.createNewFile()) {
				System.out.println("File created: "+ txtFile.getName());
			}
			else {
				System.out.println("File already exists.");
			}
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
		try {
			FileWriter myWriter = new FileWriter("Enrollment.txt", true);
			String fName = firstName.getText();
			String lName = lastName.getText();
			myWriter.write(fName +" "+ lName+"\n");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
			
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}//end file
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addStudent) {
			this.studentInput();
			
		}
		else if (e.getSource() == homeButton) {
			this.homeScreen();
		
		}
		 else if (e.getSource() == submit) {
			this.file();
			firstName.setText("");
			lastName.setText("");
			this.homeScreen(); //after writing a file or adding to an existing file, brings user back to home screen
			
		} 
	}//end actionPerformed 
	
	
}//end class
