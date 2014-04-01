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

		//�f�[�^�x�[�X�֓o�^
		KuchikomiForm kuchikomiForm =  (KuchikomiForm) form;
		KuchikomiDAO dao = new KuchikomiDAO();
		int count = dao.create(kuchikomiForm);
		//���X�g��1���Ȃ烍�O�C������
		System.out.println(count);
		if(count == 1){
			request.getSession().removeAttribute("user_KuchikomiForm");
			request.getSession().removeAttribute("station");
			return mapping.findForward("success");
		}
		else{
			//���s�����ꍇ
			return mapping.getInputForward();
		}
	}
}
