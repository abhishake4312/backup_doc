package WithStrategyPattern;

public class Vechile {

	DriveStrategy driveStrategy;
	
	Vechile(DriveStrategy d){
		this.driveStrategy=d;
	}
	
	void drive(){
		driveStrategy.drive();
	}
}
