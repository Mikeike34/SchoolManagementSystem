package GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student {
	
	
	Random r = new Random();
	private int low = 100000;
	private int high = 999999;
	private int idNum;
	private String first;
	private String last;
	private String email;
	
	private List<Student> students = new ArrayList<>();
	
	
	Student(String fName, String lName){
		this.first = fName;
		this.last = lName;
		idNum = r.nextInt(high - low)+ low;
		email = first + last + "@School.edu";
		this.addToList();
	}//end student
	
	
	private void addToList() {
		students.add(this);
	}//end addToList
	
	/*public void printList() {
		students.stream().forEach(System.out::println);
	}
	public void print(List<Student> list) {
		for(Student elem : list) {
			System.out.println(elem + "\n");
		}
	} */

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
		return " "+first + " " + last + "   ID Number: "+ idNum + "   Email: "+ email;
	}
	
	

}//end class
