
public class EPS {

	public static void main(String[] args) {
		
	Address address1 = new Address("51","Fake Street","Wollongong","NSW", "2000");	
	Doctor doctor1 = new Doctor("0231","Brendan","Alderton", address1);
	
	//System.out.println(doctor1); Doctor and Address object fine
	
	Medication medication1 = new Medication(100,"Panadol","Paracitamol");
	Medication medication2 = new Medication(101,"Asprin","Yeet");
	
	medication1.setMedications(medication1);
	medication2.setMedications(medication2);
	
	medication1.setContraMedications(medication2);
	medication2.setContraMedications(medication1);

//	System.out.println(medication1);// Medication objects working fine
//	System.out.println(medication2);
	
	Procedures procedure1 = new Procedures("General Surgery");
	procedure1.setProcedureNotes("Test Note for procedures");
	procedure1.setContraMedication(medication1);
	procedure1.setProcesures(procedure1);
	
	//System.out.println(procedure1); //Procedure working fine
	
	Patient patient1 = new Patient("677016", "Brendan", "Alderton","Male" ,"0435888999", address1, doctor1);
	
	patient1.setProcedureList(procedure1);
	
	TreatmentPlan treatmentPlan1 = new TreatmentPlan();
	treatmentPlan1.setDoctorsNotes("Test note for Treatments");
	treatmentPlan1.setCurrentMecications(medication2);
	treatmentPlan1.setDosage("30mg/When needed");
	treatmentPlan1.setMedicationAllergies(medication1);
	treatmentPlan1.setCurrentMecications(medication1);
	treatmentPlan1.setDosage("40mg/ every hour");

	
	//System.out.println(treatmentPlan1);
	
	treatmentPlan1.removeCurrentMedication(medication2);
	
	//System.out.println(treatmentPlan1);
	
	patient1.setTreatmentPlan(treatmentPlan1);
	
	//System.out.println(patient1);//works good now
	
	Pharmacy pharmacy1 = new Pharmacy(3001,address1);
	
	pharmacy1.setStockList(medication2, 32);
	
	System.out.println(pharmacy1);
	
	}

}
