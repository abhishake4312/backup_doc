package WithStrategyPattern;

public class OffRoadVechile extends Vechile{
	
	OffRoadVechile(){
		super(new SpecialDriveStrategy());
	}

}
