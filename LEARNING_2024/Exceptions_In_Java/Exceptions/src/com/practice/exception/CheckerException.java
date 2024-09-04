

package com.practice.exception;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*1) As this is a checked exception main function will not throw it to JVM
 * and if we don't throws it to JVM or handle it here then compiler will
   show error.*/
public class CheckerException {
	
  public static void main(String[] args) throws IOException    {
	   BufferedWriter bw = new BufferedWriter(new FileWriter("myFile.txt"));
	    bw.write("Test");
	    bw.close();
  }
}
