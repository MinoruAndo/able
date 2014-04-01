//�A�N�V����

package admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import DB.Admin;
import DB.AdminDAO;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//�t�H�[���̓��e�����o��
		LoginForm loginForm = (LoginForm) form;
		//�f�[�^�x�[�X����l�����o�����X�g�ɃZ�b�g
		AdminDAO dao = new AdminDAO();
		List<Admin> list = dao.find(loginForm);
		//���X�g��1���Ȃ烍�O�C������
		if(list.size() == 1){
			request.setAttribute("list", list);
			HttpSession adminSession = request.getSession();
			adminSession.setAttribute("adminlogin", list.get(0).getId());
			return mapping.findForward("success");
		}
		else{
			//���s�����ꍇ
			return mapping.getInputForward();
		}
	}
}
