package week2.monday.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BasicLambdas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> newList = new ArrayList<>();
		newList.add("abcd");
		newList.add("efg");
		newList.add("hijk");
		newList.add("lmnop");
		newList.add("qrs");
		newList.add("tuvw");
		newList.add("xyz");
		newList.add("edd");
		newList.add("aa");
		newList.add("ab");
		List<Integer> newIntList = new ArrayList<>();
		newIntList.add(1);
		newIntList.add(300);
		newIntList.add(5);
		newIntList.add(7);
		newIntList.add(1000);
		newIntList.add(4);

		System.out.println("Part 1");
		System.out.println("\nsort by length");
		sortByLength(newList);
		System.out.println("\nsort by first letter");
		sortByFirstChar(newList);
		System.out.println("\nSort by first E");
		sortByEThenByOrderTwoStreams(newList);
		sortByEthenByOrderManualMethodIn(newList);
		sortByEThenOrderOneStream(newList);
		
		System.out.println("\n\n********************************Part 2");
		System.out.println("Put e infront of even and o infront of odd");
		printListWithEAndO(newIntList);
		System.out.println("\n\n********************************Part 3");
		System.out.println("Filter by if start with a and lenght less then 3");
		printAllStartWithAAndLessThen3(newList);
	}
	


	
	/*
	 *  length (i.e., shortest to longest)
	 *  (Hint: this exact solution was shown in the lecture)
	 *  reverse length (i.e., longest to shortest)
	 */
	public static void sortByLength(List<String> newList) {
	    Comparator<String> compByLength = (aName, bName) -> aName.length() - bName.length();
	    newList.stream().sorted(compByLength).forEach(System.out::println);
	}
	/*
	 * alphabetically by the first character only 
	 * (Hint: charAt(0) returns the numeric code for the first character)
	 */
	public static void sortByFirstChar(List<String> newList) {
		String str = newList.stream()
		.sorted(Comparator.comparingInt(o -> o.charAt(0)))
		.collect(Collectors.joining());
		System.out.println(str);
	}
	/*
	 * Strings that contain “e” first, everything else second. 
	 * For now, put the code directly in the lambda. 
	 * (Hint: remember that the body of a lambda is 
	 * allowed to have curly braces and a return statement.
	 */

	public static void sortByEThenByOrderTwoStreams(List<String> newList) {
		List<String> startWithE = newList.stream()
				.filter(s -> s.startsWith("e")).collect(Collectors.toList());
		List<String> sortedNotE = newList.stream()
				.filter(s -> !s.startsWith("e"))
				.sorted(String::compareTo).collect(Collectors.toList());
		System.out.println(startWithE);
		System.out.println(sortedNotE);
	}
	public static void sortByEthenByOrderManualMethodIn(List<String> newList) {
		List<String> startWithE = newList.stream()
				.sorted( (s1,s2) -> {
					if(s1.startsWith(("e"))) {
						return -1;
					}
					return 1;
				}).collect(Collectors.toList());
		System.out.println(startWithE);
	}
	/*
	 * 
	 * Redo the previous problem, but use a static helper method
	 * so that your lambda looks like this:
	 * Arrays.sort(words, (s1,s2) -> Utils.yourMethod(s1,s2))
	 */
	public static void sortByEThenOrderOneStream(List<String> newList) {
		List<String> startWithE = newList.stream().sorted((s1,s2) -> compare(s1,s2)).collect(Collectors.toList());
		System.out.println(startWithE);
	}
	public static int compare(String s1, String s2) {
		int returnNum = -1;
		if(!s1.contains("e") && !s2.contains("e")) {
			if(s1.compareTo(s2) > 0) {
				//minIndex = j;
				returnNum = 1;
				//System.out.println(0);
			}				
		}

		if(s1.contains("e") && !s2.contains("e")) {
			//nothing happens
			//System.out.println(1);
		}
		//if temp contains the e and min does not
		if(!s1.contains("e") && s2.contains("e")) {
			//minIndex = j;
			returnNum = 1;
			//System.out.println(2);

		}

		//if both contains an e
		if(s1.contains("e") && s2.contains("e")) {
			if(s1.compareTo(s2) > 1) {
				//minIndex = j;
				returnNum = 1;
				//System.out.println(3);

			}
		}
		return returnNum;
	}
	

	
	/*
	 * Using Java 8 features write a method that returns a comma separated string based on a 
	 * given list of integers. 
	 * Each element should be preceded by the letter 'e' 
	 	* if the number is even, and preceded by the letter 'o' 
	 	* if the number is odd. For example, 
 	* if the input list is (3,44), the output should be 'o3,e44'.
	 */
	public static void printListWithEAndO(List<Integer> newList) {
		//List<Integer> intList = newList.stream()
		String result = newList.stream()
		.map(i -> i % 2 == 0 ? "e" + i : "o" + i)
		.collect(Collectors.joining(","));
		System.out.println(result);
	}
	
	/*
	 * Given a list of Strings, 
	 * write a method that returns a list of all strings that start 
	 * with the letter 'a' (lower case) and have exactly 3 letters. 
	 * TIP: Use Java 8 Lambdas and Streams API's.
	 */
	public static void printAllStartWithAAndLessThen3(List<String> newList) {
		List<String> strList = newList.stream()
				.filter(s -> s.length() < 3 && s.startsWith("a"))
				.collect(Collectors.toList());
		System.out.println(strList);
	}
}