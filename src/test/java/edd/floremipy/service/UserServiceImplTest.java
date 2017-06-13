package edd.floremipy.service;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edd.floremipy.dto.UserDTO;
import edd.floremipy.model.UserRole;


public class UserServiceImplTest {
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testAuthenticate() {
		// On se logge si on donne le bon login et mot de passe
		String expected = "le_directeur";
		String actual = UserServiceImpl.getInstance().authenticate("le_directeur", "Dir#01");
		assertEquals(expected,actual);		
	}
	
	@Test
	public void testAuthenticateLoginInexistant() {
		// On retourne utilisateur inconnu si login incorrect
		String expected = "PB:LoginController:Erreur 001:Utilisateur inconnu";
		String actual =  UserServiceImpl.getInstance().authenticate("INCONNU@xyz.com", "11");
		assertEquals(expected,actual);		
	}
	@Test
	public void testAuthenticatePwdIncorrect() {
		//on retourne 'mot de passe incorrect' si login correct, mais pas le bon mot de passe fourni
		String expected = "PB:Pwd:Erreur 001:Mot de passe incorrect pour cet utilisateur";
		String actual = UserServiceImpl.getInstance().authenticate("le_directeur", "pwdIncorrect");
		assertEquals(expected,actual);	
	}
	
	@Test
	public void testGetUser() {
		// On verifie getUser qui nous donne apres authentification le role et le mail d'un user
		String expected = "DIRECTEUR";
		String expectedMail = "directeur@bl.com";
		UserDTO unUserDTO = UserServiceImpl.getInstance().getUser("le_directeur");
		assertEquals(expected,unUserDTO.getRole().toString());	
		
		assertEquals(expectedMail, unUserDTO.getEmail());
	}
	
	


}
