package model;

import java.sql.*;
import java.util.*;

public class ContactDAO {
	
	private Connection conn;
	
	public ContactDAO() {
		conn = Maconnexion.getConnection();
	}
	
	public void ajouterContact(ContactModel contM) {
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("insert into contacts(nom_cont,prenom_cont,mail_cont,telephone_cont) values (?,?,?,?)");
			preparedStatement.setString(1, contM.getNom());
			preparedStatement.setString(2, contM.getPrenom());
			preparedStatement.setString(3, contM.getMail());
			preparedStatement.setString(4, contM.getTelephone());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
	
	public void modifierContact(ContactModel contM) {
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("update contacts set nom_cont=?, prenom_cont=?, mail_cont=?, telephone_cont=? where id_cont =" + contM.getId());
			preparedStatement.setString(1, contM.getNom());
			preparedStatement.setString(2, contM.getPrenom());
			preparedStatement.setString(3, contM.getMail());
			preparedStatement.setString(4, contM.getTelephone());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
	
	public void supprimerContact(ContactModel contM) {
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("delete from contacts where id_cont =" + contM.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
	
	public ArrayList<ContactModel> getAllContacts() {
		ArrayList<ContactModel> contMListe = new ArrayList<ContactModel>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultats = statement.executeQuery("select * from contacts order by id_cont");
			while (resultats.next()) {
				ContactModel contM = new ContactModel();
				contM.setId(resultats.getInt("id_cont"));
				contM.setNom(resultats.getString("nom_cont"));
				contM.setPrenom(resultats.getString("prenom_cont"));
				contM.setMail(resultats.getString("mail_cont"));
				contM.setTelephone(resultats.getString("telephone_cont"));
				contMListe.add(contM);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contMListe;
	}
}
