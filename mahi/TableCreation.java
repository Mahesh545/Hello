package mahi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import oracle.jdbc.driver.OracleDriver;

public class TableCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@//localHost:1521/XE";
		String un="SYSTEM";
		String pwd="system";
		Connection con=null;
		Statement stmt=null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver has loaded successfully");
			con=DriverManager.getConnection(url,un,pwd);
			System.out.println("Connection established successfully");
			stmt=con.createStatement();
			String s="Create Table Movies(Name VARCHAR2(20) PRIMARY KEY,Actor VARCHAR2(20),Actress VARCHAR2(20),Director VARCHAR2(20),YearOfRelease NUMBER(10))";
			boolean res=stmt.execute(s);
			if(res==false)
			{
				System.out.println("New table is created...");
			}
			else
			{
				System.out.println("Table Creation is failed");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Some problem occured");
		}
	}

}
