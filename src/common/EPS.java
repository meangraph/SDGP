package common;
import views.LandingPage;
import java.util.ArrayList;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.*;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class EPS {

	public static void main(String[] args) throws WriterException, IOException {
	ArrayList<Patient> patient = new ArrayList<Patient>();
	ArrayList<Medication> medication = new ArrayList<Medication>();
	LandingPage gui = new LandingPage();
	gui.setVisible(true);
	Address address1 = new Address("51","Fake Street","Wollongong","NSW", "2000");	
	Doctor doctor1 = new Doctor("0231","Brendan","Alderton", address1);
	
	String data = "www.uow.edu.au";
	String path = "C:\\Users\\B\\eclipse-workspace\\EPS\\src\\test.jpg";
	
	
	BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 500, 500);
	
	MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
	
	
	//System.out.println(doctor1); Doctor and Address object fine
	
	Medication medication1 = new Medication(100,"Panadol","Paracitamol");
	Medication medication2 = new Medication(101,"Asprin","Yeet");
	medication1.setControlled(false);
	medication2.setControlled(false);
	
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
	
	Patient patient1 = new Patient("677016",1233212, "Brendan", "Alderton","Male" ,"0435888999", address1, doctor1,"Australian");
	patient1.setProcedureList(procedure1);
	Patient patient2 = new Patient("6777016",555555,"Jack","White","Female","053254323",address1,doctor1,"New Zealand");
	
	TreatmentPlan treatmentPlan1 = new TreatmentPlan();
	treatmentPlan1.setMedicationAllergies(medication1);
	treatmentPlan1.setDoctorsNotes("Test for doctors notes");
	String dob1 = "01/08/1985";
	String dob2 = "20/11/1992";
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	try {
		patient1.setDob(formatter.parse(dob1));
		patient2.setDob(formatter.parse(dob2));
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	patient1.addDiagnosis("Big old goofy head");
	patient1.addMedications(medication2, "40mg taken when needed");
	patient1.addMedications(medication1, "Whenever you feel like fam");
	
	//System.out.println(treatmentPlan1);
	
	
	//System.out.println(treatmentPlan1);
	
	patient1.setTreatmentPlan(treatmentPlan1);
	patient1.setHealthCareCard(120334823);
	
	TreatmentPlan tplan2 = new TreatmentPlan();
	patient2.setTreatmentPlan(tplan2);
	
	
	System.out.println(patient1);//works good now
	System.out.println(patient1.getHealthCareCard());
	
	Pharmacy pharmacy1 = new Pharmacy(3001,address1);
	
	pharmacy1.setStockList(medication2, 32);
	System.out.println(pharmacy1);
	pharmacy1.dispenceStock(medication2, 2);
	
	patient1.setEmailAdress("ba449@uowmail.edu.au");
	System.out.println(pharmacy1);
	
	patient1.setPrivateHealthCareNumber(2312312);
	
	patient.add(patient2);
	patient.add(patient1);
	medication.add(medication1);
	medication.add(medication2);
	
	
	
	
//	try {
//		FileInputStream patients = new FileInputStream("patients.txt");
//		ObjectInputStream objectIn = new ObjectInputStream(patients);
//		
//		ArrayList<Patient> patientList = (ArrayList<Patient>) objectIn.readObject();
//		
//		System.out.println(patientList.size());
//		
//		for (int i = 0; i < patientList.size();i++) {
//			System.out.println(patientList.get(i).getFirstName());
//			System.out.println(patientList.get(i).getPensionerNumber());
//		}
//		
//		objectIn.close();
//		
//	} catch (IOException | ClassNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
	
	
	//try {
		//FileOutputStream patients = new FileOutputStream("patients.txt");
		//FileOutputStream medications = new FileOutputStream("medications.txt");
		
		//ObjectOutputStream patientsOutput = new ObjectOutputStream(patients);
		//ObjectOutputStream medicationOutput = new ObjectOutputStream(medications);
		
	//	patientsOutput.writeObject(patient);
		//medicationOutput.writeObject(medication);
	//	patientsOutput.close();
		//medicationOutput.close();
		
//	} catch (IOException e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
	}
	
}
