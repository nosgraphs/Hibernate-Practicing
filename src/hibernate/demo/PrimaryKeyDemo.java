
package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        
        
        
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        try{
            System.out.println("Creating a new user");
            Student tempStudent1 = new Student("Mohamed","Shaaban","snbfdsn@tastcorner.com");
            Student tempStudent2 = new Student("Eman","Shaaban","tastyc';dsdorner@tastycorner.com");
            Student tempStudent3 = new Student("Mostafa","Shaaban","dhjsaldhasl@tastycorner.com");
            session.beginTransaction();
            System.out.println("Saving");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            session.getTransaction().commit();  
            System.out.println("Done Saving");
            
        }
        finally{
        factory.close();
                }
        
    }
    
}
