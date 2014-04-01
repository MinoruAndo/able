package admin_usermanager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import DB.UserInfo;
import DB.UserInfoDAO;

public class UserManager extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UserDelForm userDelForm =  (UserDelForm) form;

		UserInfoDAO dao = new UserInfoDAO();

		List<UserInfo> result = dao.find(userDelForm.getLoginid());
		if(result.isEmpty()){
			request.getSession().removeAttribute("admin_usermanager_UserDelForm");
			return mapping.findForward("failure");
		} else {
			return mapping.findForward("success");
		}
	}
}
