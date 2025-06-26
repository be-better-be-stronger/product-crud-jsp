package com.productapp.model;

import java.time.LocalDate;




import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
	
    private String name;
    private double price;
    private int quantity;
    private String unit;
    
  
    @Column(name = "created_date", updatable = false)
    private LocalDate createdDate;
    
    @Column(name = "created_by")
    private String createdBy;

    public Product() {
    }
    
    public Product(String name, double price, int quantity, String unit, LocalDate createdDate, String createdBy) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.unit = unit;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}

    public Product(int id, String name, double price, int quantity, String unit, LocalDate createdDate, String createdBy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.createdDate = LocalDate.now();
        this.createdBy = createdBy;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
