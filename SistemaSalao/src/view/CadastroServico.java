package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConectaBanco.ConectaBanco;
import ConectaBanco.ModeloTabela;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CadastroServico extends JFrame {

	ConectaBanco conecta = new ConectaBanco();
	private JPanel contentPane;
	private JTextField txtCod;
	private JTextField txtDesc;
	private JTextField txtValor;
	private JTable tbServico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroServico frame = new CadastroServico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
public void preencherTabela(String SQL) {
		
		
		ArrayList dados = new ArrayList();
		
		String[] Colunas = new String[] {"Telefone","Nome","Logradouro","Numero","Bairro","Cidade","Data de Nascimento","funcao","Dias de trabalho","Comissao"};
		
		conecta.executaSQL(SQL);
		try {
			conecta.rs.first();
			
			do {
				dados.add(new Object[] {conecta.rs.getString("codServico"), conecta.rs.getString("descServico"), conecta.rs.getString("valorServico")});
				
			}while(conecta.rs.next());
			ModeloTabela modelo = new ModeloTabela(dados, Colunas);
			tbServico.setModel(modelo);
			tbServico.getColumnModel().getColumn(0).setPreferredWidth(100);
			tbServico.getColumnModel().getColumn(0).setResizable(false);
			tbServico.getColumnModel().getColumn(1).setPreferredWidth(100);
			tbServico.getColumnModel().getColumn(1).setResizable(false);
			tbServico.getColumnModel().getColumn(2).setPreferredWidth(100);
			tbServico.getColumnModel().getColumn(2).setResizable(false);
		
			tbServico.getTableHeader().setReorderingAllowed(false);
			tbServico.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tbServico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(rootPane,"Erro ao preencher o ArrayList! \n" + ex);
		}
		
		
	}

	/**
	 * Create the frame.
	 */
	public CadastroServico() {
		conecta.conexao();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 950, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtCod = new JTextField();
		txtCod.setBounds(30, 112, 129, 36);
		contentPane.add(txtCod);
		txtCod.setColumns(10);

		txtDesc = new JTextField();
		txtDesc.setBounds(198, 112, 544, 36);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);

		txtValor = new JTextField();
		txtValor.setBounds(776, 112, 129, 36);
		contentPane.add(txtValor);
		txtValor.setColumns(10);

		JLabel Codigo = new JLabel("Codigo");
		Codigo.setBounds(30, 87, 46, 14);
		contentPane.add(Codigo);

		JLabel lblNewLabel = new JLabel("Descricao");
		lblNewLabel.setBounds(198, 87, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Valor");
		lblNewLabel_1.setBounds(779, 87, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cadastro de Servicos");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(285, 11, 345, 49);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Cadastrar Servicos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					PreparedStatement pst = conecta.conn.prepareStatement(
							"insert into tbServico(codServico,descServico,valorServico)values(?,?,?)");
					if (txtCod.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");

					} else if (txtDesc.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");

					} else if (txtValor.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");

					} else {

						pst.setString(1, txtCod.getText());
						pst.setString(2, txtDesc.getText());
						pst.setString(3, txtValor.getText());
						pst.executeUpdate();
						JOptionPane.showMessageDialog(rootPane, "Cadastrado com sucesso");
						txtCod.setText("");
						txtDesc.setText("");
						txtValor.setText("");

					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(rootPane, "Erro na insercao! \n" + ex);

				}
			}

		});
		btnNewButton.setBounds(198, 171, 123, 36);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Alterar Servicos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					if (txtCod.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");

					} else if (txtDesc.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");

					} else if (txtValor.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");

					} else {
						PreparedStatement pst = conecta.conn.prepareStatement("update tbServico set codServico=?, descServico=?,valorServico=?");
						pst.setString(1, txtCod.getText());
						pst.setString(2, txtDesc.getText());
						pst.setString(3, txtValor.getText());
						pst.execute();
						JOptionPane.showMessageDialog(rootPane, "Editado com sucesso");
					}
				}

				catch (SQLException ex) {
					JOptionPane.showMessageDialog(rootPane, "Erro ao alterar! \n" + ex);
					txtCod.setText("");
					txtDesc.setText("");
					txtValor.setText("");

				}
			}

		});
		btnNewButton_1.setBounds(346, 171, 109, 36);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Excluir Servicos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				conecta.executaSQL("delete from tbServico where codServico='"+txtCod.getText()+"'");
				JOptionPane.showMessageDialog(rootPane,"Excluido com sucesso");
				
				
			}
		});
		btnNewButton_2.setBounds(617, 171, 109, 36);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Novo");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCod.setText("");
				txtDesc.setText("");
				txtValor.setText("");
				
				
			}
		});
		btnNewButton_3.setBounds(480, 171, 109, 36);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Exibir todos");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				preencherTabela("select * from tbServico order by ");
				
				
			}
		});
		btnNewButton_4.setBounds(754, 171, 109, 36);
		contentPane.add(btnNewButton_4);

		tbServico = new JTable();
		tbServico.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "New column", "New column", "New column" }));
		tbServico.setBounds(30, 253, 870, 165);
		contentPane.add(tbServico);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
					
					conecta.executaSQL("select * from tbServico where codServico='"+txtCod.getText()+"'");
					conecta.rs.first();
					txtCod.setText(conecta.rs.getString("codServico"));
					txtDesc.setText(conecta.rs.getString("descServico"));
					txtValor.setText(conecta.rs.getString("valorServico"));
					
					
					
					
				} catch (SQLException e1) {
					
					JOptionPane.showMessageDialog(rootPane,"Erro ao mostrar dados!"+e1);
					txtCod.setText("");
					txtDesc.setText("");
					txtValor.setText("");
					
				}		
				
				
			}
			
			
		});
		btnBuscar.setBounds(47, 171, 123, 36);
		contentPane.add(btnBuscar);
	}
}
