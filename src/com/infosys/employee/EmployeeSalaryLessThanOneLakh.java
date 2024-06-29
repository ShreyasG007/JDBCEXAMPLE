package com.infosys.employee;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeSalaryLessThanOneLakh {

	public void employeeInformationInsert() throws ClassNotFoundException, SQLException {

		Class.forName(Constants.getJdbcdriver());
		Connection connection = DriverManager.getConnection(Constants.getJdbcurl(), Constants.getUsername(),
				Constants.getPassword());

		PreparedStatement ps = connection.prepareStatement("insert into salarylessthanonelakh (employee_id,employee_name,employee_profile,employee_salary,employee_dateofjoin) select * from employee where employee_salary<100000");

		ps.executeUpdate();

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeSalaryLessThanOneLakh employee = new EmployeeSalaryLessThanOneLakh();
		employee.employeeInformationInsert();
	}
}
