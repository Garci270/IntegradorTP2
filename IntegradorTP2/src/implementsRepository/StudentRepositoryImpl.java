package implementsRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dto.DTOStudent;
import repositories.StudentRepository;
import tables.Student;

public class StudentRepositoryImpl implements StudentRepository {
	
	private EntityManager em;
	
	public StudentRepositoryImpl(EntityManager em) {
		this.em = em;
	}

	//DAR DE ALTA UN ESTUDIANTE
	@Override
	public void insertStudent(Student student) {
		try {
			em.getTransaction().begin();
			if(!em.contains(student)) {
				em.persist(student);
			}else {
				em.merge(student);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//RECUPERAR UN ESTUDIANTE POR NÚMERO DE LIBRETA UNIVERSITARIA
	@Override
	public DTOStudent getStudentByNumberOfLibrety(long number) {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety) FROM Student s WHERE s.numberOfLibrety = ?1";
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

	//RECUPERAR TODOS LOS ESTUDIANTES Y ESTABLECER UN CRITERIO DE ORDENAMIENTO SIMPLE (LASTNAME)
	@Override
	public List<DTOStudent> getStudentsBySimpleOrdering() {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety) FROM Student s ORDER BY s.lastname";
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
			String jpql = "SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety) FROM Student s WHERE s.genre = ?1";
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

}
