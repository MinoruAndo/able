package user;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import DB.UserInfo;
import DB.UserInfoDAO;

public class UserInfoCreateAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession userInfoSession = request.getSession();
		//�t�H�[���̓��e�����o��
		UserInfoForm userInfoForm = (UserInfoForm) form;
		System.out.println("��ʂ���擾����form: " + userInfoForm);
		String loginid = userInfoForm.getLoginid();
		String mail = userInfoForm.getMail();
		String password = userInfoForm.getPassword();

		// ���e�̊m�F
		UserInfoDAO dao = new UserInfoDAO();
		List<UserInfo> list = null;
		if (loginid != null && loginid.length() != 0) {
			if (password != null && password.length() != 0) {
				list = dao.find(userInfoForm.getLoginid());
				System.out.println("UserInfoCreateAction : " + list.size());
			}
		}

		// ���e���f�[�^�ɂ��邩�ǂ���
		if (list != null && list.size() == 0) {
			// �m�F��ʂ֑J��
			System.out.println("�Z�b�V����" + userInfoSession.getAttribute("userInfo"));
			return mapping.findForward("success");
		}
		else{
			//���s�����ꍇ
//			ActionErrors errors = new ActionErrors();
//			errors.add("mail", new ActionError("string.unique"));
//
//			this.saveMessages(request, errors);
//			System.out.println("�G���[���b�Z�[�W:" + errors.get("mail"));
//			return mapping.getInputForward();

//			// JSP�Ƀ��b�Z�[�W��\��
			ActionMessages messages = new ActionMessages();
			messages.add("mes1", new ActionMessage("errors.unique"));

			System.out.println("���b�Z�[�W:" + messages.get("mes1"));
			this.saveMessages(request, messages);
			return mapping.findForward("failuer");

		}
	}
}
