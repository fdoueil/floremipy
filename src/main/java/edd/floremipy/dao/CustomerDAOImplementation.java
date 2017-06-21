package edd.floremipy.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edd.floremipy.model.Customer;

@Repository("unCustomerDAO")
@Scope("singleton")

public class CustomerDAOImplementation extends AbstractDAO implements CustomerDAOInterface {

	@Override
	public Customer findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
