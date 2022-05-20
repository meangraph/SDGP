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
	
	private String diagnosis;
	private ArrayList<Medication> patientMeds = new ArrayList<>();
	private ArrayList<String> doctorsNotes = new ArrayList<String>();
	

	public TreatmentPlan() {
		// TODO Auto-generated constructor stub
	}
	
	

	public String getDiagnosis() {
		return diagnosis;
	}



	public ArrayList<Medication> getPatientMeds() {
		return patientMeds;
	}



	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}



	public void setPatientMeds(Medication x) {
		patientMeds.add(x);
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


	public void setDoctorsNotes(String x) {
		doctorsNotes.add(x);
	}

	
	@Override
	public String toString() {
		
		
	//	for (int i = 0; i < currentMedications2.size();i++) {
	//		currentMedList += currentMedications2.get(i) + " " + dosage.get(i) + ", ";
	//	}
		
		
		String notes = "";
		
		for(String note: doctorsNotes) {
			notes += note + ",";
		}	
		
		return "Current Medications: "  + "\nAllergies: "
				+ "\nDoctors Notes: " + notes + "\n";
	}
	
}

