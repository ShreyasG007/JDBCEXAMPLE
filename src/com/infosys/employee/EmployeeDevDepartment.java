package com.infosys.employee;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDevDepartment {

	public void employeeInformationInsert() throws ClassNotFoundException, SQLException {

		Class.forName(Constants.getJdbcdriver());
		Connection connection = DriverManager.getConnection(Constants.getJdbcurl(), Constants.getUsername(),
				Constants.getPassword());

		PreparedStatement ps = connection.prepareStatement("insert into devdepartment (employee_id,employee_name,employee_profile,employee_salary,employee_dateofjoin) select * from employee where employee_profile='dev'");

		ps.executeUpdate();

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeDevDepartment employee = new EmployeeDevDepartment();
		employee.employeeInformationInsert();
	}
}
