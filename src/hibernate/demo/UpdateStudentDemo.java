
package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        try{
            int studentId=1;
            
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting student with the id "+studentId);
            Student myStudent= session.get(Student.class, studentId);
            System.out.println("Updating Student ");
            
            System.out.println("Done Saving");
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email='hello@tastycorner.com'").executeUpdate();
            session.createQuery("delete from Student where id=1").executeUpdate();
            session.getTransaction().commit();
        }
        finally{factory.close();}
        
        
    }
    
    
    
    
    
    
    
    
}
