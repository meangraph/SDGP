package common;

public class Address {
	
	private String houseNum,streetName,suburb,state,postCode;

	public Address(String houseNum, String streetName, String suburb, String state, String postCode) {
		this.houseNum = houseNum;
		this.streetName = streetName;
		this.suburb = suburb;
		this.state = state;
		this.postCode = postCode;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getSuburb() {
		return suburb;
	}

	public String getState() {
		return state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Override
	public String toString() {
		return houseNum + " " + streetName + " " + suburb + " " + state + " " + postCode + " Australia";
	}
	
}
