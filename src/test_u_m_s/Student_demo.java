package test_u_m_s;

import java.rmi.server.Operation;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Student_demo {
    
    public void insertion(char operation,String name1,String lname2,String salary1,String pos ,String ph,String dateEntry,String nationalID,String date_of_birth ,String address1,String gender ){
                            //name1,lname2,salary1, pos,ph, address1, gender
        Connection con=MyconnectionDemo.getConnection();
       PreparedStatement ps; 
        if(operation=='j'){
            try{
            ps=con.prepareStatement("insert into Student1(name,lname,salary,position,phone,db_entery,Email,db_birth,address,gender)values(?,?,?,?,?,?,?,?,?,?) ");
          
            
            ps.setString(1, name1);
             ps.setString(2, lname2);
              ps.setString(3, salary1);
                ps.setString(4, pos);
                  ps.setString(5, ph);
                    ps.setString(6, dateEntry);
                      ps.setString(7, nationalID);
                        ps.setString(8, date_of_birth);
                    ps.setString(9, address1);
               ps.setString(10, gender);
           
               if (ps.executeUpdate()>0) {
                   
                   JOptionPane.showMessageDialog(null, "Record inserted Successfully!!");
                   
                
            }else{
   JOptionPane.showMessageDialog(null, "Record not inserted Successfully!!");
 
                   
                   
               } }catch(Exception e){}
            
    }
        
        
//      if(operation=='u'){//j is for Update
//            try{
     if(operation=='u'){//j is for Update
            try{
           ps=con.prepareStatement("update Student1 set `name`=?,`lname`=?,`salary`=?,`position`=?,`phone`=?,`db_entery`=?,`Email`=?,`db_birth`=?,`address`,?`gender`=?");
          
          ps.setString(1, name1);
             ps.setString(2, lname2);
              ps.setString(3, salary1);
                ps.setString(4, pos);
                  ps.setString(5, ph);
                    ps.setString(6, dateEntry);
                      ps.setString(7, nationalID);
                        ps.setString(8, date_of_birth);
                    ps.setString(9, address1);
               ps.setString(10, gender);
           
               if (ps.executeUpdate()>0) {
                   
                   JOptionPane.showMessageDialog(null, "Record Updated Successfully!!");
                   
                
            }else{
   JOptionPane.showMessageDialog(null, "Record not updated Successfully!!");
 
                   
                   
               } }catch(Exception e){}
            
    }    
        
        
        
      
         if(operation=='d'){//j is for delete
            try{
            ps=con.prepareStatement("delete from student1 where name=? ");
            
             ps.setString(1, name1);
         // ps.setString(2, name1);
            
           
               if (ps.executeUpdate()>0) {
                   
                   JOptionPane.showMessageDialog(null, "Record Deleted Successfully!!");
                   
                
            }else{
   JOptionPane.showMessageDialog(null, "Record not Delete Successfully!!");
 
                   
                   
               } }catch(Exception e){}
            
    }
        
        
        
        
        
        
 
    
}
    public void fillEmployee(JTable table,String valuesearch){
        
        Connection con=MyconnectionDemo.getConnection();
        PreparedStatement ps;
        
        try {
            ps=con.prepareStatement("select * from student_last where CONCAT('id','name','lname','salary','position','phone','address','gender')like ? ");
            ps.setString(1,"%"+valuesearch+"%");
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
       Object [] row;
            while (rs.next()) {                
                
                row=new Object[8];
                row [0]=rs.getInt(1);
                row [1]=rs.getString(2);
                row [2]=rs.getString(3);
                row [3]=rs.getString(4);
                row [4]=rs.getString(5);
                row [5]=rs.getString(6);
                row [6]=rs.getString(7);
                row [7]=rs.getString(8);
                model.addRow(row);
                 
            }
            
        } catch (Exception e) {
        }
    }
    
    
    
    
    
     public void fillStudent(JTable table,String valuesearch){
        
        Connection con=MyconnectionDemo.getConnection();
        PreparedStatement ps;
        
        try {
            ps=con.prepareStatement("select * from student1 where CONCAT('id','name','lname','salary','position','phone','db_entery','Email','db_birth','address','gender')like ? ");
            ps.setString(1,"%"+valuesearch+"%");
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
       Object [] row;
            while (rs.next()) {                
                
                row=new Object[11];
                row [0]=rs.getInt(1);
                row [1]=rs.getString(2);
                row [2]=rs.getString(3);
                row [3]=rs.getString(4);
                row [4]=rs.getString(5);
                row [5]=rs.getString(6);
                row [6]=rs.getString(7);
                row [7]=rs.getString(8);
                 row [8]=rs.getString(9);
                  row [9]=rs.getString(10);
                model.addRow(row);
                 
            }
            
        } catch (Exception e) {
        }
    }
    
}
