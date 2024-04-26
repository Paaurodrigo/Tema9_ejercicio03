package com.hibernate.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.hibernate.dao.SerieDAO;

import com.hibernate.model.Serie;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class App {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtNom;
	private JTextField txtTemp;
	private JTextField txtCap;
	private DefaultTableModel modelSerie; 
	private SerieDAO serieDAO;
	private List <Serie> series;

	
	
	
	
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

	public void refrescar() {
		List<Serie> series= null;
		modelSerie.setRowCount(0);
		series = serieDAO.selectAllSerie();
		series.forEach(s->{
			Object [] row = new Object [4];
			row [0]=s.getIdSerie();
			row [1]=s.getNomSerie();
			row [2]=s.getTemporadas();
			row [3]=s.getCapitulos();
			modelSerie.addRow(row);
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
	

	int id=0;
	String nomSerie="";
	int temporada=0;
	int cap=0;

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 638, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		
		serieDAO=new SerieDAO();
		series=serieDAO.selectAllSerie();
		
		modelSerie = new DefaultTableModel();

		modelSerie.addColumn("ID");
		modelSerie.addColumn("Titulo");
		modelSerie.addColumn("Nº Temporadas");
		modelSerie.addColumn("Total episodios");

		JTable table = new JTable(modelSerie);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				TableModel modelSerie = table.getModel();
				// ID NAME AGE CITY
				txtId.setText(modelSerie.getValueAt(index, 0).toString());
				txtNom.setText(modelSerie.getValueAt(index, 1).toString());
				txtTemp.setText(modelSerie.getValueAt(index, 2).toString());
				txtCap.setText(modelSerie.getValueAt(index, 3).toString());
			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(34, 25, 542, 236);
		frame.getContentPane().add(scrollPane);
		
		JButton btnAct = new JButton("Actualizar");
		btnAct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				id=Integer.parseInt(txtId.getText());
				nomSerie=txtNom.getText();
				temporada=Integer.parseInt(txtTemp.getText());
				cap=Integer.parseInt(txtCap.getText());
				Serie serie2=serieDAO.selectSerieById(id);				
				serie2.setNomSerie(nomSerie);
				serie2.setCapitulos(cap);
				serie2.setTemporadas(temporada);
				serieDAO.updateSerie(serie2);
				
			
				
				refrescar();
			}
		});
		btnAct.setBounds(226, 501, 117, 25);
		frame.getContentPane().add(btnAct);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				id=Integer.parseInt(txtId.getText());
				serieDAO.deleteSerie(id);
				refrescar();
			}
		});
		btnBorrar.setBounds(439, 501, 117, 25);
		frame.getContentPane().add(btnBorrar);
		refrescar();
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
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nomSerie=txtNom.getText();
				temporada=Integer.parseInt(txtTemp.getText());
				cap=Integer.parseInt(txtCap.getText());
				System.out.println(nomSerie+temporada+cap);
				Serie serie=new Serie(nomSerie,temporada,cap);				
				serieDAO.insertSerie(serie);
			refrescar();
				
			}
		});
		btnGuardar.setBounds(34, 501, 117, 25);
		frame.getContentPane().add(btnGuardar);
		
		
	}
}
