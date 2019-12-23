package rmidatabase;
import java.sql.*; 
import java.util.*;  
import java.util.logging.Level;
import java.util.logging.Logger;

// Implementing the remote interface 
public class rmiimpl implements rmiinterface 
{
   // Implementing the interface method 
   public List<Student> getStudents() throws Exception 
   {  
      List<Student> list = new ArrayList<Student>();   
      Connection con = null;
      Statement stmt=null;
      //String connectionURL = "jdbc:derby://localhost/C:/Users/Aashee/AppData/Roaming/NetBeans/Derby/student";
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      String connectionURL = "jdbc:derby://localhost:1527/student";
    
      con = DriverManager.getConnection(connectionURL, "root", "root");
            //Find the selected item
      stmt = con.createStatement();  
      String sql = "SELECT * FROM STUDENT"; 
      ResultSet rs = stmt.executeQuery(sql);  
      
      //Extract data from result set 
      while(rs.next()) 
      { 
         // Retrieve by column name 
         int id  = rs.getInt("ID"); 
         
         String name = rs.getString("NAME"); 
         // Setting the values 
         Student student = new Student(); 
         student.setID(id); 
         student.setName(name);
         list.add(student); 
      } 
      rs.close(); 
      return list;     
   }
//    public static void main(String[] args) {
//        rmiimpl rmi = new rmiimpl();
//       try {
//           System.out.println(rmi.getStudents());
//       } catch (Exception ex) {
//           Logger.getLogger(rmiimpl.class.getName()).log(Level.SEVERE, null, ex);
//       }
//    }
}