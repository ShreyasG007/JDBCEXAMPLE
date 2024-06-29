package com.infosys.employee;

public class Constants {
	
	private static final String jdbcDriver="com.mysql.cj.jdbc.Driver";
	private static final String jdbcURL = "jdbc:mysql://localhost:3306/infosys";
    private static final String username = "root";
    private static final String password = "Shreyas21";
    private static final String csvFilePath = "C:/Users/Hp/Downloads/employees_dev_test_support.csv";
    
	public static String getJdbcdriver() {
		return jdbcDriver;
	}
	public static String getJdbcurl() {
		return jdbcURL;
	}
	public static String getUsername() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
	public static String getCsvfilepath() {
		return csvFilePath;
	}
	
}
