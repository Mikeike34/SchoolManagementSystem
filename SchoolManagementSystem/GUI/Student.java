package GUI;

import java.util.LinkedList;
import java.util.Random;

public class Student {
	
	
	Random r = new Random();
	private int low = 100000;
	private int high = 999999;
	private int idNum;
	private String last;
	private String first;
	private String email;
	
	
	Student(String lName, String fName){
		this.last = lName;
		this.first = fName;
		idNum = r.nextInt(high - low)+ low;
		email = first + last + "@School.edu";
		
	}//end student
	
	
	
	
	
	
//getters and setters for student information
	public int getIdNum() {
		return idNum;
	}//end getIdNum


	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}//end setIdNum


	public String getFirst() {
		return first;
	}//end getFirst


	public void setFirst(String first) {
		this.first = first;
	}//end setFirst


	public String getLast() {
		return last;
	}//end getLast


	public void setLast(String last) {
		this.last = last;
	}//end setLast


	public String getEmail() {
		return email;
	}//end getEmail


	public void setEmail(String email) {
		this.email = email;
	}//end setEmail

	@Override
	public String toString() {
		return "  "+last + " " + first + "   ID Number: "+ idNum + "   Email: "+ email;
	}
	
	

}//end class
