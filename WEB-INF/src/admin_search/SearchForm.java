package admin_search;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class SearchForm extends ActionForm {

	private int code;
    private String name;
    private String text;
    private int people;
    private int pricemin;
    private int pricemax;
    private boolean pet;
    private String address;
    private String photo;
    private String station;


    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public int getPricemin() {
		return pricemin;
	}
	public void setPricemin(int pricemin) {
		this.pricemin = pricemin;
	}
	public int getPricemax() {
		return pricemax;
	}
	public void setPricemax(int pricemax) {
		this.pricemax = pricemax;
	}
	public boolean isPet() {
		return pet;
	}
	public void setPet(boolean pet) {
		this.pet = pet;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		setPet(false);
	}

}
