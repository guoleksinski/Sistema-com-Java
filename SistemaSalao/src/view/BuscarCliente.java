package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConectaBanco.ConectaBanco;
import ConectaBanco.ModeloTabela;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarCliente extends JFrame {
	
	 ConectaBanco conecta = new ConectaBanco();

	private JPanel contentPane;
	private JTable tbCliente;

	
	
	
public void preencherTabela(String SQL) {
		
		
		ArrayList dados = new ArrayList();
		
		String[] Colunas = new String[] {"Telefone","Nome","Data de Nascimento","Debitos","Creditos"};
		
		conecta.executaSQL(SQL);
		try {
			conecta.rs.first();
			
			do {
				dados.add(new Object[] {conecta.rs.getString("telefoneCliente"), conecta.rs.getString("nomeCliente"), conecta.rs.getString("dataNascto"),conecta.rs.getFloat("debitoCliente"),conecta.rs.getFloat("creditoCliente")});
				
			}while(conecta.rs.next());
			ModeloTabela modelo = new ModeloTabela(dados, Colunas);
			tbCliente.setModel(modelo);
			tbCliente.getColumnModel().getColumn(0).setPreferredWidth(100);
			tbCliente.getColumnModel().getColumn(0).setResizable(false);
			tbCliente.getColumnModel().getColumn(1).setPreferredWidth(100);
			tbCliente.getColumnModel().getColumn(1).setResizable(false);
			tbCliente.getColumnModel().getColumn(2).setPreferredWidth(100);
			tbCliente.getColumnModel().getColumn(2).setResizable(false);
			tbCliente.getColumnModel().getColumn(3).setPreferredWidth(100);
			tbCliente.getColumnModel().getColumn(3).setResizable(false);
			tbCliente.getColumnModel().getColumn(4).setPreferredWidth(100);
			tbCliente.getColumnModel().getColumn(4).setResizable(false);
			tbCliente.getTableHeader().setReorderingAllowed(false);
			tbCliente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tbCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(rootPane,"Erro ao preencher o ArrayList! \n" + ex);
		}
		
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					BuscarCliente frame = new BuscarCliente();
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
	public BuscarCliente() {
		
		
		conecta.conexao();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 670, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BUSCAR CLIENTE\r\n");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		lblNewLabel.setBounds(208, 11, 253, 65);
		contentPane.add(lblNewLabel);
		
		tbCliente = new JTable();
		tbCliente.setBounds(50, 92, 550, 292);
		contentPane.add(tbCliente);
		preencherTabela("select * from tbCliente order by nomeCliente");
	}

}
