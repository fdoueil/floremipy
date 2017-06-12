package edd.floremipy.service;

import java.util.ArrayList;

import edd.floremipy.model.User;

public interface UserServiceInterface {
	
	String authenticate(String login, String pwd);	
	int disconnect(String login);
	

}
