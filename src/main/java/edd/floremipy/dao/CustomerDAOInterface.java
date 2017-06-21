package edd.floremipy.dao;

import edd.floremipy.model.Customer;

public interface CustomerDAOInterface {
	Customer findById(long id);
}
