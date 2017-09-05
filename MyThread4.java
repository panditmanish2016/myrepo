class MyThread4 extends Thread
{
 public void run()   
 {                  		
  try  
  {
   for(int i=0; i<7; i++)   
   {
     Thread.sleep(500);
     System.out.println( this.getName() + ":  " + i );
   }
  }
  catch(InterruptedException e)   
  { 
    e.printStackTrace();  
  }
		
	}

}
class ThreadDemo
{
	public static void main(String []k) throws Exception 
	{
		// 	resume suspend
   MyThread4 srd1 = new MyThread4();   
   MyThread4 srd2 = new MyThread4();   
   srd1.setName("First");
   srd2.setName("Second");
   srd1.start();      
   srd2.start();
   try   
   {
     Thread.sleep( 1000 );
     srd1.suspend();
     System.out.println("Suspending thread First");
     Thread.sleep( 1000 );
     srd1.resume();
     System.out.println("Resuming thread First");
 
     Thread.sleep(1000);
     srd2.suspend();
     System.out.println("Suspending thread Second");
     Thread.sleep(1000);
     srd2.resume();
     System.out.println("Resuming thread Second");
   }
   catch(InterruptedException e)   
   {  
     e.printStackTrace();   
   }
 }
 
}