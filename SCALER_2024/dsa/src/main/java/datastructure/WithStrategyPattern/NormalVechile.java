package datastructure.WithStrategyPattern;

public class NormalVechile extends Vechile {

	NormalVechile(){
		super(new NormalDriveStrategy());
	}
}
