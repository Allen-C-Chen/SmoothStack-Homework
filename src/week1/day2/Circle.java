package week1.day2;
public class Circle implements Shape{
	private double radius = 5;


	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return radius * radius * 3.14;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("  *  ");
		System.out.println(" ***  ");
		System.out.println("****** ");
		System.out.println(" ***  ");
		System.out.println("  *  ");
	}
}
