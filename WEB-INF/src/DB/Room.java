package DB;

public class Room {

    private int code;
    private String name;
    private String text;
    private int people;
    private int price;
    private boolean pet;
    private String address;
    private String photo;
    private String station;

    private int code2;
    private String name2;
    private String text2;
    private int people2;
    private int price2;
    private boolean pet2;
    private String address2;
    private String photo2;
    private String station2;

    public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
		this.code2 = code;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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

}
