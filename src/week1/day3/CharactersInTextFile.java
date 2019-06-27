package week1.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Write an example that counts the number of times a 
 * particular character, such as e, appears in a file. 
 * The character can be specified at the command line
 * @author drago
 *
 */
public class CharactersInTextFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch = 'i';
		System.out.println(countCharInTextFile(ch,"text.txt"));
	}
	static int countCharInTextFile(char ch, String path) {
		int count = 0;
	    File file = new File(path);
	    try {
			BufferedReader reader = new BufferedReader(
				    new InputStreamReader(
				        new FileInputStream(file),
				        Charset.forName("UTF-8")));
			int c;
			while(( c = reader.read()) != -1) {
				char character = (char) c;
				if(character == ch) {
					count++;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		return count;
	}
}
