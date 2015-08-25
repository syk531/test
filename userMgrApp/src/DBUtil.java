import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBUtil {
	static HashMap dss = new HashMap();
	private static InitialContext getInitialContext() throws NamingException {
		return new InitialContext();
	}
	
	public static Connection getConnection() throws Exception {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@211.108.23.13:1521/orcl";
		String user = "buttoney";
		String passwd = "buttoney";
		/* ���� mariaDB
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "syk";
		String passwd = "syk";
		*/
		Class.forName(driver);
		return DriverManager.getConnection(url, user, passwd);
	}
	
	public static Connection getDatasource() throws Exception {
		DataSource ds = null;
		Connection con = null;
		String dsName = "jdbc/test";
		
		try {
			synchronized (dss) {
				ds = (DataSource) dss.get(dsName);
				if(ds == null) {
					Context initContext = getInitialContext();
					Context envContext = (Context) initContext.lookup("java:/comp/env");
					ds = (DataSource) envContext.lookup(dsName);
					dss.put(dsName, ds);
				}
			}
			con = ds.getConnection();
			return con;
		} catch (NamingException e) {
			closeConnection(con);
			throw new Exception(
				"Naming Exception getConnection : Name not found [" + e.toString() + "] : Connection cannot be obtained");
		} catch (SQLException e) {
			closeConnection(con);
			throw new Exception(
				"SQLException getConnection : Name not found [" + e.toString() + "] : Connection cannot be obtained");
		} catch (Exception e) {
			closeConnection(con);
			throw new Exception(
				"Exception getConnection : Name not found [" + e.toString() + "] : Connection cannot be obtained");
		}
	}
	
	public static void closeConnection(Connection con) {
		if(null != con) {
			try {
				con.close();
			} catch(Exception e) {}
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement pstmt) {
		if(null != pstmt) {
			try {
				pstmt.close();
			} catch(Exception e) {}
		}
		closeConnection(con);
	}
	
	public static void closeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(null != rs) {
			try {
				rs.close();
			} catch(Exception e) {}
		}
		closeConnection(con, pstmt);
	}
}
