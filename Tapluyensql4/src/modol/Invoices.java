package modol;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entites.Invoice;

public class Invoices {
	public List<Invoice> findAll() {
		List<Invoice> invoice = new ArrayList<Invoice>();
		try {
			PreparedStatement preparedstatement = ConnectDB.connection()
					.prepareStatement("select * from invoice");
			ResultSet result = preparedstatement.executeQuery();
			while (result.next()) {
				Invoice invoices = new Invoice();
				invoices.setId(result.getInt("id"));
				invoices.setName(result.getString("name"));
				invoices.setPayment(result.getString("payment"));
				invoices.setStatus(result.getString("status"));
				invoices.setCreated(result.getDate("created"));
				invoices.setTotal(result.getDouble("total"));
				invoice.add(invoices);
			}
		} catch (Exception e) {
			System.out.println("loi o day");
		} finally {
			ConnectDB.disconnect();
		}
		return invoice;
	}
	
	public List<Invoice> sort() {
		List<Invoice> invoice = new ArrayList<Invoice>();
		try {
			PreparedStatement preparedstatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM invoice ORDER BY id DESC");
			ResultSet result = preparedstatement.executeQuery();
			while (result.next()) {
				Invoice invoices = new Invoice();
				invoices.setId(result.getInt("id"));
				invoices.setName(result.getString("name"));
				invoices.setPayment(result.getString("payment"));
				invoices.setStatus(result.getString("status"));
				invoices.setCreated(result.getDate("created"));
				invoices.setTotal(result.getDouble("total"));
				invoice.add(invoices);
			}
		} catch (Exception e) {
			System.out.println("loi o day");
		} finally {
			ConnectDB.disconnect();
		}
		return invoice;
	}
	
	public List<Invoice> sort2( double min, double max) {
		List<Invoice> invoice = new ArrayList<Invoice>();
		try {
			PreparedStatement preparedstatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM invoice where total >= ? and total <= ? and created = CURDATE()");
			// created = curdate() : so sanh ngay trong sql voi ngay hien tai
			preparedstatement.setDouble(1, min);
			preparedstatement.setDouble(2,max);
			
			
			ResultSet result = preparedstatement.executeQuery();
			
			while (result.next()) {
				Invoice invoices = new Invoice();
				invoices.setId(result.getInt("id"));
				invoices.setName(result.getString("name"));
				invoices.setPayment(result.getString("payment"));
				invoices.setStatus(result.getString("status"));
				invoices.setCreated(result.getDate("created"));
				invoices.setTotal(result.getDouble("total"));
				invoice.add(invoices);
			}
		} catch (Exception e) {
			System.out.println("loi o day");
		} finally {
			ConnectDB.disconnect();
		}
		return invoice;
	}
	
	public List<Invoice> sort4(String key) {
		List<Invoice> invoice = new ArrayList<Invoice>();
		try {
			PreparedStatement preparedstatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM invoice where payment = ? ORDER BY total DESC");
			preparedstatement.setString(1, key);
			ResultSet result = preparedstatement.executeQuery();
			while (result.next()) {
				Invoice invoices = new Invoice();
				invoices.setId(result.getInt("id"));
				invoices.setName(result.getString("name"));
				invoices.setPayment(result.getString("payment"));
				invoices.setStatus(result.getString("status"));
				invoices.setCreated(result.getDate("created"));
				invoices.setTotal(result.getDouble("total"));
				invoice.add(invoices);
			}
		} catch (Exception e) {
			System.out.println("loi o day");
		} finally {
			ConnectDB.disconnect();
		}
		return invoice;
	}
	
	public List<Invoice> sort5(Date star, Date end, String keyword) {
		List<Invoice> invoice = new ArrayList<Invoice>();
		try {
			PreparedStatement preparedstatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM invoice where created >= ? and created <= ? and status =?");
			preparedstatement.setDate(1, new java.sql.Date(star.getTime()));
			preparedstatement.setDate(2, new java.sql.Date(end.getTime()));
			preparedstatement.setString(3,keyword);
			ResultSet result = preparedstatement.executeQuery();
			while (result.next()) {
				Invoice invoices = new Invoice();
				invoices.setId(result.getInt("id"));
				invoices.setName(result.getString("name"));
				invoices.setPayment(result.getString("payment"));
				invoices.setStatus(result.getString("status"));
				invoices.setCreated(result.getDate("created"));
				invoices.setTotal(result.getDouble("total"));
				invoice.add(invoices);
			}
		} catch (Exception e) {
			System.out.println("loi o day");
		} finally {
			ConnectDB.disconnect();
		}
		return invoice;
	}
}
