package common;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Patient implements Serializable{

	
	private static final long serialVersionUID = 1L;
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
	private String emailAddress;
	private String nationallity;
	private Date dob;
	private int privateHealthCareNumber;
	private HashMap<Medication, String> currentMedications = new HashMap<Medication, String>();
	private ArrayList<Medication> medAllergies = new ArrayList<Medication>();
	private ArrayList<TreatmentPlan> treatmentPlan = new ArrayList<TreatmentPlan>();
	private ArrayList<Procedures> procedureList = new ArrayList<Procedures>();
	private ArrayList<String> diagnosisList = new ArrayList<String>();
	
	
	public Patient() {}
	
	public Patient(String patientID,int medicareNumber, String firstName, String lastName,String sex, String phoneNum, Address address, Doctor doctor, String nationallity) {
		super();
		this.patientID = patientID;
		this.medicareNumber = medicareNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.phoneNum = phoneNum;
		this.address = address;
		this.doctor = doctor;
		this.nationallity = nationallity;
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


	public TreatmentPlan getTreatmentPlan(int x) {
		return treatmentPlan.get(x);
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


	public String getEmailAddress() {
		return emailAddress;
	}

	public String getNationallity() {
		return nationallity;
	}

	public void setEmailAdress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setNationallity(String nationallity) {
		this.nationallity = nationallity;
	}

	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public void addDiagnosis(String x) {
		diagnosisList.add(x);
	}
	
	public String getDiagnosis() {
		String diag = "";
		if (diagnosisList.isEmpty()) {
			diag = "No active diagnosis for this patient";
		} else {
			for (String i : diagnosisList) {
				diag += i + ",";
			}
		}
		return diag;
	}
	
	
	public int getPrivateHealthCareNumber() {
		return privateHealthCareNumber;
	}

	public void setPrivateHealthCareNumber(int privateHealthCareNumber) {
		this.privateHealthCareNumber = privateHealthCareNumber;
	}

	public String getAge() {
		LocalDate curDate = LocalDate.now();
		LocalDate birthday = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		int age = Period.between(birthday, curDate).getYears();
		String ageString = Integer.toString(age);
		return ageString;
	}
	
	
	
	public void removeCurrentMedication(Medication x) {
		
		currentMedications.remove(x);
	}
	
	public void addMedications(Medication x, String y) {
		currentMedications.put(x, y);
	}
	
	public String getCurrentMeds() {
		String currentMeds = "";
		
		if (currentMedications.isEmpty()) {
			currentMeds = "No current medication for this patient";
		} else {
			for (Map.Entry<Medication,String> m: currentMedications.entrySet()) {
				currentMeds += ((Medication)m.getKey()).getBrandName() + ", " + m.getValue() + "\n";
			}
		} return currentMeds;
	}
	
	
	public String getMedAllergies() {
		String allergies = "";
		
		if(medAllergies.isEmpty()) {
			allergies = "No allergies for this patient";
		} else {
			for (int i = 0; i < medAllergies.size(); i++) {
				allergies += medAllergies.get(i).getBrandName();
			}
		}
		return allergies;
	}

	public void setMedAllergies(Medication x) {
		medAllergies.add(x);
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
