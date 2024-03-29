package week1.day4;

public class DeadLockPractice {
	   public static Object Lock1 = new Object();
	   public static Object Lock2 = new Object();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      Thread1 T1 = new Thread1();
	      Thread2 T2 = new Thread2();
	      T1.start();
	      T2.start();

	}

	static class Thread1 extends Thread{
		public void run() {
	         synchronized (Lock1) {
	             System.out.println("Thread 1: Holding lock 1.");
	             try { Thread.sleep(10); }
	             catch (InterruptedException e) {}
	             System.out.println("Thread 1: Waiting for lock 2.");
	             
	             synchronized (Lock2) {
	                System.out.println("Thread 1: Holding lock 1 & ..");
	             }
	         }
		}
	}
	static class Thread2 extends Thread{
		public void run() {
	         synchronized (Lock2) {
	             System.out.println("Thread 2: Holding lock 2...");
	             try { Thread.sleep(10); }
	             catch (InterruptedException e) {}
	             System.out.println("Thread 1: Waiting for lock 2...");
	             
	             synchronized (Lock1) {
	                System.out.println("Thread 2: Holding lock 1 & 2...");
	             }
	         }
		}
	}
}
