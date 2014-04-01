package admin_kuchikomi;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import DB.Room;
import DB.RoomDAO;
import admin_search.*;

public class KuchikomiConfirmation extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int num = Integer.parseInt(request.getParameter("code"));
		HttpSession session = request.getSession();
		session.setAttribute("num", num);
		return mapping.findForward("success");

	}

}
