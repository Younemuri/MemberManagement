package member;

import java.sql.*;
import java.util.Scanner;

public class Login {
	Scanner sc = new Scanner(System.in);
	
	Connection con;
	private String oracle_url;
	private String user_id;
	private String user_password;
	private String id;
	private String pw;
	
	public Login() {
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
	
	void do_login() {
	    String query = "SELECT * FROM Member";
	    String ID;
	    Statement stmt = null;
        ResultSet rs = null;
	    
	    try {
	    	this.con = DriverManager.getConnection(oracle_url, this.user_id, this.user_password);
	    	stmt = con.createStatement();
	    	rs = stmt.executeQuery(query);
			 
			while(rs.next()) {
				System.out.print(rs.getString(1));
			}
	    	
	        while(true) {
	            System.out.println("ID와 PW를 입력해주세요.");
	            System.out.print("ID: ");
	            id = sc.nextLine();
	            
	            if(id.equals("1")) {
	                System.out.print("PW: ");
	                pw = sc.nextLine();
	                    if(pw.equals("1")) {
	                        System.out.println("비밀번호가 틀립니다. 다시 입력해주세요");
	                    } else {
	                        System.out.println("[로그인]");
	                    }
	            }
	            else if(!id.equals(query)){
	                System.out.println("아이디가 존재하지 않습니다. 다시 입력해주세요");
	            }
	            else {
	                System.out.println("아이디와 비밀번호가 틀립니다. 다시 입력해주세요"); 
	            }
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
}
