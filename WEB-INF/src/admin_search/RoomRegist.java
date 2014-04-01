package admin_search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import DB.*;

public class RoomRegist extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		RoomCreateForm roomCreateForm =  (RoomCreateForm) form;
		RoomDAO dao = new RoomDAO();

		HttpSession session = request.getSession();

		String path;
		System.out.println(session.getAttribute("photopath"));
		//fileName‚ªnull‚¾‚Á‚½‚ç
		if(session.getAttribute("photopath") == null){
			path = "";
		} else{
			path = (String)session.getAttribute("photopath");
		}
		int result = dao.create(roomCreateForm,path);
		session.removeAttribute("admin_search_RoomCreate");
		session.removeAttribute("photopath");
		return mapping.findForward("success");
	}
}
