package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextPane;
import java.awt.List;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.table.DefaultTableModel;

import ConectaBanco.ConectaBanco;
import ConectaBanco.ModeloTabela;

import javax.swing.ListSelectionModel;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MarcarHorario extends JFrame {

	ConectaBanco conecta = new ConectaBanco();
	private JPanel contentPane;
	private JTextField txtTelefone;
	private JTextField txtNome;
	private JTable table_1;
	private JTable tbMarcar;
	private JTextField txtDesc;
	private JTextField txtCod;
	private JTextField txtValorTotal;
	private JTextField txtDebitos;
	private JTextField txtCredito;
	private JTextField txtDataNascto;
	private JTextField txtValor;

	
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
			tbMarcar.setModel(modelo);
			tbMarcar.getColumnModel().getColumn(0).setPreferredWidth(100);
			tbMarcar.getColumnModel().getColumn(0).setResizable(false);
			tbMarcar.getColumnModel().getColumn(1).setPreferredWidth(100);
			tbMarcar.getColumnModel().getColumn(1).setResizable(false);
			tbMarcar.getColumnModel().getColumn(2).setPreferredWidth(100);
			tbMarcar.getColumnModel().getColumn(2).setResizable(false);
		
			tbMarcar.getTableHeader().setReorderingAllowed(false);
			tbMarcar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tbMarcar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
					MarcarHorario frame = new MarcarHorario();
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
	public MarcarHorario() {
		conecta.conexao();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtTelefone.setBounds(22, 11, 115, 51);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JButton btnVerificarCliente = new JButton("Verificar Cliente");
		btnVerificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					conecta.executaSQL("select * from tbCliente where telefoneCliente='"+txtTelefone.getText()+"'");
					conecta.rs.first();
					txtNome.setText(conecta.rs.getString("nomeCliente"));
					txtDataNascto.setText(conecta.rs.getString("dataNascto"));
					txtDebitos.setText(conecta.rs.getString("debitoCliente"));
					txtCredito.setText(conecta.rs.getString("creditoCliente"));
					
					
				} catch (SQLException e1) {
					
					JOptionPane.showMessageDialog(rootPane,"Nao ha clientes cadastrado com esse telefone!");
					txtNome.setText("");
					txtDataNascto.setText("");
					txtTelefone.setText("");
					txtTelefone.requestFocus();
				}		
				
				
			}
				
			
			
		});
		btnVerificarCliente.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnVerificarCliente.setBounds(147, 11, 137, 23);
		contentPane.add(btnVerificarCliente);
		
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BuscarCliente frame = new BuscarCliente();
				 frame.setVisible(true);
				
				
			}
		});
		btnBuscarCliente.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnBuscarCliente.setBounds(147, 45, 137, 23);
		contentPane.add(btnBuscarCliente);
		
		JButton btnNovoCliente = new JButton("Novo Cliente\r\n");
		btnNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCliente frame = new CadastroCliente();
				 frame.setVisible(true);
				
				
			}
			});
		btnNovoCliente.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNovoCliente.setBounds(147, 79, 137, 23);
		contentPane.add(btnNovoCliente);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setBounds(379, 11, 495, 34);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNome.setBounds(339, 20, 55, 14);
		contentPane.add(lblNome);
		
		table_1 = new JTable();
		table_1.setBounds(39, 174, 1, 1);
		contentPane.add(table_1);
		
		JList list_1 = new JList();
		list_1.setBounds(55, 420, 213, -173);
		contentPane.add(list_1);
		
		tbMarcar = new JTable();
		tbMarcar.setForeground(Color.BLACK);
		tbMarcar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbMarcar.setFont(new Font("Verdana", Font.PLAIN, 16));
		tbMarcar.setBackground(Color.WHITE);
		tbMarcar.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"cod servico", "descricao servico", "valor servico"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbMarcar.getColumnModel().getColumn(0).setResizable(false);
		tbMarcar.setBounds(22, 174, 245, 265);
		contentPane.add(tbMarcar);
		
		txtDesc = new JTextField();
		txtDesc.setEditable(false);
		txtDesc.setBounds(304, 209, 316, 34);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);
		
		txtCod = new JTextField();
		txtCod.setBounds(304, 164, 100, 34);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		JLabel lblCodServico = new JLabel("Codigo servico");
		lblCodServico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodServico.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCodServico.setBounds(304, 138, 90, 23);
		contentPane.add(lblCodServico);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(697, 388, 177, 51);
		contentPane.add(btnFinalizar);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				preencherTabela("select * from tbServico where codServico='"+txtCod.getText()+"'");
			}
		});
		btnNewButton.setBounds(774, 209, 100, 34);
		contentPane.add(btnNewButton);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setBounds(774, 343, 100, 34);
		contentPane.add(txtValorTotal);
		txtValorTotal.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Valor Total");
		lblNewLabel.setBounds(773, 310, 111, 29);
		contentPane.add(lblNewLabel);
		
		txtDebitos = new JTextField();
		txtDebitos.setEditable(false);
		txtDebitos.setBounds(379, 56, 115, 36);
		contentPane.add(txtDebitos);
		txtDebitos.setColumns(10);
		
		txtCredito = new JTextField();
		txtCredito.setEditable(false);
		txtCredito.setBounds(554, 56, 115, 36);
		contentPane.add(txtCredito);
		txtCredito.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Debitos");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(328, 66, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Credito");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(504, 66, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data de Nascimento");
		lblNewLabel_3.setBounds(679, 67, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		txtDataNascto = new JTextField();
		txtDataNascto.setEditable(false);
		txtDataNascto.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtDataNascto.setBounds(788, 56, 86, 36);
		contentPane.add(txtDataNascto);
		txtDataNascto.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Verificar Codigo");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton_1.setBounds(430, 164, 137, 34);
		contentPane.add(btnNewButton_1);
		
		txtValor = new JTextField();
		txtValor.setBounds(642, 209, 100, 34);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
	}
}
