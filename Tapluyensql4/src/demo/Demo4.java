package demo;

import java.util.List;

import entites.Invoice;
import modol.ConnectDB;
import modol.Invoices;

public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//if(ConnectDB.connection() != null) {
			//System.out.println("Done");
		//}else {
			//System.out.println ("Faile");
		//}
		
		Invoices invoices = new Invoices();
		List<Invoice> invoi = invoices.sort4( "chuyen khoan");
		System.out.println("invoice: "+ invoi.size());
		for(Invoice ina : invoi) {
			System.out.println("id: "+ ina.getId());
			System.out.println("id: "+ ina.getName());
			System.out.println("id: "+ ina.getStatus());
			System.out.println("id: "+ ina.getPayment());
			System.out.println("id: "+ ina.getTotal());
			System.out.println("id: "+ ina.getCreated());
			System.out.println("----------------------------");
		}
	}

}
