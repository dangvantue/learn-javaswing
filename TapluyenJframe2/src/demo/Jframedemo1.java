package demo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.City;
import entities.Country;
import model.Demomodel;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Jframedemo1 extends JFrame {

	private JPanel contentPane;
	private JComboBox JcomboboxCountry;
	private JTextField JtextfieldID;
	private JTextField JtextfieldName;
	private JTextField Jtextfieldpopau;
	private JTextField JtextfieldArea;
	private JList JlistCity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jframedemo1 frame = new Jframedemo1();
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
	public Jframedemo1() {
		setTitle("Demo1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JcomboboxCountry = new JComboBox();
		JcomboboxCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JcomboboxCountry_actionPerformed(e);
			}
		});
		JcomboboxCountry.setBounds(81, 11, 128, 27);
		contentPane.add(JcomboboxCountry);

		JlistCity = new JList();
		JlistCity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JlistCity_mouseClicked(e);
			}
		});
		JlistCity.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JlistCity.setBounds(81, 81, 145, 117);
		contentPane.add(JlistCity);

		JLabel lblNewLabel = new JLabel("Country");
		lblNewLabel.setBounds(10, 17, 61, 19);
		contentPane.add(lblNewLabel);

		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(10, 80, 61, 19);
		contentPane.add(lblCity);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(307, 80, 55, 19);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setBounds(307, 124, 55, 19);
		contentPane.add(lblNewLabel_1_1);

		JLabel JtextfieldPopualation = new JLabel("Popualation");
		JtextfieldPopualation.setBounds(307, 164, 79, 19);
		contentPane.add(JtextfieldPopualation);

		JLabel lblNewLabel_1_3 = new JLabel("Area");
		lblNewLabel_1_3.setBounds(307, 211, 79, 19);
		contentPane.add(lblNewLabel_1_3);

		JtextfieldID = new JTextField();
		JtextfieldID.setBounds(381, 77, 116, 22);
		contentPane.add(JtextfieldID);
		JtextfieldID.setColumns(10);

		JtextfieldName = new JTextField();
		JtextfieldName.setColumns(10);
		JtextfieldName.setBounds(381, 123, 116, 22);
		contentPane.add(JtextfieldName);

		Jtextfieldpopau = new JTextField();
		Jtextfieldpopau.setColumns(10);
		Jtextfieldpopau.setBounds(381, 163, 116, 22);
		contentPane.add(Jtextfieldpopau);

		JtextfieldArea = new JTextField();
		JtextfieldArea.setColumns(10);
		JtextfieldArea.setBounds(381, 210, 116, 22);
		contentPane.add(JtextfieldArea);
		loadData();
	}
	
	
	public void JcomboboxCountry_actionPerformed(ActionEvent e) {
		Country country = (Country) JcomboboxCountry.getSelectedItem();
		//System.out.println("name: " + country.getName());
		DefaultListModel<City> citi = new DefaultListModel<City>();
		for(City citis : country.getCity()) {
			citi.addElement(citis);
		}
		JlistCity.setModel(citi);
		JlistCity.setCellRenderer(new listcityrender());
	}
	private class listcityrender extends DefaultListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			// TODO Auto-generated method stub
			City cities = (City) value;
			return super.getListCellRendererComponent(list, cities.getName(), index, isSelected, cellHasFocus);
		}
		
	}
	public void JlistCity_mouseClicked(MouseEvent e) {
		//System.out.println("haha");
		List<City> city = JlistCity.getSelectedValuesList();
		if(city.size()>0) {
			for(City i : city) {
				JtextfieldID.setText(i.getId());
				JtextfieldName.setText(i.getName());
				Jtextfieldpopau.setText(String.valueOf(i.getPopualation()));
				JtextfieldArea.setText(String.valueOf(i.getArea()));
			}
		}
	}

	private void loadData() {
		Demomodel demomodol = new Demomodel();
		DefaultComboBoxModel<Country> defultcomboboxmodel = new DefaultComboBoxModel<Country>();
		for (Country i : demomodol.findAll()) {
			defultcomboboxmodel.addElement(i);
		}
		JcomboboxCountry.setModel(defultcomboboxmodel);
		JcomboboxCountry.setRenderer(new cellrender());
	}

	private class cellrender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			// TODO Auto-generated method stub
			Country i = (Country) value;
			return super.getListCellRendererComponent(list, i.getName(), index, isSelected, cellHasFocus);
		}
	}

}
