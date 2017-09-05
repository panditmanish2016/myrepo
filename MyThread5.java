
class MyThread5 extends Thread
{
 public void run()
 {
	// to sleep()
 for(int i=1;i<5;i++){  
    try{
	 Thread.sleep(500);
	}catch(InterruptedException e)
	{
		System.out.println("thread Interrupted");
	}  
    System.out.println(i+ " threadONE ");
  }
 }
}
class ThreadDemo
{
	public static void main(String []k) throws Exception 
	{
		MyThread th1=new MyThread();
		 th1.start();
		 for(int i=1;i<5;i++){  
    try{
	 Thread.sleep(500);
	}catch(InterruptedException e)
	{
		System.out.println("thread Interrupted");
	}  
    System.out.println(i+ " threadONE ");
	if(i==3)
	{
		th1.stop();
	}
 
	}
	System.out.println("EXITING threaMain ");
}
}