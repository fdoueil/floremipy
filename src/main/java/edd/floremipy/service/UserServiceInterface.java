package edd.floremipy.service;

import java.util.ArrayList;

import edd.floremipy.model.User;

public interface UserServiceInterface {
	
	String authenticate(String login, String pwd);	
	int disconnect(String login);
	
//	@Override
//	public void add(User newUser) ;
//
//	@Override
//	public void delete(String identifiantUser);
//
//	@Override
//	public HashMap<String, User> getListeDesUsers(); 
}
