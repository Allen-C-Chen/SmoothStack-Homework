package week1.day3;

import java.io.File;
/*
 * Write a Java program to get a list of 
 * all file/directory names under a given directory
 */
public class ListDirectories {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\drago\\Dropbox";
		System.out.println(path);
	}
	public static String printList(String path) {
		String str = "";
        File folder = new File(path);
        
        File[] files = folder.listFiles();
 
        for (File file : files)
        {
            str += file.getName();
        }
		return str;
	}
}
