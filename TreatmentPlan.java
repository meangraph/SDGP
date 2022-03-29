import java.util.ArrayList;

public class TreatmentPlan{
	
	private ArrayList<Medication> currentMedications = new ArrayList<Medication>();
	private ArrayList<Medication> medicationAllergies = new ArrayList<Medication>();
	//private ArrayList<Procedures> procedures = new ArrayList<Procedures>();
	private ArrayList<String> doctorsNotes = new ArrayList<String>();
	public TreatmentPlan() {
		super();
		
	}
	public ArrayList<Medication> getCurrentMecications() {
		return currentMedications;
	}
	public ArrayList<Medication> getMedicationAllergies() {
		return medicationAllergies;
	}
//	public ArrayList<Procedures> getProcedures() {
//		return procedures;
//	}
	public ArrayList<String> getDoctorsNotes() {
		return doctorsNotes;
	}
	public void setCurrentMecications(Medication x) {
		currentMedications.add(x);
	}
	public void setMedicationAllergies(Medication x) {
		medicationAllergies.add(x);
	}
//	public void setProcedures(Procedures x) {
//		procedures.add(x);
//	}
	public void setDoctorsNotes(String x) {
		doctorsNotes.add(x);
	}
	@Override
	public String toString() {
		
		String currentMedList = "";
		
		for(Medication medication : currentMedications) {
			currentMedList += medication.getBrandName() + ", ";
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

