package model.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	private static Employee instantiateEmployee(ResultSet rs, Sector sec) throws SQLException {
		
		Employee emp = new Employee();
		
		emp.setId(rs.getInt("id"));
		emp.setName(rs.getString("name"));
		emp.setSalary(rs.getDouble("salary"));
		emp.setJobTitle(rs.getString("jobTitle"));
		emp.setBirthDate(rs.getDate("birthDate"));
		emp.setSector(sec);				
		return emp;
	}
	
	private static Sector instantiateSector(ResultSet rs) throws SQLException {
		
		Sector sec = new Sector();
		
		sec.setId(rs.getInt("sectorId"));
		sec.setName(rs.getString("SecName"));
		return sec;
	}
}
