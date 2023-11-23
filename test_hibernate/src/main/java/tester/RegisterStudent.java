package tester;

import java.util.Scanner;

import dao.StudentDao;
import dao.StudentDaoImpl;
import pojos.Student;

public class RegisterStudent {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			//
			System.out.println("Enter user details :id, name, standard(class)");
			// create dao instance n call method
			StudentDao dao = new StudentDaoImpl();
			Student student = new Student(sc.nextInt(), sc.next(),sc.nextInt());
			System.out.println(dao.registerStudent(student));
		} // JVM : sf.close() ---> DBCP(db conn pool) clenedd up!
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
