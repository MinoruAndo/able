package user;

import org.apache.struts.action.ActionForm;

public class UserTopForm extends ActionForm {

	private int code = 0;
	private String name = null;
	private String text = null;
	private int people = 0;
	private long price = 0;
	private boolean pet = false;
	private String station = null;


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
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public boolean isPet() {
		return pet;
	}
	public void setPet(boolean pet) {
		this.pet = pet;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}




}
