/**
 * Objective: Create classes that will write a line of information and display the date and time
 * Algorithm: Create two classes, one that will write the data needed and the other to test and display the data written using IO
 * Input and Output: The user will create the file object that they want to write and the program will write and read the info and dispaly the date and time
 * Created by: Gavin Scott
 * Date: 04/17/22
 * Version: JDK 16.0.2
 */

import java.io.*;
public class TestObjectInputStream {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.dat"));
		
		String name = input.readUTF();
		double score = input.readDouble();
		java.util.Date date = (java.util.Date) (input.readObject());
		
		System.out.println(name + " " + score +" " + date);
	}
	
}
