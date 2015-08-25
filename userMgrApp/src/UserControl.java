
public class UserControl {
	private UserInfoVO returnVO = new UserInfoVO();
	private UserInfoVO inVO = new UserInfoVO();
	private static String _DEL = "delete";
	private static String _INS = "insert";
	private static String _MOD = "update";
	private static String _SEL = "select";
	private static String _ALL = "selectall";
	
	public UserControl(UserInfoVO vo) {
		this.inVO = vo;
	}
	
	public UserInfoVO send(UserInfoVO vo) throws Exception {
		String command = inVO.getCommand();
		if(command.equals(_DEL)) {
			UserInfoEty userEty = new UserInfoEty();
			userEty.deleteUserInfo(vo);
		} else if(command.equals(_INS)) {
			UserInfoEty userEty = new UserInfoEty();
			userEty.registerUserInfo(vo);
		} else if(command.equals(_MOD)) {
			UserInfoEty userEty = new UserInfoEty();
			userEty.modifyUserInfo(vo);
		} else if(command.equals(_SEL)) {
			UserInfoEty userEty = new UserInfoEty();
			returnVO = userEty.retrieveUserInfo(vo);
		}
		return returnVO;
	}
	
	public UserInfoVO[] send() throws Exception {
		String command = inVO.getCommand();
		UserInfoVO[] returnVOs = null;
		if(command.equals(_ALL)) {
			UserInfoEty userEty = new UserInfoEty();
			returnVOs = userEty.retrieveAllUserInfo();
		} else {
			throw new Exception("잘못된 List 조회 Command 입니다.");
		}
		return returnVOs;
	}
	
}
