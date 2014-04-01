package user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import DB.KuchikomiDAO;
import DB.Kuchikomi;

public class KuchikomiCreateAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();
		KuchikomiForm kuchikomiForm = (KuchikomiForm)form;

		System.out.println("station = " + kuchikomiForm.getStation());
		System.out.println("code = " + session.getAttribute("code"));
		session.setAttribute("user_KuchikomiForm", kuchikomiForm);
		return mapping.findForward("success");
	}
}
