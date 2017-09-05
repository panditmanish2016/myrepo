class MyThread3 extends Thread
{
 public void run()
 {
	if(Thread.currentThread().isDaemon()){//checking for daemon thread  
   System.out.println("daemon thread work");  
  }
  else{  
  System.out.println("user thread work");  
 }  
  
 }

}
class ThreadDemo
{
	public static void main(String []k) throws Exception 
	{
		// to set daemon thread
		MyThread3 t1=new MyThread3();
		t1.setDaemon(true);
		t1.start();
		System.out.println(t1.isDaemon());
		
	}
}