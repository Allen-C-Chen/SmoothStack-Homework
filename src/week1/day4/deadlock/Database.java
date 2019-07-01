package week1.day4.deadlock;

public class Database {
	synchronized void method1 (Database db) {
		System.out.println("method 1 is running" );
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.method2(this);
		System.out.println("Method 1 is over");
	}
	synchronized void method2 (Database db) {
		System.out.println("method 2 is running" );
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}	
		db.method1(this);
		System.out.println("Method 2 is over");

	}

}
