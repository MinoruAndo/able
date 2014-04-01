package admin_search;

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

public class ShowAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		SearchForm searchForm =(SearchForm)form;

		HttpSession session = request.getSession();
		SearchForm form2 = (SearchForm)session.getAttribute("form");

		RoomDAO dao = new RoomDAO();
//		String show = null;
//
//		show = request.getParameter("show");

			//ï®åèè⁄ç◊ï\é¶èàóù
			List<Room> list = dao.UpdateCheck(searchForm.getCode());

			request.setAttribute("list", list);
			return mapping.findForward("show");
	}

}

