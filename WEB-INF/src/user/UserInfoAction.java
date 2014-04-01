package user;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import DB.UserInfo;
import DB.UserInfoDAO;

public class UserInfoAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//�t�H�[���̓��e�����o��
		UserInfoForm userInfoForm = (UserInfoForm) form;
		System.out.println("userLoginForm " + userInfoForm);
		String loginid = userInfoForm.getLoginid();
		String mail = userInfoForm.getMail();
		Date adddate = userInfoForm.getAdddate();
		String password = userInfoForm.getPassword();
		//�f�[�^�x�[�X����l�����o�����X�g�ɃZ�b�g
		UserInfoDAO dao = new UserInfoDAO();
		List<UserInfo> list = dao.find(userInfoForm);
		//���X�g��1���Ȃ烍�O�C������
		System.out.println(list.size());
		if(list.size() == 1){
			request.setAttribute("list", list);
			return mapping.findForward("success");
		}
		else{
			//���s�����ꍇ
			return mapping.getInputForward();
		}
	}
}
