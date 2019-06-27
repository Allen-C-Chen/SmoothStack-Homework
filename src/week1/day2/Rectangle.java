package week1.day2;

public class Rectangle implements Shape{
	private int base = 5;
	private int height = 5;
	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return base * height;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");		
	}

}
