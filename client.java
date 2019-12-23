package rmidatabase;
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.util.*;  

public class client {  
   private client() {}  
   public static void main(String[] args)throws Exception {  
      try { 
         // Getting the registry 
         Registry registry = LocateRegistry.getRegistry("localhost",1998); 
    
         // Looking up the registry for the remote object 
         rmiinterface stub = (rmiinterface) registry.lookup("Hello"); 
    
        // Calling the remote method using the obtained object 
         List<Student> list = (List)stub.getStudents(); 
         for (Student s:list) 
         { 
            
            // System.out.println("bc "+s.getBranch()); 
            System.out.println("ID: " + s.getId()); 
            System.out.println("name: " + s.getName());  
         }  
      // System.out.println(list); 
      } catch (Exception e) { 
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}