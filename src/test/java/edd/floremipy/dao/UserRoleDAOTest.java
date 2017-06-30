package edd.floremipy.dao;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import edd.floremipy.model.UserRoleDb;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRoleDAOTest {

	@Autowired
	private UserRoleDAO useRoleDao;
	
	@Test
	public void testDirecteur() {
		UserRoleDb userRoleExpected= useRoleDao.findByUserName("le_directeur");
		assertEquals("DIRECTEUR", userRoleExpected.getRole());
	}

	@Test
	public void testClient() {
		UserRoleDb userRoleExpected= useRoleDao.findByUserName("le_client");
		assertEquals("CLIENT", userRoleExpected.getRole());
	}
}
