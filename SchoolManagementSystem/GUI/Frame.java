package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;





public class Frame extends JFrame implements ActionListener {
	//all panels
	JPanel panel1 = new JPanel(); //panel on top left of frame
	JPanel panel2 = new JPanel(); //panel on top right of frame
	JPanel panel3 = new JPanel(); //panel on bottom of frame spanning the entire width of frame
	
	//all labels
	JLabel title = new JLabel(); //Used for the title on any page
	JLabel inputFN = new JLabel(); //label for inputing first name on Student Input page
	JLabel inputLN = new JLabel(); //label for inputting last name on Student Input page
	JLabel caseSensitive = new JLabel(); // label for warning user for case sensitivity
	
	//all buttons
	JButton addStudent = new JButton(); //button to add a student. This button should only exist on the home page.
	JButton homeButton = new JButton(); //button to get back to the home page. This button should not exist on the home page. 
	JButton studentList = new JButton(); 
	JButton submit = new JButton(); //button used to submit student data on the Student Input page
	JButton studentSearch = new JButton(); //button used to bring user to student search page
	JButton search = new JButton(); //button used to search for a specific student on the Student Search Page
	
	//all ImageIcons
	ImageIcon home = new ImageIcon("Home.png"); //image for the home button
	
	//all text fields
	JTextField firstName = new JTextField();
	JTextField lastName = new JTextField();
	
	//all text ares
	JTextArea list = new JTextArea(23,45);
	JTextArea inputFeedback = new JTextArea(5,20);
	JTextArea homeInfo = new JTextArea(5,40);
	
	
	
	
	
	
	
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
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		
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
		this.getPanel1().add(studentSearch);//Student search button on the home page to bring user to the student search page. 
		studentSearch.addActionListener(this);
		this.getPanel2().add(studentList); //button to read enrollment list
		studentList.addActionListener(this);
		//this.getPanel3().add(title); //adding label to top of the frame(panel 3)
		this.getPanel3().add(homeButton); //button to return to  the home page
		homeButton.addActionListener(this);
		this.getPanel3().add(title); //label for title of page
		this.getPanel1().add(inputFN); //label for student first name
		this.getPanel1().add(firstName); //The text field for student's first name
		this.getPanel1().add(inputLN); //label for student last name
		this.getPanel1().add(lastName); //The text field for student's last name
		this.getPanel2().add(submit); //button to save inputed data to a text file
		submit.addActionListener(this);
		this.getPanel2().add(search); //button to search for a student in the students array
		search.addActionListener(this);
		this.getPanel2().add(caseSensitive);
		this.getPanel3().add(list);
		this.getPanel3().add(inputFeedback);
		this.getPanel3().add(homeInfo);
		
		
		//visibility of base frame
		addStudent.setVisible(false);
		studentList.setVisible(false);
		homeButton.setVisible(false);
		firstName.setVisible(false);
		lastName.setVisible(false);
		inputFN.setVisible(false);
		inputLN.setVisible(false);
		submit.setVisible(false);
		list.setVisible(false);
		inputFeedback.setVisible(false);
		homeInfo.setVisible(false);
		panel1.setVisible(false);
		panel2.setVisible(false);
		search.setVisible(false);
		studentSearch.setVisible(false);
		caseSensitive.setVisible(false);
		
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
	
	
	
	
	//Adjusts components in frame to look and function as a home screen UI
	public void homeScreen(){  
		
		//buttons
		addStudent.setText("Add Student");
		addStudent.setBounds(45, 135, 150, 55); //x, y, width, height
		addStudent.setFocusable(false);
		
		studentSearch.setText("Find Student");
		studentSearch.setBounds(45,200,150,55);
		studentSearch.setFocusable(false);
		
		studentList.setText("Student List");
		studentList.setBounds(45,135,150,55); //x, y ,width, height
		studentList.setFocusable(false);
		
		//label
		title.setText("HOME PAGE");
		title.setFont(new Font("Garamond", Font.PLAIN, 35)); //name of font, style of font(plain, bold, italic), font size
		title.setBounds(140, 0, 300, 200);
		title.setForeground(Color.black);
		title.setBackground(new Color(253,253,150)); //sets the background color of the label
		title.setOpaque(true); //allows the background to be seen
		
		//textArea
		homeInfo.setBackground(new Color(253,253,150));
		homeInfo.setEditable(false);
		homeInfo.setText("                       Enroll a new student by clicking 'Add Student'\n"+
				"\n                       Find a current student by clicking 'Find Student'\n"+
				"\n                                                              or\n"+
				"\n                    See currently enrolled students by clicking 'Student List'");
		
		
		//deciding what is used for Home Screen
		homeButton.setVisible(false);
		addStudent.setVisible(true);
		studentList.setVisible(true);
		firstName.setVisible(false);
		lastName.setVisible(false);
		inputFN.setVisible(false);
		inputLN.setVisible(false);
		submit.setVisible(false);
		list.setVisible(false);
		inputFeedback.setVisible(false);
		homeInfo.setVisible(true);
		panel1.setVisible(true);
		panel2.setVisible(true);
		search.setVisible(false);
		studentSearch.setVisible(true);
		caseSensitive.setVisible(false);
		
		
		//ensures UI is displaying correctly
		this.repaint();
		this.revalidate();
		
		
	}//end homeScreen
	
	
	
	
	//Adjusts components in frame to look and function as a Student Input UI
	public void studentInput() {  
		//title on UI page
		title.setText("Input New Student Data");
		title.setFont(new Font("Garamond", Font.PLAIN, 25));
		title.setBounds(getBounds());
		title.setBounds(125,0,300,200);
		title.setForeground(Color.black);
		title.setBackground(new Color(253,253,150));
		title.setOpaque(true);
		
		//text area on page
		inputFeedback.setBackground(new Color(253,253,150));
		inputFeedback.setEditable(false);
		
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
		firstName.setText("");
		lastName.setPreferredSize(new Dimension(150,40));
		lastName.setText("");
		
		//deciding what is used for Student Input page
		addStudent.setVisible(false);
		studentList.setVisible(false);
		homeButton.setVisible(true);
		firstName.setVisible(true);
		lastName.setVisible(true);
		inputFN.setVisible(true);
		inputLN.setVisible(true);
		submit.setVisible(true);
		list.setVisible(false);
		inputFeedback.setVisible(true);
		homeInfo.setVisible(false);
		panel1.setVisible(true);
		panel2.setVisible(true);
		search.setVisible(false);
		studentSearch.setVisible(false);
		caseSensitive.setVisible(false);
		
		
		//ensures UI is displaying correctly
		this.repaint(); 
		this.revalidate();
		
	}//end studentInput
	
	
	File txtFile = new File("studentList.txt");
	
	
	List<Student> students = new ArrayList<>(); //an ArrayList of student objects
	
	//creates a text file and writes student info to file. If file already exists, it will add to existing file
	public void file() {
		
		try {
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
			Student stud= new Student(lastName.getText(),firstName.getText());
			students.add(stud);
			FileWriter myWriter = new FileWriter("studentList.txt", true);
			myWriter.write(stud.toString()+"\n"+"\n");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
			inputFeedback.setText("Enrolled Student.\n"+"\nYou can add another student"+"\n                       or"+"\nReturn to the home page");
			
			
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}//end file
	
	
	
	//search method will return all students with the last name searched.
	private int search(String last,String first)throws IOException{
		
		sort(lines);
		
		Iterator<String> iter = lines.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			if(s.contains(last)&&s.contains(first)){
				return lines.indexOf(s);
			}
			
		}//end while
	
		return -1;
		
	}//end search
	
	
	
	
	private void searchResult() throws IOException {
		int index = search(lastName.getText(),firstName.getText());
		if(index >= 0) {
			list.append(lines.get(index)+"\n");
		}
		else {
			list.append(" Student is not enrolled.");
		}
		
	}//end searchResult
	
	
	
	
	List<String> lines = new ArrayList<String>();
	
	//sort method reads the list of enrolled students and sorts it into a new List.
	private void sort(List<String> lines) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(txtFile));
		String line;
		while((line = bufferedReader.readLine()) != null) {
			if(line.trim().length() > 0) {
				lines.add(line);
				line = bufferedReader.readLine();
			}
		}
		bufferedReader.close();
		Collections.sort(lines, Collator.getInstance());
		
		
	}//end sort
	
	
	
	File orderedTxtFile = new File("newStudentList.txt"); 
	
	public void studentList() throws IOException {
		
		
		title.setText("Current Students");
		
		homeButton.setPreferredSize(new Dimension(40,40)); //x,y,width,height
		homeButton.setFocusable(false);
		homeButton.setIcon(home);
		
		list.setEditable(false); //ensures user cannot type here.
		list.setText("");
		
		addStudent.setVisible(false);
		studentList.setVisible(false);
		homeButton.setVisible(true);
		firstName.setVisible(false);
		lastName.setVisible(false);
		inputFN.setVisible(false);
		inputLN.setVisible(false);
		submit.setVisible(false);
		list.setVisible(true);
		inputFeedback.setVisible(false);
		homeInfo.setVisible(false);
		panel1.setVisible(false);
		panel2.setVisible(false);
		search.setVisible(false);
		studentSearch.setVisible(false);
		caseSensitive.setVisible(false);
		
		//Reading student list and ordering it into a new text file. 
		sort(lines);
				try {
					if (orderedTxtFile.createNewFile()) {
						System.out.println("File created: "+ orderedTxtFile.getName());
						}
					else {
						System.out.println("File already exists. File Overwritten.");
					}
					
				}catch(IOException e) {
					System.out.println("Error: "+e.getMessage());
				}
				
				try{
					BufferedWriter bw = new BufferedWriter(new FileWriter(orderedTxtFile));
						for(String str : lines) {
							bw.write(str + "\n");
							bw.newLine();
						}
						bw.close();
				}catch(IOException e){
					System.out.println("Error: "+e.getMessage());
				}
				
				//reading ordered list of students and displaying it to the UI
				try {
					Scanner myReader = new Scanner(orderedTxtFile);
					while(myReader.hasNextLine()) {
						String data = myReader.nextLine();
						//System.out.println(data); //displays student list in console
						list.append(data + "\n"); //displays student list in text area *append allows each line to be added onto the previous line instead of overwriting the previous line.
					}
					myReader.close();
				}catch(IOException e) {
					System.out.println("Error: "+ e.getMessage());
				}
				
				lines.clear();
		
				
		this.repaint(); 
		this.revalidate();
		
	}//end studentList
	
	public void studentSearchPage() {
		//title on UI page
				title.setText("Student Search");
				title.setFont(new Font("Garamond", Font.PLAIN, 25));
				title.setBounds(getBounds());
				title.setBounds(125,0,300,200);
				title.setForeground(Color.black);
				title.setBackground(new Color(253,253,150));
				title.setOpaque(true);
				
				//text area on page
				inputFeedback.setBackground(new Color(253,253,150));
				inputFeedback.setEditable(false);
				
				//buttons on Student Input Page
				homeButton.setPreferredSize(new Dimension(40,40)); //x,y,width,height
				homeButton.setFocusable(false);
				homeButton.setIcon(home);
				
				search.setText("Search");
				search.setLocation(0,200);
				search.setPreferredSize(new Dimension(90,30));
				
				
				//Labels
				inputFN.setText("Enter Student's First Name: ");
				inputFN.setForeground(Color.black);
				inputFN.setOpaque(true);
				inputFN.setBackground(new Color(253,253,150));
				
				
				inputLN.setText("Enter Student's Last Name: ");
				inputLN.setForeground(Color.black);
				inputLN.setOpaque(true);
				inputLN.setBackground(new Color(253,253,150));
				
				caseSensitive.setText("Reminder: Input is Case Sensitive.");
				caseSensitive.setFont(new Font("Garamond", Font.ITALIC,  15));
				caseSensitive.setForeground(Color.black);
				caseSensitive.setOpaque(true);
				caseSensitive.setBackground(new Color(253,253,150));
				
				
				//text fields on Student Input page
				firstName.setPreferredSize(new Dimension(150,40));
				firstName.setText("");
				lastName.setPreferredSize(new Dimension(150,40));
				lastName.setText("");
				list.setEditable(false);
				list.setText("");
				
				
				//deciding what is used for Student Input page
				addStudent.setVisible(false);
				studentList.setVisible(false);
				homeButton.setVisible(true);
				firstName.setVisible(true);
				lastName.setVisible(true);
				inputFN.setVisible(true);
				inputLN.setVisible(true);
				submit.setVisible(false);
				list.setVisible(true);
				inputFeedback.setVisible(true);
				homeInfo.setVisible(false);
				panel1.setVisible(true);
				panel2.setVisible(true);
				search.setVisible(true);
				studentSearch.setVisible(false);
				caseSensitive.setVisible(true);
				
				
				
				//ensures UI is displaying correctly
				this.repaint(); 
				this.revalidate();
		
	}//end studentSearchPage
	
	
	
	
	//gets info about the file created through the file() method.
	public void getFileInfo() {
		
		if(txtFile.exists()) {
			System.out.println("File name: "+ txtFile.getName());
			System.out.println("Absolute path: "+ txtFile.getAbsolutePath());
			System.out.println("File size in bytes: "+ txtFile.length());
		}
	}
	

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
			firstName.setText(""); //sets firstName text field to blank
			lastName.setText(""); //sets lastName text field to blank
			//this.homeScreen(); //after writing a file or adding to an existing file, brings user back to home screen
			//System.out.println(Arrays.toString(students));
			
		}
		 else if (e.getSource()== studentList) {
			 list.setText("");
			 try {
				this.studentList();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		 }
		 else if(e.getSource() == studentSearch) {
			 this.studentSearchPage();
		 }
		 else if(e.getSource() == search) {
			 list.setText("");
			try {
				this.searchResult();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			 firstName.setText("");
			 lastName.setText("");
			 this.repaint(); 
			 this.revalidate();
		 }
	}//end actionPerformed 
	
	
}//end class
