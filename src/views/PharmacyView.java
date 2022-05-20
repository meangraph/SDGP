package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.Medication;
import common.Patient;
import common.Pharmacy;
import common.Prescription;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class PharmacyView extends JFrame {

	private JPanel contentPane;
	Pharmacy pharmacy;
	Patient patient;
	Prescription prescription;
	ArrayList<Prescription> prescriptionList;
	private JTextField tfQrSearch;
	private JTable medsTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PharmacyView frame = new PharmacyView();
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
	public PharmacyView() {
		setTitle("Signed in as:");
		initComponents();
	}
	public PharmacyView(Pharmacy x) {
		pharmacy = x;
		setTitle("Signed in as: " + pharmacy.getPharmacyID());
		
		
			FileInputStream prescriptions;
			try {
				prescriptions = new FileInputStream("prescriptions.txt");
				ObjectInputStream prescriptionsIn = new ObjectInputStream(prescriptions);
				prescriptionList = (ArrayList<Prescription>) prescriptionsIn.readObject();
				prescriptionsIn.close();
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			initComponents();
			
			 
			
	}
		
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatientInfo = new JLabel("Patient Information");
		lblPatientInfo.setForeground(Color.GRAY);
		lblPatientInfo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblPatientInfo.setBounds(22, 44, 121, 14);
		contentPane.add(lblPatientInfo);
		
		JLabel lblFName = new JLabel("First Name:");
		lblFName.setBounds(22, 69, 66, 14);
		contentPane.add(lblFName);
		
		JLabel lblLName = new JLabel("Last Name:");
		lblLName.setBounds(22, 94, 66, 14);
		contentPane.add(lblLName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(54, 119, 32, 14);
		contentPane.add(lblAge);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setBounds(54, 144, 32, 14);
		contentPane.add(lblSex);
		
		JLabel lblPFname = new JLabel("");
		lblPFname.setBounds(95, 69, 99, 14);
		contentPane.add(lblPFname);
		
		JLabel lblPLName = new JLabel("");
		lblPLName.setBounds(95, 94, 96, 14);
		contentPane.add(lblPLName);
		
		JLabel lblPAge = new JLabel("");
		lblPAge.setBounds(96, 119, 76, 14);
		contentPane.add(lblPAge);
		
		JLabel lblPSex = new JLabel("");
		lblPSex.setBounds(95, 144, 76, 14);
		contentPane.add(lblPSex);
		
		tfQrSearch = new JTextField();
		tfQrSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		tfQrSearch.setBounds(386, 41, 172, 42);
		contentPane.add(tfQrSearch);
		tfQrSearch.setColumns(10);
		
		JLabel lblEnterQr = new JLabel("Enter QR Code:");
		lblEnterQr.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterQr.setBounds(386, 16, 90, 14);
		contentPane.add(lblEnterQr);
		
		JTextArea taPharmacyNote = new JTextArea();
		taPharmacyNote.setWrapStyleWord(true);
		taPharmacyNote.setLineWrap(true);
		taPharmacyNote.setBackground(new Color(102, 153, 255));
		taPharmacyNote.setBounds(386, 139, 172, 93);
		contentPane.add(taPharmacyNote);
		
		JLabel lblPrescriber = new JLabel("Prescriber");
		lblPrescriber.setForeground(Color.GRAY);
		lblPrescriber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblPrescriber.setBounds(22, 169, 76, 14);
		contentPane.add(lblPrescriber);
		
		JLabel lblDrName = new JLabel("");
		lblDrName.setBounds(22, 193, 354, 14);
		contentPane.add(lblDrName);
		
		JLabel lblDrAddress = new JLabel("");
		lblDrAddress.setBounds(22, 218, 354, 14);
		contentPane.add(lblDrAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 250, 354, 155);
		contentPane.add(scrollPane);
		
		medsTable = new JTable();
		medsTable.setModel(new DefaultTableModel(
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
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(medsTable);
		
		DefaultTableModel model = (DefaultTableModel) medsTable.getModel();
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				String qrCode = tfQrSearch.getText();
				System.out.println(qrCode);
				boolean found = false;
				
				for (int i = 0; i < prescriptionList.size();i++) {
					if (prescriptionList.get(i).getQrCode().equalsIgnoreCase(qrCode)) {
						found = true;
						prescription = prescriptionList.get(i);
						patient = prescription.getPatient();
						lblPFname.setText(patient.getFirstName());
						lblPLName.setText(patient.getLastName());
						lblPAge.setText(patient.getAge());
						lblPSex.setText(patient.getSex());
						taPharmacyNote.setText(prescription.getDrNotes());
						lblDrAddress.setText(prescription.getDoctor().getAddress().toString());
						lblDrName.setText("Dr." + prescription.getDoctor().getFirstName() + " " + prescription.getDoctor().getLastName());
						
						for (int j = 0; j < prescription.getPrescriptionMedications().size();j++) {
						for (Medication meds: prescription.getPrescriptionMedications().keySet()) {
							for (String str : prescription.getPrescriptionMedications().values()) {
								System.out.println(meds);
								System.out.println(str);
								model.addRow(new Object[]{meds,str,prescription.getRepeats(j),prescription.getFrequency(j)});
							}
						}
						}
					}
				}
				if (found == false) {
					JOptionPane.showMessageDialog(null,
                            "Prescription not found!");
				}
			}
		});
		btnSearch.setBounds(469, 90, 89, 23);
		contentPane.add(btnSearch);
		
		
	}
}
