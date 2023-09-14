package repositories;

import java.util.List;

import dto.DTOStudent;
import entity.Career;
import entity.Student;

public interface StudentRepository {
	
	public void insertStudent(Student student);
	public List<DTOStudent> getStudentsBySimpleOrdering();
	public DTOStudent getStudentByNumberOfLibrety(long number);
	public List<DTOStudent> getStudentsByGenre(String genre);
	public List<DTOStudent> getStudentsByCareerCity(Career car, String city);

}
