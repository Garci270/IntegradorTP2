package services;

import java.util.List;

import dto.DTOStudent;
import entity.Career;
import entity.Student;
import repositories.StudentRepositoryImpl;

public class StudentServices {
	private StudentRepositoryImpl impl;
	
	public StudentServices() {
		 this.impl = new StudentRepositoryImpl();
	}
	
	public void insertStudent(Student student) {
		this.impl.insertStudent(student);
	}
	public List<DTOStudent> getStudentsBySimpleOrdering(){
		return this.impl.getStudentsBySimpleOrdering();
	}
	public DTOStudent getStudentByNumberOfLibrety(long number) {
		return this.impl.getStudentByNumberOfLibrety(number);
	}
	
	public List<DTOStudent> getStudentsByGenre(String genre){
		return this.impl.getStudentsByGenre(genre);
	}

	public List<DTOStudent> getStudentsByCareerCity(Career car, String city){
		return this.impl.getStudentsByCareerCity(car, city);
	}
}
