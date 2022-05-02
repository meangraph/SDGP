package common;

import java.util.ArrayList;

public class Database {
	private ArrayList<Patient> patients = new ArrayList<Patient>();
	private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	private ArrayList<Pharmacy> pharmacy = new ArrayList<Pharmacy>();
	
	public ArrayList<Patient> getPatients() {
		return patients;
	}
	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}
	public ArrayList<Pharmacy> getPharmacy() {
		return pharmacy;
	}
	public Patient getPatientsAt(int x) {
		return patients.get(x);
	}
	public Doctor getDoctorsAt(int x) {
		return doctors.get(x);
	}
	public Pharmacy getPharmacyAt(int x) {
		return pharmacy.get(x);
	}
	public void setPatients(Patient x) {
		patients.add(x);
	}
	public void setDoctors(Doctor x) {
		doctors.add(x);
	}
	public void setPharmacy(Pharmacy x) {
		pharmacy.add(x);
	}

}
