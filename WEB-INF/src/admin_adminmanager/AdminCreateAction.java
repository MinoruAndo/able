package admin_adminmanager;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import DB.AdminCreate;
import DB.AdminCreateDAO;

public class AdminCreateAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String flg = null;
		flg = request.getParameter("flg");

		if(flg != null) {
			AdminCreateDAO dao = new AdminCreateDAO();
			List<AdminCreate> list = dao.findAll();

			request.setAttribute("list", list);
			return mapping.findForward("find");

		}else{
		//�t�H�[���̓��e�����o��
		AdminCreateForm adminCreateForm = (AdminCreateForm) form;
		System.out.println("adminCreateForm " + adminCreateForm);

		HttpSession adminCreateSession = request.getSession();
		adminCreateSession.setAttribute("admin_adminmanager_AdminCreateForm", adminCreateForm);

		String loginid = adminCreateForm.getLoginid();
		int staffNo = adminCreateForm.getStaffNo();
		Date adddate = adminCreateForm.getAdddate();
		String password = adminCreateForm.getPassword();

		//�f�[�^�x�[�X����l�����o�����X�g�ɃZ�b�g
		AdminCreateDAO dao = new AdminCreateDAO();
		List<AdminCreate> list = dao.find(adminCreateForm);
		List<AdminCreate> list2 = dao.findStaff(adminCreateForm.getStaffNo());

		//���X�g��0���Ȃ�o�^�m�F��
		System.out.println(list.size());
		if(list.size() == 0){
			if(list2.size() == 0){

			request.setAttribute("list", adminCreateForm);
			return mapping.findForward("success");
			}
			else{
				//���s�����ꍇ
				String msg = "�Ј��ԍ����d�����Ă��܂�";
				request.setAttribute("msg", msg);
				return mapping.findForward("error");
			}
		}
		else{
			//���s�����ꍇ
			String msg = "���O�C��ID���d�����Ă��܂�";
			request.setAttribute("msg", msg);
			return mapping.findForward("error");
		}
		}

	}
}
