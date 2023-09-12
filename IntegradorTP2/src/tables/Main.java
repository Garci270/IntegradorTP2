package tables;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import implementsRepository.CareerRepositoryImpl;
import implementsRepository.StudentRepositoryImpl;

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
		stuImpl.insertStudent(s5);	
		Career c1 = new Career(1,"Tudai");
		Career c2 = new Career(2,"Sistemas");
		CareerRepositoryImpl carImpl = new CareerRepositoryImpl(em);
		carImpl.insertCareer(c2);
		carImpl.insertStudentToCareer(c1, s5);
		carImpl.getReportOfCareers();
		System.out.println(stuImpl.getStudentsBySimpleOrdering());
		em.close();
		emf.close();

	}

}
