package model.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.EmployeeDao;
import model.entities.Employee;
import model.entities.Sector;

public class EmployeeDaoJDBC implements EmployeeDao {
	
	private static Connection conn = null;
	
	public EmployeeDaoJDBC (Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Employee obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Employee obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findBySector(Sector sec) {
		// TODO Auto-generated method stub
		return null;
	}
}
