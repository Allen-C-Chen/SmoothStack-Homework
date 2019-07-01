package week1.day4;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumer {
    LinkedList<Integer> list = new LinkedList<>(); 
    int capacity = 3; 

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ProducerConsumer pc = new ProducerConsumer();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
        t1.start(); 
        t2.start(); 
  
        // t1 finishes before t2 
        t1.join(); 
        t2.join(); 

	}

	public void produce() throws InterruptedException {
		Random rand = new Random();

		int val = 0;
		boolean run = true;
		while(run) {
			synchronized (this) {
				//producer thread doesnt do anything while waiting
				while(list.size() >= capacity) {
					System.out.println("          Producer is waitng");
					Thread.sleep(100);
					wait();
				}
				val = rand.nextInt(50);

				System.out.println("Produce prodced a value " + val);
				list.add(val);
				notify(); //wakes up a single thread that is waiting on this object's monitor
				
				Thread.sleep(1000);
			}
		}
	}
	public void consume() throws InterruptedException {
		boolean run = true;
		while(run) {
			synchronized(this) {
				//consumer waits if there is nothing in the list
				while(list.size() <= 0) {
					System.out.println("          Consumer is waitng");
					Thread.sleep(100);
					wait(); //wakes up a single thread that is waiting on this object's monitor
				}
	            int val = list.removeFirst(); 
	            
	            System.out.println("Consumer consumed- " + val); 

				notify();
				
				Thread.sleep(1000);
			}
		}
	}
}
