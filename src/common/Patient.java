package common;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Patient implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String patientID;
	private String password;
	private int medicareNumber;//Login ID
	private String firstName;
	private String lastName;
	private String sex;
	private String phoneNum;
	private Address address;
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
	private ArrayList<String> frequency = new ArrayList<String>();
	private ArrayList<Prescription> prescriptionList = new ArrayList<>();

	
	
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



	public TreatmentPlan getTreatmentPlanData(int x) {
		return treatmentPlan.get(x);
	}


	public ArrayList<TreatmentPlan> getTreatmentPlan() {
		return treatmentPlan;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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



	public void setTreatmentPlan(TreatmentPlan x) {
		treatmentPlan.add(x);
	}

	public ArrayList<Procedures> getProcedureList() {
		return procedureList;
	}


	public void setProcedureList(Procedures x) {
		procedureList.add(x);
	}


	public ArrayList<Prescription> getPrescriptionList() {
		return prescriptionList;
	}

	public void prescriptionList(ArrayList<Prescription> prescriptionList) {
		this.prescriptionList = prescriptionList;
	}
	
	public void setPrescriptionList(Prescription x) {
		prescriptionList.add(x);
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
			diag = diagnosisList.get(diagnosisList.size()-1);
			}
		return diag;
	}
	
	public String getDiagnosisList() {
		String diag = "";
		if (diagnosisList.isEmpty()) {
			diag = "No active diagnosis for this patient";
			return diag;
		} else {
			for (String i : diagnosisList) {
				diag += i + "\n";
			}
		}
		return diag;
	}
	
	public String getDiagnosisListAt(int x) {
		return diagnosisList.get(x);
	}
	public String getFrequency() {
		String freq = "";
		if (frequency.isEmpty()) {
			return freq;
		}
		for  (String  i:  frequency) {
			freq += i;
		}
		return freq;
	}

	public void setFrequency(String x) {
		frequency.add(x);
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
	
	public void removeAllMedications() {
		currentMedications.clear();
		frequency.clear();
	}
	
	public void removeCurrentMedication(Medication x) {
		
		currentMedications.remove(x);
		diagnosisList.remove(x);
		frequency.remove(x);
	}
	
	public void addMedications(Medication x, String y) {
		currentMedications.put(x, y);
	}
	
	

	public HashMap<Medication, String> getCurrentMedicationsMap() {
		return currentMedications;
	}

	public String getCurrentMeds() {
		String currentMeds = "";
		
		if (currentMedications.isEmpty()) {
			currentMeds = "No current medication for this patient";
			return currentMeds;
		} else {
			
			for (Map.Entry<Medication,String> m: currentMedications.entrySet()) {
				for (int i = 0; i < diagnosisList.size();i++) {
					int index = 0;
					try {
				currentMeds += ((Medication)m.getKey()).getBrandName() + ": " + m.getValue() + " " + frequency.get(index) + " for " + diagnosisList.get(index) + "\n";
					}catch(IndexOutOfBoundsException e) {
						System.out.print("No medications for patients");
					}
				index++;
			}
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
	
	public Medication getMedicationAllergies() {
		for (Medication i: medAllergies) {
			return i;
		}
		
		return null;
		
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
				+ phoneNum + "\nAddress: " + address +  "\n\nProcedures:\n" + proList
				+  "\n\nTreatment Plan:\n" + TPlanString;
	}
}
