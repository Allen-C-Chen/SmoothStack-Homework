package week1.day4;

import java.util.LinkedList;

public class ProducerConsumer {
    LinkedList<Integer> list = new LinkedList<>(); 
    int capacity = 3; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void produce() throws InterruptedException {
		int val = 0;
		boolean run = true;
		while(run) {
			synchronized (this) {
				//producer thread doesnt do anything while waiting
				while(list.size() == capacity) {
					System.out.println("          Producer is waitng");
					Thread.sleep(100);
					wait();
				}
				System.out.println("Produce prodced a value " + val);
				list.add(val ++);
				notify(); //wakes up a single thread that is waiting on this object's monitor
				//
				Thread.sleep(1000);
			}
		}
	}
	public void consume() throws InterruptedException {
		boolean run = true;
		while(run) {
			synchronized(this) {
				//consumer waits if there is nothing in the list
				while(list.size() == 0) {
					System.out.println("          Consumer is waitng");
					Thread.sleep(100);
					wait(); //wakes up a single thread that is waiting on this object's monitor
				}
	            int val = list.removeFirst(); 
	            
	            System.out.println("Consumer consumed- "
	                                            + val); 

				notify();
				
				Thread.sleep(10000);
			}
		}
	}
}
