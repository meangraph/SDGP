package views;
import common.Patient;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
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
import javax.swing.JList;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
		);
		
		try {
			FileInputStream patients = new FileInputStream("patients.txt");
			ObjectInputStream objectIn = new ObjectInputStream(patients);
			
			ArrayList<Patient> patientList = (ArrayList<Patient>) objectIn.readObject();
			
			currentPatient = patientList.get(2);
			objectIn.close();
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImageIcon homeIcon = new ImageIcon(Objects.requireNonNull(
                this.getClass().getResource("/resources/homeicon_24.png")));
		
		JPanel panelHome = new JPanel();
		tabbedPane.addTab(null, homeIcon, panelHome, null);
		
		JLabel lblFName = new JLabel("First Name:");
		
		JLabel lblPFName = new JLabel(currentPatient.getFirstName());
		lblPFName.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblLName = new JLabel("Last Name:");
		
		JLabel lblPLName = new JLabel(currentPatient.getLastName());
		lblPLName.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblAge = new JLabel("Age:");
		
		JLabel lblPAge = new JLabel(currentPatient.getAge());
		
		JLabel lblSex = new JLabel("Sex:");
		
		JLabel lblPSex = new JLabel(currentPatient.getSex());
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNationality = new JLabel("Nationality:");
		
		JLabel lblPNationality = new JLabel(currentPatient.getNationallity());
		
		JLabel lblMobileNumber = new JLabel("Mobile Number:");
		
		JLabel lblPMobileNumber = new JLabel(currentPatient.getPhoneNum());
		lblPMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblEmail = new JLabel("E-Mail:");
		
		JLabel lblPEmailAddress = new JLabel(currentPatient.getEmailAddress());
		lblPEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		txtMedicareNumber = new JTextField();
		txtMedicareNumber.setBackground(Color.LIGHT_GRAY);
		txtMedicareNumber.setEditable(false);
		txtMedicareNumber.setText("Medicare Number: " + currentPatient.getMedicareNumber());
		txtMedicareNumber.setColumns(10);
		
		txtPrivateHeathcareNumber = new JTextField();
		txtPrivateHeathcareNumber.setText("Private Heathcare Number: " + currentPatient.getPrivateHealthCareNumber());
		if (currentPatient.getPrivateHealthCareNumber() == 0) {
			txtPrivateHeathcareNumber.setVisible(false);
		} 
		txtPrivateHeathcareNumber.setEditable(false);
		txtPrivateHeathcareNumber.setColumns(10);
		txtPrivateHeathcareNumber.setBackground(Color.LIGHT_GRAY);
		
		txtPensionerNumber = new JTextField();
		txtPensionerNumber.setText("Pensioner Number: " + currentPatient.getPensionerNumber());
		if (currentPatient.getPensionerNumber() == 0) {
			txtPensionerNumber.setVisible(false);
		} 
		txtPensionerNumber.setEditable(false);
		txtPensionerNumber.setColumns(10);
		txtPensionerNumber.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblDiagnosis = new JLabel("Diagnosis:");
		lblDiagnosis.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDiagnosis.setForeground(Color.DARK_GRAY);
		
		JLabel lblPDiagnosis = new JLabel(currentPatient.getDiagnosis());
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblMedicalHistory = new JLabel("Medical History");
		lblMedicalHistory.setForeground(Color.DARK_GRAY);
		lblMedicalHistory.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JSeparator separator_2 = new JSeparator();
		
		JLabel lblCurrentMedications = new JLabel("Current Medications:");
		lblCurrentMedications.setForeground(Color.DARK_GRAY);
		lblCurrentMedications.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblAllergies = new JLabel("Allergies: " + currentPatient.getMedAllergies());
		lblAllergies.setForeground(Color.DARK_GRAY);
		lblAllergies.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblPAllergies = new JLabel();
		
		JSeparator separator_3 = new JSeparator();
		
		JSeparator separator_4 = new JSeparator();
		
		JLabel lblAdditionalNotes = new JLabel("Additional Notes:");
		lblAdditionalNotes.setForeground(Color.DARK_GRAY);
		lblAdditionalNotes.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JScrollPane spCurrentMeds = new JScrollPane();
		
		JScrollPane spMedicalHistory = new JScrollPane();
		
		JScrollPane spAdditionalNotes = new JScrollPane();
		GroupLayout gl_panelHome = new GroupLayout(panelHome);
		gl_panelHome.setHorizontalGroup(
			gl_panelHome.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHome.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_panelHome.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSex)
						.addComponent(lblAge)
						.addComponent(lblFName)
						.addComponent(lblNationality))
					.addGap(18)
					.addGroup(gl_panelHome.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelHome.createSequentialGroup()
							.addComponent(lblPSex)
							.addPreferredGap(ComponentPlacement.RELATED, 807, Short.MAX_VALUE)
							.addComponent(lblEmail))
						.addGroup(gl_panelHome.createSequentialGroup()
							.addComponent(lblPFName, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblLName, GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE))
						.addGroup(gl_panelHome.createSequentialGroup()
							.addComponent(lblPAge, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMobileNumber))
						.addComponent(lblPNationality, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelHome.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelHome.createSequentialGroup()
							.addGroup(gl_panelHome.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPMobileNumber, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPLName, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
							.addGap(164)
							.addGroup(gl_panelHome.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMedicareNumber, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPrivateHeathcareNumber, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPensionerNumber, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblPEmailAddress, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
					.addGap(40))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDiagnosis)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPDiagnosis)
					.addContainerGap(1412, Short.MAX_VALUE))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 1530, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMedicalHistory)
					.addContainerGap(1443, Short.MAX_VALUE))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(786))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCurrentMedications)
					.addContainerGap(1413, Short.MAX_VALUE))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(spCurrentMeds, GroupLayout.PREFERRED_SIZE, 758, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(772, Short.MAX_VALUE))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAllergies)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPAllergies, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1021, Short.MAX_VALUE))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 1530, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(spMedicalHistory, GroupLayout.PREFERRED_SIZE, 756, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(774, Short.MAX_VALUE))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addGroup(gl_panelHome.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(separator_4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAdditionalNotes)
					.addContainerGap(1435, Short.MAX_VALUE))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(spAdditionalNotes, GroupLayout.PREFERRED_SIZE, 757, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(773, Short.MAX_VALUE))
		);
		gl_panelHome.setVerticalGroup(
			gl_panelHome.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelHome.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFName)
						.addComponent(lblPFName)
						.addComponent(lblLName)
						.addComponent(lblPLName)
						.addComponent(txtMedicareNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panelHome.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelHome.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panelHome.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAge)
								.addComponent(lblPAge)
								.addComponent(lblPMobileNumber)
								.addComponent(lblMobileNumber))
							.addGap(18)
							.addGroup(gl_panelHome.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSex)
								.addComponent(lblPSex)
								.addComponent(lblPEmailAddress)
								.addComponent(lblEmail))
							.addGap(16)
							.addGroup(gl_panelHome.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNationality)
								.addComponent(lblPNationality)))
						.addGroup(gl_panelHome.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPrivateHeathcareNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtPensionerNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelHome.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDiagnosis)
						.addComponent(lblPDiagnosis))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMedicalHistory)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelHome.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelHome.createSequentialGroup()
							.addGap(62)
							.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE))
						.addComponent(spMedicalHistory, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCurrentMedications)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spCurrentMeds, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelHome.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAllergies)
						.addComponent(lblPAllergies))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAdditionalNotes)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(spAdditionalNotes, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		
		
		
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
		
		JTextArea taCurrentMedications = new JTextArea(currentPatient.getCurrentMeds());
		taCurrentMedications.setEditable(false);
		spCurrentMeds.setViewportView(taCurrentMedications);
		panelHome.setLayout(gl_panelHome);
		
		JPanel panelPastPrescriptions = new JPanel();
		tabbedPane.addTab("Past Prescriptions", null, panelPastPrescriptions, null);
		
		JLabel lblNewLabel = new JLabel("New label");
		GroupLayout gl_panelPastPrescriptions = new GroupLayout(panelPastPrescriptions);
		gl_panelPastPrescriptions.setHorizontalGroup(
			gl_panelPastPrescriptions.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPastPrescriptions.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(660, Short.MAX_VALUE))
		);
		gl_panelPastPrescriptions.setVerticalGroup(
			gl_panelPastPrescriptions.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPastPrescriptions.createSequentialGroup()
					.addGap(44)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(444, Short.MAX_VALUE))
		);
		panelPastPrescriptions.setLayout(gl_panelPastPrescriptions);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("+Create New Treatment Plan", null, panel, null);
		
		JLabel lblFullName = new JLabel("Patient's Name");
		
		JLabel lblPFullName = new JLabel(currentPatient.getFirstName() + " " + currentPatient.getLastName());
		
		JLabel lblMedicareNo = new JLabel("Medicare No:");
		String medicareNum = Integer.toString(currentPatient.getMedicareNumber());
		JLabel lblPMedicareNumber = new JLabel(medicareNum);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(37)
					.addComponent(lblFullName)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPFullName, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
					.addComponent(lblMedicareNo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPMedicareNumber, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFullName)
						.addComponent(lblPFullName)
						.addComponent(lblMedicareNo)
						.addComponent(lblPMedicareNumber))
					.addContainerGap(469, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
