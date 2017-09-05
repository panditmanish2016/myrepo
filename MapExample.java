import java.util.*;  
class MapExample{  
 public static void main(String args[]){  
  Map<Integer,String> map=new HashMap<Integer,String>();  
  map.put(100,"Amit");  
  map.put(101,"Vijay");  
  map.put(102,"Rahul");  
  // more elegant way, this should be the standard way, recommend!
  for(Map.Entry m:map.entrySet()){  
   System.out.println(m.getKey()+" "+m.getValue());  
  } 
 
   // weired, but works anyway, not recommend!
		System.out.println("\nExample 3...");
		for (Object key : map.keySet()) {
			System.out.println("Key : " + key.toString() + " Value : " + map.get(key));
		} 
 }  
}  