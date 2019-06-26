package week1_24_28;

import java.util.Random;

public class Tuesday_25_hw {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = sumOfArgs(args);
		System.out.println("Sum: " + sum);
		
		int[][] arr = genRandomArray();
		System.out.println(findMaxNumberAndPosIn2DArray(arr));
		
		Circle newCircle = new Circle();
		newCircle.calculateArea();
		newCircle.display();
		Triangle newTriangle = new Triangle();
		
		newTriangle.calculateArea();
		newTriangle.display();
		Rectangle newRectangle = new Rectangle();
		newRectangle.calculateArea();
		newRectangle.display();
		
		
	}
	public static int sumOfArgs(String[] args) {
		int sum = 0;
		for(int i = 0; i < args.length; i ++) {
			sum += Integer.parseInt(args[i]);
		}
		return sum;
	}
	public static int[][] genRandomArray() {
		int[][] arr = new int [20][25];
        Random rand = new Random(); 
        int int1;
        for(int i = 0; i < 20; i ++){        
        	for(int j = 0; j < 25; j ++) {
                int1 = rand.nextInt(1000)-20; 
                arr[i][j] = int1;
        	}
        }
        return arr;
	}
	public static String findMaxNumberAndPosIn2DArray(int[][] arr) {
		int max = 0;
		int maxRowPos = 0;
		int maxColPos = 0;
		for(int row = 0; row < arr.length; row ++) {
			for(int col = 0; col < arr[0].length; col ++) {
				if(arr[row][col] > max) {
					max = arr[row][col];
					maxRowPos= row;
					maxColPos= col;

				}
			}
		}
		return "Max Number: " + max + "\nRow Position: " + maxRowPos + "\nCol Position: " + maxColPos + "\n";
	}
}


interface Shape{
    void calculateArea();
    void display();
}
class Circle implements Shape{
	private double radius = 5;

	@Override
	public void calculateArea() {
		System.out.println(radius * radius * 3.14);
	}
	@Override
	public void display() {
		System.out.println("  *  ");
		System.out.println(" ***  ");
		System.out.println("****** ");
		System.out.println(" ***  ");
		System.out.println("  *  ");
	}
}
class Triangle implements Shape{
	private int base = 5;
	private int height = 5;
	@Override
	public void calculateArea() {
		System.out.println(base * height /2);
	}
	@Override
	public void display() {
		System.out.println("*");
		System.out.println("**");
		System.out.println("****");
		System.out.println("*****");

	}
}
class Rectangle implements Shape{
	private int base = 5;
	private int height = 5;

	@Override
	public void calculateArea() {
		System.out.println(base * height );

	}
	@Override
	public void display() {
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");

	}
}
