package com.hibernate.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class App {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtNom;
	private JTextField txtTemp;
	private JTextField txtCap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 638, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(34, 501, 117, 25);
		frame.getContentPane().add(btnGuardar);
		
		DefaultTableModel modelSerie = new DefaultTableModel();

		modelSerie.addColumn("ID");
		modelSerie.addColumn("Titulo");
		modelSerie.addColumn("Nº Temporadas");
		modelSerie.addColumn("Total episodios");

		JTable table = new JTable(modelSerie);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(34, 25, 542, 236);
		frame.getContentPane().add(scrollPane);
		
		JButton btnAct = new JButton("Actualizar");
		btnAct.setBounds(226, 501, 117, 25);
		frame.getContentPane().add(btnAct);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(439, 501, 117, 25);
		frame.getContentPane().add(btnBorrar);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(176, 285, 114, 19);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(176, 324, 114, 19);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		txtTemp = new JTextField();
		txtTemp.setBounds(176, 366, 114, 19);
		frame.getContentPane().add(txtTemp);
		txtTemp.setColumns(10);
		
		txtCap = new JTextField();
		txtCap.setBounds(176, 415, 114, 19);
		frame.getContentPane().add(txtCap);
		txtCap.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setBounds(88, 287, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Serie:");
		lblNewLabel_1.setBounds(88, 326, 70, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Temporadas");
		lblNewLabel_2.setBounds(63, 368, 88, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Capitulos");
		lblNewLabel_3.setBounds(81, 417, 70, 15);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
