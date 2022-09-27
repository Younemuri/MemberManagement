package member;

import java.sql.*;
import java.util.Scanner;

public class Delete {
	Scanner sc = new Scanner(System.in);
	
	Connection con;
	private String oracle_url;
	private String user_id;
	private String user_password;
	private String name;
	
	public Delete() {
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
	
	void delete_sql() {
		System.out.println("삭제하고 싶은 회원의 이름을 입력해주세요.");
		System.out.print(">>");
		name = sc.nextLine();
		
		String query = "DELETE FROM Member WHERE NAME='"+ name +"'";
		PreparedStatement preparedStatement = null;
		
		try {
			this.con = DriverManager.getConnection(oracle_url, this.user_id, this.user_password);
			preparedStatement = this.con.prepareStatement(query);
			preparedStatement.executeUpdate();
			
			System.out.println("[회원 삭제 완료]");
			
			preparedStatement.close();
			this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
