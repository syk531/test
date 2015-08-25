
public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String emp_no = "A-1003";
		String id = "java2";
		String pwd = "1234";
		String name = "�����α׷�";
		String rnumber = "7809012621913";
		String dept = "�ַ�ǰ��߼���";
		String position = "����";
		String registdate = "20020408";
		
		//xi 1:insert 2:update 3:delete 4:select 5:selectall
		int xi = 5;
		UserInfoVO returnVo = null;
		UserInfoVO vo = new UserInfoVO(emp_no, id, pwd, name, rnumber, dept, position, registdate);
		try {
			if(xi == 1) {
				vo.setCommand("insert");
				UserControl ctrl = new UserControl(vo);
				ctrl.send(vo);
			}
			if(xi == 2) {
				vo.setCommand("update");
				UserControl ctrl = new UserControl(vo);
				ctrl.send(vo);
			}
			
			if(xi == 3) {
				vo.setCommand("delete");
				UserControl ctrl = new UserControl(vo);
				ctrl.send(vo);
			}
			
			if(xi == 4) {
				vo.setCommand("select");
				UserControl ctrl = new UserControl(vo);
				returnVo = ctrl.send(vo);
				
				System.out.println("���: " + returnVo.getEmp_no() + "\n");
				System.out.println("���̵�: " + returnVo.getId() + "\n");
				System.out.println("�н�����: " + returnVo.getPwd() + "\n");
				System.out.println("�̸�: " + returnVo.getName() + "\n");
				System.out.println("�ֹι�ȣ: " + returnVo.getRnumber() + "\n");
				System.out.println("�μ�: " + returnVo.getDept() + "\n");
				System.out.println("����: " + returnVo.getPosition() + "\n");
				System.out.println("�������: " + returnVo.getRegistdate() + "\n");
				System.out.println("��ȸ�� ���������� ����Ǿ����ϴ�.");
			}
			
			if(xi == 5) {
				vo.setCommand("selectall");
				UserControl ctrl = new UserControl(vo);
				UserInfoVO[] rvos = ctrl.send();
				System.out.println("��ü�Ǽ� : " + rvos.length);
				for(UserInfoVO userInfoVO : rvos) {
					System.out.println("���: " + userInfoVO.getEmp_no() + "\n");
					System.out.println("���̵�: " + userInfoVO.getId() + "\n");
					System.out.println("�н�����: " + userInfoVO.getPwd() + "\n");
					System.out.println("�̸�: " + userInfoVO.getName() + "\n");
					System.out.println("�ֹι�ȣ: " + userInfoVO.getRnumber() + "\n");
					System.out.println("�μ�: " + userInfoVO.getDept() + "\n");
					System.out.println("����: " + userInfoVO.getPosition() + "\n");
					System.out.println("�������: " + userInfoVO.getRegistdate() + "\n");
				}
				System.out.println("��ȸ�� ���������� ����Ǿ����ϴ�.");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
