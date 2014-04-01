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

public class UserInfoCreateConfirmAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession userInfoSession = request.getSession();
		UserInfoForm userInfoForm = (UserInfoForm) userInfoSession.getAttribute("user_UserInfoForm");

		System.out.println("�Z�b�V����(user_UserInfoForm)" + userInfoSession.getAttribute("user_UserInfoForm"));

		//�f�[�^�̏d���`�F�b�N
		UserInfoDAO dao = new UserInfoDAO();
		List<UserInfo> list = null;
		if (userInfoForm.getLoginid() != null && userInfoForm.getLoginid().length() != 0) {
			if (userInfoForm.getPassword() != null && userInfoForm.getPassword().length() != 0) {
				list = dao.find(userInfoForm);
				System.out.println("UserInfoCreateConfirmAction : " + list.size());
			}
		}
		int count = 0;
		if (list.size() == 0) {
			//�f�[�^�x�[�X�֓o�^
			count = dao.create(userInfoForm);
			//���X�g��1���Ȃ烍�O�C������
			System.out.println(count);
		}
		if(count == 1){
			userInfoSession.invalidate();
			userInfoSession = request.getSession();

			userInfoSession.setAttribute("user_UserInfoForm", userInfoForm);

			userInfoSession.setAttribute("loginid", userInfoForm.getLoginid());

			return mapping.findForward("success");
		}
		else{
			//���s�����ꍇ
			return mapping.getInputForward();
		}
	}
}
