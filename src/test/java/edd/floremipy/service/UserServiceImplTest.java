package edd.floremipy.service;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


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
		
		String expected = "le_directeur";
		String actual = UserServiceImpl.getInstance().authenticate("le_directeur", "Dir#01");
		assertEquals(expected,actual);		
	}
	
	@Test
	public void testAuthenticateLoginInexistant() {
		String expected = "PB:Login:Erreur 001:Utilisateur inconnu";
		String actual =  UserServiceImpl.getInstance().authenticate("INCONNU@xyz.com", "11");
		assertEquals(expected,actual);		
	}
	@Test
	public void testAuthenticatePwdIncorrect() {
		String expected = "PB:Pwd:Erreur 001:Mot de passe incorrect pour cet utilisateur";
		String actual = UserServiceImpl.getInstance().authenticate("le_directeur", "pwdIncorrect");
		assertEquals(expected,actual);	
	}


}
