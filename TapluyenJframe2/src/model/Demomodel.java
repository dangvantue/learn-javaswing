package model;

import java.util.ArrayList;
import java.util.List;

import entities.City;
import entities.Country;

public class Demomodel {

	public List<Country> findAll() {
		List<Country> country = new ArrayList<Country>();

		List<City> citi1 = new ArrayList<City>();
		citi1.add(new City("hue", "tthue", 5000, 748));
		citi1.add(new City("dn", "da nang", 3000, 500));
		citi1.add(new City("qt", "quang tri", 4000, 700));
		country.add(new Country("vn", "viet nam", citi1));

		List<City> citi2 = new ArrayList<City>();
		citi2.add(new City("tt", "thanh hoa", 7000, 848));
		citi2.add(new City("na", "Nghe an", 8000, 900));
		country.add(new Country("bv", " bac viet ", citi2));

		List<City> citi3 = new ArrayList<City>();
		citi3.add(new City("saigon", "ho chi minh", 4000, 1848));
		citi3.add(new City("bd", "binh duong", 5000, 1200));
		country.add(new Country("nv", " nam viet ", citi3));

		return country;
	}
}
