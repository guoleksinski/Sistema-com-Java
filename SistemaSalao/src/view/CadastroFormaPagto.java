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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class CadastroFormaPagto extends JFrame {

	ConectaBanco conecta = new ConectaBanco();
	private JPanel contentPane;
	private JTextField txtDesc;
	private JTextField txtCod;
	private JTable tbForma;

	/**
	 * Launch the application.
	 */
public void preencherTabela(String SQL) {
		
		
		ArrayList dados = new ArrayList();
		
		String[] Colunas = new String[] {"Codigo","Descricao"};
		
		conecta.executaSQL(SQL);
		try {
			conecta.rs.first();
			
			do {
				dados.add(new Object[] {conecta.rs.getString("codFormaPagamento"), conecta.rs.getString("descFormaPagto")});
				
			}while(conecta.rs.next());
			ModeloTabela modelo = new ModeloTabela(dados, Colunas);
			tbForma.setModel(modelo);
			tbForma.getColumnModel().getColumn(0).setPreferredWidth(100);
			tbForma.getColumnModel().getColumn(0).setResizable(false);
			tbForma.getColumnModel().getColumn(1).setPreferredWidth(100);
			tbForma.getColumnModel().getColumn(1).setResizable(false);
			
		
			tbForma.getTableHeader().setReorderingAllowed(false);
			tbForma.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tbForma.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(rootPane,"Erro ao preencher o ArrayList! \n" + ex);
		}
		
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFormaPagto frame = new CadastroFormaPagto();
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
	public CadastroFormaPagto() {
		conecta.conexao();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 698, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Forma de Pagamento");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
		lblNewLabel.setBounds(85, 24, 516, 33);
		contentPane.add(lblNewLabel);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(173, 125, 488, 40);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descricao");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(173, 93, 62, 27);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					PreparedStatement pst = conecta.conn.prepareStatement(
							"insert into tbFormaPagamento(codFormaPagamento,descFormaPagto)values(?,?)");
					if (txtCod.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");

					} else if (txtDesc.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");

					
					} else {

						pst.setString(1, txtCod.getText());
						pst.setString(2, txtDesc.getText());
						
						pst.executeUpdate();
						JOptionPane.showMessageDialog(rootPane, "Cadastrado com sucesso");
						txtCod.setText("");
						txtDesc.setText("");
						

					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(rootPane, "Erro na insercao! \n" + ex);

				}
			}
				
				
			
		});
		btnNewButton.setBounds(19, 263, 98, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo");
		lblNewLabel_2.setBounds(19, 100, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtCod = new JTextField();
		txtCod.setBounds(19, 125, 98, 40);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
					
					conecta.executaSQL("select * from tbFormaPagamento where codFormaPagamento='"+txtCod.getText()+"'");
					conecta.rs.first();
					txtCod.setText(conecta.rs.getString("codFormaPagamento"));
					txtDesc.setText(conecta.rs.getString("descFormaPagto"));
					
					
					
					
					
				} catch (SQLException e1) {
					
					JOptionPane.showMessageDialog(rootPane,"Erro ao mostrar dados!"+e1);
					txtCod.setText("");
					txtDesc.setText("");
					
					
				}		
				
				
			}	
				
			
		});
		btnNewButton_1.setBounds(19, 207, 98, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Novo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCod.setText("");
				txtDesc.setText("");
				
			}
		});
		btnNewButton_2.setBounds(19, 321, 98, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Excluir\r\n");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				conecta.executaSQL("delete from tbFormaPagamento where codFormaPagamento='"+txtCod.getText()+"'");
				JOptionPane.showMessageDialog(rootPane,"Excluido com sucesso");
			}
		});
		btnNewButton_3.setBounds(19, 377, 98, 33);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Exibir Todos");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				preencherTabela("select * from tbFormaPagamento order by codFormaPagamento");
				
			}
		});
		btnNewButton_4.setBounds(156, 307, 102, 33);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Alterar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					if (txtCod.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");

					} else if (txtDesc.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");

					

					} else {
						PreparedStatement pst = conecta.conn.prepareStatement("update tbFormaPagamento set codFormaPagamento=?, descFormaPagto=?");
						pst.setString(1, txtCod.getText());
						pst.setString(2, txtDesc.getText());
						
						pst.execute();
						JOptionPane.showMessageDialog(rootPane, "Editado com sucesso");
					}
				}

				catch (SQLException ex) {
					JOptionPane.showMessageDialog(rootPane, "Erro ao alterar! \n" + ex);
					txtCod.setText("");
					txtDesc.setText("");
					

				}
			}
			
		});
		btnNewButton_5.setBounds(156, 250, 98, 33);
		contentPane.add(btnNewButton_5);
		
		tbForma = new JTable();
		tbForma.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		tbForma.setBounds(308, 207, 315, 217);
		contentPane.add(tbForma);
		
		JLabel lblNewLabel_3 = new JLabel("Codigo");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(362, 182, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Descricao");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(519, 182, 67, 14);
		contentPane.add(lblNewLabel_4);
	}

}
