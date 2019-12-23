package rmidatabase;

import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 

public class server extends rmiimpl { 
   public server() {} 
   public static void main(String args[]) 
   { 
      try 
      { 
         // Instantiating the implementation class 
         rmiimpl obj = new rmiimpl(); 
    
//         // Exporting the object of implementation class (
//           // here we are exporting the remote object to the stub) 
         rmiinterface stub = (rmiinterface) UnicastRemoteObject.exportObject(obj, 0);  
//         
//         // Binding the remote object (stub) in the registry 
//         Registry registry = LocateRegistry.getRegistry(); 
//         
//         registry.bind("Hello", stub);  
         
            Registry reg = LocateRegistry.createRegistry(1998);
            reg.rebind("Hello", stub);
            System.err.println("Server ready");
      } 
      catch (Exception e) 
      { 
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}