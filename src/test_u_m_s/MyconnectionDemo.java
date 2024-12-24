package test_u_m_s;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class MyconnectionDemo {
    static Connection getConnection(){
    
        Connection con=null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/U_M_S","root","");
            
                    
            
            
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
}
}