package week1.day4;

public class Singleton {
	private volatile static Singleton _instance;
	private Singleton() {
		
	}
	public static Singleton getInstanceDoubleCheck() {
		if(_instance == null){ //check 1
			synchronized(Singleton.class){ ///check 2
				_instance = new Singleton();
			}
		}
		return _instance;
	}
}
