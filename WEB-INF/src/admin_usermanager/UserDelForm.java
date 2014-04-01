package admin_usermanager;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class UserDelForm extends ActionForm {
	private String loginid = null;

	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

}
