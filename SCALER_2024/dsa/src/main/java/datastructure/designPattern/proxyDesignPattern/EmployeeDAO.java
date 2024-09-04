package datastructure.designPattern.proxyDesignPattern;

public interface EmployeeDAO {

	public void create(String client, Employee obj);
	public Employee get(String client);
	public void delete(String client,Employee obj);
	
}
