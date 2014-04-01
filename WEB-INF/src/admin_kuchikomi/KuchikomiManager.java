package admin_kuchikomi;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import DB.*;

public class KuchikomiManager extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		KuchikomiForm kuchikomiForm =  (KuchikomiForm) form;

		KuchikomiDAO dao = new KuchikomiDAO();

		List<Kuchikomi> result = dao.find(kuchikomiForm);

		if(result.isEmpty()){
			request.getSession().removeAttribute("KuchikomiForm");
			return mapping.findForward("failure");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("result", result);
			return mapping.findForward("success");
		}
	}
}
