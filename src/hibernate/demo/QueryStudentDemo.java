
package hibernate.demo;

import hibernate.demo.entity.Student;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        try{
            
            session.beginTransaction();
            //query Students
            List<Student> theStudents = session.createQuery("from Student").getResultList();
            for(Student tempStudent : theStudents) {
                System.out.println("The Students are"+tempStudent);
            
            }
            System.out.println("\n\n\nThe first names starting with Mostafa are");
            theStudents = session.createQuery("from Student s where s.firstName='Mostafa'").getResultList();
            for(Student tempStudent : theStudents) {
                System.out.println("The Students are"+tempStudent);
            
            }
            System.out.println("\n\n\nThe first names starting with ASmaa  or last name is ahmed is ");
            theStudents = session.createQuery("from Student s where" +" s.firstName='Asmaa' or s.lastName='Ahmed'").getResultList();
            for(Student tempStudent : theStudents) {
                System.out.println("The Students are"+tempStudent);
            
            }
            System.out.println("\n\n\nThe Student with the mail like gmail.com");
            theStudents = session.createQuery("from Student s where " + " s.email LIKE '%tastycorner.com' ").getResultList();
            for(Student tempStudent : theStudents) {
                System.out.println("The Students are"+tempStudent);
            
            }
            
            
            //Display Students
            
            session.getTransaction().commit();  
            System.out.println("Done ");
            
        }
        finally{factory.close();}
        
        
    }
    
    
    
    
    
    
    
    
}
