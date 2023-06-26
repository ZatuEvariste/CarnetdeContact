package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
import java.util.ArrayList;
import javax.swing.*;

import model.ContactDAO;
import model.ContactModel;
import view.View;

public class Controller {
	private ContactModel modele;
	private View vue;
	private ContactDAO contactDao;
	private ArrayList<ContactModel> arrayContacts = null;
	
	public Controller(View vue) {
		this.vue = vue;
		contactDao = new ContactDAO();
		arrayContacts = contactDao.getAllContacts();
		vue.getListeContact().setListData(arrayContacts.toArray());
		initController();
	}
	
	public void initController() {
		vue.getBtnAjouter().addActionListener(ActionEvent->ajouterContact());
		vue.getBtnEffacer().addActionListener(ActionEvent->effacer());
		vue.getListeContact().addListSelectionListener(ListeSelectionEvent->selectionContact());
		vue.getBtnModifier().addActionListener(ActionEvent->modifierContact());
		vue.getBtnSupprimer().addActionListener(ActionEvent->supprimerContact());
	}
	
	private void ajouterContact() {
		String nom = vue.getTextFieldNom().getText();
		String prenom = vue.getTextFieldPrenom().getText();
		String email = vue.getTextFieldMail().getText();
		String tel = vue.getTextFieldTelephone().getText();
		
		modele = new ContactModel();
		modele.setNom(nom);
		modele.setPrenom(prenom);
		modele.setMail(email);
		modele.setTelephone(tel);
		contactDao.ajouterContact(modele);
		
		arrayContacts = contactDao.getAllContacts();
		vue.getListeContact().setListData(arrayContacts.toArray());
		
		vue.getLblMessage().setText("Contact ajouté");
	}
	
	private void selectionContact() {
		int selectionModele = vue.getListeContact().getSelectedIndex();
		if (selectionModele < 0) {
			return;
		}
		
		ContactModel modele1 = arrayContacts.get(selectionModele);
		vue.getTextFieldId().setText(" " + (modele1.getId()));
		vue.getTextFieldNom().setText(modele1.getNom());
		vue.getTextFieldPrenom().setText(modele1.getPrenom());
		vue.getTextFieldMail().setText(modele1.getMail());
		vue.getTextFieldTelephone().setText(modele1.getTelephone());
	}
	
	private void modifierContact() {
		int option = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment modifier le contact? ");
		if (option == JOptionPane.OK_OPTION) {
			String idContact = vue.getTextFieldId().getText();
			int idCont = Integer.parseInt(idContact);
			String nom = vue.getTextFieldNom().getText();
			String prenom = vue.getTextFieldPrenom().getText();
			String email = vue.getTextFieldMail().getText();
			String tel = vue.getTextFieldTelephone().getText();
			
			modele = new ContactModel();
			modele.setId(idCont);
			modele.setNom(nom);
			modele.setPrenom(prenom);
			modele.setMail(email);
			modele.setTelephone(tel);
			contactDao.modifierContact(modele);
			
			arrayContacts = contactDao.getAllContacts();
			vue.getListeContact().setListData(arrayContacts.toArray());
			
			vue.getLblMessage().setText("Contact modifié");
		}
	}
	
	private void supprimerContact() {
		int option = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer le contact? ");
		if (option == JOptionPane.OK_OPTION) {
			String idContact = vue.getTextFieldId().getText();
			int idCont = Integer.parseInt(idContact);
			
			modele = new ContactModel();
			modele.setId(idCont);
			
			contactDao.supprimerContact(modele);
			
			arrayContacts = contactDao.getAllContacts();
			vue.getListeContact().setListData(arrayContacts.toArray());
			
			vue.getLblMessage().setText("Contact supprimé");
		}
	}
	
	private void effacer() {
		vue.getTextFieldId().setText("");
		vue.getTextFieldNom().setText("");
		vue.getTextFieldPrenom().setText("");
		vue.getTextFieldMail().setText("");
		vue.getTextFieldTelephone().setText("");
	}
	
}
