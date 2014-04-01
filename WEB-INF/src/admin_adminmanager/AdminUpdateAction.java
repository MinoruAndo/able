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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import admin_search.UpdateForm;
import DB.AdminCreate;
import DB.AdminCreateDAO;

public class AdminUpdateAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String loginid = request.getParameter("loginid");
		String update = request.getParameter("update");
		String check = request.getParameter("check");
		String edit = request.getParameter("edit");


		AdminCreateDAO dao = new AdminCreateDAO();

		if(check != null) {
			AdminUpdateForm adminUpdateForm = (AdminUpdateForm) form;
			System.out.println("adminUpdateForm " + adminUpdateForm);
			String msg = null;



			List<AdminCreate> list = dao.find(request.getParameter("id"));

			request.setAttribute("list", list);

			if(adminUpdateForm.getLoginid().equals("") || adminUpdateForm.getPassword().equals("")){
				//失敗した場合
				// JSPにメッセージを表示
				ActionMessages messages = new ActionMessages();
				messages.add("mes1", new ActionMessage("errors.adminupdate"));

				System.out.println("メッセージ:" + messages.get("mes1"));
				this.saveMessages(request, messages);
				return mapping.getInputForward();
			}

			request.setAttribute("adminUpdateForm", adminUpdateForm);
			return mapping.findForward("check");
		}
		else if(edit != null) {

			AdminCreateForm adminCreateForm = (AdminCreateForm) form;
			System.out.println("adminCreateForm " + adminCreateForm);

			List<AdminCreate> list = dao.find(loginid);

			System.out.println(list.size());

			request.setAttribute("list", list);

			return mapping.findForward("success");

		}
		else if(update != null) {

			AdminUpdateForm adminUpdateForm = (AdminUpdateForm) form;
			System.out.println("adminCreateForm " + adminUpdateForm);

			int count = dao.update(request.getParameter("id"), adminUpdateForm);
			System.out.println(count + "件更新しました");

			return mapping.findForward("update");

		}

		return mapping.getInputForward();
	}
}
