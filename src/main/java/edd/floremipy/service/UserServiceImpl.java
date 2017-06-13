package edd.floremipy.service;

import java.util.HashMap;

import edd.floremipy.dto.UserDTO;
import edd.floremipy.model.User;
import edd.floremipy.model.UserRole;

public class UserServiceImpl implements UserServiceInterface {

	HashMap<String, User> listeDesUsers = new HashMap<String, User>();

	private static UserServiceImpl userManagerUnique;

	public static UserServiceImpl getInstance() {
		if (userManagerUnique == null) {
			userManagerUnique = new UserServiceImpl();
			preRemplir();
		}
		return userManagerUnique;
	}

	@Override
	public String authenticate(String login, String pwd) {

		String retour = login;
		User userLogge = this.listeDesUsers.get(login);
		if (userLogge == null) {
			retour = "PB:LoginController:Erreur 001:Utilisateur inconnu";
		} else {
			if (!userLogge.getPwd().equals(pwd)) {
				userLogge = null;
				retour = "PB:Pwd:Erreur 001:Mot de passe incorrect pour cet utilisateur";
			}
		}
		return retour;

	}

	@Override
	public int disconnect(String login) {
		// TODO Auto-generated method stub
		return 0;
	}

	//
	// @Override
	// public HashMap<String, User> getListeDesUsers() {
	//
	// return listeDesUsers;
	// }

	private static void preRemplir() {

		System.out.println("avant:" + userManagerUnique.listeDesUsers.size());
		Long id = (long) 1;
		String ident1 = "le_directeur";
		Long idCustomer = (long) 10;

		User user1 = new User(id, ident1, "directeur@bl.com", "Dir#01", UserRole.DIRECTEUR, idCustomer);
		userManagerUnique.listeDesUsers.put(ident1, user1);

		id = (long) 2;
		String ident2 = "le_jardinier";
		Long idCustomer2 = (long) 20;
		User user2 = new User(id, ident2, "jardinier@bl.com", "Jar#01", UserRole.JARDINIER, idCustomer2);
		userManagerUnique.listeDesUsers.put(ident2, user2);

		id = (long) 3;
		String ident3 = "le_magasinier";
		Long idCustomer3 = (long) 30;
		User user3 = new User(id, ident3, "magasinier@bl.com", "Mag#01", UserRole.MAGASINIER, idCustomer3);
		userManagerUnique.listeDesUsers.put(ident3, user3);
		System.out.println("avant:" + userManagerUnique.listeDesUsers.size());

		id = (long) 4;
		String ident4 = "le_client";
		Long idCustomer4 = (long) 40;
		User user4 = new User(id, ident4, "client@bl.com", "Cli#01", UserRole.CLIENT, idCustomer4);
		userManagerUnique.listeDesUsers.put(ident4, user4);
		System.out.println("avant:" + userManagerUnique.listeDesUsers.size());
	}

	@Override
	public UserDTO getUser(String login) {
		// On retrouve le user associé au login, et on en retourne un DTO
		UserDTO retour = null;
		User userLogge = this.listeDesUsers.get(login);
		if (userLogge != null) {
			retour = new UserDTO(userLogge.getIdentifiant(), userLogge.getEmail(), userLogge.getRole(),	userLogge.getIdCustomer());

		}
		return retour;
	}

}
