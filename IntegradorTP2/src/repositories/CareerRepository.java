package repositories;

import java.util.List;

import tables.Career;
import tables.Student;
import tables.StudentHistory;

public interface CareerRepository {
	
	public void insertCareer(Career career);
	public void insertStudentToCareer(Career career, Student student);
	public List<Career> getCareersByNumberOfStudents();
	public void getReportOfCareers();
	public List<Student> getStudentsByCareerCity(Career car);

}
