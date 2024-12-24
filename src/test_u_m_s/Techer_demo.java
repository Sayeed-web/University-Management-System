package test_u_m_s;

import java.rmi.server.Operation;
import java.sql.*;
import javax.swing.JOptionPane;
public class Techer_demo {
    
    public void insertion(char operation,String name1,String lname2,String salary1,String pos ,String ph ,String address1,String gender ){
                            //name1,lname2,salary1, pos,ph, address1, gender
        Connection con=MyconnectionDemo.getConnection();
       PreparedStatement ps; 
        if(operation=='j'){
            try{
            ps=con.prepareStatement("insert into student_last(name,lname,salary,position,phone,address,gender)values(?,?,?,?,?,?,?) ");
          
            
            ps.setString(1, name1);
             ps.setString(2, lname2);
              ps.setString(3, salary1);
                ps.setString(4, pos);
                  ps.setString(5, ph);
                    ps.setString(6, address1);
               ps.setString(7, gender);
           
               if (ps.executeUpdate()>0) {
                   
                   JOptionPane.showMessageDialog(null, "Record inserted Successfully!!");
                   
                
            }else{
   JOptionPane.showMessageDialog(null, "Record not inserted Successfully!!");
 
                   
                   
               } }catch(Exception e){}
            
    }
 
    
}
}
