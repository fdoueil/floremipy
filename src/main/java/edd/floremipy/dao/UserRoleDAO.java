package edd.floremipy.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import edd.floremipy.model.UserRoleDb;

@Component
public class UserRoleDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private static final long serialVersionUID = 7358773333340661699L;

	public UserRoleDb findByUserName(String userName) {

		String q = "SELECT u FROM UserRoleDb u where upper(u.username) = upper(:userName)";
		Query reqInnerJoin = entityManager.createQuery(q);
		reqInnerJoin.setParameter("userName", userName);

		UserRoleDb userRole = (UserRoleDb) reqInnerJoin.getSingleResult();
		
		return userRole;
	}
}
