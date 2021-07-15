package entities;

public class Product {
	private String id;
	private String name;
	private double price;
	private int quantity;
	private String descripsion;

	public Product() {
		super();
	}

	public Product(String id, String name, double price, int quantity, String descripsion) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.descripsion = descripsion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getDescripsion() {
		return descripsion;
	}

	public void setDescripsion(String descripsion) {
		this.descripsion = descripsion;
	}

}
