package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.EmployeeDao;
import model.entities.Employee;
import model.entities.Sector;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		EmployeeDao employeeDao = DaoFactory.createEmployeeDaoJDBC();

		System.out.println("Test 1: findBySector");
		Sector sec = new Sector(2, null);
		List<Employee> list = employeeDao.findBySector(sec);
		for (Employee emp : list) {
			System.out.println(emp);
		}
		
		System.out.println();
		System.out.println("Test 2: findById");
		Employee empFindById = employeeDao.findById(4);
		System.out.println(empFindById);
		
		System.out.println();
		System.out.println("Test 3: insert");
		Date birthDate = sdf.parse("1975-06-24");
		Employee newEmp = new Employee(null, "Marta Brown", 3600.0, "Human Resource", birthDate, sec);
		employeeDao.insert(newEmp);
		System.out.println("Done! Inserted: " + newEmp.getId() + " - " + newEmp.getName());
	}
}
