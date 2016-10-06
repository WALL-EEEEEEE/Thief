import java.io.InputStream;
import java.sql.Driver;
import java.util.Properties;

import org.junit.Test;

import com.mysql.jdbc.Connection;


public class SampleTest1 {
	
	@Test
	public void test() throws Exception {
		
		Driver driver = new com.mysql.jdbc.Driver();
		String url = "jdbc:mysql://localhost:3306/test";
		Properties info = new Properties();
		info.put("user","root");
		info.put("password","root");
		Connection connect = (Connection) driver.connect(url,info);
		System.out.println(connect);
		
		
	}
	
	public Connection getConnect() throws Exception{
		String driverClass = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;
		
		/*
		 * 使用IO流中的inputStream 对象来获取配置文件
		 *
		 */
		 InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties");
		 Properties pro = new Properties();
		 pro.load(input);
		 driverClass = pro.getProperty("driver");
		 jdbcUrl = pro.getProperty("user");
		 user = pro.getProperty("user");
		 password = pro.getProperty("password");
		 
		 //依据JAVA的反射原理,通过Class的forname方法参数是全类名
		 Driver driver = (Driver) Class.forName(driverClass).newInstance();
		 Properties info = new Properties();
		 info.put("user", user);
		 info.put("passowrd", password);
		 return (Connection)driver.connect(jdbcUrl, info);
		 
		
		
	}
	
	@Test
	public void testGetConnection() throws Exception{
		System.out.print(getConnect());
	}

}
