package edd.floremipy.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import edd.floremipy.model.UserRoleDb;

@Component
public class UserRoleDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public UserRoleDb findByUserName(String userName) {

		String q = "SELECT u FROM UserRoleDb u where upper(u.username) = upper(:userName)";
		Query reqInnerJoin = entityManager.createQuery(q);
		reqInnerJoin.setParameter("userName", userName);

		UserRoleDb userRole = null;
		try {
			userRole=(UserRoleDb) reqInnerJoin.getSingleResult();
		} catch (NoResultException e) {
			//e.printStackTrace();
			//LOG
			throw new UsernameNotFoundException(String.format("User {0} inexistant !",userName));
		}
		
		return userRole;
	}
}
