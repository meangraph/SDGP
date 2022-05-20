package common;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class Prescription implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String diagnosis;
	private Patient patient;
	private Doctor doctor;
	private HashMap<Medication, String> prescriptionMedications = new HashMap<Medication, String>();
	private ArrayList<Integer> repeats = new ArrayList<>();
	private String qrCode;
	private String drNotes;
	private ArrayList<String> frequency = new ArrayList<String>();
	
	public Prescription() {}
	public Prescription(String diagnosis, Patient patient, Doctor doctor, String qrCode, String drNotes) {
		super();
		this.diagnosis = diagnosis;
		this.patient = patient;
		this.doctor = doctor;
		this.qrCode = qrCode;
		this.drNotes = drNotes;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public Patient getPatient() {
		return patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public int getRepeats(int x) {
		return repeats.get(x);
	}
	public String getQrCode() {
		return qrCode;
	}
	public String getDrNotes() {
		return drNotes;
	}
	
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public void addMedications(Medication x, String y) {
		prescriptionMedications.put(x, y);
	}
	
	public String getFrequency(int x) {
		return frequency.get(x);
	}
	public void setFrequency(String x) {
		frequency.add(x);
	}
	public void setRepeats(int x) {
		repeats.add(x);
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	public void setDrNotes(String drNotes) {
		this.drNotes = drNotes;
	}
	public String generateQRCode() {
		String charCodes = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder sb = new StringBuilder();
		Random ran = new Random();
		String qrCode;
		int i = 0;
		
		while(i < 10) {
			sb.append(charCodes.charAt(ran.nextInt(charCodes.length())));
			i++;
		}
		qrCode = sb.toString();
		return qrCode;
		
	}
	public void generateQRImage() throws WriterException, IOException {
		String imageName = this.getQrCode()+".jpg";
		String data = this.getQrCode();
		String path = "C:\\Users\\B\\eclipse-workspace\\EPS\\QRCodes\\"+imageName;
		BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 300, 300);
		
		MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
	}
	
	
	
	public HashMap<Medication, String> getPrescriptionMedications() {
		return prescriptionMedications;
	}
	@Override
	public String toString() {
		return "Prescription [diagnosis=" + diagnosis + ", patient=" + patient + ", doctor=" + doctor.getFirstName() + doctor.getLastName()
				+ ", prescriptionMedications=" + prescriptionMedications + ", repeats=" + repeats + ", qrCode=" + qrCode
				+ ", drNotes=" + drNotes + ", frequency=" + frequency + "]";
	}

}
