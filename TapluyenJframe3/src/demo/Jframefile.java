package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Helper.Helpermodol;
import entities.Student;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Jframefile extends JFrame {

	private JPanel contentPane;
	private JTable Jtablefile;
	private JScrollPane scrollPane;
	private JMenu Jmenufile;
	private JMenuItem Jmenuitemfile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jframefile frame = new Jframefile();
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
	public Jframefile() {
		setTitle("Demo nhieu file");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		Jmenufile = new JMenu("File");
		menuBar.add(Jmenufile);

		Jmenuitemfile = new JMenuItem("Open");
		Jmenufile.add(Jmenuitemfile);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 403, 151);
		contentPane.add(scrollPane);

		Jtablefile = new JTable();
		scrollPane.setViewportView(Jtablefile);

		JButton Jbuttonchoosefile = new JButton("ChooseFile");
		Jbuttonchoosefile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jbuttonchoosefile_actionPerformed(e);
			}
		});
		Jbuttonchoosefile.setBounds(109, 185, 89, 23);
		contentPane.add(Jbuttonchoosefile);
	}

	public void Jbuttonchoosefile_actionPerformed(ActionEvent e) {
		JFileChooser jfilechooser = new JFileChooser("c:\\tuejava\\tuejava2\\jframefile");
		jfilechooser.setDialogTitle("vui long chon nhieu file");
		jfilechooser.setMultiSelectionEnabled(true);
		int tru = jfilechooser.showOpenDialog(null);
		if (tru == JFileChooser.APPROVE_OPTION) {
			/*File[] files = jfilechooser.getSelectedFiles();
			DefaultTableModel defaulttablemodel = new DefaultTableModel();
			defaulttablemodel.addColumn("id");
			defaulttablemodel.addColumn("name");
			defaulttablemodel.addColumn("price");
			defaulttablemodel.addColumn("quantity");	
			for (File file : files) {
				String filePath = file.getAbsolutePath();
				List<Student> students = Helpermodol.imporfile(filePath);
				for (Student i : students) {
					defaulttablemodel.addRow(new Object[] { i.getId(), i.getName(), 
							i.getPrice(), i.getQuantity() });
				}
			}*/
			// cach 2:
			File [] file = jfilechooser.getSelectedFiles();
			DefaultTableModel defaulttablemodel = new DefaultTableModel();
			defaulttablemodel.addColumn("id");
			defaulttablemodel.addColumn("name");
			defaulttablemodel.addColumn("price");
			defaulttablemodel.addColumn("quantity");
			
			List<Student> TotalStudent = new ArrayList<Student>();
			for(File files : file) {
				String filePath = files.getAbsolutePath();
				List<Student> students = Helpermodol.imporfile(filePath);
				TotalStudent.addAll(students);
			}
			for(Student student : TotalStudent) {
				defaulttablemodel.addRow(new Object[] { student.getId(), student.getName(), 
						student.getPrice(), student.getQuantity()});
			}
			Jtablefile.setModel(defaulttablemodel);
		}
	}
}
