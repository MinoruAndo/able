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

public class AdminDeleteAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//フォームの内容を取り出す
//		AdminCreateForm adminCreateForm = (AdminCreateForm) form;
//		System.out.println("adminCreateForm " + adminCreateForm);
//
//		HttpSession adminCreateSession = request.getSession();
//		adminCreateSession.setAttribute("admin_adminmanager_AdminCreateForm", adminCreateForm);

		String loginid = request.getParameter("loginid");
		String delete = request.getParameter("delete");
		String check = request.getParameter("check");


		AdminCreateDAO dao = new AdminCreateDAO();

		if(check != null) {
			List<AdminCreate> list = dao.find(loginid);


			System.out.println(list.size());

			request.setAttribute("list", list);
			return mapping.findForward("success");

		}
		else if(delete != null) {
			int count  = dao.delete(loginid);

			System.out.println(count + "件削除");

			return mapping.findForward("success");
		}

		return mapping.getInputForward();
	}
}
