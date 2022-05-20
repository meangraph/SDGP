package common;
import java.io.Serializable;
import java.util.ArrayList;

public class Doctor implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String doctorID;
	private String firstName, lastName;
	private String password;
	private Address address; //address of the doctors workplace
	
	public Doctor(String doctorID,String password, String firstName, String lastName, Address address) {
		super();
		this.doctorID = doctorID;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	public String getDoctorID() {
		return doctorID;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Address getAddress() {
		return address;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Doctor ID:" + doctorID + "\nFirst Name:" + firstName + "\nLast Name:" + lastName + "\nSurgery Address: "
				+ address;
	}
	
}
