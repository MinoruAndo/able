package user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import DB.UserInfo;
import DB.UserInfoDAO;

public class MypageAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//sessionの取得
		HttpSession session = request.getSession();
		//sessionの中からloginidを取り出す
		String loginid = (String) session.getAttribute("loginid");

		//if (userInfoform == null) {
			//データベースからデータの取出し
			UserInfoDAO dao = new UserInfoDAO();
			List<UserInfo> list = dao.find(loginid);
			System.out.println("MypageAction list.size(): " + list.size());
//			session.setAttribute("user_UserInfoForm",list.get(0));
			UserInfoForm f = new UserInfoForm();
			f.setLoginid(list.get(0).getLoginid());
			f.setMail(list.get(0).getMail());
			f.setPassword(list.get(0).getPassword());
			session.setAttribute("user_UserInfoForm",f);
		//}
		//else {
			//session.setAttribute("userInfo",userInfoform);
		//}

		return mapping.findForward("success");

		//画面遷移先
		//req.getRequestDispatcher("../web/user/hensyu.jsp").forward(req, resp);

	}

}
