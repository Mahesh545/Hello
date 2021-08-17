package mahi;
//Using metadata



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class RetrevingData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url="jdbc:oracle:thin:@//localHost:1521/XE";
		String un="SYSTEM";
		String pwd="system";
		Connection con=null;
		Statement stmt=null;
		ResultSet res=null;
		ResultSetMetaData rsmd=null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver has loaded successfully");
			con=DriverManager.getConnection(url,un,pwd);
			System.out.println("Connection established successfully");
			stmt=con.createStatement();
			String s="SELECT * FROM MOVIES";
			res=stmt.executeQuery(s);
			rsmd=res.getMetaData();
			 for(int i=1;i<rsmd.getColumnCount();i++)
			 {
				 System.out.println(rsmd.getColumnName(i)+" "+rsmd.getColumnTypeName(i));
			 }
			 while(res.next()==true)
			 {
				 String a=res.getString("Name");
				 String b=res.getString("Actor");
				 String c=res.getString("Actress");
				 String d=res.getString("Director");
				 int e=res.getInt("YearOfRelease");
				System.out.println(a+" "+b+" "+c+" "+d+" "+e);
				}

			 }
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Some problem occured");
		}
	}
}

