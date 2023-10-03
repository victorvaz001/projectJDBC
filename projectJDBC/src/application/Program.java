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
		Sector sec = new Sector(2, null);		
		List<Employee> list = employeeDao.findBySector(sec);
		for (Employee emp : list) {
			System.out.println(emp);
			
		System.out.println();
		System.out.println("Test 2: findById");
		Employee empFindById = employeeDao.findById(4);
		System.out.println(empFindById);
		}
	}
}	
