
public class UserInfoEty {
	UserInfoDAO m_dao = null;

	public UserInfoDAO getUserInfoDAO() {
		if(null == m_dao) {
			m_dao = new UserInfoDAO();
		}
		return m_dao;
	}

	public void setUserInfoDAO(UserInfoDAO dao) {
		this.m_dao = dao;
	}
	
	public int registerUserInfo(UserInfoVO uvo) throws Exception {
		return getUserInfoDAO().insertUserInfo(uvo);
	}
	public UserInfoVO retrieveUserInfo(UserInfoVO uvo) throws Exception {
		return getUserInfoDAO().selectUserInfo(uvo);
	}
	public int modifyUserInfo(UserInfoVO uvo) throws Exception {
		return getUserInfoDAO().updateUserInfo(uvo);
	}
	public int deleteUserInfo(UserInfoVO uvo) throws Exception {
		return getUserInfoDAO().deleteUserInfo(uvo);
	}
	public UserInfoVO[] retrieveAllUserInfo() throws Exception {
		return getUserInfoDAO().selectUserInfoList();
	}
	
}
