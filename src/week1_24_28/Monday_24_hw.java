package week1_24_28;

import java.util.Scanner;

public class Monday_24_hw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Scanner scanner = new Scanner( System.in );

		System.out.println("Hello please enter a number");
		int num = scanner.nextInt();
		String sol1 = printSet1(num);
		System.out.println(sol1);
		String sol2 = printSet2(num);
		System.out.println(sol2);
		String sol3 = printSet3(num);
		System.out.println(sol3);
		String sol4 = printSet4(num);
		System.out.println(sol4);
	}
	static String printSet1(int num) {
		String str = "";
		for(int i = 1; i <= num; i ++) {
			for(int j = 0; j < i; j ++) {
				str += "*";
			}
			str += "\n";
		}
		return str;
	}
	static String printSet2(int num) {
		String str = "";
		for(int i= num; i > 0; i --) {
			for(int j = 0; j < i; j ++) {
				str += "*";
			}
			str += "\n";			
		}
		return str;
	}
	static String printSet3(int num) {
		String str= "";
		for(int i = 0; i < num; i ++) {
			for(int j = 0; j < num-i-1;j ++) {
				str+= " "; 
			}
			for(int j = 0 ; j < (i*2)+1; j ++) {
				str += "*";
			}
			str+= "\n";
			
		}
		return str;
	}
	static String printSet4(int num) {
		String str = "";
		for(int i = num; i > 0; i --) {
			for(int j = 0; j < num-i;j ++) {
				str+= " "; 
			}
			for(int j = (i*2)-1 ; j > 0; j--) {
				str += "*";
			}

			str+= "\n";
		}		
		return str;
	}
}
