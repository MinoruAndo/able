package user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import DB.UserInfo;
import DB.UserInfoDAO;

public class UserDeleteAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//session�̎擾
		HttpSession session = request.getSession();

		//session�̒�����loginid�����o��
		String loginid = (String) session.getAttribute("loginid");

		//�f�[�^�x�[�X����f�[�^�̎�o��
		UserInfoDAO dao = new UserInfoDAO();
		List<UserInfo> list = dao.find(loginid);
		session.setAttribute("userInfo",list.get(0));

		System.out.println("UserDeleteAction" + list.get(0));
		return mapping.findForward("success");
	}
}
