package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.EmployeeDao;
import model.entities.Employee;
import model.entities.Sector;

public class Program {

	public static void main(String[] args) {
		
		EmployeeDao employeeDao = DaoFactory.createEmployeeDaoJDBC();
		
		System.out.println("Test 1: findBySector");
		Sector sec = new Sector(3, null);		
		List<Employee> list = employeeDao.findBySector(sec);
		for (Employee emp : list) {
			System.out.println(emp);
		}
	}
}	
