package member;

import java.sql.*;
import java.util.Scanner;

public class Search {
	Scanner sc = new Scanner(System.in);
	
	Connection con;
	private String oracle_url;
	private String user_id;
	private String user_password;
	
	public Search() {
		this.oracle_url = "jdbc:oracle:thin:@localhost:1521:xe";
		this.user_id = "madang";
		this.user_password = "madang";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("JDBC 드라이버가 없습니다.");
			e.printStackTrace();
		}
		
		/*
		 * DB 연결
		 */
		
		try {
			this.con = DriverManager.getConnection(oracle_url, this.user_id, this.user_password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 연결이 안되었습니다.");
			e.printStackTrace();
		}
	}
	
	void search_sql() {
		String query = "SELECT * FROM Member";
		Statement stmt = null;
        ResultSet rs = null;
		
		try {
			this.con = DriverManager.getConnection(oracle_url, this.user_id, this.user_password);
			 stmt = con.createStatement();
			 rs = stmt.executeQuery(query);
			 
			 System.out.println("\n");
			
			 while (rs.next()) {
				 System.out.print(rs.getString(1) + "   ");
				 System.out.print(rs.getString(2) + "   ");
				 System.out.print(rs.getString(3) + "   ");
				 System.out.print(rs.getString(4) + "   ");
				 System.out.print(rs.getString(5) + "   ");
				 System.out.print(rs.getString(6) + "   ");
				 System.out.print(rs.getString(7) + "   ");
				 System.out.print(rs.getString(8) + "   ");
				 System.out.print(rs.getString(9));
				 System.out.println("\n");
	            }
			 
			 rs.close();
			 stmt.close();
			 this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
