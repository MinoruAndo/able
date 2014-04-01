package user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import DB.UserInfoDAO;

public class Hensyu_kakuninAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession userInfoSession = request.getSession();
		UserInfoForm userInfoForm = (UserInfoForm) userInfoSession.getAttribute("userInfo");
		String loginid = (String) userInfoSession.getAttribute("loginid");

		System.out.println("�Z�b�V����" + userInfoSession.getAttribute("userInfo"));
		//�f�[�^�x�[�X�֓o�^
		UserInfoDAO dao = new UserInfoDAO();
		int count = dao.update(loginid, userInfoForm);
		//���X�g��1���Ȃ烍�O�C������

		if(count == 1){
//			userInfoSession.invalidate();
			userInfoSession = request.getSession();

			//�f�o�b�O�p
			System.out.println(loginid);

			userInfoSession.removeAttribute("userInfo");

			userInfoSession.setAttribute("loginid", userInfoForm.getLoginid());

			return mapping.findForward("success");
		}
		else{
			//���s�����ꍇ
			return mapping.getInputForward();
		}
	}
}
