package user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import DB.Room;
import DB.RoomDAO;

import admin_search.SearchForm;

public class TopAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		SearchForm searchForm = (SearchForm) form;
//		String id = loginForm.getId();
//		String password = loginForm.getPassword();

		RoomDAO dao = new RoomDAO();
		List<Room> list = dao.findAll(searchForm);

		System.out.println(list.size());
		if(list.size() == 1){
			request.setAttribute("list", list);
			return mapping.findForward("success");
		}
		else{
			return mapping.getInputForward();
		}
	}
}
