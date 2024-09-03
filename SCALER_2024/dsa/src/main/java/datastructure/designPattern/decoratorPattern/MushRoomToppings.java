package datastructure.designPattern.decoratorPattern;

public class MushRoomToppings extends ToppingsDecorator{
	BasePizza bp;
	
	MushRoomToppings(BasePizza bp){
		this.bp=bp;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		int finalCost= bp.cost()+50;
		return finalCost;
	}
}
