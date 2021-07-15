package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Product;
import model.ProductModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jframedemo extends JFrame {

	private JPanel contentPane;
	private JTextField JtextfieldId;
	private JTextField JtextfieldName;
	private JTextField JtextfieldPrice;
	private JTextField JtextfieldQuantity;
	private JButton JbuttonSave;
	private JTextArea JareaDescripsion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jframedemo frame = new Jframedemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Jframedemo() {
		setTitle("Thong tin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(22, 11, 91, 14);
		contentPane.add(lblNewLabel);
		
		JtextfieldId = new JTextField();
		JtextfieldId.setBounds(155, 8, 166, 20);
		contentPane.add(JtextfieldId);
		JtextfieldId.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(22, 39, 91, 14);
		contentPane.add(lblName);
		
		JtextfieldName = new JTextField();
		JtextfieldName.setColumns(10);
		JtextfieldName.setBounds(155, 36, 166, 20);
		contentPane.add(JtextfieldName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(22, 70, 91, 14);
		contentPane.add(lblPrice);
		
		JtextfieldPrice = new JTextField();
		JtextfieldPrice.setColumns(10);
		JtextfieldPrice.setBounds(155, 67, 166, 20);
		contentPane.add(JtextfieldPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(22, 98, 91, 14);
		contentPane.add(lblQuantity);
		
		JtextfieldQuantity = new JTextField();
		JtextfieldQuantity.setColumns(10);
		JtextfieldQuantity.setBounds(155, 95, 166, 20);
		contentPane.add(JtextfieldQuantity);
		
		JLabel lblNewLabel_3_1 = new JLabel("Descriptsion");
		lblNewLabel_3_1.setBounds(22, 137, 91, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(155, 147, 166, 106);
		contentPane.add(scrollPane);
		
		JareaDescripsion = new JTextArea();
		scrollPane.setViewportView(JareaDescripsion);
		
		JbuttonSave = new JButton("Save");
		JbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JbuttonSave_actionPerformed(e);
			}
		});
		JbuttonSave.setBounds(10, 218, 89, 23);
		contentPane.add(JbuttonSave);
	}
	
	public void JbuttonSave_actionPerformed(ActionEvent e) {
		//lay du lieu nhap tu man hinh
		String id = JtextfieldId.getText();
		String name = JtextfieldName.getText();
		double price = Double.parseDouble(JtextfieldPrice.getText().trim());
		int quantity = Integer.parseInt(JtextfieldQuantity.getText().trim());
		String description = JareaDescripsion.getText();
		// gan du lieu do cho doi tuong san pham
		Product products = new Product();
		products.setId(id);
		products.setName(name);
		products.setPrice(price);
		products.setQuantity(quantity);
		products.setDescripsion(description);
		// dua doi tuong san pham vao ham de luu duoi dang file
		ProductModel productmodel = new ProductModel();
		productmodel.save(products);
		
		
	}
}
