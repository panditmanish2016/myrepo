class MyThread extends Thread
{
 public void run()
 {
	// to sleep()
 for(int i=1;i<5;i++){  
    try{
	 Thread.sleep(500);
	}catch(InterruptedException e)
	{
		System.out.println(e);
	}  
    System.out.println(i+ " second ");
  }
 }

}
class ThreadDemo
{
	public static void main(String []k) throws Exception 
	{
		MyThread t=new MyThread();
		 t.start();
		 for(int i=1;i<5;i++){  
		  System.out.println(i);
		 }
	}
}