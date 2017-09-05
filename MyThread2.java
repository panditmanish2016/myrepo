class MyThread2 extends Thread
{
 public void run()
 {
	// to sleep()
 for(int i=1;i<5;i++){  
    try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
    System.out.println(i);
  }
 }

}
class MyThread3 extends Thread
{
 public void run()
 {
	// to sleep()
 for(int i=1;i<5;i++){  
    try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
    System.out.println(i+ "MyThread3 ");
  }
 }

}
class ThreadDemo
{
	public static void main(String []k) throws Exception 
	{    
	    // setpriority
		MyThread2 t1=new MyThread2();
		MyThread3 t2=new MyThread3();
		t1.setPriority(1);
		t1.start();
		t2.setPriority(10);
		t2.start();
		
	}
}