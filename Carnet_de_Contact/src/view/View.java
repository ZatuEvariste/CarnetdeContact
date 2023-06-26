package view;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Color;

public class View {

	private JFrame frame;
	private JList listeContact;
	private JTextField textFieldId;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldMail;
	private JTextField textFieldTelephone;
	private JTextField textFieldRechercheContact;
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnEffacer;
	private JButton btnSupprimer;
	private JButton btnRechercher;
	private JLabel lblMessage;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					View window = new View();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel donneesContactPanel = new JPanel();
		donneesContactPanel.setBorder(BorderFactory.createTitledBorder("Les données de contact :"));
		donneesContactPanel.setBounds(26, 27, 351, 203);
		frame.getContentPane().add(donneesContactPanel);
		donneesContactPanel.setLayout(null);
		
		JLabel lbId = new JLabel("ID :");
		lbId.setBounds(10, 21, 46, 14);
		donneesContactPanel.add(lbId);
		
		JLabel lbNom = new JLabel("Nom :");
		lbNom.setBounds(10, 46, 46, 14);
		donneesContactPanel.add(lbNom);
		
		JLabel lbPrenom = new JLabel("Prénom :");
		lbPrenom.setBounds(10, 71, 46, 14);
		donneesContactPanel.add(lbPrenom);
		
		JLabel lbMail = new JLabel("Email :");
		lbMail.setBounds(10, 96, 46, 14);
		donneesContactPanel.add(lbMail);
		
		JLabel lbTelephone = new JLabel("Tel :");
		lbTelephone.setBounds(10, 121, 46, 14);
		donneesContactPanel.add(lbTelephone);
		
		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		textFieldId.setBounds(66, 18, 70, 20);
		donneesContactPanel.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		textFieldNom.setBounds(66, 43, 204, 20);
		donneesContactPanel.add(textFieldNom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(66, 68, 204, 20);
		donneesContactPanel.add(textFieldPrenom);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(66, 93, 204, 20);
		donneesContactPanel.add(textFieldMail);
		
		textFieldTelephone = new JTextField();
		textFieldTelephone.setColumns(10);
		textFieldTelephone.setBounds(66, 118, 204, 20);
		donneesContactPanel.add(textFieldTelephone);
		
		JPanel listeContactPanel = new JPanel();
		listeContactPanel.setBorder(BorderFactory.createTitledBorder("Liste des contacts :"));
		listeContactPanel.setBounds(412, 27, 351, 391);
		frame.getContentPane().add(listeContactPanel);
		listeContactPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 331, 358);
		listeContactPanel.add(scrollPane);
		
		listeContact = new JList();
		scrollPane.setViewportView(listeContact);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(26, 254, 156, 38);
		frame.getContentPane().add(btnAjouter);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(221, 254, 156, 38);
		frame.getContentPane().add(btnModifier);
		
		btnEffacer = new JButton("Effacer");
		btnEffacer.setBounds(26, 303, 156, 38);
		frame.getContentPane().add(btnEffacer);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(221, 303, 156, 38);
		frame.getContentPane().add(btnSupprimer);
		
		btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(607, 475, 156, 38);
		frame.getContentPane().add(btnRechercher);
		
		textFieldRechercheContact = new JTextField();
		textFieldRechercheContact.setBounds(26, 475, 571, 38);
		frame.getContentPane().add(textFieldRechercheContact);
		textFieldRechercheContact.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Rechercher un contact :");
		lblNewLabel.setBounds(26, 450, 123, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblMessage = new JLabel("");
		lblMessage.setForeground(new Color(255, 0, 0));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(123, 381, 156, 14);
		frame.getContentPane().add(lblMessage);
	}



	public JList getListeContact() {
		return listeContact;
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTextFieldId() {
		return textFieldId;
	}

	public JTextField getTextFieldNom() {
		return textFieldNom;
	}

	public JTextField getTextFieldPrenom() {
		return textFieldPrenom;
	}

	public JTextField getTextFieldMail() {
		return textFieldMail;
	}

	public JTextField getTextFieldTelephone() {
		return textFieldTelephone;
	}

	public JTextField getTextFieldRechercheContact() {
		return textFieldRechercheContact;
	}

	public JButton getBtnAjouter() {
		return btnAjouter;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public JButton getBtnEffacer() {
		return btnEffacer;
	}

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public JButton getBtnRechercher() {
		return btnRechercher;
	}
	

	public JLabel getLblMessage() {
		return lblMessage;
	}

	public void setListeContact(JList listeContact) {
		this.listeContact = listeContact;
	}

	public void setLblMessage(JLabel lblMessage) {
		this.lblMessage = lblMessage;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setTextFieldId(JTextField textFieldId) {
		this.textFieldId = textFieldId;
	}

	public void setTextFieldNom(JTextField textFieldNom) {
		this.textFieldNom = textFieldNom;
	}

	public void setTextFieldPrenom(JTextField textFieldPrenom) {
		this.textFieldPrenom = textFieldPrenom;
	}

	public void setTextFieldMail(JTextField textFieldMail) {
		this.textFieldMail = textFieldMail;
	}

	public void setTextFieldTelephone(JTextField textFieldTelephone) {
		this.textFieldTelephone = textFieldTelephone;
	}

	public void setTextFieldRechercheContact(JTextField textFieldRechercheContact) {
		this.textFieldRechercheContact = textFieldRechercheContact;
	}
	public void setBtnAjouter(JButton btnAjouter) {
		this.btnAjouter = btnAjouter;
	}

	public void setBtnModifier(JButton btnModifier) {
		this.btnModifier = btnModifier;
	}

	public void setBtnEffacer(JButton btnEffacer) {
		this.btnEffacer = btnEffacer;
	}

	public void setBtnSupprimer(JButton btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}

	public void setBtnRechercher(JButton btnRechercher) {
		this.btnRechercher = btnRechercher;
	}
}
