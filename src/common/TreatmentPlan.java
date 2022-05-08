package common;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TreatmentPlan implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Medication> medicationAllergies = new ArrayList<Medication>();
	private ArrayList<String> doctorsNotes = new ArrayList<String>();
	

	public TreatmentPlan() {
		// TODO Auto-generated constructor stub
	}

	public String getMedicationAllergies() {
		
		if (medicationAllergies.isEmpty()) {
			return "No medication allergies";
		}
		
		else {
		String medsAllergies = "";
		for (int i = 0; i < medicationAllergies.size(); i++) {
			medsAllergies += medicationAllergies.get(i).getBrandName();
		}
		
		return medsAllergies;
		}
	}

	public String getDoctorsNotes() {
		String notes = "";
		
		if (doctorsNotes.isEmpty()) {
			notes = "No current doctors notes";
			return notes;
		} else {
			for (int i = 0; i < doctorsNotes.size();i++) {
				notes += doctorsNotes.get(i) + "\n";
			}
			return notes;
		}
	}

	public void setMedicationAllergies(Medication x) {
		medicationAllergies.add(x);
	}

	public void setDoctorsNotes(String x) {
		doctorsNotes.add(x);
	}

	
	@Override
	public String toString() {
		
		
	//	for (int i = 0; i < currentMedications2.size();i++) {
	//		currentMedList += currentMedications2.get(i) + " " + dosage.get(i) + ", ";
	//	}
		
		String allergyList = "";
		
		for(Medication allergy: medicationAllergies) {
			allergyList += allergy.getBrandName() + ", ";
		}
		
		String notes = "";
		
		for(String note: doctorsNotes) {
			notes += note + ",";
		}	
		
		return "Current Medications: "  + "\nAllergies: "
				+ allergyList + "\nDoctors Notes: " + notes + "\n";
	}
	
}

