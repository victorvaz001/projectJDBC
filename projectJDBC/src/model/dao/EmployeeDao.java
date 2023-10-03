package model.dao;

import java.util.List;

import model.entities.Employee;
import model.entities.Sector;

public interface EmployeeDao {
	
	void insert(Employee obj);
	void update(Employee obj);
	void delete(Integer obj);
	Employee findById(Integer id);
	List<Employee> findAll();
	List<Employee> findBySector(Sector sec);
}
