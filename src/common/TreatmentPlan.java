package common;
import java.util.ArrayList;

public class TreatmentPlan{
	
	private ArrayList<Medication> currentMedications = new ArrayList<Medication>();
	private ArrayList<Medication> medicationAllergies = new ArrayList<Medication>();
	private ArrayList<String> doctorsNotes = new ArrayList<String>();
	private ArrayList<String> dosage = new ArrayList<String>();

	public TreatmentPlan() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Medication> getCurrentMecications() {
		return currentMedications;
	}
	public ArrayList<Medication> getMedicationAllergies() {
		return medicationAllergies;
	}

	public ArrayList<String> getDoctorsNotes() {
		return doctorsNotes;
	}
	public void setCurrentMecications(Medication x) {
		currentMedications.add(x);
	}
	public void setMedicationAllergies(Medication x) {
		medicationAllergies.add(x);
	}

	public void setDoctorsNotes(String x) {
		doctorsNotes.add(x);
	}

	public ArrayList<String> getDosage() {
		return dosage;
	}

	public void setDosage(String x) {
		dosage.add(x);
	}

	public void removeCurrentMedication(Medication x) {
		
		int y = currentMedications.indexOf(x);//gets index of the medication we are removing
		currentMedications.remove(x);//remove the medication from the currentMedications list
		dosage.remove(y);//remove the dosage note at the index of the 
	}
	
	@Override
	public String toString() {
		
		String currentMedList = "";
		
		for (int i = 0; i < currentMedications.size();i++) {
			currentMedList += currentMedications.get(i).getBrandName() + " " + dosage.get(i) + ", ";
		}
		
		String allergyList = "";
		
		for(Medication allergy: medicationAllergies) {
			allergyList += allergy.getBrandName() + ", ";
		}
		
		String notes = "";
		
		for(String note: doctorsNotes) {
			notes += note + ",";
		}	
		
		return "Current Medications: " + currentMedList + "\nAllergies: "
				+ allergyList + "\nDoctors Notes: " + notes + "\n";
	}
	
}

