package view;

import controller.Controller;

public class Launch {

	public static void main(String[] args) {
		View vue = new View();
		Controller controleur1 = new Controller(vue);
		
		try {
			vue.getFrame().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
