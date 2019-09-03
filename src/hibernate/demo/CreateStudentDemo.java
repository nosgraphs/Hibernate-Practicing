
package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        try{
            System.out.println("Creating a new user");
            Student tempStudent = new Student("Mo'men","Ahmed","tastycorner@gfndm.com");
            session.beginTransaction();
            System.out.println("Saving");
            session.save(tempStudent);
            session.getTransaction().commit();  
            System.out.println("Done Saving");
            
        }
        finally{factory.close();}
        
        
    }
    
    
    
    
    
    
    
    
}
