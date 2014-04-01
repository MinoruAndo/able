package admin_adminmanager;

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
import DB.UserInfo;
import DB.UserInfoDAO;

public class AdminCreateConfirmAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession adminCreateSession = request.getSession();
		AdminCreateForm adminCreateForm = (AdminCreateForm) adminCreateSession.getAttribute("admin_adminmanager_AdminCreateForm");

		System.out.println("セッション(admin_adminmanager_AdminCreateForm)" + adminCreateSession.getAttribute("admin_adminmanager_AdminCreateForm"));

		//データの重複チェック
		AdminCreateDAO dao = new AdminCreateDAO();
		List<AdminCreate> list = null;
		if (adminCreateForm.getLoginid() != null && adminCreateForm.getLoginid().length() != 0) {
			if (adminCreateForm.getPassword() != null && adminCreateForm.getPassword().length() != 0) {
				list = dao.find(adminCreateForm);
				System.out.println("AdminCreateConfirmAction : " + list.size());
			}
		}
		int count = 0;
		if (list.size() == 0) {
			//データベースへ登録
			count = dao.create(adminCreateForm);

			System.out.println("登録list" + count);
			List<AdminCreate> create = dao.findAll();

			request.setAttribute("create", create);
			return mapping.findForward("success");
		}
//		if(count == 1){
//			adminCreateSession.invalidate();
//			adminCreateSession = request.getSession();
//
//			adminCreateSession.setAttribute("admin_adminmanager_AdminCreateForm", adminCreateForm);
//
//			adminCreateSession.setAttribute("loginid", adminCreateForm.getLoginid());
//
//			return mapping.findForward("success");
//		}
//		else{
//			//失敗した場合
//			return mapping.getInputForward();
//		}
		return mapping.findForward("success");
	}
}
