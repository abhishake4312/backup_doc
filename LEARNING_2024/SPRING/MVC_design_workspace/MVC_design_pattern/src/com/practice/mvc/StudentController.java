package com.practice.mvc;

public class StudentController {

	private Student studentModel;
	private StudentView studentView;
	
	public StudentController(Student studentModel,StudentView studentView) {
		this.studentModel=studentModel;
		this.studentView=studentView;
	}
	public void setStudentName(String name) {
		studentModel.setName(name);
	}
	public String getStudentName() {
		return studentModel.getName();
	}
	public void setStudentRollNumber(int rollNo) {
		studentModel.setRollNo(rollNo);
	}
	public int getRollNo() {
		return studentModel.getRollNo();
	}
	public void updateView() {
		studentView.printStudentInformation(studentModel.getName(), studentModel.getRollNo());
	}
}
