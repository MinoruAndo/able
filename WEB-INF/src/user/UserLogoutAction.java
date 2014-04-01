package user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UserLogoutAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//session�̎擾
		HttpSession session = request.getSession();
System.out.println("UserLogoutAction");
		//�t�H�[���̓��e�����o��
//		UserInfoForm userInfoForm = (UserInfoForm) form;
//		session.setAttribute("userInfo",userInfoForm);

		session.removeAttribute("userInfo");
		session.removeAttribute("user_UserInfoForm");
		session.removeAttribute("loginid");
		session.removeAttribute("station");

		return mapping.findForward("success");
	}
}
