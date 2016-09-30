package FrameTest2;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserManager {
   
	//ĞŞ¸ÄÃÜÂë
	public static boolean modifyPass(String name,String pass) throws ClassNotFoundException{
		
		int rows = 0;
		Class.forName("com.mysql.jdbc.Driver");
		try {
			
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("update employer set upwd=? where uname=?");
			ps.setString(1, pass);
			ps.setString(2, name);
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rows>0)
		{
			return true;		
		}
		return false;
	}
}
