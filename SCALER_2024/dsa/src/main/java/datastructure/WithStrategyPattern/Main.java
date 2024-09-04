package datastructure.WithStrategyPattern;

public class Main {

	public static void main(String[] args){
		
		SportsVechile v = new SportsVechile(new SpecialDriveStrategy());
		v.drive();
		
		OffRoadVechile v2= new OffRoadVechile();
		v2.drive();
		
		NormalVechile v3=new NormalVechile();
		v3.drive();
		
	}
}
