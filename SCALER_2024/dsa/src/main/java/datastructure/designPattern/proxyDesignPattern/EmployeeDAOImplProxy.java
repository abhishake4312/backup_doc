//package datastructure.designPattern.proxyDesignPattern;
//
//public class EmployeeDAOImplProxy implements EmployeeDAO {
//
//	EmployeeDAOImpl employeeDAOimpl;
//
//	EmployeeDAOImplProxy(EmployeeDAOImpl employeeDAOimpl){
//		this.employeeDAOimpl=employeeDAOimpl;
//	}
//	public void create(String client, Employee obj) {
//		// TODO Auto-generated method stub
//		if(client=="ADMIN"){
//			employeeDAOimpl.create(client,obj);
//		}else{
//			System.out.println("access denied");
//		}
//
//	}
//
//	@Override
//	public Employee get(String client) {
//		// TODO Auto-generated method stub
//		// TODO Auto-generated method stub
//				if(client=="ADMIN" || client=="USER"){
//					return employeeDAOimpl.get(client);
//
//				}else{
//					System.out.println("access denied");
//				}
//
//	}
//
//	@Override
//	public void delete(String client, Employee obj) {
//		// TODO Auto-generated method stub
//		// TODO Auto-generated method stub
//				if(client=="ADMIN"){
//					employeeDAOimpl.delete(client,obj);
//				}else{
//					System.out.println("access denied");
//				}
//	}
//
//}
