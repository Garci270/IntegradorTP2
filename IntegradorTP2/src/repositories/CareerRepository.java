package repositories;

import java.util.List;

import dto.DTOCareerByStudents;
import dto.DTOStudent;
import entity.Career;
import entity.Student;

public interface CareerRepository {
	
	public void insertCareer(Career career);
	public void insertStudentToCareer(Career career, Student student);
	public List<DTOCareerByStudents> getCareersByNumberOfStudents();
	public void getReportOfCareers();
	public List<DTOStudent> getStudentsByCareerCity(Career car);

}
