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

import DB.Kuchikomi;
import DB.KuchikomiDAO;
import DB.Room;
import DB.RoomDAO;
import admin_search.*;

public class UserShowAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		SearchForm searchForm =(SearchForm)form;

		HttpSession session = request.getSession();

		RoomDAO dao = new RoomDAO();
		KuchikomiDAO kuchikomidao = new KuchikomiDAO();
		//ï®åèè⁄ç◊ï\é¶èàóù
		List<Room> list = dao.UpdateCheck(searchForm.getCode());
		System.out.println("UserShowAction#list.size() = " + list.size());
		List<Kuchikomi> kuchikomilist = kuchikomidao.find_station(list.get(0).getStation());

		request.setAttribute("list", list);
		request.setAttribute("kuchikomilist", kuchikomilist);
		session.setAttribute("station", list.get(0).getStation());
		session.setAttribute("code", searchForm.getCode());
		return mapping.findForward("usershow");
	}
}
