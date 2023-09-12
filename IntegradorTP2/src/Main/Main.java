package Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import implementsRepository.CareerRepositoryImpl;
import implementsRepository.StudentRepositoryImpl;
import tables.Career;
import tables.Student;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Arquitectura");
		EntityManager em = emf.createEntityManager();
		Student s1 = new Student(1,"Agustin", "Garcia", 20, "Male", 43046407,1234, "Bolivar");
		Student s2 = new Student(2,"Manuel", "asd", 18, "Male", 4561236,3215, "Bolivar");
		Student s3 = new Student(3,"Nahuel", "Perez", 22, "Male", 84561235,6548, "Tandil");
		Student s4 = new Student(4,"Juan", "Martinez", 26, "Male", 54215614,3214, "Bragado");
		Student s5 = new Student(5,"Martin", "Gimenez", 20, "Male", 5423156,3156, "Loberia");
		StudentRepositoryImpl stuImpl= new StudentRepositoryImpl(em);
		
		//DAR DE ALTA UN ESTUDIANTE
		//stuImpl.insertStudent(s1);
		//stuImpl.insertStudent(s2);
		//stuImpl.insertStudent(s3);
		//stuImpl.insertStudent(s4);
		//stuImpl.insertStudent(s5);	
		Career c1 = new Career(1,"Tudai");
		Career c2 = new Career(2,"Sistemas");
		CareerRepositoryImpl carImpl = new CareerRepositoryImpl(em);
		//carImpl.insertCareer(c1);
		//carImpl.insertCareer(c2);
		
		//MATRICULAR UN ESTUDIANTE EN UNA CARRERA
		//carImpl.insertStudentToCareer(c1, s5);
		//carImpl.insertStudentToCareer(c2, s4);
		
		System.out.println("RECUPERAR TODOS LOS ESTUDIANTES Y ESTABLECER UN CRITERIO DE ORDENAMIENTO SIMPLE (LASTNAME ASC)");
		System.out.println(stuImpl.getStudentsBySimpleOrdering());
		
		System.out.println("RECUPERAR UN ESTUDIANTE POR NÚMERO DE LIBRETA UNIVERSITARIA");
		System.out.println(stuImpl.getStudentByNumberOfLibrety(1234));

		System.out.println("RECUPERAR TODOS LOS ESTUDIANTES EN BASE A SU GÉNERO");
		System.out.println(stuImpl.getStudentsByGenre("Male"));
		
		System.out.println("RECUPERAR LAS CARRERAS CON INSCRIPTOS Y ORDENAR POR CANTIDAD DE INSCRIPTOS");
		System.out.println(carImpl.getCareersByNumberOfStudents());
		
		System.out.println("RECUPERAR ESTUDIANTES BY CARRERA");
		carImpl.getReportOfCareers();
		
		System.out.println("RECUPERAR ESTUDIANTES POR CIUDAD SEGÚN CARRERA");
		carImpl.getStudentsByCareerCity(c2);
		
		
		em.close();
		emf.close();

	}

}
