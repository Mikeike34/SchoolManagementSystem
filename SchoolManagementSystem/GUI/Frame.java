package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class Frame extends JFrame implements ActionListener {
	
	JPanel panel1 = new JPanel(); //panel on top left of frame
	JPanel panel2 = new JPanel(); //panel on top right of frame
	JPanel panel3 = new JPanel(); //panel on bottom of frame spanning the entire width of frame
	
	JLabel label1 = new JLabel();
	
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	
	
	
	
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
		
		
	}//end constructor
	
	public JPanel getPanel1(){
		return panel1;
	}//end getPanel1
	
	public JPanel getPanel2() {
		return panel2;
	}//end getPanel2
	
	public JPanel getPanel3() {
		return panel3;
	}//end getPanel3
	
	public void homeScreen(){
		
		//buttons
		button1.setText("New Student");
		button1.setBounds(45, 135, 150, 55); //x, y, width, height
		button1.addActionListener(this);
		
		button2.setText("Place Holder");
		button2.setBounds(45,135,150,55); //x, y ,width, height
		
		//label
		label1.setText("HOME PAGE");
		label1.setFont(new Font("Garamond", Font.PLAIN, 35)); //name of font, style of font(plain, bold, italic), font size
		label1.setBounds(140, 0, 300, 200);
		label1.setHorizontalTextPosition(JLabel.CENTER);
		label1.setVerticalTextPosition(JLabel.CENTER);
		label1.setForeground(Color.black);
		label1.setBackground(new Color(253,253,150)); //sets the background color of the label
		label1.setOpaque(true); //allows the background to be seen
		
		
		//adding to panels
		this.getPanel1().add(button1);
		this.getPanel2().add(button2);
		this.getPanel3().add(label1);
		
	}//end homeScreen
	
	public void studentInput() {
		label1.setText("Input New Student Data");
		label1.setFont(new Font("Garamond", Font.PLAIN, 25));
		label1.setBounds(getBounds());
		label1.setBounds(125,0,300,200);
		label1.setForeground(Color.black);
		label1.setBackground(new Color(253,253,150));
		label1.setOpaque(true);
		
		
		this.getPanel3().add(label1);
		
		
	}//end studentInput

	@Override
	public void actionPerformed(ActionEvent e) {
		this.getPanel1().remove(button1);
		this.getPanel2().remove(button2);
		this.studentInput();
		
		
	}//end actionPerformed
	
	

}//end class
