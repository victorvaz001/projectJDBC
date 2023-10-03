package model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
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
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement(
					"INSERT INTO employee "
					+ "	(name, salary, jobTitle, birthDate, sectorId) "
					+ "	VALUES (?, ?, ?, ?, ?)",
					+ Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getName());
			st.setDouble(2, obj.getSalary());
			st.setString(3, obj.getJobTitle());
			st.setDate(4, new java.sql.Date(obj.getBirthDate().getTime()));
			st.setInt(5, obj.getSector().getId());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
		}
		catch (SQLException e) {
			throw new DbException("Error: " + e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
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
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st =  conn.prepareStatement(
					"SELECT employee.*,sector.Name as SecName "
					+ "FROM employee INNER JOIN sector "
					+ "ON employee.sectorId = sector.Id "
					+ "WHERE employee.id = ?");
			
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if (rs.next()) {
				Sector sec = instantiateSector(rs);
				Employee obj = instantiateEmployee(rs, sec);
				return obj;
			}
			return null;						
		}
		catch (SQLException e) {
			throw new DbException("Error: " + e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findBySector(Sector sec) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT employee.*,sector.Name as SecName "
					+ "FROM employee INNER JOIN sector "
					+ "ON employee.sectorId = sector.id "
					+ "WHERE sector.Id = ?");
			
			st.setInt(1, sec.getId());
			
			rs = st.executeQuery();
			
			List<Employee> list = new ArrayList<>();
			Map<Integer, Sector> map = new HashMap<>();
			
			while (rs.next()) {
				Sector sector = map.get(rs.getInt("sectorId"));
				
				if (sector == null) {
					sector = instantiateSector(rs);
					map.put(rs.getInt("sectorId"), sector);
				}
				Employee emp = instantiateEmployee(rs, sector);
				list.add(emp);
			}
			return list;
			
		}
		catch (SQLException e) {
			throw new DbException("Error: " + e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
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
