package learning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// define the id
			int studentId = 1;

			// start a transaction
			session.beginTransaction();

			// now get a new session and start transaction
			System.out.println("\nGetting student with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);

			// delete the student
			System.out.println("\nDeleting student: " + myStudent);
			session.delete(myStudent);

			// delete student id=2
			System.out.println("\nDeleting student id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
