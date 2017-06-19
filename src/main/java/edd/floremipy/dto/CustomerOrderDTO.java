package edd.floremipy.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class CustomerOrderDTO implements Serializable {
	long id;
	Date customerOrderDate;
	long idCustomer;
	Long idAdress;
	ArrayList<CustomerOrderLineDTO> lignesCommande;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCustomerOrderDate() {
		return customerOrderDate;
	}

	public void setCustomerOrderDate(Date customerOrderDate) {
		this.customerOrderDate = customerOrderDate;
	}

	public long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Long getIdAdress() {
		return idAdress;
	}

	public void setIdAdress(Long idAdress) {
		this.idAdress = idAdress;
	}

	public ArrayList<CustomerOrderLineDTO> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(ArrayList<CustomerOrderLineDTO> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	

}
