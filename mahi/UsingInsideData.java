package mahi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UsingInsideData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@//localHost:1521/XE";
		String un="SYSTEM";
		String pwd="system";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		ResultSetMetaData rsmd=null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver has loaded successfully");
			con=DriverManager.getConnection(url,un,pwd);
			System.out.println("Connection established successfully");
			String s="SELECT * FROM MOVIES Where Actor=?";
			pstmt=con.prepareStatement(s);
			Scanner Scan=new Scanner(System.in);
			System.out.println("Enter the Name of the Actor");
			String temp=Scan.nextLine();
			pstmt.setString(1,temp);
			res=pstmt.executeQuery();
			
			 while(res.next()==true)
			 {
				 String a=res.getString(1);
				
				System.out.println(a);
				}

			 }
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Some problem occured");
		}
	}
}
