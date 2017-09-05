import java.util.*;  
class Book {  
int id;  
String name,author,publisher;  
int quantity;  
public Book(int id, String name, String author, String publisher, int quantity) {  
    this.id = id;  
    this.name = name;  
    this.author = author;  
    this.publisher = publisher;  
    this.quantity = quantity;  
}  
}  
public class BookArrListExample {  
public static void main(String[] args) {  
    //Creating list of Books  
    List<Book> list=new ArrayList<Book>();  
    //Creating Books
    	 Scanner in = new Scanner(System.in);
		 System.out.println("enter book id ");
        String s = in.nextLine();
		int id=Integer.parseInt(s);
        System.out.println("You entered book id  "+id);
		System.out.println("enter book name ");
        String name  = in.nextLine();
		 System.out.println("You entered book name   "+name);
		 System.out.println("enter book author ");
        String authorname  = in.nextLine();
		 System.out.println("You entered book author   "+authorname);
		 System.out.println("enter book publisher ");
        String publishername  = in.nextLine();
		 System.out.println("You entered book publisher   "+publishername);
		 System.out.println("enter book quantity ");
        String s1 = in.nextLine();
		int quantity=Integer.parseInt(s1);
        System.out.println("You entered book quantity  "+quantity);
    Book b1=new Book(id,name,authorname,publishername,quantity);  
    //Adding Books to list  
    list.add(b1);   
    //Traversing list 
	System.out.println("your book details list is here below ");
    for(Book b:list){  
        System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
    } 
}  
}  