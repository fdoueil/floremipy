package edd.floremipy.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserRoleDTO extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8145893728159454878L;
	private int id;
	
	public UserRoleDTO(int id, String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
