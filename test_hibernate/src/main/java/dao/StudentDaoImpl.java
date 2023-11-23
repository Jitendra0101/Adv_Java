package dao;

import static utils.HibernateUtils.getSf;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String registerStudent(Student student) {
		// TODO Auto-generated method stub
		// 1. open session from SF
				Session session = getSf().openSession();
				// 2. begin a tx
				Transaction tx = session.beginTransaction();
				try {
					session.save(student);
					// success : commit
					tx.commit();
				} catch (RuntimeException e) {
					// rollback tx n re throw the exc to the caller
					if(tx != null)
						tx.rollback();
					throw e;			
				} finally {
					if (session != null)
						session.close();			
				}
				return "User registered with ID "+student.getId();
			}
	}
	
