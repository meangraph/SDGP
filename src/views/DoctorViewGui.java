package views;
import common.Database;
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
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;

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
		
		ImageIcon homeIcon = new ImageIcon(Objects.requireNonNull(
                this.getClass().getResource("/resources/homeicon_24.png")));
		
		JPanel panelHome = new JPanel();
		tabbedPane.addTab(null, homeIcon, panelHome, null);
		
		JLabel lblFName = new JLabel("First Name:");
		
		JLabel lblPFName = new JLabel("Test");
		lblPFName.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblLName = new JLabel("Last Name:");
		
		JLabel lblPLName = new JLabel("Test");
		lblPLName.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblAge = new JLabel("Age:");
		
		JLabel lblPAge = new JLabel("Test");
		
		JLabel lblSex = new JLabel("Sex:");
		
		JLabel lblPSex = new JLabel("Test");
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNationality = new JLabel("Nationality:");
		
		JLabel lblPNationality = new JLabel("Test");
		
		JLabel lblMobileNumber = new JLabel("Mobile Number:");
		
		JLabel lblPMobileNumber = new JLabel("Test");
		lblPMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblEmail = new JLabel("E-Mail:");
		
		JLabel lblPEmailAddress = new JLabel("Test");
		lblPEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		txtMedicareNumber = new JTextField();
		txtMedicareNumber.setBackground(Color.LIGHT_GRAY);
		txtMedicareNumber.setEditable(false);
		txtMedicareNumber.setText("Medicare Number:");
		txtMedicareNumber.setColumns(10);
		
		txtPrivateHeathcareNumber = new JTextField();
		txtPrivateHeathcareNumber.setText("Private Heathcare Number:");
		txtPrivateHeathcareNumber.setEditable(false);
		txtPrivateHeathcareNumber.setColumns(10);
		txtPrivateHeathcareNumber.setBackground(Color.LIGHT_GRAY);
		
		txtPensionerNumber = new JTextField();
		txtPensionerNumber.setText("Pensioner Number:");
		txtPensionerNumber.setEditable(false);
		txtPensionerNumber.setColumns(10);
		txtPensionerNumber.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblDiagnosis = new JLabel("Diagnosis:");
		lblDiagnosis.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDiagnosis.setForeground(Color.DARK_GRAY);
		
		JLabel lblPDiagnosis = new JLabel("No active diagnosis for this patient");
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblMedicalHistory = new JLabel("Medical History");
		lblMedicalHistory.setForeground(Color.DARK_GRAY);
		lblMedicalHistory.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JTextArea taMedicalHistory = new JTextArea();
		taMedicalHistory.setEditable(false);
		
		JSeparator separator_2 = new JSeparator();
		
		JLabel lblCurrentMedications = new JLabel("Current Medications:");
		lblCurrentMedications.setForeground(Color.DARK_GRAY);
		lblCurrentMedications.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JTextArea taCurrentMedications = new JTextArea();
		taCurrentMedications.setEditable(false);
		
		JLabel lblAllergies = new JLabel("Allergies:");
		lblAllergies.setForeground(Color.DARK_GRAY);
		lblAllergies.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblPAllergies = new JLabel("N/A");
		
		JSeparator separator_3 = new JSeparator();
		
		JSeparator separator_4 = new JSeparator();
		
		JLabel lblAdditionalNotes = new JLabel("Additional Notes:");
		lblAdditionalNotes.setForeground(Color.DARK_GRAY);
		lblAdditionalNotes.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JTextArea taAdditionalNotes = new JTextArea();
		taAdditionalNotes.setEditable(false);
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
							.addGroup(gl_panelHome.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelHome.createSequentialGroup()
									.addComponent(lblPSex)
									.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
									.addComponent(lblEmail))
								.addGroup(gl_panelHome.createSequentialGroup()
									.addComponent(lblPAge, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblMobileNumber))
								.addGroup(gl_panelHome.createSequentialGroup()
									.addComponent(lblPFName, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblLName, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)))
							.addGap(18)
							.addGroup(gl_panelHome.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPEmailAddress, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPMobileNumber, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPLName, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
							.addGap(164)
							.addGroup(gl_panelHome.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMedicareNumber, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPrivateHeathcareNumber, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPensionerNumber, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
							.addGap(40))
						.addGroup(gl_panelHome.createSequentialGroup()
							.addComponent(lblPNationality, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDiagnosis)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPDiagnosis)
					.addContainerGap(575, Short.MAX_VALUE))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMedicalHistory)
					.addContainerGap(717, Short.MAX_VALUE))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(786))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCurrentMedications)
					.addContainerGap(687, Short.MAX_VALUE))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(taCurrentMedications, GroupLayout.PREFERRED_SIZE, 757, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAllergies)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPAllergies, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(364, Short.MAX_VALUE))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(taMedicalHistory, GroupLayout.PREFERRED_SIZE, 757, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addGroup(gl_panelHome.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(separator_4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAdditionalNotes)
					.addContainerGap(709, Short.MAX_VALUE))
				.addGroup(gl_panelHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(taAdditionalNotes, GroupLayout.PREFERRED_SIZE, 757, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
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
					.addComponent(taMedicalHistory, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCurrentMedications)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(taCurrentMedications, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelHome.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAllergies)
						.addComponent(lblPAllergies))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAdditionalNotes)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(taAdditionalNotes, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(43, Short.MAX_VALUE))
		);
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
		contentPane.setLayout(gl_contentPane);
	}
}
