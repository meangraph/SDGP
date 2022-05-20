package views;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import common.Prescription;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class QRView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Prescription prescription;
	ArrayList<Prescription> prescriptionList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QRView frame = new QRView();
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
	
	
	public QRView(Prescription x){
		
		try {
			FileInputStream prescriptions = new FileInputStream("prescriptions.txt");
			ObjectInputStream prescriptionsIn = new ObjectInputStream(prescriptions);
			prescriptionList = (ArrayList<Prescription>) prescriptionsIn.readObject();
			prescriptionsIn.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		prescription = x;
		setTitle("Prescription for " + prescription.getPatient().getFirstName() + " " + prescription.getPatient().getLastName());
		initComponents();
		
		
	}
	public QRView() {
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		
		setTitle("Prescription for " + prescription.getPatient().getFirstName() + " " + prescription.getPatient().getLastName());
		initComponents();
	}
	private void initComponents(){
		
		getContentPane().setLayout(null);
		setBounds(0, 0, 588, 529);
		JLabel lblQrCode = new JLabel("Test",SwingConstants.CENTER);
		lblQrCode.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblQrCode.setText(prescription.getQrCode());
		lblQrCode.setBounds(198, 333, 183, 27);
		getContentPane().add(lblQrCode);
		
		JLabel lblQRImage = new JLabel();
		String path = "C:\\Users\\B\\eclipse-workspace\\EPS\\QRCodes\\"+prescription.getQrCode()+".jpg";
		lblQRImage.setIcon(new ImageIcon(path));
	    //lblQRImage.setIcon(new ImageIcon(this.getClass().getResource("\\QRCodes"+prescription.getQrCode()+".jpg")));
		lblQRImage.setBounds(139, 29, 300, 300);
		getContentPane().add(lblQRImage);
		
		JLabel lblNewLabel = new JLabel(prescription.getPatient().getFirstName() + " " + prescription.getPatient().getLastName(),SwingConstants.CENTER);
		lblNewLabel.setBounds(209, 371, 164, 14);
		getContentPane().add(lblNewLabel);
		
		JCheckBox cbEmail = new JCheckBox("E-Mail");
		cbEmail.setSelected(true);
		cbEmail.setBackground(Color.WHITE);
		cbEmail.setBounds(157, 392, 68, 23);
		getContentPane().add(cbEmail);
		
		JCheckBox cbSMS = new JCheckBox("SMS");
		cbSMS.setBackground(Color.WHITE);
		cbSMS.setBounds(354, 392, 68, 23);
		getContentPane().add(cbSMS);
		
		JButton sendPrescription = new JButton("Send Prescription");
		sendPrescription.setForeground(Color.WHITE);
		sendPrescription.setBackground(new Color(0, 102, 255));
		sendPrescription.setOpaque(true);
		sendPrescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbEmail.isSelected()==true && cbSMS.isSelected()==false) {
					JOptionPane.showMessageDialog(null, "Email has been sent to " + prescription.getPatient().getEmailAddress());
					dispose();
				}
				if (cbEmail.isSelected() == false && cbSMS.isSelected() == true) {
					JOptionPane.showMessageDialog(null, "SMS has been sent to " + prescription.getPatient().getPhoneNum());
					dispose();
				}
				if (cbEmail.isSelected() == true && cbSMS.isSelected() == true) {
					JOptionPane.showMessageDialog(null, "Email has been sent to " + prescription.getPatient().getEmailAddress() + "\nSMS has been sent to " + prescription.getPatient().getPhoneNum());
					dispose();
				}
				prescriptionList.add(prescription);
				try {
					FileOutputStream prescriptions = new FileOutputStream("prescriptions.txt");
					ObjectOutputStream prescriptionOutput = new ObjectOutputStream(prescriptions);
					prescriptionOutput.writeObject(prescriptionList);
					prescriptionOutput.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		sendPrescription.setBounds(216, 443, 146, 23);
		getContentPane().add(sendPrescription);
		
	}
}
