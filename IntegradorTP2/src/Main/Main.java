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
		Student s6 = new Student(6,"Paula", "Gimenez", 30, "Female", 32584617,6453, "Tandil");
		StudentServices stuServices = new StudentServices();
		
		//2A) DAR DE ALTA UN ESTUDIANTE
		//stuServices.insertStudent(s1);
		//stuServices.insertStudent(s2);
		//stuServices.insertStudent(s3);
		//stuServices.insertStudent(s4);
		//stuServices.insertStudent(s5);
		//stuServices.insertStudent(s6);
		Career c1 = new Career(1,"Tudai");
		Career c2 = new Career(2,"Sistemas");
		CareerServices carServices = new CareerServices();
		//carServices.insertCareer(c1);
		//carServices.insertCareer(c2);
		
		//2B) MATRICULAR UN ESTUDIANTE EN UNA CARRERA
		//carServices.insertStudentToCareer(c1, s5);
		//carServices.insertStudentToCareer(c2, s4);
		//carServices.insertStudentToCareer(c2, s3);
		
		System.out.println("\n2C) RECUPERAR TODOS LOS ESTUDIANTES Y ESTABLECER UN CRITERIO DE ORDENAMIENTO SIMPLE (LASTNAME ASC)");
		System.out.println(stuServices.getStudentsBySimpleOrdering());
		
		System.out.println("\n2D) RECUPERAR UN ESTUDIANTE POR NÚMERO DE LIBRETA UNIVERSITARIA");
		System.out.println(stuServices.getStudentByNumberOfLibrety(1234));

		System.out.println("\n2E) RECUPERAR TODOS LOS ESTUDIANTES EN BASE A SU GÉNERO");
		System.out.println(stuServices.getStudentsByGenre("Female"));
		
		System.out.println("\n2F) RECUPERAR LAS CARRERAS CON INSCRIPTOS Y ORDENAR POR CANTIDAD DE INSCRIPTOS");
		System.out.println(carServices.getCareersByNumberOfStudents());
				
		System.out.println("\n2G) RECUPERAR LOS ESTUDIANTES DE UNA DETERMINADA CARRERA, FILTRADO POR CIUDAD DE RESIDENCIA");
		System.out.println(stuServices.getStudentsByCareerCity(c2, "Tandil"));
		
		System.out.println("\n3) Generar un reporte de las carreras, que para cada carrera incluya información de los\r\n"
				+ "inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar\r\n"
				+ "los años de manera cronológica.");
		System.out.println("\n3) REPORTE POR CARRERA POR AÑO COMPACTO"); 
		System.out.println(carServices.getReportOfCareers());
		
		System.out.println("\n3) REPORTE POR CARRERA POR AÑO DETALLADO"); 
		carServices.getReportOfCareersDetail();
		


	}

}
