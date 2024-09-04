package designPattern.decoratorPattern;

public class OrderPizzaMain {

	
	public static void main(String[] args){
		
		System.out.println("Find cost of margerrita pizza with panner");
		
		BasePizza bp = new MargerritaBase();
		
		BasePizza marWithPanner = new PannerToppings(bp);
		
		
		System.out.println("cost is "+ new PannerToppings(new MargerritaBase()).cost());
		
		System.out.println("Find cost of margerrita pizza with panner , with mushroom and extracheese");
		
		BasePizza marWithPannerWithMush= new MushRoomToppings(marWithPanner);
		
		BasePizza margWithPanWithMushWithEC = new ExtraCheeseToppings(marWithPannerWithMush);
		
		System.out.println("cost is "+margWithPanWithMushWithEC.cost());
		
		//OR we can find directly by
		
		System.out.println("cost is "+ new ExtraCheeseToppings(new MushRoomToppings(new PannerToppings(new MargerritaBase()))).cost());
	}
}
