import java.util.ArrayList;

public class Patient{

	private String patientID;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private Address address;
	private Doctor doctor;
	private ArrayList<TreatmentPlan> treatmentPlan = new ArrayList<TreatmentPlan>();
	private ArrayList<Procedures> procedureList = new ArrayList<Procedures>();
	
	
	public Patient(String patientID, String firstName, String lastName, String phoneNum, Address address, Doctor doctor) {
		super();
		this.patientID = patientID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.address = address;
		this.doctor = doctor;
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


	@Override
	public String toString() {
		
		String procedureString = "";
		
		for (Procedures procedures: procedureList) {
			
			
			procedureString += procedures.getProcedureName() + " " +  procedures.getProcedureNotes() + " " + procedures.getContraMedication() + ",";
		}
		
		String TPlanString = "";
		
		for(TreatmentPlan tPlan: treatmentPlan) {
			TPlanString += "Current Medications: " + tPlan.getCurrentMecications() + "\nMedication Allergies: " + tPlan.getMedicationAllergies()
			+ "\nDoctors Notes: " + tPlan.getDoctorsNotes();
		}
		
		return "Patient ID: " + patientID + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nPhone Number: "
				+ phoneNum + "\nAddress: " + address + "\nDoctor: " + doctor.getFirstName() + " " + doctor.getLastName() + "\n\nProcedures:\n\n" + getProcedureList().toString()
				+  "\n\nTreatment Plan:" + TPlanString;
	}
}
