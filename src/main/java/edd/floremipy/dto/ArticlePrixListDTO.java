package edd.floremipy.dto;

public class ArticlePrixListDTO {

	public String name;
	public String Description;
	public float priceValue;
	public int quantityInStock;
	public int quantityOrder;
	public int id;
	public String img;

	public ArticlePrixListDTO() {
		this.name = "Article Test";
		this.Description = "Article cr�� automatiquement";
		this.priceValue = 10.26F;
		this.quantityInStock = 12;
		this.quantityOrder = 0;
		this.id = -9999;
		this.img = "Olivier.jpg";
	}

	public String getName() {
		return this.name;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public float getPriceValue() {
		return this.priceValue;
	}

	public void setPriceValue(float priceValue) {
		this.priceValue = priceValue;
	}

	public int getQuantityInStock() {
		return this.quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public int getQuantityOrder() {
		return this.quantityOrder;
	}

	public void setQuantityOrder(int quantityOrder) {
		this.quantityOrder = quantityOrder;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}



}
