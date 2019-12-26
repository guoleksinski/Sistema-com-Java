package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConectaBanco.ConectaBanco;
import ConectaBanco.ModeloTabela;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class CadastroCliente extends JFrame {
	
	
	ConectaBanco conecta = new ConectaBanco();
	
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTable table;
	private JTextField txtDataNascto;
	private JTable table_1;
	private JTable tbCliente;
	private JTextField txtDebito;
	private JTextField txtCredito;
	
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
	
	
	

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
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
	public CadastroCliente() {
		
		conecta.conexao();
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("window"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro de clientes");
		lblNewLabel.setBounds(201, -15, 471, 96);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 28));
		contentPane.add(lblNewLabel);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNome.setBounds(63, 152, 46, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(63, 177, 298, 32);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(63, 109, 298, 32);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblTelefone.setBounds(63, 84, 99, 14);
		contentPane.add(lblTelefone);

		JLabel lblDataNascto = new JLabel("Data de Nascimento\r\n");
		lblDataNascto.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDataNascto.setBounds(63, 220, 121, 14);
		contentPane.add(lblDataNascto);

		DefaultTableModel modelo = new DefaultTableModel();
		
		txtDataNascto = new JTextField();
		txtDataNascto.setBounds(63, 245, 132, 32);
		contentPane.add(txtDataNascto);
		txtDataNascto.setColumns(10);
		
		JButton btnAdicionarCliente = new JButton("Adicionar Cliente");
		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pst = conecta.conn.prepareStatement("insert into tbCliente(telefoneCliente,nomeCliente,dataNascto,debitoCliente,creditoCliente)values(?,?,?,?,?)");
					pst.setString(1,txtTelefone.getText());
					pst.setString(2,txtNome.getText());
					pst.setString(3,txtDataNascto.getText());
					pst.setString(4,txtDebito.getText());
					pst.setString(5,txtCredito.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(rootPane,"Cadastrado com sucesso");
					txtNome.setText("");
					txtDataNascto.setText("");
					txtTelefone.setText("");
				}
					catch(SQLException ex) {
						JOptionPane.showMessageDialog(rootPane,"Erro na insercao! \n" + ex);
						txtNome.setText("");
						txtDataNascto.setText("");
						txtTelefone.setText("");
						txtDebito.setText("");
						txtCredito.setText("");
						txtTelefone.requestFocus();
					}
				}
			}
		);
		btnAdicionarCliente.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnAdicionarCliente.setBounds(673, 123, 132, 32);
		contentPane.add(btnAdicionarCliente);
		
		JButton btnPesquisarCliente = new JButton("Procurar Cliente");
		btnPesquisarCliente.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnPesquisarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					conecta.executaSQL("select * from tbCliente where telefoneCliente='"+txtTelefone.getText()+"'");
					conecta.rs.first();
					txtNome.setText(conecta.rs.getString("nomeCliente"));
					txtDataNascto.setText(conecta.rs.getString("dataNascto"));
					txtDebito.setText(conecta.rs.getString("debitoCliente"));
					txtCredito.setText(conecta.rs.getString("creditoCliente"));
					
					
				} catch (SQLException e1) {
					
					JOptionPane.showMessageDialog(rootPane,"Erro ao mostrar dados!"+e1);
					txtNome.setText("");
					txtDataNascto.setText("");
					txtTelefone.setText("");
					txtTelefone.requestFocus();
				}		
				
				
			}
		});
		btnPesquisarCliente.setBounds(673, 84, 132, 32);
		contentPane.add(btnPesquisarCliente);
		
		JButton btnExcluir = new JButton("Excluir Cliente\r\n");
		btnExcluir.setBackground(Color.LIGHT_GRAY);
		btnExcluir.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conecta.executaSQL("delete from tbCliente where telefoneCliente='"+txtTelefone.getText()+"'");
				JOptionPane.showMessageDialog(rootPane,"Excluido com sucesso");
				txtNome.setText("");
				txtDataNascto.setText("");
				txtTelefone.setText("");
				txtTelefone.requestFocus();
			}
		});
		btnExcluir.setBounds(673, 167, 132, 32);
		contentPane.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar Cadastro\r\n");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pst = conecta.conn.prepareStatement("update tbCliente set nomeCliente=?, dataNascto=? where telefoneCliente=?");
					
					pst.setString(1,txtNome.getText());
					pst.setString(2,txtDataNascto.getText());
					pst.setString(3,txtTelefone.getText());
					pst.execute();
					JOptionPane.showMessageDialog(rootPane,"alterado com sucesso");
					txtNome.setText("");
					txtDataNascto.setText("");
					txtTelefone.setText("");
				}
					catch(SQLException ex) {
						JOptionPane.showMessageDialog(rootPane,"Erro ao alterar! \n" + ex);
						txtNome.setText("");
						txtDataNascto.setText("");
						txtTelefone.setText("");
						txtTelefone.requestFocus();
					}
				}
			
		});
		
		
		btnAlterar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnAlterar.setBounds(673, 217, 132, 32);
		contentPane.add(btnAlterar);
		
		table_1 = new JTable();
		table_1.setBounds(183, 392, -66, 8);
		contentPane.add(table_1);
		
		tbCliente = new JTable();
		tbCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				
			}
		));
		tbCliente.setBackground(UIManager.getColor("Button.background"));
		tbCliente.setBounds(57, 319, 748, 131);
		contentPane.add(tbCliente);
		
		JButton btnExibirTodos = new JButton("Exibir todos ");
		btnExibirTodos.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnExibirTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				preencherTabela("select * from tbCliente order by nomeCliente");
			}
		});
		btnExibirTodos.setBounds(673, 259, 132, 32);
		contentPane.add(btnExibirTodos);
		
		JLabel lblDebito = new JLabel("Debitos");
		lblDebito.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDebito.setBounds(400, 84, 58, 14);
		contentPane.add(lblDebito);
		
		txtDebito = new JTextField();
		txtDebito.setText("0,00");
		txtDebito.setBounds(400, 109, 162, 32);
		contentPane.add(txtDebito);
		txtDebito.setColumns(10);
		
		txtCredito = new JTextField();
		txtCredito.setText("0,00");
		txtCredito.setColumns(10);
		txtCredito.setBounds(400, 177, 162, 32);
		contentPane.add(txtCredito);
		
		JLabel lblNewLabel_1 = new JLabel("Creditos");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(400, 152, 58, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(111, 294, 73, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNome_1.setBounds(243, 294, 73, 14);
		contentPane.add(lblNome_1);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDataDeNascimento.setBounds(375, 294, 121, 14);
		contentPane.add(lblDataDeNascimento);
		
		JLabel lblNewLabel_3 = new JLabel("Debitos\r\n\r\n");
		lblNewLabel_3.setBounds(564, 295, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Creditos");
		lblNewLabel_4.setBounds(706, 295, 58, 14);
		contentPane.add(lblNewLabel_4);

	}
}
