package user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import DB.*;

public class KuchikomiCreateConfirmAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//データベースへ登録
		KuchikomiForm kuchikomiForm =  (KuchikomiForm) form;
		KuchikomiDAO dao = new KuchikomiDAO();
		int count = dao.create(kuchikomiForm);
		//リストが1件ならログイン成功
		System.out.println(count);
		if(count == 1){
			request.getSession().removeAttribute("user_KuchikomiForm");
			request.getSession().removeAttribute("station");
			return mapping.findForward("success");
		}
		else{
			//失敗した場合
			return mapping.getInputForward();
		}
	}
}
