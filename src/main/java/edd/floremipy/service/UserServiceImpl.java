package edd.floremipy.service;


import java.util.HashMap;


import edd.floremipy.model.User;


public class UserServiceImpl implements UserServiceInterface {
	
	HashMap<String,User> listeDesUsers = new HashMap<String,User> ();
	
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
		User userLogge = listeDesUsers.get(login);
		if (userLogge==null) {
			retour = "PB:Login:Erreur 001:Utilisateur inconnu";
		} else
		{
			if (!userLogge.getPwd().equals(pwd)) {
				userLogge=null;
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
	
//	@Override
//	public void add(User newUser) {
//		listeDesUsers.put(newUser.getEmail(), newUser);
//	}
//
//	@Override
//	public void delete(String identifiantUser) {
//		listeDesUsers.remove(identifiantUser);
//	}
//
//	@Override
//	public HashMap<String, User> getListeDesUsers() {
//
//		return listeDesUsers;
//	}

	private static void preRemplir() {
		
		
		System.out.println("avant:" + userManagerUnique.listeDesUsers.size());
		Long id=(long) 1;
		String ident1="le_directeur";		
		User user1 = new User(id, ident1, "directeur@bl.com", "Dir#01");
		userManagerUnique.listeDesUsers.put(ident1,user1);
		
		id=(long) 2;
		String ident2 = "le_jardinier";
		User user2 = new User(id, ident2, "jardinier@bl.com", "Jar#01");
		userManagerUnique.listeDesUsers.put(ident2,user2);
		System.out.println("avant:" + userManagerUnique.listeDesUsers.size());


	}

}
