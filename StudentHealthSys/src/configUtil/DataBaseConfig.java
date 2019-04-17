package configUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DataBaseConfig {
     public static String url1="jdbc:mysql://localhost:3306/";
     public static String databaseName="students";
     public static String userName="&user=root";
     public static String password="&password=root";
     public static String driverName="com.mysql.jdbc.Driver";
     public static String encoding="&useUnicode=true&characterEncoding=UTF-8";
     public static String url=url1+databaseName+"?"+"useSSL=false"+encoding+userName+password;
       @SuppressWarnings("finally")
	public static Connection getConnection() {
    	   Connection con=null;
    	     try {
				Class.forName(driverName);
				con=DriverManager.getConnection(url);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				return con;
			}
       }
     
       public static void closeDatabaseConnection(Connection con,PreparedStatement ps,ResultSet rs) {
			try {
		    	   if(rs!=null)rs.close();
				if(ps!=null) ps.close();
		    	if(con!=null) con.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
       }
}
