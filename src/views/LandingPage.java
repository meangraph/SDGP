package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.Patient;

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class LandingPage extends JFrame {
	private JTextField tfUsername;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JPopupMenu popup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LandingPage frame = new LandingPage();
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
	public LandingPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LandingPage.class.getResource("/resources/EvolveImageIcon.png")));
		
		getContentPane().setBackground(Color.WHITE);
		setTitle("Evolve - New Era Prescription System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 511);
		
		JButton btnNewUser = new JButton("New Patient");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signUpPage = new SignUp();
				signUpPage.setVisible(true);
			}
		});
		
		
		JLabel lblHomeIcon = new JLabel("");
		lblHomeIcon.setIcon(new ImageIcon(LandingPage.class.getResource("/resources/EvolveImage.png")));
		
		JLabel lblUserName = new JLabel("Username");
		
		JLabel lblPassword = new JLabel("Password");
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JRadioButton rbPatient = new JRadioButton("Patient");
		rbPatient.setBackground(Color.WHITE);
		buttonGroup.add(rbPatient);
		rbPatient.setSelected(true);
		
		JRadioButton rbDoctor = new JRadioButton("Doctor");
		rbDoctor.setBackground(Color.WHITE);
		buttonGroup.add(rbDoctor);
		
		JRadioButton rbPharmacy = new JRadioButton("Pharmacy");
		rbPharmacy.setBackground(Color.WHITE);
		buttonGroup.add(rbPharmacy);
		
		JLabel lblUsertype = new JLabel("User Type");
		
		JButton btnTestPatient = new JButton("Test Patient");
		btnTestPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorViewGui doctorGui = new DoctorViewGui();
				doctorGui.setVisible(true);
				dispose();
			}
		});
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbPatient.isSelected()) {
					try {
						FileInputStream patients = new FileInputStream("patients.txt");
						ObjectInputStream objectIn = new ObjectInputStream(patients);
						
						ArrayList<Patient> patientList = (ArrayList<Patient>) objectIn.readObject();
						objectIn.close();
						
						for (int i = 0; i < patientList.size();i++) {
							if(patientList.get(i).getPatientID().compareTo(tfUsername.getText()) == 0 && patientList.get(i).getPassword().compareTo(passwordField.getText()) == 0){
								int index = i;
								System.out.println(i);
								JOptionPane.showMessageDialog(null,
		                                "User logged in succesfully");
								
								PatientView pview = new PatientView(index);
								pview.setVisible(true);
								dispose();
								break;
							
							} 
							
							
							
						}
			
						
						
					} catch (IOException | ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(215))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(188)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPassword)
										.addComponent(lblUserName))
									.addGap(66)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
										.addComponent(tfUsername, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblUsertype)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblHomeIcon)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btnTestPatient)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnNewUser))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(rbPatient)
												.addGap(18)
												.addComponent(rbDoctor)
												.addGap(18)
												.addComponent(rbPharmacy))))))))
					.addGap(212))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblHomeIcon, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUserName)
						.addComponent(tfUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rbPharmacy)
						.addComponent(rbDoctor)
						.addComponent(rbPatient)
						.addComponent(lblUsertype))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnNewUser)
						.addComponent(btnTestPatient))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
}
