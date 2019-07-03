package week2.monday.homework;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class BasicDateTime {
	public static void main(String[] args) {
		storeBirthday();
	}
/*
 * Date-Time API
 * Which class would you use to store your birthday in years, months,
 	* days, seconds, and nanoseconds?
 	* answer:
 		LocalDateTime class
 		to take a particular time zone, use ZonedDateTime
*/
	public static void storeBirthday() {
        LocalDateTime birthDate = LocalDateTime.of(1994, Month.SEPTEMBER, 27, 0, 0, 0);
        System.out.println(birthDate);
        System.out.println("Thursday before each month " );
        dateOfPreviousThursday(birthDate);
        System.out.println("\nprint length of each month " );
    	printLengthOfEachMonth(2019);
    	System.out.println("\nFind all Mondays given a month " );
    	findAllMondaysGivenMonth("JULY");
    	System.out.println("\nFriday 13th Checker");
    	friday13thChecker(1,"JULY",2019);
    	friday13thChecker(13,"SEPTEMBER",2019);

	}
/*
 * Given a random date, how would you find the date of the previous Thursday?
 * What is the difference between a ZoneId and a ZoneOffset?
 * How would you vert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an Instant?
*/
	public static void dateOfPreviousThursday(LocalDateTime date) {
		System.out.println("Current Date " + date);
		TemporalAdjuster temp = date;
		System.out.printf("The previous Thursday is: %s%n",
		          date.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)));
		//TemporalAdjuster.previous returns the previous day of week adjuster 
	}
/* 
 * Write an example that, for a given year, 
 	* reports the length of each month within that year.
*/
	public static void printLengthOfEachMonth(int year) {
		System.out.println("For year " + year  + " the length of each month is :" );
		//Month is an enum representing the 12 months of the year
		for(Month month :Month.values()) { //Returns an array containing the constants of this enum type, 
			//in the order they are declared.
			
			//A year-month in the ISO-8601 calendar system, such as 2007-12.
            YearMonth months = YearMonth.of(year, month);
            System.out.println(month+ ": " + months.lengthOfMonth());
            //of(int year, Month month)
            //Obtains an instance of YearMonth from a year and month.

		}
	}
	
/* * Write an example that, for a given month of the current year, 
 	* lists all of the Mondays in that month.
*/
	public static void findAllMondaysGivenMonth(String newMonth) {
		Month month = Month.valueOf(newMonth);
		
        LocalDate localYear = Year.now().atMonth(month).atDay(1)
        		.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        
        Month requestedMonth = localYear.getMonth();
        while(requestedMonth == month) {
        	System.out.println(localYear);
        	localYear = localYear.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        	requestedMonth = localYear.getMonth();
        }
        
	}
/*
 * Write an example that tests whether a given date 
 	* occurs on Friday the 13th.
 */
	public static void friday13thChecker(int day, String newMonth, int year) {
		Month month = Month.valueOf(newMonth);
		LocalDate date = Year.of(year).atMonth(month).atDay(day);
		boolean isFriday13th =  date.get(ChronoField.DAY_OF_WEEK) == 5;
		System.out.println(isFriday13th);

	}
}
