package user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import DB.UserInfo;
import DB.UserInfoDAO;

public class UserLoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//�t�H�[���̓��e�����o��
		UserLoginForm userLoginForm = (UserLoginForm) form;

		//�f�[�^�x�[�X����l�����o�����X�g�ɃZ�b�g
		UserInfoDAO dao = new UserInfoDAO();

		// userLoginForm����UserInfoForm�փf�[�^���R�s�[
		UserInfoForm f = new UserInfoForm();
		f.setLoginid(userLoginForm.getId());
		f.setPassword(userLoginForm.getPassword());
		List<UserInfo> list = dao.find(f);

		//���X�g��1���Ȃ烍�O�C������
//		System.out.println("UserLoginAction�̃��O�C��ID�������ʁF" + list.size());
		if(list.size() == 1){
			HttpSession userInfoSession = request.getSession();
			userInfoSession.setAttribute("loginid", list.get(0).getLoginid());

			// ��ʑJ�ڂ̂��߃p�����[�^�擾
			String str = request.getParameter("gamen");
			System.out.println("��ʑJ�ڂ̂��߃p�����[�^�擾:" + str);
			if ("".equals(str)) {
				return mapping.findForward("usertop");
			}
			else {
				return mapping.findForward("kuchikomi");
			}
		}
		else{
			//���s�����ꍇ
//			// JSP�Ƀ��b�Z�[�W��\��
			ActionMessages messages = new ActionMessages();
			messages.add("mes1", new ActionMessage("errors.login"));

			System.out.println("���b�Z�[�W:" + messages.get("mes1"));
			this.saveMessages(request, messages);
			return mapping.getInputForward();
		}
	}
}
