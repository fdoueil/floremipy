package edd.floremipy.service;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import edd.floremipy.dto.UserRoleDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsServiceImplTest {

	@Autowired
	private UserDetailsServiceImpl userDetailService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Test
	public void testAdm() {
		UserRoleDTO userRoleDto = (UserRoleDTO) userDetailService.loadUserByUsername("adm");
		assertNotNull(userDetailService);
		assertEquals(4, userRoleDto.getId());
		assertTrue(isRolePresent(userRoleDto.getAuthorities(),"ROLE_ADMIN"));
		assertTrue(passwordEncoder.matches("adm", "$2a$10$C9VKScI/geqTvEMqPLFWbeIcZczntJTE6umI2QJqHBS.JaVYD1mz2"));
	}
	
	@Test(expected = UsernameNotFoundException.class)
	public void testNonExistUser() {
		UserRoleDTO userRoleDto = (UserRoleDTO) userDetailService.loadUserByUsername("xxx");
	}

	/**
	 * Check if a role is present in the authorities of current user
	 * 
	 * @param authorities
	 *            all authorities assigned to current user
	 * @param role
	 *            required authority
	 * @return true if role is present in list of authorities assigned to
	 *         current user, false otherwise
	 */
	private boolean isRolePresent(Collection<GrantedAuthority> authorities, String role) {
		boolean isRolePresent = false;
		for (GrantedAuthority grantedAuthority : authorities) {
			isRolePresent = grantedAuthority.getAuthority().equals(role);
			if (isRolePresent)
				break;
		}
		return isRolePresent;
	}
}
