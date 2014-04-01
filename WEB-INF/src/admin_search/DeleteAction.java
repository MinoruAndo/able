package admin_search;

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

public class DeleteAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SearchForm searchForm =(SearchForm)form;
		HttpSession session = request.getSession();
		SearchForm form2 = (SearchForm)session.getAttribute("form");

		RoomDAO dao = new RoomDAO();
		String check = null;
		String delete = null;
		String back = null;
		check = request.getParameter("check");
		delete = request.getParameter("delete");
		back = request.getParameter("back");



		if(delete != null){
			//削除処理
			int count = dao.Delete(searchForm.getCode());
			//削除後の検索処理
			List<Room> list = dao.findAll(form2);

			request.setAttribute("list", list);
			return mapping.findForward("delete");

		}else if (check != null){

			//削除確認処理
			List<Room> list = dao.DeleteCheck(searchForm.getCode());

			request.setAttribute("list", list);
			return mapping.findForward("check");

		}else if (back != null) {
			//削除確認画面から戻る処理
			List<Room> list = dao.findAll(form2);
			System.out.println(form2.getCode());

			request.setAttribute("list", list);
			return mapping.findForward("delete");
		}

		return mapping.findForward("success");

	}

}
