package com.practice.mvc;

public class MVCPatternDemo {
	public static void main(String[] args) {

	      //fetch student record based on his roll no from the database
	      Student model  = retriveStudentFromDatabase();

	      //Create a view : to write student details on console
	      StudentView view = new StudentView();

	      StudentController controller = new StudentController(model, view);

	      controller.updateView();

	      //update model data
	      
      /*    model.setName("abhi"); 
       *    don't do directly do via controller cause  
	        StudentController is the controller class responsible to store data in Student object
	        and update view StudentView accordingly.
	  */
	      controller.setStudentName("John");

	      controller.updateView();
	   }

	   private static Student retriveStudentFromDatabase(){
	      Student student = new Student();
	      student.setName("Robert");
	      student.setRollNo(10);
	      return student;
	   }
}
