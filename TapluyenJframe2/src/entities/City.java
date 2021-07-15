package entities;

public class City {
	private String id;
	private String name;
	private int popualation;
	private double area;

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

	public int getPopualation() {
		return popualation;
	}

	public void setPopualation(int popualation) {
		this.popualation = popualation;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public City(String id, String name, int popualation, double area) {
		super();
		this.id = id;
		this.name = name;
		this.popualation = popualation;
		this.area = area;
	}

	public City() {
		super();
	}

}
