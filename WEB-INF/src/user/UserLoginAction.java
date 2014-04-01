package user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import DB.UserInfo;
import DB.UserInfoDAO;

public class UserLoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//フォームの内容を取り出す
		UserLoginForm userLoginForm = (UserLoginForm) form;

		//データベースから値を取り出しリストにセット
		UserInfoDAO dao = new UserInfoDAO();

		// userLoginFormからUserInfoFormへデータをコピー
		UserInfoForm f = new UserInfoForm();
		f.setLoginid(userLoginForm.getId());
		f.setPassword(userLoginForm.getPassword());
		List<UserInfo> list = dao.find(f);

		//リストが1件ならログイン成功
//		System.out.println("UserLoginActionのログインID検索結果：" + list.size());
		if(list.size() == 1){
			HttpSession userInfoSession = request.getSession();
			userInfoSession.setAttribute("loginid", list.get(0).getLoginid());

			// 画面遷移のためパラメータ取得
			String str = request.getParameter("gamen");
			System.out.println("画面遷移のためパラメータ取得:" + str);
			if ("".equals(str)) {
				return mapping.findForward("usertop");
			}
			else {
				return mapping.findForward("kuchikomi");
			}
		}
		else{
			//失敗した場合
//			// JSPにメッセージを表示
			ActionMessages messages = new ActionMessages();
			messages.add("mes1", new ActionMessage("errors.login"));

			System.out.println("メッセージ:" + messages.get("mes1"));
			this.saveMessages(request, messages);
			return mapping.getInputForward();
		}
	}
}
