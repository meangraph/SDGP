package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.Medication;
import common.Patient;

import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PatientView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Patient currentPatient;
	private JTextField txtMedicareNumber;
	private JTextField txtPrivateHealthNumber;
	private JTextField txtPensioner;
	private JTable medsTable;
	private JTextField tfSearch;
	private int patientIndex;
	ArrayList<Medication> medsList = new ArrayList<Medication>();
	private JTextField tfAllergiesSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientView frame = new PatientView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param i 
	 */
	public PatientView(int x) {
		
		
		try {
			FileInputStream patients = new FileInputStream("patients.txt");
			FileInputStream medication = new FileInputStream("medications.txt");
			ObjectInputStream objectIn = new ObjectInputStream(patients);
			ObjectInputStream medsIn = new ObjectInputStream(medication);
			
			ArrayList<Patient> patientList = (ArrayList<Patient>) objectIn.readObject();
			medsList = (ArrayList<Medication>) medsIn.readObject();
			currentPatient = patientList.get(x);
			patientIndex = x;
			medsIn.close();
			objectIn.close();
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Evolve - Signed in as: " + currentPatient.getFirstName() + " " +currentPatient.getLastName());
		initComponents();
		initEvents();
	}
	
	
	public PatientView() {
		setTitle("Signed in as " + currentPatient.getFirstName() + " " +currentPatient.getLastName());
		initComponents();
		initEvents();
	}

	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PatientView.class.getResource("/resources/EvolveImageIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 738);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 600, 688);
		contentPane.add(tabbedPane);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(PatientView.class.getResource("/resources/homeicon_24.png")), panel, null);
		panel.setLayout(null);
		
		JLabel lblFName = new JLabel("First Name:");
		lblFName.setBounds(10, 11, 76, 14);
		panel.add(lblFName);
		
		JLabel lblUserFName = new JLabel(currentPatient.getFirstName());
		lblUserFName.setBounds(96, 11, 103, 14);
		panel.add(lblUserFName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 36, 76, 14);
		panel.add(lblLastName);
		
		JLabel lblUserLName = new JLabel(currentPatient.getLastName());
		lblUserLName.setBounds(96, 36, 103, 14);
		panel.add(lblUserLName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(38, 61, 28, 14);
		panel.add(lblAge);
		
		JLabel lbluserAge = new JLabel(currentPatient.getAge());
		lbluserAge.setBounds(96, 61, 103, 14);
		panel.add(lbluserAge);
		
		txtMedicareNumber = new JTextField();
		txtMedicareNumber.setEditable(false);
		txtMedicareNumber.setBackground(Color.LIGHT_GRAY);
		txtMedicareNumber.setText("Medicare Number: " + currentPatient.getMedicareNumber());
		txtMedicareNumber.setBounds(395, 8, 170, 20);
		panel.add(txtMedicareNumber);
		txtMedicareNumber.setColumns(10);
		
		txtPrivateHealthNumber = new JTextField();
		txtPrivateHealthNumber.setEditable(false);
		txtPrivateHealthNumber.setText("Private Health No: " + currentPatient.getPrivateHealthCareNumber());
		if (currentPatient.getPrivateHealthCareNumber() == 0) {
			txtPrivateHealthNumber.setVisible(false);
		} 
		txtPrivateHealthNumber.setColumns(10);
		txtPrivateHealthNumber.setBackground(Color.LIGHT_GRAY);
		txtPrivateHealthNumber.setBounds(395, 37, 170, 20);
		panel.add(txtPrivateHealthNumber);
		
		txtPensioner = new JTextField();
		txtPensioner.setEditable(false);
		txtPensioner.setText("Pensioner Number: " + currentPatient.getPensionerNumber());
		if (currentPatient.getPensionerNumber() == 0) {
			txtPensioner.setVisible(false);
		} 
		txtPensioner.setColumns(10);
		txtPensioner.setBackground(Color.LIGHT_GRAY);
		txtPensioner.setBounds(395, 68, 170, 20);
		panel.add(txtPensioner);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setBounds(38, 85, 28, 14);
		panel.add(lblSex);
		
		JLabel lbluserSex = new JLabel(currentPatient.getSex());
		lbluserSex.setBounds(96, 85, 103, 14);
		panel.add(lbluserSex);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 212, 513, 133);
		panel.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(426, 145, 125, 58);
		panel.add(scrollPane_1);
		
		JLabel lblContraMeds = new JLabel("Contra-Indications - N/A");
		lblContraMeds.setBounds(235, 535, 316, 14);
		panel.add(lblContraMeds);
		
		medsTable = new JTable();
		medsTable.setBackground(Color.WHITE);
		medsTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Drug", "Prescribed", "Strength", "Frequency", "Reason", "Remarks"
			}
		) {
			/**
			 * 
			 */
			
			boolean[] columnEditables = new boolean[] {
				true, false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(medsTable);
		
		DefaultTableModel model = (DefaultTableModel) medsTable.getModel();
		
		JList medList = new JList(medsList.toArray());
		medList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Medication meds = medsList.get(medList.getSelectedIndex());
				model.addRow(new Object [] {meds,meds.isControlled(),"","","","",""});
					
			}
		});
		scrollPane_1.setViewportView(medList);
		
		scrollPane_1.setVisible(false);
		medList.setVisible(false);
		
		
		
		JButton btnAddMeds = new JButton("Add Medication");
		btnAddMeds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane_1.setVisible(true);
				medList.setVisible(true);
				tfSearch.setVisible(true);
				
			}
		});
		btnAddMeds.setBounds(150, 145, 131, 23);
		panel.add(btnAddMeds);
		
		JLabel lblNewLabel = new JLabel("Current medications:");
		lblNewLabel.setBounds(10, 149, 130, 14);
		panel.add(lblNewLabel);
		
		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		tfSearch.setVisible(false);
		tfSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfSearch.setText("");
			}
		});
		tfSearch.setText("Search here");
		tfSearch.setBounds(330, 148, 86, 20);
		panel.add(tfSearch);
		tfSearch.setColumns(10);
		
		
		JButton btnRemoveCMed = new JButton("Remove Medication");
		btnRemoveCMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = medsTable.getSelectedRow();
				model.removeRow(row);
			}
		});
		btnRemoveCMed.setBounds(38, 356, 152, 23);
		panel.add(btnRemoveCMed);
		
		JLabel lblMedicationAllergies = new JLabel("Medication Allergies:");
		lblMedicationAllergies.setBounds(10, 412, 130, 14);
		panel.add(lblMedicationAllergies);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(38, 447, 170, 102);
		panel.add(scrollPane_2);
		
		JList allergyList = new JList();
		DefaultListModel allergyListModel = new DefaultListModel();
		scrollPane_2.setViewportView(allergyList);
		
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(421, 412, 125, 58);
		panel.add(scrollPane_3);
		
		
		
		JList medslist2 = new JList(medsList.toArray());
		medslist2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Medication medSelected = medsList.get(medslist2.getSelectedIndex());
				allergyListModel.addElement(medSelected);
				allergyList.setModel(allergyListModel);
				
			}
		});
		scrollPane_3.setViewportView(medslist2);
		
		medslist2.setVisible(false);
		scrollPane_3.setVisible(false);
		
		tfAllergiesSearch = new JTextField();
		tfAllergiesSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfAllergiesSearch.setText("");
			}
		});
		tfAllergiesSearch.setText("Search here");
		tfAllergiesSearch.setBounds(330, 412, 86, 20);
		panel.add(tfAllergiesSearch);
		tfAllergiesSearch.setColumns(10);
		tfAllergiesSearch.setVisible(false);
		
		JButton btnAddAllergies = new JButton("Add Allergies");
		btnAddAllergies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medslist2.setVisible(true);
				scrollPane_3.setVisible(true);
				tfAllergiesSearch.setVisible(true);
			}
		});
		btnAddAllergies.setBounds(150, 408, 131, 23);
		panel.add(btnAddAllergies);
		
		JButton btnRemoveAllergy = new JButton("Remove Allergy");
		btnRemoveAllergy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allergyListModel.remove(allergyList.getSelectedIndex());
			}
		});
		btnRemoveAllergy.setBounds(38, 569, 152, 23);
		panel.add(btnRemoveAllergy);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Row count: "+model.getRowCount());
				for (int row = 0; row < model.getRowCount();row++) {
					int column = 0;
					currentPatient.addMedications((Medication) model.getValueAt(row, column), model.getValueAt(row, column+2).toString());
					currentPatient.addDiagnosis(model.getValueAt(row, column+4).toString());
					currentPatient.getDiagnosis();
					System.out.println("Row "+row);
					
				}

				for (int i = 0; i < allergyListModel.getSize();i++) {
					currentPatient.setMedAllergies((Medication) allergyListModel.get(i));
				}
				
				 
				try {
					FileInputStream patients = new FileInputStream("patients.txt");
					ObjectInputStream objectIn = new ObjectInputStream(patients);
					
					ArrayList<Patient> patientList = (ArrayList<Patient>) objectIn.readObject();
					objectIn.close();
					
					patientList.set(patientIndex, currentPatient);
					
					FileOutputStream patientsList = new FileOutputStream("patients.txt");
					ObjectOutputStream patientsOutput = new ObjectOutputStream(patientsList);
					
					patientsOutput.writeObject(patientList);
					patientsOutput.close();
					
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				System.out.println("Current meds: " +currentPatient.getCurrentMeds());
				System.out.println("Diagnosis: " +currentPatient.getDiagnosis());
				System.out.println("Allergies: "+currentPatient.getMedAllergies());
			
			}
		});
		
		btnSave.setBounds(236, 616, 89, 23);
		panel.add(btnSave);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Medical History", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Pathology History", null, panel_2, null);
		panel_2.setLayout(null);
		
	}

	private void initEvents() {
		// TODO Auto-generated method stub
		
	}
}
