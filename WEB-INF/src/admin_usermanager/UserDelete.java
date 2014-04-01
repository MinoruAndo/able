package admin_usermanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import DB.*;

public class UserDelete extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UserDelForm userDelForm =  (UserDelForm) form;

		UserInfoDAO dao = new UserInfoDAO();

		int result = dao.delete(userDelForm.getLoginid());
		request.getSession().removeAttribute("admin_usermanager_UserDelForm");
		return mapping.findForward("success");
	}
}
