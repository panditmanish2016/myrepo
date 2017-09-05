class MyThread1 extends Thread
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
class ThreadDemo
{
	public static void main(String []k) throws Exception 
	{  
	   // join ()
		MyThread1 t1=new MyThread1();
		MyThread1 t2=new MyThread1();
		MyThread1 t3=new MyThread1();
		t1.start();
		try{
			t1.join();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		t2.start();
		t3.start();
	}
}