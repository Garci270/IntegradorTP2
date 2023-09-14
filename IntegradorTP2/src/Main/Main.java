package Main;

import entity.Career;
import entity.Student;
import services.CareerServices;
import services.StudentServices;

public class Main {

	public static void main(String[] args) {
		
		Student s1 = new Student(1,"Agustin", "Garcia", 20, "Male", 43046407,1234, "Bolivar");
		Student s2 = new Student(2,"Manuel", "asd", 18, "Male", 4561236,3215, "Bolivar");
		Student s3 = new Student(3,"Nahuel", "Perez", 22, "Male", 84561235,6548, "Tandil");
		Student s4 = new Student(4,"Juan", "Martinez", 26, "Male", 54215614,3214, "Bragado");
		Student s5 = new Student(5,"Martin", "Gimenez", 20, "Male", 5423156,3156, "Loberia");
		StudentServices stuServices = new StudentServices();
		
		//DAR DE ALTA UN ESTUDIANTE
		//stuServices.insertStudent(s1);
		//stuServices.insertStudent(s2);
		//stuServices.insertStudent(s3);
		//stuServices.insertStudent(s4);
		//stuServices.insertStudent(s5);	
		Career c1 = new Career(1,"Tudai");
		Career c2 = new Career(2,"Sistemas");
		CareerServices carServices = new CareerServices();
		//carServices.insertCareer(c1);
		//carServices.insertCareer(c2);
		
		//MATRICULAR UN ESTUDIANTE EN UNA CARRERA
		//carServices.insertStudentToCareer(c1, s5);
		//carServices.insertStudentToCareer(c2, s4);
		//carServices.insertStudentToCareer(c2, s3);
		
		System.out.println("\nRECUPERAR TODOS LOS ESTUDIANTES Y ESTABLECER UN CRITERIO DE ORDENAMIENTO SIMPLE (LASTNAME ASC)");
		System.out.println(stuServices.getStudentsBySimpleOrdering());
		
		System.out.println("\nRECUPERAR UN ESTUDIANTE POR NÚMERO DE LIBRETA UNIVERSITARIA");
		System.out.println(stuServices.getStudentByNumberOfLibrety(1234));

		System.out.println("\nRECUPERAR TODOS LOS ESTUDIANTES EN BASE A SU GÉNERO");
		System.out.println(stuServices.getStudentsByGenre("Male"));
		
		System.out.println("\nRECUPERAR LAS CARRERAS CON INSCRIPTOS Y ORDENAR POR CANTIDAD DE INSCRIPTOS");
		System.out.println(carServices.getCareersByNumberOfStudents());
		
		System.out.println("\nRECUPERAR ESTUDIANTES BY CARRERA");
		carServices.getReportOfCareers();
		
		System.out.println("\nRECUPERAR ESTUDIANTES POR CIUDAD SEGÚN CARRERA");
		stuServices.getStudentsByCareerCity(c2, "Tandil");
		


	}

}
