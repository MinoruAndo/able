//アクション

package admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import DB.Admin;
import DB.AdminDAO;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//フォームの内容を取り出す
		LoginForm loginForm = (LoginForm) form;
		//データベースから値を取り出しリストにセット
		AdminDAO dao = new AdminDAO();
		List<Admin> list = dao.find(loginForm);
		//リストが1件ならログイン成功
		if(list.size() == 1){
			request.setAttribute("list", list);
			HttpSession adminSession = request.getSession();
			adminSession.setAttribute("adminlogin", list.get(0).getId());
			return mapping.findForward("success");
		}
		else{
			//失敗した場合
			return mapping.getInputForward();
		}
	}
}
