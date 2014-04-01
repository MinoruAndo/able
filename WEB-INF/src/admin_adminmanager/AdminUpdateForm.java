package admin_adminmanager;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class AdminUpdateForm extends ActionForm {
	private String loginid = null;
	private int staffNo;
	private Date adddate = null;
	private String password = null;

	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public int getStaffNo() {
		return staffNo;
	}
	public void setStaffNo(int staffNo) {
		this.staffNo = staffNo;
	}
	public Date getAdddate() {
		return adddate;
	}
	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
