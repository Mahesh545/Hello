package mahi;



// this is program for INSERTING DATA


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;
import java.util.Scanner;

public class Inserting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String url="jdbc:oracle:thin:@//localHost:1521/XE";
				String un="SYSTEM";
				String pwd="system";
				Connection con=null;
				Statement stmt=null;
				ResultSet res=null;
				PreparedStatement pstmt=null;
				
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					System.out.println("Driver has loaded successfully");
					con=DriverManager.getConnection(url,un,pwd);
					System.out.println("Connection established successfully");
			
					String s="INSERT INTO MOVIES VALUES(?,?,?,?,?)";
					pstmt=con.prepareStatement(s);
					Scanner scan=new Scanner(System.in);
					System.out.println("Enter the Movie Name");
					String temp1=scan.nextLine();
					System.out.println("Enter the name of Actor");
					String temp2=scan.nextLine();
					System.out.println("Enter the name of Actress");
					String temp3=scan.nextLine();
					System.out.println("Enter the name of the director");
					String temp4=scan.nextLine();
					System.out.println("Enter the YearOfRelease");
					int temp5=scan.nextInt();
					 pstmt.setString(1, temp1);
					 pstmt.setString(2, temp2);
					 pstmt.setString(3, temp3);
					 pstmt.setString(4, temp4);
					 pstmt.setInt(5, temp5);
					 int x=pstmt.executeUpdate();
					 System.out.println(x+ "Row has been updated");
		
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Some problem occured");
				}
			}
}


