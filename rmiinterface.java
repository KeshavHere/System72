package rmidatabase;
import java.rmi.Remote; 
import java.rmi.RemoteException; 
import java.util.*;

// Creating Remote interface for our application 
public interface rmiinterface extends Remote 
{  
   public List<Student> getStudents() throws Exception;  
}