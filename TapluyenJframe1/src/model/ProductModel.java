package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class ProductModel {
	// viet ham luu thong tin 1 doi tuong product
	
	
	public void save(Product product) {
		//List<Product> product = new ArrayList<Product>();
		
		try {
			String content = "id: " + product.getId() + "\n" + "name: " + product.getName() + "\n" + "price: " + product.getPrice() + "\n" + "quantity: " + product.getQuantity()
			 + "\n"+ "decripsion: "+ product.getDescripsion();
			
			Files.write(Paths.get("c:\\tuejava\\tuejava2\\" + product.getId() + product.getName()+".txt"),content.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("loi roi");
		}		
	}

}
