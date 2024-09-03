package datastructure.designPattern.proxyDesignPattern;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public void create(String client, Employee obj) {
		// TODO Auto-generated method stub
		System.out.println("create a employee object");
		
	}

	@Override
	public Employee get(String client) {
		// TODO Auto-generated method stub
		System.out.println("get an object");
		return new Employee();
	}

	@Override
	public void delete(String client, Employee obj) {
		// TODO Auto-generated method stub
		System.out.println("delete an object");
		
	}

}
