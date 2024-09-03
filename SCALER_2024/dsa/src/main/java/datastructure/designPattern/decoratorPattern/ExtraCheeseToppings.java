package datastructure.designPattern.decoratorPattern;

public class ExtraCheeseToppings extends ToppingsDecorator{
	BasePizza bp;
	
	ExtraCheeseToppings(BasePizza bp){
		this.bp=bp;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		int finalCost= bp.cost()+25;
		return finalCost;
	}
}
