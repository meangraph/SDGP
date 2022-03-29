import java.util.ArrayList;

public class Doctor {
		
	private String doctorID;
	private String firstName, lastName;
	private Address address; //address of the doctors workplace
	private ArrayList<Patient> patientList = new ArrayList<Patient>();
	
	public Doctor(String string, String firstName, String lastName, Address address) {
		super();
		this.doctorID = string;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	public String getDoctorID() {
		return doctorID;
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
	public ArrayList<Patient> getPatientList() {
		return patientList;
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
	public void setPatientList(Patient x) {
		patientList.add(x);
	}
	@Override
	public String toString() {
		return "Doctor ID:" + doctorID + "\nFirst Name:" + firstName + "\nLast Name:" + lastName + "\nSurgery Address: "
				+ address;
	}
	
}
