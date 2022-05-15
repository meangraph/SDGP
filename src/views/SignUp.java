package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;

import common.Medication;
import common.Patient;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField tfUserName;
	private JPasswordField passwordField;
	private JTextField tfFname;
	private JTextField tfLastName;
	private JTextField tfEmail;
	private JTextField tfContactNumber;
	private JTextField tfNationallity;
	private final ButtonGroup sexButtonGroup = new ButtonGroup();
	private JTextField tfMedicare;
	private JTextField tfPrivateHealth;
	private JTextField taPensioner;
	private JPasswordField passwordField_1;
	ArrayList<Medication> medicationList = new ArrayList<Medication>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setTitle("Evolve - New Patient");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/resources/EvolveImageIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUserName = new JLabel("Username: ");
		
		tfUserName = new JTextField();
		tfUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		
		JLabel lblFirstName = new JLabel("First Name:");
		
		tfFname = new JTextField();
		tfFname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd MM yyyy");
		
		JLabel lblEmail = new JLabel("Email:");
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		
		JLabel lblContactNumber = new JLabel("Contact Number:");
		
		tfContactNumber = new JTextField();
		tfContactNumber.setColumns(10);
		
		JLabel lblNationallity = new JLabel("Nationallity:");
		
		tfNationallity = new JTextField();
		tfNationallity.setColumns(10);
		
		JLabel lblSex = new JLabel("Sex:");
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		sexButtonGroup.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		sexButtonGroup.add(rdbtnFemale);
		
		JRadioButton rdbtnOther = new JRadioButton("Other");
		sexButtonGroup.add(rdbtnOther);
		
		JLabel lblMedicareNo = new JLabel("Medicare No:");
		
		tfMedicare = new JTextField();
		tfMedicare.setColumns(10);
		
		JLabel lblPrivateHealthNo = new JLabel("Private Health No:");
		
		tfPrivateHealth = new JTextField();
		tfPrivateHealth.setColumns(10);
		
		JLabel lblPensionerNo = new JLabel("Pensioner No:");
		
		taPensioner = new JTextField();
		taPensioner.setColumns(10);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					FileInputStream patients = new FileInputStream("patients.txt");
					ObjectInputStream objectIn = new ObjectInputStream(patients);
					
					
					ArrayList<Patient> patientList = (ArrayList<Patient>) objectIn.readObject();
					objectIn.close();
					patients.close();
					
					FileOutputStream patientsOut = new FileOutputStream("patients.txt");
					ObjectOutputStream objectOut = new ObjectOutputStream(patientsOut);
					
					Patient patient = new Patient();
					patient.setPatientID(tfUserName.getText());
					patient.setFirstName(tfFname.getText());
					patient.setLastName(tfLastName.getText());
					patient.setDob(dateChooser.getDate());
					patient.setEmailAdress(tfEmail.getText());
					patient.setPhoneNum(tfContactNumber.getText());
					patient.setNationallity(tfNationallity.getText());
					
					if (rdbtnMale.isSelected()) {
						patient.setSex("Male");
					}
					if (rdbtnFemale.isSelected()){
						patient.setSex("Female");
					}
					if (rdbtnOther.isSelected()) {
						patient.setSex("Other");
					}
					
					int medNumber = Integer.parseInt(tfMedicare.getText());
					patient.setMedicareNumber(medNumber);
					
					if (tfPrivateHealth.getText().isEmpty()) {
						tfPrivateHealth.setText("0");
					}
					int privHealthNum = Integer.parseInt(tfPrivateHealth.getText());
					patient.setPrivateHealthCareNumber(privHealthNum);
					
					if (taPensioner.getText().isEmpty()) {
						taPensioner.setText("0");
					}
					
					int pensionNum = Integer.parseInt(taPensioner.getText());
					patient.setPensionerNumber(pensionNum);
					
					patient.setPassword(passwordField.getText());
					patient.setPatientID(tfUserName.getText());
					
					patientList.add(patient);
					
					objectOut.writeObject(patientList);
					objectOut.close();
					patientsOut.close();
					dispose();
					JOptionPane.showMessageDialog(null, "Account created successfully, you may now log in to update medical details");
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGap(19)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblPrivateHealthNo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblContactNumber, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblSex))
									.addGap(18))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGap(34)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFirstName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
										.addComponent(lblDateOfBirth, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(29))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblConfirmPassword)
									.addGap(18)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblUserName)
							.addGap(18)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(passwordField, 167, 167, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(rdbtnMale)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(rdbtnFemale)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(rdbtnOther, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
										.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(tfFname, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
										.addComponent(tfUserName)
										.addComponent(tfContactNumber))
									.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(18)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblEmail)
												.addComponent(lblNationallity)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblLastName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
												.addComponent(lblMedicareNo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(tfPrivateHealth, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
									.addComponent(lblPensionerNo)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tfLastName, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfNationallity, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfMedicare, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(taPensioner, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
							.addGap(50))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(244)
					.addComponent(btnCreateAccount)
					.addContainerGap(252, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUserName))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmPassword))
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfFname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFirstName)
						.addComponent(lblLastName))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblEmail)
							.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblDateOfBirth))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblContactNumber)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(tfContactNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNationallity)
							.addComponent(tfNationallity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSex)
						.addComponent(rdbtnMale)
						.addComponent(rdbtnFemale)
						.addComponent(rdbtnOther)
						.addComponent(lblMedicareNo)
						.addComponent(tfMedicare, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrivateHealthNo)
						.addComponent(tfPrivateHealth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPensionerNo)
						.addComponent(taPensioner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addComponent(btnCreateAccount)
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
