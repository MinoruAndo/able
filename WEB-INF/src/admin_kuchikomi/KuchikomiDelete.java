package admin_kuchikomi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import user.KuchikomiForm;
import DB.*;

public class KuchikomiDelete extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		KuchikomiDAO dao = new KuchikomiDAO();
		HttpSession session = request.getSession();
		int num = Integer.parseInt(request.getParameter("code"));
		int result = dao.delete(num);
		request.getSession().removeAttribute("user_KuchikomiForm");
		session.removeAttribute("num");
		return mapping.findForward("success");

	}
}
