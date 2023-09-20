package services;

import java.util.List;

import dto.DTOCareerByStudents;
import dto.DTOCareerByYear;
import entity.Career;
import entity.Student;
import repositories.CareerRepositoryImpl;
import repositories.StudentHistoryRepositoryImpl;

public class CareerServices {
	private static CareerServices instance;
	private CareerRepositoryImpl impl;
	private StudentHistoryRepositoryImpl impl_student_history;

	private CareerServices() {
		this.impl = CareerRepositoryImpl.getInstance();
		this.impl_student_history = StudentHistoryRepositoryImpl.getInstance();
	}
	
	public static CareerServices getInstance() {
		if (instance == null) {
			instance = new CareerServices();
		}
		return instance;
	}
	
	public void graduateStudent(Student student, Career career) {
		this.impl_student_history.graduateStudent(student, career);
	}
	public void insertStudentToCareer(Career career, Student student) {
		this.impl_student_history.insertStudentToCareer(career, student);
	}
	public void insertCareer(Career career) {
		this.impl.insertCareer(career);
	}
	public List<DTOCareerByStudents> getCareersByNumberOfStudents(){
		return this.impl.getCareersByNumberOfStudents();
	}
	public void getReportOfCareersDetail() {
		this.impl.getReportOfCareersDetail();
	}
	
	public List<DTOCareerByYear> getReportOfCareers() {
		return this.impl.getReportOfCareers();
	}
	
}
