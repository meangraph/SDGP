package common;
import java.util.ArrayList;

public class Patient{

	private String patientID;
	private int medicareNumber;//Login ID
	private String firstName;
	private String lastName;
	private String sex;
	private String phoneNum;
	private Address address;
	private Doctor doctor;
	private int healthCareCard;
	private int pensionerNumber;
	private ArrayList<TreatmentPlan> treatmentPlan = new ArrayList<TreatmentPlan>();
	private ArrayList<Procedures> procedureList = new ArrayList<Procedures>();
	
	
	public Patient(String patientID,int medicareNumber, String firstName, String lastName,String sex, String phoneNum, Address address, Doctor doctor) {
		super();
		this.patientID = patientID;
		this.medicareNumber = medicareNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.phoneNum = phoneNum;
		this.address = address;
		this.doctor = doctor;
	}


	public int getMedicareNumber() {
		return medicareNumber;
	}


	public int getHealthCareCard() {
		return healthCareCard;
	}


	public int getPensionerNumber() {
		return pensionerNumber;
	}


	public void setMedicareNumber(int medicareNumber) {
		this.medicareNumber = medicareNumber;
	}


	public void setHealthCareCard(int healthCareCard) {
		this.healthCareCard = healthCareCard;
	}


	public void setPensionerNumber(int pensionerNumber) {
		this.pensionerNumber = pensionerNumber;
	}


	public String getPatientID() {
		return patientID;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public Address getAddress() {
		return address;
	}


	public Doctor getDoctor() {
		return doctor;
	}


	public ArrayList<TreatmentPlan> getTreatmentPlan() {
		return treatmentPlan;
	}


	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	public void setTreatmentPlan(TreatmentPlan x) {
		treatmentPlan.add(x);
	}

	public ArrayList<Procedures> getProcedureList() {
		return procedureList;
	}


	public void setProcedureList(Procedures x) {
		procedureList.add(x);
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	@Override
	public String toString() {
		
		StringBuilder proList = new StringBuilder();
		
		for(Procedures procedure: procedureList) {
			proList.append(procedure).append(" ");
		}
		
		StringBuilder TPlanString = new StringBuilder();
		
		for(TreatmentPlan tPlan: treatmentPlan) {
			TPlanString.append(tPlan).append(" ");
		}
		
		return "Patient ID: " + patientID + "\nMedicare Number: " + medicareNumber +"\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nSex: " + sex + "\nPhone Number: " 
				+ phoneNum + "\nAddress: " + address + "\nDoctor: " + doctor.getFirstName() + " " + doctor.getLastName() + "\n\nProcedures:\n" + proList
				+  "\n\nTreatment Plan:\n" + TPlanString;
	}
}
