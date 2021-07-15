package entities;

import java.util.ArrayList;
import java.util.List;

public class Country {
	private String id;
	private String name;
	private List<City> city = new ArrayList<City>();

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

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}

	public Country(String id, String name, List<City> city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public Country() {
		super();
	}

}
