package datastructure;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//As this is a checked exception then compiler is telling to either throws to JVM or handle
//it here
public class CheckedException {

	
	public static void main(String[] args) throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("myFile.txt"));
	    bw.write("Test");
	    bw.close();
	}
}
