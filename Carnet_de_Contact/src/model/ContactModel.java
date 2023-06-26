package model;

public class ContactModel {

	int id;
	String nom;
	String prenom;
	String mail;
	String telephone;

	public ContactModel() {
		this.id = 0;
		this.nom = "";
		this.prenom = "";
		this.mail = "";
		this.telephone = "";
	}
	
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getMail() {
		return mail;
	}
	public String getTelephone() {
		return telephone;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return id + ", " + nom + ", " + prenom + ", " + mail + ", " + telephone;
	}
}
