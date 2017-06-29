package edd.floremipy.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customerorderline database table.
 * 
 */
@Entity
@NamedQuery(name="Customerorderline.findAll", query="SELECT c FROM Customerorderline c")
public class Customerorderline implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerorderlinePK id;

	private int delivredQuantity;

	private int quantity;

	//bi-directional many-to-one association to Customerorder
	@ManyToOne
	@JoinColumn(name="IdCustomerOrder")
	private Customerorder customerorder;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="IdArticle")
	private Article article;

	public Customerorderline() {
	}

	public CustomerorderlinePK getId() {
		return this.id;
	}

	public void setId(CustomerorderlinePK id) {
		this.id = id;
	}

	public int getDelivredQuantity() {
		return this.delivredQuantity;
	}

	public void setDelivredQuantity(int delivredQuantity) {
		this.delivredQuantity = delivredQuantity;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Customerorder getCustomerorder() {
		return this.customerorder;
	}

	public void setCustomerorder(Customerorder customerorder) {
		this.customerorder = customerorder;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}