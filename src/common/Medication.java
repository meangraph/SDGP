package common;
import java.io.Serializable;
import java.util.ArrayList;

public class Medication implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int medicationID;
	private String brandName, chemicalName;
	private boolean controlled;
	private ArrayList<Medication> medications = new ArrayList<Medication>();
	private ArrayList<Medication> contraMedications = new ArrayList<Medication>();
	public Medication(int medicationID,String brandName, String chemicalName) {
		this.setMedicationID(medicationID);
		this.brandName = brandName;
		this.chemicalName = chemicalName;
	}
	public Medication() {
		// TODO Auto-generated constructor stub
	}
	public String getBrandName() {
		return brandName;
	}
	public String getChemicalName() {
		return chemicalName;
	}
	public String getContraMedications() {
		return this.getBrandName();
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public void setChemicalName(String chemicalName) {
		this.chemicalName = chemicalName;
	}
	public void setContraMedications(Medication x) {
		contraMedications.add(x);
	}
	public ArrayList<Medication> getMedications() {
		return medications;
	}
	public void setMedications(Medication x) {
		medications.add(x);
	}
	
	public int getMedicationID() {
		return medicationID;
	}
	public void setMedicationID(int medicationID) {
		this.medicationID = medicationID;
	}
	
	
	public String isControlled() {
		String prescribed = "";
		if (controlled == true) {
			prescribed = "Yes";
		}
		if (controlled == false) {
			prescribed = "No";
		}
		
		return prescribed;
	}
	public void setControlled(boolean controlled) {
		this.controlled = controlled;
	}
	@Override
	public String toString() {
		
		String medList = "";
		
		for(Medication meds: medications) {
			medList += meds.getBrandName();
		}
		
		return medList;
	}
}
