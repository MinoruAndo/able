package user;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import DB.UserInfo;
import DB.UserInfoDAO;

public class UserInfoCreateAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession userInfoSession = request.getSession();
		//フォームの内容を取り出す
		UserInfoForm userInfoForm = (UserInfoForm) form;
		System.out.println("画面から取得したform: " + userInfoForm);
		String loginid = userInfoForm.getLoginid();
		String mail = userInfoForm.getMail();
		String password = userInfoForm.getPassword();

		// 内容の確認
		UserInfoDAO dao = new UserInfoDAO();
		List<UserInfo> list = null;
		if (loginid != null && loginid.length() != 0) {
			if (password != null && password.length() != 0) {
				list = dao.find(userInfoForm.getLoginid());
				System.out.println("UserInfoCreateAction : " + list.size());
			}
		}

		// 内容がデータにあるかどうか
		if (list != null && list.size() == 0) {
			// 確認画面へ遷移
			System.out.println("セッション" + userInfoSession.getAttribute("userInfo"));
			return mapping.findForward("success");
		}
		else{
			//失敗した場合
//			ActionErrors errors = new ActionErrors();
//			errors.add("mail", new ActionError("string.unique"));
//
//			this.saveMessages(request, errors);
//			System.out.println("エラーメッセージ:" + errors.get("mail"));
//			return mapping.getInputForward();

//			// JSPにメッセージを表示
			ActionMessages messages = new ActionMessages();
			messages.add("mes1", new ActionMessage("errors.unique"));

			System.out.println("メッセージ:" + messages.get("mes1"));
			this.saveMessages(request, messages);
			return mapping.findForward("failuer");

		}
	}
}
