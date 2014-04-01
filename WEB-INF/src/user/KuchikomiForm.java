package user;

import org.apache.struts.validator.ValidatorForm;

public class KuchikomiForm extends ValidatorForm {
	private String station;
	private String kuchikomi;
	private String loginid;
	private int addNo;

	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getKuchikomi() {
		return kuchikomi;
	}
	public void setKuchikomi(String kuchikomi) {
		this.kuchikomi = kuchikomi;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public int getAddNo() {
		return addNo;
	}
	public void setAddNo(int addNo) {
		this.addNo = addNo;
	}

}
