import java.util.*;  
class ArrayListTest{  
 public static void main(String args[]){  
  ArrayList<String> list=new ArrayList<String>();//Creating arraylist using generic way  
  list.add("Ravi");//Adding object in arraylist  add();
  list.add("Vijay");  
  list.add("Ravi");  
  list.add("Ajay");  
  //Traversing list through Iterator  
  /*Iterator itr=list.iterator();  
  while(itr.hasNext()){  
   System.out.println(itr.next());  
  } */ 
  for(String x:list) // for each loop
  {
	  System.out.println(x); 
  }
 }  
}  