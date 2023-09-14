package repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dto.DTOStudent;
import entity.Career;
import entity.Student;

public class StudentRepositoryImpl implements StudentRepository {

	private EntityManager em;

	public StudentRepositoryImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Arquitectura");
		this.em = emf.createEntityManager();
	}

	// DAR DE ALTA UN ESTUDIANTE
	@Override
	public void insertStudent(Student student) {
		try {
			em.getTransaction().begin();
			if (!em.contains(student)) {
				em.persist(student);
			} else {
				em.merge(student);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// RECUPERAR UN ESTUDIANTE POR NÚMERO DE LIBRETA UNIVERSITARIA
	@Override
	public DTOStudent getStudentByNumberOfLibrety(long number) {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity) FROM Student s WHERE s.numberOfLibrety = ?1";
			TypedQuery<DTOStudent> query = em.createQuery(jpql, DTOStudent.class);
			query.setParameter(1, number);
			DTOStudent stu = query.getSingleResult();
			em.getTransaction().commit();
			return stu;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// RECUPERAR TODOS LOS ESTUDIANTES Y ESTABLECER UN CRITERIO DE ORDENAMIENTO
	// SIMPLE (LASTNAME)
	@Override
	public List<DTOStudent> getStudentsBySimpleOrdering() {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity) FROM Student s ORDER BY s.lastname";
			TypedQuery<DTOStudent> query = em.createQuery(jpql, DTOStudent.class);
			List<DTOStudent> stus = query.getResultList();
			em.getTransaction().commit();
			return stus;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<DTOStudent> getStudentsByGenre(String genre) {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity) FROM Student s WHERE s.genre = ?1";
			TypedQuery<DTOStudent> query = em.createQuery(jpql, DTOStudent.class);
			query.setParameter(1, genre);
			List<DTOStudent> stus = query.getResultList();
			em.getTransaction().commit();
			return stus;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	//RECUPERAR LOS ESTUDIANTES DE UNA DETERMINADA CARRERA, FILTRADO POR CIUDAD DE RESIDENCIA
	@Override
	public List<DTOStudent> getStudentsByCareerCity(Career car, String city) {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity) FROM Student s JOIN s.careers c WHERE c.career = ?1 AND s.residenceCity=?2";
			TypedQuery<DTOStudent> query = em.createQuery(jpql, DTOStudent.class);
			query.setParameter(1, car);
			query.setParameter(2, city);
			List<DTOStudent> stus = query.getResultList();
			em.getTransaction().commit();
			System.out.println("Career: "+car.getName()+", City: "+city);
			return stus;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
