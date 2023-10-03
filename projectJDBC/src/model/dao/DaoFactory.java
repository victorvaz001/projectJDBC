package model.dao;

import db.DB;
import model.impl.EmployeeDaoJDBC;

public class DaoFactory {
	
	public static EmployeeDao createEmployeeDaoJDBC() {
		return new EmployeeDaoJDBC(DB.getConnection());
	}
}
