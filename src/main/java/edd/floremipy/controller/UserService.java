package edd.floremipy.controller;

import java.util.ArrayList;

import edd.floremipy.model.User;

public interface UserService {
	
	User authenticate(String login, String pwd);
	
}
