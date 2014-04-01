//アクションフォーム

package admin;

import org.apache.struts.validator.ValidatorForm;

public class LoginForm extends ValidatorForm {

	private String id = null;
	private String password = null;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pasword) {
		this.password = pasword;
	}
}
