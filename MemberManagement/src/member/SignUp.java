package member;

import java.sql.*;
import java.util.Scanner;

public class SignUp {
	Scanner sc = new Scanner(System.in);
	
	Connection con;
	private String oracle_url;
	private String user_id;
	private String user_password;
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String birth;
	private String phone;
	private String address;
	private String email;
	private String nickname;
	
	public SignUp() {
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
	
	void insert_sql() {
		String query = "INSERT INTO Member(ID, PW, NAME, GENDER, BIRTH, PHONE, ADDRESS, EMAIL, NICKNAME) VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		
		try {
			this.con = DriverManager.getConnection(oracle_url, this.user_id, this.user_password);
			preparedStatement = this.con.prepareStatement(query);
			// Oracle 준비되었음
			System.out.print("ID: ");
			id = sc.nextLine();
			preparedStatement.setString(1, id);
			System.out.print("PW: ");
			pw = sc.nextLine();
			preparedStatement.setString(2, pw);
			System.out.print("이름: ");
			name = sc.nextLine();
			preparedStatement.setString(3, name);
			System.out.print("성별: ");
			gender = sc.nextLine();
			preparedStatement.setString(4, gender);
			System.out.print("생년월일: ");
			birth = sc.nextLine();
			preparedStatement.setString(5, birth);
			System.out.print("핸드폰 번호: ");
			phone = sc.nextLine();
			preparedStatement.setString(6, phone);
			System.out.print("주소: ");
			address = sc.nextLine();
			preparedStatement.setString(7, address);
			System.out.print("이메일: ");
			email = sc.nextLine();
			preparedStatement.setString(8, email);
			System.out.print("닉네임: ");
			nickname = sc.nextLine();
			preparedStatement.setString(9, nickname);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			this.con.close();
			System.out.println("[회원 가입 완료]");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("NAME은 Primary Key 따라서, 중복이 안됩니다.");
			e.printStackTrace();
		}
	}
}
