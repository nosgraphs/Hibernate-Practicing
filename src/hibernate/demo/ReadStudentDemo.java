
package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        try{
            System.out.println("Creating a new user");
            Student tempStudent = new Student("Ahmed","Salah","asalah@tastycorner.com");
            session.beginTransaction();
            System.out.println("Saving");
            System.out.println(tempStudent);
            session.save(tempStudent);
            session.getTransaction().commit();  
            System.out.println("SAved student .genereated id "+tempStudent.getId());
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting student with the id "+tempStudent.getId());
            Student myStudent= session.get(Student.class, tempStudent.getId());
            System.out.println("Completed"+myStudent);
            session.getTransaction().commit();
            
            System.out.println("Done Saving");
            
        }
        finally{factory.close();}
        
        
    }
    
    
    
    
    
    
    
    
}
