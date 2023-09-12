package repositories;

import java.util.List;

import tables.Career;
import tables.Student;

public interface StudentRepository {
	
	public void insertStudent(Student student);
	public List<Student> getStudentsBySimpleOrdering();
	public Student getStudentByNumberOfLibrety(long number);
	public List<Student> getStudentsByGenre(String genre);

}
