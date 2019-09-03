
package jdbv;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        
        
        
     String DRIVER ="com.mysql.jdbc.Driver";
     String URL = "jdbc:mysql://localhost/hb_student_tracker";
     String USER = "root";
     String PASSWORD = "root1234";
        try
        {
            Class.forName(DRIVER);
            System.out.println("Connecting to database" + URL);
            Connection myConn = DriverManager.getConnection(URL , USER , PASSWORD);
            System.out.println("Connection Successful");
        
        
        }
        catch (Exception exc){
            exc.printStackTrace();
        
        
        }
        
    }
    
    
    
}
