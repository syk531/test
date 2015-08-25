import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserInfoDAO {
	public int insertUserInfo(UserInfoVO mvo) throws Exception {
		String dml = "insert into EMPINFO (" +
				"emp_no, id, pwd, name, rnumber, dept, position, registdate" +
				") values (?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		int intVal = 0;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, mvo.getEmp_no());
			pstmt.setString(2, mvo.getId());
			pstmt.setString(3, mvo.getPwd());
			pstmt.setString(4, mvo.getName());
			pstmt.setString(5, mvo.getRnumber());
			pstmt.setString(6, mvo.getDept());
			pstmt.setString(7, mvo.getPosition());
			pstmt.setString(8, mvo.getRegistdate());
			
			intVal = pstmt.executeUpdate();
			if(intVal < 1) {
				System.out.println("������ �Է� ����");
			} else {
				System.out.println("������ �Է� ����");
			}
		} catch(SQLException e) {
			String msg = "sql exception�߻�";
			throw new SQLException(msg + "\n" + e);
		} finally {
			try {
				DBUtil.closeConnection(con, pstmt);
			} catch(Exception e) {}
		}
		return intVal;
	}
	
	public int updateUserInfo(UserInfoVO mvo) throws Exception {
		String dml = "update EMPINFO set " +
				"id = ?, pwd=?, name=?, rnumber=?, dept=?, position=?, registdate=?" +
				" where emp_no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		int intVal = 0;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPwd());
			pstmt.setString(3, mvo.getName());
			pstmt.setString(4, mvo.getRnumber());
			pstmt.setString(5, mvo.getDept());
			pstmt.setString(6, mvo.getPosition());
			pstmt.setString(7, mvo.getRegistdate());
			pstmt.setString(8, mvo.getEmp_no());
			
			intVal = pstmt.executeUpdate();
			if(intVal < 1) {
				System.out.println("������ ���� ����");
			} else {
				System.out.println("������ ���� ����");
			}
		} catch(SQLException e) {
			String msg = "sql exception�߻�";
			throw new SQLException(msg + "\n" + e);
		} finally {
			try {
				DBUtil.closeConnection(con, pstmt);
			} catch(Exception e) {}
		}
		return intVal;
	}
	
	public int deleteUserInfo(UserInfoVO mvo) throws Exception {
		String dml = "delete from empinfo" +
				" where emp_no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		int intVal = 0;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, mvo.getEmp_no());
			
			intVal = pstmt.executeUpdate();
			if(intVal < 1) {
				System.out.println("������ ���� ����");
			} else {
				System.out.println("������ ���� ����");
			}
		} catch(SQLException e) {
			String msg = "sql exception�߻�";
			throw new SQLException(msg + "\n" + e);
		} finally {
			try {
				DBUtil.closeConnection(con, pstmt);
			} catch(Exception e) {}
		}
		return intVal;
	}
	
	public UserInfoVO selectUserInfo(UserInfoVO mvo) throws Exception {
		String dml = "select * from empinfo where emp_no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserInfoVO retval = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, mvo.getEmp_no());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				retval = new UserInfoVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			}
		} catch(SQLException e) {
			String msg = "������ ��ȸ ����";
			System.out.println(msg + "\n" + e);
			throw new SQLException(msg + "\n" + e);
		} finally {
			DBUtil.closeConnection(con, pstmt, rs);
		}
		return retval;
	}
	
	public UserInfoVO[] selectUserInfoList() throws Exception {
		String dml = "select * from empinfo";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserInfoVO[] retval = null;
		UserInfoVO uvo = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			rs = pstmt.executeQuery();
			ArrayList<UserInfoVO> v = new ArrayList<UserInfoVO>();
			
			while(rs.next()) {
				uvo = new UserInfoVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
				v.add(uvo);
			}
			retval = new UserInfoVO[v.size()];
			v.toArray(retval);
		} catch(SQLException e) {
			String msg = "�����͸���Ʈ ��ȸ ����";
			System.out.println(msg + "\n" + e);
			throw new SQLException(msg + "\n" + e);
		} finally {
			DBUtil.closeConnection(con, pstmt, rs);
		}
		return retval;
	}
}