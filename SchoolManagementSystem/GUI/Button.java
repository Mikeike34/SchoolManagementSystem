package GUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button implements ActionListener{
	
	Component Button(String title,int type){
		JButton button = new JButton(title);
		
		if(type == 1) {
			action1(null);
		}
		else if(type == 2) {
			action2(null);
		}
		else if(type == 3) {
			button.addActionListener(this);
		}
		return button;
		
	}//end constructor

	public void action1(ActionEvent e) {
		
		
	}//end action1
	public void action2(ActionEvent e) {
		
	}//end action2

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	

}//end class
