package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javax.swing.JScrollBar;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		try {
			FileInputStream medications = new FileInputStream("medications.txt");
			ObjectInputStream objectIn = new ObjectInputStream(medications);
			medicationList = (ArrayList<Medication>) objectIn.readObject();
			objectIn.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		JLabel lblCurrentMedications = new JLabel("Current Medications:");
		
		JList list = new JList(medicationList.toArray());
		
		JScrollBar scrollBar = new JScrollBar();

	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblCurrentMedications))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(19)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblPrivateHealthNo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblContactNumber, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblSex)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblUserName)
											.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblConfirmPassword)))
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFirstName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
								.addComponent(lblDateOfBirth, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(29)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
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
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblPensionerNo))))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(tfLastName, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
									.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
									.addComponent(tfNationallity, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
									.addComponent(tfMedicare, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
									.addComponent(taPensioner, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
								.addGap(50)))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUserName)
						.addComponent(tfUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCurrentMedications)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
