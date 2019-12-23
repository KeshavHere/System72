package rmidatabase;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Student implements java.io.Serializable {   
   private int id;   
   private String name;    
  
   public int getId() { 
      return id; 
   } 
   public String getName() { 
      return name; 
   } 
   public void setID(int id) { 
      this.id = id; 
   } 
   public void setName(String name) { 
      this.name = name; 
   } 

}