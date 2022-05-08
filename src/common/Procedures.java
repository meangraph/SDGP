package common;
import java.io.Serializable;
import java.util.ArrayList;

public class Procedures implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String procedureName;
	private ArrayList<String> procedureNotes = new ArrayList<String>();
	private ArrayList<Medication> contraMedication = new ArrayList<Medication>();
	private ArrayList<Procedures> procedures = new ArrayList<Procedures>();
	public Procedures(String procedureName) {
		this.procedureName = procedureName;

	}
	public ArrayList<Medication> getContraMedication() {
		return contraMedication;
	}
	public void setProcedureNotes(ArrayList<String> procedureNotes) {
		this.procedureNotes = procedureNotes;
	}
	public String getProcedureName() {
		return procedureName;
	}
	public ArrayList<String> getProcedureNotes() {
		return procedureNotes;
	}
	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}
	public void setProcedureNotes(String x) {
		procedureNotes.add(x);
	}
	public void setContraMedication(Medication x) {
		contraMedication.add(x);
	}
	public ArrayList<Procedures> getProcesures() {
		return procedures;
	}
	public void setProcesures(Procedures x) {
		procedures.add(x);
	}
	@Override
	public String toString() {
		
		String cMedications = "";
		
		for(Medication contraMeds: contraMedication) {
			cMedications += contraMeds.getBrandName() + ",";
		}
		
		String notes = "";
		
		for(String note: procedureNotes) {
			notes += note + ",";
		}
		
		return  "\nProcedure Name: " + procedureName + "\nProcedure Notes: " + notes
				+ "\nContra Medications: " + cMedications;
	}
	
	
	
}
