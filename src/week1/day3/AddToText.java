package week1.day3;

/**
 * Write a Java program to append text to an existing file
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddToText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "hi john";
		String path = "text.txt";
		appendText(path,data);
	}
	public static void appendText(String path, String data) {
        try {
            File f1 = new File(path);

            FileWriter fileWritter = new FileWriter(f1.getName(),true); //creates a FileWriter object given a File object with a 
            															//boolean indicating whether or not to append the data written.
            //https://www.tutorialspoint.com/java/java_filewriter_class.htm more info
            BufferedWriter bw = new BufferedWriter(fileWritter); // Instantiate the BufferedWriter clas
            bw.write(data); //Writes a portion of a String.
			bw.close(); //Closes the stream, flushing it first.
			//more info https://docs.oracle.com/javase/7/docs/api/java/io/BufferedWriter.html
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("your file has been appended");
	}
}
