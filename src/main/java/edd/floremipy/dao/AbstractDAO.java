package edd.floremipy.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractDAO implements Serializable {

	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager(){
		return this.entityManager;
	}
}
