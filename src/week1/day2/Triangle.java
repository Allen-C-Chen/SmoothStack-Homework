package week1.day2;

public class Triangle implements Shape{

	private int base = 5;
	private int height = 5;

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return base * height /2;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("*");
		System.out.println("**");
		System.out.println("****");
		System.out.println("*****");		
	}

}
