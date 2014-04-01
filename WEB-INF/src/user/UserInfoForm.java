package user;

import java.util.Date;

import org.apache.struts.validator.ValidatorForm;

public class UserInfoForm extends ValidatorForm {
	private String loginid = null;
	private String mail = null;
	private Date adddate = null;
	private String password = null;

	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getAdddate() {
		return adddate;
	}
	public void setAdddate(java.sql.Date adddate) {
		this.adddate = adddate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
