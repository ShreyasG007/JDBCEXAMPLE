package com.infosys.employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Employee {

	
	public void employeeInformationInsert() throws ClassNotFoundException, SQLException {
		
		Class.forName(Constants.getJdbcdriver());
		Connection connection = DriverManager.getConnection(Constants.getJdbcurl(),Constants.getUsername(),Constants.getPassword());
		
		PreparedStatement ps = connection.prepareStatement("insert into employee(employee_id,employee_name,employee_profile,employee_salary,employee_dateofjoin)values(?,?,?,?,?)");
		try (BufferedReader br = new BufferedReader(new FileReader(Constants.getCsvfilepath()))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
            	String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                String profile = data[2].trim();
                double salary = Double.parseDouble(data[3].trim());
                String dateOfJoin = data[4].trim();

               
                ps.setInt(1, id);      
                ps.setString(2, name); 
                ps.setString(3, profile); 
                ps.setDouble(4, salary);  
                ps.setString(5, dateOfJoin);  

                ps.executeUpdate(); 
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Employee employee = new Employee();
		employee.employeeInformationInsert();
	}
}
