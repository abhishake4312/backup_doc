package designPattern.decoratorPattern;

public class PannerToppings extends ToppingsDecorator{
	
	BasePizza bp;
	
	PannerToppings(BasePizza bp){
		this.bp=bp;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		int finalCost= bp.cost()+30;
		return finalCost;
	}

}
