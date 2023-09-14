package services;

import java.util.List;

import dto.DTOCareerByStudents;
import dto.DTOCareerByYear;
import entity.Career;
import entity.Student;
import repositories.CareerRepositoryImpl;

public class CareerServices {
	private CareerRepositoryImpl impl;

	public CareerServices() {
		this.impl = new CareerRepositoryImpl();
	}

	public void insertCareer(Career career) {
		this.impl.insertCareer(career);
	}
	public void insertStudentToCareer(Career career, Student student) {
		this.impl.insertStudentToCareer(career, student);
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
