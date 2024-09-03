package datastructure.math.gcd;

public class MaxInJava {

	public static void main(String[] args){
		// MAXIMUM int value in java is 2147483647
		
		int max= 2147483647;
		
		int lessmaxby1= 2147483646;
		int lessmaxby2= 2147483645;
		
		
		System.out.println("Printing 2nd last and 3rd last value");
		// Runs for 2 time
		for(int i=lessmaxby2;i<=lessmaxby1;i++){
		   System.out.println(i);
		}
		
		
		System.out.println("Printing last and 2nd last value");
		// Running in infinite loop
		for(long i= lessmaxby1;i<=max;i++){
			System.out.println(i);
		}
		
	}
}
