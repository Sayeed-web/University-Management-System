package test_u_m_s;


import java.sql.*;



public class MyFunction {
    
    public static int countData(String tabelName){
    
    int total=0;
    Connection con=MyconnectionDemo.getConnection();
    Statement st;
    
        try {
            st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT COUNT(*) AS 'total' FROM"+tabelName);
            while (rs.next()) {                
                 
                total=rs.getInt(1);
                
                
            }
            
            
            
        } catch (Exception e) {
        }
    
    
        return total;
    
    
}}
