package demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entites.Invoice;
import modol.ConnectDB;
import modol.Invoices;

public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//if(ConnectDB.connection() != null) {
			//System.out.println("Done");
		//}else {
			//System.out.println ("Faile");
		//}
		try {SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy");
		// format choi ve dang date
		Date starday = simpledateformat.parse("01/07/2021");
		Date endday = simpledateformat.parse("20/07/2021");
		Invoices invoices = new Invoices();
		List<Invoice> invoi = invoices.sort5(starday, endday, "chua hoan thanh");
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
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
