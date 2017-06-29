package edd.floremipy.dto;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CatalogueLineDTO implements Serializable {
	@Override
	public String toString() {
		return "CatalogueLineDTO [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", stock=" + stock + ", description=" + description + ", imgsrc=" + imgsrc + "]";
	}
	int id;
	String name;
	String category;
	double price;
	int stock;
	String description;
	String imgsrc;
	
	public CatalogueLineDTO(int id, String name, String category, double price, int stock, String description,
			String imgsrc) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.description = description;
		this.imgsrc = imgsrc;
	}
	
	
	/*
	public CatalogueLineDTO(int id, String name, String category, double price, int stock, String description, String imgsrc) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.description= description;
		this.imgsrc=imgsrc;
	}
	*/ 
	

	public CatalogueLineDTO() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	
	//convertir au format String JSON(P) chaque ligne du catalogue reçu
    public String lineToJson() {
        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(this));
        return gson.toJson(this);    
    }

}
