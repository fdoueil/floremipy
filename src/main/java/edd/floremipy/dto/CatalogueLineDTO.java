package edd.floremipy.dto;

import java.io.Serializable;

public class CatalogueLineDTO implements Serializable {
	@Override
	public String toString() {
		return "CatalogueLineDTO [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", stock=" + stock + "]";
	}
	int id;
	String name;
	String category;
	double price;
	int stock;
	
	
	public CatalogueLineDTO(int id, String name, String category, double price, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}

	protected CatalogueLineDTO() {

		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
