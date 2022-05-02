package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.Database;

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setTitle("EPS - Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 511);
		
		JButton btnNewUser = new JButton("New Patient");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnLogin = new JButton("Login");
		
		JLabel lblHomeIcon = new JLabel("");
		lblHomeIcon.setIcon(new ImageIcon(LandingPage.class.getResource("/resources/landingIcon_64.png")));
		
		JLabel lblUserName = new JLabel("Username");
		
		JLabel lblPassword = new JLabel("Password");
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JRadioButton rbPatient = new JRadioButton("Patient");
		buttonGroup.add(rbPatient);
		rbPatient.setSelected(true);
		
		JRadioButton rbDoctor = new JRadioButton("Doctor");
		buttonGroup.add(rbDoctor);
		
		JRadioButton rbPharmacy = new JRadioButton("Pharmacy");
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(174)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
							.addComponent(btnNewUser))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(188)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPassword)
										.addComponent(lblUserName))
									.addGap(66)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblHomeIcon)
											.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE))
										.addComponent(tfUsername, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblUsertype)
									.addGap(18)
									.addComponent(rbPatient)
									.addGap(18)
									.addComponent(rbDoctor)
									.addGap(18)
									.addComponent(rbPharmacy)))))
					.addGap(212))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(294)
					.addComponent(btnTestPatient)
					.addContainerGap(306, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(lblHomeIcon, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
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
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnNewUser))
					.addGap(49)
					.addComponent(btnTestPatient)
					.addGap(53))
		);
		getContentPane().setLayout(groupLayout);
	}
}
