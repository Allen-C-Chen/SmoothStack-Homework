package week2.monday.homework;

import java.util.ArrayList;
import java.util.List;

public class basicTest {

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
		List<String> startWithE = new ArrayList<>();
		
		System.out.println(newList);

		int minIndex = 0;
		for(int i = 0; i < newList.size(); i ++) {
			System.out.println("New Set");
			minIndex = i;
			for(int j = i+1; j < newList.size(); j ++) {
				String minString = newList.get(minIndex);
				String tempString = newList.get(j);
				System.out.println("min String: " + minString);
				System.out.println("tempString : " + tempString);
				if(!minString.contains("e") && !tempString.contains("e")) {
					if(minString.compareTo(tempString) > 0) {
						minIndex = j;
						System.out.println(0);
					}				
				}
				//if min contains an e and temp does not
				if(minString.contains("e") && !tempString.contains("e")) {
					//nothing happens
					System.out.println(1);
				}
				//if temp contains the e and min does not
				if(!minString.contains("e") && tempString.contains("e")) {
					minIndex = j;
					System.out.println(2);

				}

				//if both contains an e
				if(minString.contains("e") && tempString.contains("e")) {
					if(minString.compareTo(tempString) > 1) {
						minIndex = j;
						System.out.println(3);

					}
				}

			}
			String tempStr = newList.get(i);
			newList.set(i, newList.get(minIndex));
			newList.set(minIndex, tempStr);
			System.out.println("String " + newList.get(i));
			System.out.println(newList);

		}
		System.out.println(newList);
	}

}
