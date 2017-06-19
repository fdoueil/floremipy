package edd.floremipy.dto;

import java.io.Serializable;

public class CustomerOrderLineDTO implements Serializable {
	long idArticle;
	int quantity;
	int delivredQuantity;
	public long getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(long idArticle) {
		this.idArticle = idArticle;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDelivredQuantity() {
		return delivredQuantity;
	}
	public void setDelivredQuantity(int delivredQuantity) {
		this.delivredQuantity = delivredQuantity;
	}
	public CustomerOrderLineDTO(long idArticle, int quantity, int delivredQuantity) {
		super();
		this.idArticle = idArticle;
		this.quantity = quantity;
		this.delivredQuantity = delivredQuantity;
	}
	
}
