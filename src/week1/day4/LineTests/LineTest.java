package week1.day4.LineTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LineTest {

	@Test
	public void basicTest1ParallelTo() {
		Line newLine = new Line(0,0,1,1);
		Line newLine2 = new Line(2,2,3,3);
		assertTrue(newLine.parallelTo(newLine2));
	}	

	@Test
	public void basicTest2ParallelTo() {
		Line newLine = new Line(1,2,3,4);
		Line newLine2 = new Line(4,3,2,1);
		assertTrue(newLine.parallelTo(newLine2));
	}	
	@Test
	public void basicTest3ParallelTo() {
		Line newLine = new Line(1,1,2,2);
		Line newLine2 = new Line(4,4,3,3);
		assertTrue(newLine.parallelTo(newLine2));
	}
	@Test
	public void basicTest1GetDistance() {
		Line newLine = new Line(0,0,0,0);
		assertEquals(newLine.getDistance(),0);

	}	
	
	@Test
	public void basicTest2GetDistance() {
		Line newLine = new Line(1,2,3,4);
		assertEquals(newLine.getDistance(),2.8284271247461903);

	}	
	
	
	@Test
	public void basicTest3GetDistance() {
		Line newLine = new Line(2,3,5,0);
		assertEquals(newLine.getDistance(),4.242640687119285);

	}	
	
	@Test
	public void basicTest1GetSlope() {
		Line newLine = new Line(5,8,9,0);
		assertEquals(newLine.getSlope(),-2);

	}
	@Test
	public void basicTest2GetSlope() {
		Line newLine = new Line(2,3,5,0);
		assertEquals(newLine.getSlope(),-1);

	}
	@Test
	public void basicTest3GetSlope() {
		Line newLine = new Line(1,2,3,4);
		assertEquals(newLine.getSlope(),1);

	}
	@Test
	public void throwArithmeticException() {
		assertThrows(ArithmeticException.class, () -> {
			Line newLine = new Line(0,0,0,0);
			newLine.getSlope();
		});
	}
}
