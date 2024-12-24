/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_u_m_s;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EN.Sohrab
 */
public class subject_demo {
    
       public void insertion(char operation,String subject,String depart ){
                            //name1,lname2,salary1, pos,ph, address1, gender
        Connection con=MyconnectionDemo.getConnection();
       PreparedStatement ps; 
              
      //insertion for university subjects
        
            if(operation=='i'){//o is for insert
            try{
            ps=con.prepareStatement("insert into subjects(subject,department) values(?,?) ");
          
            //  ps.setInt(8, id);
            ps.setString(1, subject);
             ps.setString(2, depart);
           
           
               if (ps.executeUpdate()>0) {
                   
                   JOptionPane.showMessageDialog(null, "Record inserted Successfully!!");
                   
                
            }else{
   JOptionPane.showMessageDialog(null, "Record not inserted Successfully!!");
 
                   
                   
               } }catch(Exception e){}
            
    }
            
            
            
               if(operation=='u'){//u is for Update
            try{
            ps=con.prepareStatement("update subjects set subject =?,department=? where id=?");
          
         
            ps.setString(1, subject);
            ps.setString(2, depart);
         
           
               if (ps.executeUpdate()>0) {
                   
                   JOptionPane.showMessageDialog(null, "Record Updated Successfully!!");
                   
                
            }else{
   JOptionPane.showMessageDialog(null, "Record not updated Successfully!!");
 
                   
                   
               } }catch(Exception e){}
            
    }
               
               
                   if(operation=='d'){//d for delete
            try{
            ps=con.prepareStatement("delete from subjects where subject=? ");
            
       
        ps.setString(1, subject);
            
           
               if (ps.executeUpdate()>0) {
                   
                   JOptionPane.showMessageDialog(null, "Record Deleted Successfully!!");
                   
                
            }else{
   JOptionPane.showMessageDialog(null, "Record not Delete Successfully!!");
 
                   
                   
               } }catch(Exception e){}
            
    }
       
                   
    
                   
       }
                   
         public void UMS_Subjects(JTable table,String valuesearch){
        
        Connection con=MyconnectionDemo.getConnection();
        PreparedStatement ps;
        
        try {
            ps=con.prepareStatement("select * from subjects where CONCAT('id','subject','department')like ? ");
            ps.setString(1,"%"+valuesearch+"%");
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
       Object [] row;
            while (rs.next()) {                
                
                row=new Object[3];
               // row [0]=rs.getInt(1);
                row [0]=rs.getString(1);
                row [1]=rs.getString(2);
          row [2]=rs.getString(3);
//                row [4]=rs.getString(5);
//                row [5]=rs.getString(6);
//                row [6]=rs.getString(7);
//                row [7]=rs.getString(8);
                model.addRow(row);
                 
            }
            
        } catch (Exception e) {
        }
    }              
        
        
        
    
    
    
    
    
    
    
    
    
    
    
}
