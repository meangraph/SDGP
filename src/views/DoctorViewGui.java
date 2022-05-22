package views;
import common.Doctor;
import common.Medication;
import common.Patient;
import common.Prescription;
import common.TreatmentPlan;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import java.awt.Font;
import java.io.*;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.zxing.WriterException;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoctorViewGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMedicareNumber;
	private JTextField txtPrivateHeathcareNumber;
	private JTextField txtPensionerNumber;
	public Patient currentPatient;
	public Doctor currentDoctor;
	ArrayList<Medication> medsList = new ArrayList<Medication>();
	private JTable prescriptionTable;
	private JTable contraTable;
	private JTextField tfSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorViewGui frame = new DoctorViewGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DoctorViewGui() {
		initComponents();
		
	}
	public DoctorViewGui(int x) {
		try {
			FileInputStream patients = new FileInputStream("patients.txt");
			ObjectInputStream objectIn = new ObjectInputStream(patients);
			FileInputStream medication = new FileInputStream("medications.txt");
			FileInputStream doctor = new FileInputStream("doctors.txt");
			ObjectInputStream doctorsIn = new ObjectInputStream(doctor);
			ArrayList<Patient> patientList = (ArrayList<Patient>) objectIn.readObject();
			ArrayList<Doctor> doctorsList = (ArrayList<Doctor>) doctorsIn.readObject();
			ObjectInputStream medsIn = new ObjectInputStream(medication);
			medsList = (ArrayList<Medication>) medsIn.readObject();
			currentPatient = patientList.get(2);
			currentDoctor = doctorsList.get(x);
			medsIn.close();
			objectIn.close();
			doctorsIn.close();
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Evolve - Signed in as: Dr." + currentDoctor.getFirstName() + " " +currentDoctor.getLastName());
		initComponents();
	}
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 815, 551);
		
		
		
		ImageIcon homeIcon = new ImageIcon(Objects.requireNonNull(
                this.getClass().getResource("/resources/homeicon_24.png")));
		
		JPanel panelHome = new JPanel();
		tabbedPane.addTab(null, homeIcon, panelHome, null);
		
		JLabel lblFName = new JLabel("First Name:");
		lblFName.setBounds(42, 14, 78, 14);
		
		JLabel lblPFName = new JLabel(currentPatient.getFirstName());
		lblPFName.setBounds(123, 14, 84, 14);
		lblPFName.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblLName = new JLabel("Last Name:");
		lblLName.setBounds(217, 14, 78, 14);
		
		JLabel lblPLName = new JLabel(currentPatient.getLastName());
		lblPLName.setBounds(305, 14, 84, 14);
		lblPLName.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(73, 49, 32, 14);
		
		JLabel lblPAge = new JLabel(currentPatient.getAge());
		lblPAge.setBounds(123, 49, 84, 14);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setBounds(73, 81, 32, 14);
		
		JLabel lblPSex = new JLabel(currentPatient.getSex());
		lblPSex.setBounds(123, 81, 55, 14);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 143, 800, 2);
		
		JLabel lblNationality = new JLabel("Nationality:");
		lblNationality.setBounds(42, 111, 78, 14);
		
		JLabel lblPNationality = new JLabel(currentPatient.getNationallity());
		lblPNationality.setBounds(123, 111, 94, 14);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number:");
		lblMobileNumber.setBounds(193, 49, 94, 14);
		
		JLabel lblPMobileNumber = new JLabel(currentPatient.getPhoneNum());
		lblPMobileNumber.setBounds(305, 49, 84, 14);
		lblPMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setBounds(242, 81, 45, 14);
		
		JLabel lblPEmailAddress = new JLabel(currentPatient.getEmailAddress());
		lblPEmailAddress.setBounds(305, 81, 191, 14);
		lblPEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		txtMedicareNumber = new JTextField();
		txtMedicareNumber.setBounds(553, 11, 217, 20);
		txtMedicareNumber.setBackground(Color.LIGHT_GRAY);
		txtMedicareNumber.setEditable(false);
		txtMedicareNumber.setText("Medicare Number: " + currentPatient.getMedicareNumber());
		txtMedicareNumber.setColumns(10);
		
		txtPrivateHeathcareNumber = new JTextField();
		txtPrivateHeathcareNumber.setBounds(553, 37, 217, 20);
		txtPrivateHeathcareNumber.setText("Private Heathcare Number: " + currentPatient.getPrivateHealthCareNumber());
		if (currentPatient.getPrivateHealthCareNumber() == 0) {
			txtPrivateHeathcareNumber.setVisible(false);
		} 
		txtPrivateHeathcareNumber.setEditable(false);
		txtPrivateHeathcareNumber.setColumns(10);
		txtPrivateHeathcareNumber.setBackground(Color.LIGHT_GRAY);
		
		txtPensionerNumber = new JTextField();
		txtPensionerNumber.setBounds(553, 61, 217, 20);
		txtPensionerNumber.setText("Pensioner Number: " + currentPatient.getPensionerNumber());
		if (currentPatient.getPensionerNumber() == 0) {
			txtPensionerNumber.setVisible(false);
		} 
		txtPensionerNumber.setEditable(false);
		txtPensionerNumber.setColumns(10);
		txtPensionerNumber.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblDiagnosis = new JLabel("Last Diagnosis:");
		lblDiagnosis.setBounds(10, 151, 87, 14);
		lblDiagnosis.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDiagnosis.setForeground(Color.DARK_GRAY);
		
		JLabel lblPDiagnosis = new JLabel(currentPatient.getDiagnosis());
		lblPDiagnosis.setBounds(107, 151, 693, 14);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 171, 800, 2);
		
		JLabel lblMedicalHistory = new JLabel("Medical History");
		lblMedicalHistory.setBounds(10, 179, 87, 14);
		lblMedicalHistory.setForeground(Color.DARK_GRAY);
		lblMedicalHistory.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 265, 0, 2);
		
		JLabel lblCurrentMedications = new JLabel("Current Medications:");
		lblCurrentMedications.setBounds(10, 273, 117, 14);
		lblCurrentMedications.setForeground(Color.DARK_GRAY);
		lblCurrentMedications.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblAllergies = new JLabel("Allergies: " + currentPatient.getMedAllergies());
		lblAllergies.setBounds(10, 363, 121, 14);
		lblAllergies.setForeground(Color.DARK_GRAY);
		lblAllergies.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblPAllergies = new JLabel();
		lblPAllergies.setBounds(137, 363, 382, 0);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 383, 777, 3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 261, 0, 2);
		
		JLabel lblAdditionalNotes = new JLabel("Additional Notes:");
		lblAdditionalNotes.setBounds(10, 392, 95, 14);
		lblAdditionalNotes.setForeground(Color.DARK_GRAY);
		lblAdditionalNotes.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JScrollPane spCurrentMeds = new JScrollPane();
		spCurrentMeds.setBounds(10, 293, 758, 59);
		
		JScrollPane spMedicalHistory = new JScrollPane();
		spMedicalHistory.setBounds(10, 199, 756, 57);
		
		JScrollPane spAdditionalNotes = new JScrollPane();
		spAdditionalNotes.setBounds(10, 417, 757, 59);
		
		
		
		JTextArea taAdditionalNotes = new JTextArea();
		spAdditionalNotes.setViewportView(taAdditionalNotes);
		if (currentPatient.getTreatmentPlan().isEmpty()) {
			taAdditionalNotes.setText("No current treament plan");
		} else {
			taAdditionalNotes.setText(currentPatient.getTreatmentPlanData(0).getDoctorsNotes());
		}
		taAdditionalNotes.setEditable(false);
		
		JTextArea taMedicalHistory = new JTextArea();
		spMedicalHistory.setViewportView(taMedicalHistory);
		if (currentPatient.getDiagnosisList().isEmpty()) {
			taMedicalHistory.setText("No current medical history avalible");
		} else {
			taMedicalHistory.setText(currentPatient.getDiagnosisList());
		}
		taMedicalHistory.setEditable(false);
		
		JTextArea taCurrentMedications = new JTextArea();
		if (currentPatient.getCurrentMedicationsMap().isEmpty()) {
			taCurrentMedications.setText("No current medical history avalible");
		} else {
			taCurrentMedications.setText(currentPatient.getCurrentMeds());
		}
		taCurrentMedications.setEditable(false);
		spCurrentMeds.setViewportView(taCurrentMedications);
		panelHome.setLayout(null);
		panelHome.add(lblSex);
		panelHome.add(lblAge);
		panelHome.add(lblFName);
		panelHome.add(lblNationality);
		panelHome.add(lblPSex);
		panelHome.add(lblEmail);
		panelHome.add(lblPFName);
		panelHome.add(lblLName);
		panelHome.add(lblPAge);
		panelHome.add(lblMobileNumber);
		panelHome.add(lblPNationality);
		panelHome.add(lblPMobileNumber);
		panelHome.add(lblPLName);
		panelHome.add(txtMedicareNumber);
		panelHome.add(txtPrivateHeathcareNumber);
		panelHome.add(txtPensionerNumber);
		panelHome.add(lblPEmailAddress);
		panelHome.add(lblDiagnosis);
		panelHome.add(lblPDiagnosis);
		panelHome.add(separator);
		panelHome.add(lblMedicalHistory);
		panelHome.add(separator_2);
		panelHome.add(lblCurrentMedications);
		panelHome.add(spCurrentMeds);
		panelHome.add(lblAllergies);
		panelHome.add(lblPAllergies);
		panelHome.add(separator_1);
		panelHome.add(spMedicalHistory);
		panelHome.add(separator_4);
		panelHome.add(separator_3);
		panelHome.add(lblAdditionalNotes);
		panelHome.add(spAdditionalNotes);
		
		JPanel panelPastPrescriptions = new JPanel();
		tabbedPane.addTab("Past Prescriptions", null, panelPastPrescriptions, null);
		panelPastPrescriptions.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(36, 44, 73, 25);
		panelPastPrescriptions.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("+Create New Treatment Plan", null, panel, null);
		
		JLabel lblFullName = new JLabel("Patient's Name:");
		lblFullName.setBounds(10, 30, 98, 14);
		
		JLabel lblPFullName = new JLabel(currentPatient.getFirstName() + " " + currentPatient.getLastName());
		lblPFullName.setBounds(118, 30, 162, 14);
		
		JLabel lblMedicareNo = new JLabel("Medicare No:");
		lblMedicareNo.setBounds(528, 30, 100, 14);
		String medicareNum = Integer.toString(currentPatient.getMedicareNumber());
		JLabel lblPMedicareNumber = new JLabel(medicareNum);
		lblPMedicareNumber.setBounds(638, 30, 162, 14);
		panel.setLayout(null);
		panel.add(lblFullName);
		panel.add(lblPFullName);
		panel.add(lblMedicareNo);
		panel.add(lblPMedicareNumber);
		
		JLabel lblTPDiagnosis = new JLabel("Diagnosis");
		lblTPDiagnosis.setOpaque(true);
		lblTPDiagnosis.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTPDiagnosis.setBackground(new Color(153, 204, 255));
		lblTPDiagnosis.setBounds(10, 91, 162, 20);
		panel.add(lblTPDiagnosis);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(10, 111, 162, 134);
		panel.add(scrollPane);
		
		JTextArea taDiagnosis = new JTextArea();
		scrollPane.setViewportView(taDiagnosis);
		taDiagnosis.setWrapStyleWord(true);
		taDiagnosis.setLineWrap(true);
		taDiagnosis.setBackground(SystemColor.controlHighlight);
		
		JLabel lblTestReferral = new JLabel("Test Referral");
		lblTestReferral.setOpaque(true);
		lblTestReferral.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTestReferral.setBackground(new Color(153, 204, 255));
		lblTestReferral.setBounds(10, 244, 162, 25);
		panel.add(lblTestReferral);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(BorderFactory.createEmptyBorder());
		scrollPane_1.setBounds(195, 91, 416, 164);
		panel.add(scrollPane_1);
		
		prescriptionTable = new JTable();
		scrollPane_1.setViewportView(prescriptionTable);
		prescriptionTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Drug", "Strength", "Quantity", "Frequency"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		DefaultTableModel medTableModel = (DefaultTableModel) prescriptionTable.getModel();
		
		
		JLabel lblNoteToPharmacy = new JLabel("Note to Pharmacy",SwingConstants.CENTER);
		lblNoteToPharmacy.setOpaque(true);
		lblNoteToPharmacy.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNoteToPharmacy.setBackground(new Color(153, 204, 255));
		lblNoteToPharmacy.setBounds(640, 225, 160, 20);
		panel.add(lblNoteToPharmacy);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(BorderFactory.createEmptyBorder());
		scrollPane_2.setBounds(640, 244, 160, 186);
		panel.add(scrollPane_2);
		
		JTextArea taDiagnosis_1 = new JTextArea();
		scrollPane_2.setViewportView(taDiagnosis_1);
		taDiagnosis_1.setWrapStyleWord(true);
		taDiagnosis_1.setLineWrap(true);
		taDiagnosis_1.setBackground(SystemColor.controlHighlight);
		
		JLabel lblDrugInteractionSummary = new JLabel("Drug Interaction Summary",SwingConstants.CENTER);
		lblDrugInteractionSummary.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDrugInteractionSummary.setOpaque(true);
		lblDrugInteractionSummary.setBackground(SystemColor.controlHighlight);
		lblDrugInteractionSummary.setBounds(195, 264, 416, 14);
		panel.add(lblDrugInteractionSummary);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBorder(BorderFactory.createEmptyBorder());
		scrollPane_3.setBounds(10, 266, 162, 164);
		panel.add(scrollPane_3);
		
		JTextArea taTestReferral = new JTextArea();
		scrollPane_3.setViewportView(taTestReferral);
		taTestReferral.setWrapStyleWord(true);
		taTestReferral.setLineWrap(true);
		taTestReferral.setBackground(SystemColor.controlHighlight);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBorder(BorderFactory.createEmptyBorder());
		scrollPane_4.setBounds(195, 277, 416, 121);
		panel.add(scrollPane_4);
		
		contraTable = new JTable();
		contraTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medication Name", "Interacts with"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		contraTable.getColumnModel().getColumn(0).setPreferredWidth(92);
		contraTable.getColumnModel().getColumn(1).setPreferredWidth(77);
		scrollPane_4.setViewportView(contraTable);
		
		DefaultTableModel contraModel = (DefaultTableModel) contraTable.getModel();
		contraTable.setBackground(new Color(255, 51, 51));
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(638, 91, 162, 121);
		panel.add(scrollPane_5);
		scrollPane_5.setVisible(false);
		
		ArrayList<Medication> contraName = new ArrayList<>();
		ArrayList<String> medsInList = new ArrayList<>();
		ArrayList<String> medAllergies = new ArrayList<>();
		medAllergies.add(currentPatient.getMedAllergies());
		JList addMedList = new JList(medsList.toArray());
		
		addMedList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Medication meds = medsList.get(addMedList.getSelectedIndex());
				String medName = meds.getBrandName();
				medsInList.add(meds.getBrandName());
				
				
				if (contraName.contains(meds.getContraMeds())) {
					//do nothing lol
				} else {
				contraName.add(meds.getContraMeds());
				}
				
				for(int i = 0; i < contraName.size();i++) {	
					
					if(contraName.contains(meds) && contraName.get(i).getBrandName() != medName) {
						
						contraModel.addRow(new Object [] {medName, contraName.get(i)});
						break;
				} 
					
			}
				
				
				medTableModel.addRow(new Object [] {meds,"","",""});
				
				for (int i = 0; i < medAllergies.size();i++) {
					int row = medTableModel.getRowCount() -1;
					Medication testMed = (Medication) medTableModel.getValueAt(row, 0);
					String medTableMed = testMed.getBrandName();
					String allergy = medAllergies.get(i);
					
					System.out.println("MedTableMed value: " + medTableMed);
					System.out.println("Allergy " + allergy);
					if(medTableMed.equals(allergy)) { 
						contraModel.addRow(new Object []{(String) currentPatient.getFirstName() + " " + currentPatient.getLastName() + " has an allergy to "
							  ,allergy});
					}
					
					row++;
				}
				
			}
		});
		scrollPane_5.setViewportView(addMedList);
		addMedList.setVisible(false);
		
		JButton btnSearch = new JButton("Search");
		JButton btnAddMeds = new JButton("Add Medication");
		btnAddMeds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane_5.setVisible(true);
				addMedList.setVisible(true);
				tfSearch.setVisible(true);
				btnSearch.setVisible(true);
				
				
			}
		});
		btnAddMeds.setBounds(464, 57, 147, 23);
		panel.add(btnAddMeds);
		
		JButton btnRemoveMedication = new JButton("Remove Medication");
		btnRemoveMedication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(String i : medsInList) {
					System.out.println("Meds in list pre delete " +i);
				}
				
				int rowToDelete = prescriptionTable.getSelectedRow();
				Medication medToRemove = medsList.get(rowToDelete);
				medTableModel.removeRow(rowToDelete);
				medsInList.remove(rowToDelete);
				contraName.remove(medToRemove);
				contraModel.setRowCount(0);
				
				for (int i = 0; i < medAllergies.size();i++) {
					if(medTableModel.getRowCount() == 0) {
						break;
					}
					
					int row = medTableModel.getRowCount() -1;
					
					Medication testMed = (Medication) medTableModel.getValueAt(row, 0);
					String medTableMed = testMed.getBrandName();
					String allergy = medAllergies.get(i);
					
					System.out.println("MedTableMed value: " + medTableMed);
					System.out.println("Allergy " + allergy);
					if(medTableMed.equals(allergy)) { 
						contraModel.addRow(new Object []{(String) currentPatient.getFirstName() + " " + currentPatient.getLastName() + " has an allergy to "
							  ,allergy});
					}
					
					row++;
				}
				
				for (int i = 0; i < medTableModel.getRowCount(); i++) {
					Medication meds = (Medication) medTableModel.getValueAt(i, 0);
					String medName = meds.getBrandName();
					if(contraName.contains(meds) && contraName.get(i).getBrandName() != medName) {
						
						contraModel.addRow(new Object [] {medName, contraName.get(i)});
						break;
				} 
				}
				
			
				
			}
		});
		btnRemoveMedication.setBounds(449, 409, 162, 23);
		panel.add(btnRemoveMedication);
		
		JButton btnCreatePrescription = new JButton("Send E-Prescription");
		btnCreatePrescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (medTableModel.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, 
                              "No medications in medication table", 
                              "Error", 
                              JOptionPane.WARNING_MESSAGE);
				}
				
				else {
				TreatmentPlan treatmentPlan = new TreatmentPlan();
				Prescription prescription = new Prescription();
				//ArrayList <Medication> prescriptionMedications = new ArrayList<>();
				currentPatient.removeAllMedications();
				treatmentPlan.setDiagnosis(taDiagnosis.getText());
				currentPatient.addDiagnosis(taDiagnosis.getText());
				prescription.setDiagnosis(taDiagnosis.getText());
				prescription.setDoctor(currentDoctor);
				prescription.setPatient(currentPatient);
				prescription.setDrNotes(taDiagnosis_1.getText());
				prescription.setQrCode(prescription.generateQRCode());
				try {
					prescription.generateQRImage();
				} catch (WriterException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				for (int i = 0; i < medTableModel.getRowCount();i++) {
					
					
					currentPatient.addMedications((Medication)medTableModel.getValueAt(i, 0), (String)medTableModel.getValueAt(i, 1));
					currentPatient.setFrequency((String) medTableModel.getValueAt(i, 3));
					treatmentPlan.setPatientMeds((Medication)medTableModel.getValueAt(i, 0));
					prescription.addMedications((Medication)medTableModel.getValueAt(i, 0),(String)medTableModel.getValueAt(i, 1));
					prescription.setRepeats((int) medTableModel.getValueAt(i, 2));
					prescription.setFrequency((String) medTableModel.getValueAt(i, 3));
				}
//				System.out.println(treatmentPlan.getDiagnosis());
//				System.out.println(currentPatient.getCurrentMeds());
//				System.out.println(treatmentPlan.getPatientMeds());
//				System.out.println(currentPatient.getDiagnosis());
//				System.out.println(prescription.getDiagnosis());
//				System.out.println(prescription.getDrNotes());
//				System.out.println(prescription.getRepeats(0));
//				System.out.println(prescription.getDoctor().getFirstName() + " " + prescription.getDoctor().getLastName());
//				System.out.println(prescription.getFrequency().get(0));
//				System.out.println(prescription.getQrCode());
				
				QRView qrview = new QRView(prescription);
				qrview.setVisible(true);
				
				}
				
				
				
				
			
			}
		});
		contentPane.setLayout(null);
		btnCreatePrescription.setBounds(191, 409, 147, 23);
		panel.add(btnCreatePrescription);
		
		tfSearch = new JTextField();
		tfSearch.setText("Search Here");
		tfSearch.setBounds(638, 60, 74, 20);
		tfSearch.setVisible(false);
		panel.add(tfSearch);
		tfSearch.setColumns(10);
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel searchQueryListModel = new DefaultListModel();
				ArrayList<Medication> serachResult = Medication.searchMedication(tfSearch.getText(), medsList);
				//Adds the results of search to the list
				for(Medication med: serachResult) {
					searchQueryListModel.addElement(med.getBrandName());
				}
				addMedList.setModel(searchQueryListModel);
			}
		});
		btnSearch.setVisible(false);
		btnSearch.setBounds(722, 57, 78, 23);
		panel.add(btnSearch);
		contentPane.add(tabbedPane);
	}
}
