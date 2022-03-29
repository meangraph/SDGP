import java.util.ArrayList;

public class Medication{
	
	private String brandName, chemicalName;
	private ArrayList<Medication> medications = new ArrayList<Medication>();
	private ArrayList<Medication> contraMedications = new ArrayList<Medication>();
	public Medication(String brandName, String chemicalName) {
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
	
	
	@Override
	public String toString() {
		
		String medList = "";
		
		for(Medication meds: medications) {
			medList += meds.getBrandName() + ", ";
		}
		
		return "Brand Name: " + brandName + "\nChemical Name: " + chemicalName + "\nContra Medications: "
				+ medList + "\n";
	}
}
