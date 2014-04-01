package user;

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

public class UserSearchAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SearchForm searchForm =(SearchForm)form;
		System.out.println("UserSearchAction");
		HttpSession session = request.getSession();

		RoomDAO dao = new RoomDAO();

			List<Room> list = dao.findAll(searchForm);

			System.out.println("list.size() = " + list.size());
			Iterator<Room> i = list.iterator();
			while (i.hasNext()) {
				Room room = (Room)i.next();
				System.out.println(room.getCode() + "  " + room.getName());
			}

			request.setAttribute("list", list);
			return mapping.findForward("success");
	}

}
