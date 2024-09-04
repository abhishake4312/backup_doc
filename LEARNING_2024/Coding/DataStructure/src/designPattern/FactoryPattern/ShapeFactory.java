package designPattern.FactoryPattern;

public class ShapeFactory {

	//This creates a object based on condition and return to class who needs them
	Shape getShapeObject(int input){
		if(input==1){
			return new Circle();
		}
		else if(input==2){
			return new Rectangle();
		}
		else {
			return new Square();
		}
	}
}
