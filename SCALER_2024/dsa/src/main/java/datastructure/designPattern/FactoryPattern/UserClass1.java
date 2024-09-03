package datastructure.designPattern.FactoryPattern;

public class UserClass1 {
	
	
  public static void main(String[] args){
	 ShapeFactory sh= new ShapeFactory();
	 Shape s = sh.getShapeObject(1);
	  s.area();
  }
}
