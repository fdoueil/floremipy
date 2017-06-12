package edd.floremipy.service;

import java.util.HashMap;


import edd.floremipy.model.User;

public class UserServiceImpl implements UserServiceInterface {
	
	HashMap<String,User> listeDesUsers = new HashMap<String,User> ();

	@Override
	public String authenticate(String login, String pwd) {
		// TODO : stub tous les login sont ok dans un premier temps
		return login;
	}

	@Override
	public int disconnect(String login) {
		// TODO Auto-generated method stub
		return 0;
	}

}
