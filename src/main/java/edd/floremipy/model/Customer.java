package edd.floremipy.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	private String firstName;

	private String name;

	private String phone;

	//bi-directional many-to-one association to Adress
	@ManyToOne
	@JoinColumn(name="IdAdress")
	private Adress adress;

	//bi-directional many-to-one association to Customerorder
	@OneToMany(mappedBy="customer")
	private List<Customerorder> customerorders;

	public Customer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Adress getAdress() {
		return this.adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public List<Customerorder> getCustomerorders() {
		return this.customerorders;
	}

	public void setCustomerorders(List<Customerorder> customerorders) {
		this.customerorders = customerorders;
	}

	public Customerorder addCustomerorder(Customerorder customerorder) {
		getCustomerorders().add(customerorder);
		customerorder.setCustomer(this);

		return customerorder;
	}

	public Customerorder removeCustomerorder(Customerorder customerorder) {
		getCustomerorders().remove(customerorder);
		customerorder.setCustomer(null);

		return customerorder;
	}

}