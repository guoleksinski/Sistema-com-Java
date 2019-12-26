package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConectaBanco.ConectaBanco;
import ConectaBanco.ModeloTabela;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CadastroColaboradores extends JFrame {

	ConectaBanco conecta = new ConectaBanco();
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtLogradouro;
	private JTextField txtNumLog;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtDataNascto;
	private JTextField txtComissao;
	private JTable tbColab;
	
public void preencherTabela(String SQL) {
		
		
		ArrayList dados = new ArrayList();
		String[] Colunas = new String[] {"Telefone","Nome","Logradouro","Numero","Bairro","Cidade","Data de Nascimento","funcao","Dias de trabalho","Comissao"};
		
		
		conecta.executaSQL(SQL);
		try {
			conecta.rs.first();
			
			do {
				dados.add(new Object[] {conecta.rs.getString("telefoneColab"), conecta.rs.getString("nomeColab"), conecta.rs.getString("logradouroColab"),conecta.rs.getString("numLogColab"),conecta.rs.getString("bairroColab"),conecta.rs.getString("cidadeColab"),conecta.rs.getString("dataNasctoColab"),conecta.rs.getString("funcaoColab"),conecta.rs.getString("diasTrabalho"),conecta.rs.getInt("comissaoColab")});
				
			}while(conecta.rs.next());
			ModeloTabela modelo = new ModeloTabela(dados, Colunas);
			tbColab.setModel(modelo);
			tbColab.getColumnModel().getColumn(0).setPreferredWidth(100);
			tbColab.getColumnModel().getColumn(0).setResizable(false);
			tbColab.getColumnModel().getColumn(1).setPreferredWidth(100);
			tbColab.getColumnModel().getColumn(1).setResizable(false);
			tbColab.getColumnModel().getColumn(2).setPreferredWidth(100);
			tbColab.getColumnModel().getColumn(2).setResizable(false);
			tbColab.getColumnModel().getColumn(3).setPreferredWidth(100);
			tbColab.getColumnModel().getColumn(3).setResizable(false);
			tbColab.getColumnModel().getColumn(4).setPreferredWidth(100);
			tbColab.getColumnModel().getColumn(4).setResizable(false);
			tbColab.getColumnModel().getColumn(5).setPreferredWidth(100);
			tbColab.getColumnModel().getColumn(5).setResizable(false);
			tbColab.getColumnModel().getColumn(6).setPreferredWidth(100);
			tbColab.getColumnModel().getColumn(6).setResizable(false);
			tbColab.getColumnModel().getColumn(7).setPreferredWidth(100);
			tbColab.getColumnModel().getColumn(7).setResizable(false);
			tbColab.getColumnModel().getColumn(8).setPreferredWidth(200);
			tbColab.getColumnModel().getColumn(8).setResizable(true);
			tbColab.getColumnModel().getColumn(9).setPreferredWidth(40);
			tbColab.getColumnModel().getColumn(9).setResizable(false);
			tbColab.getTableHeader().setReorderingAllowed(false);
			tbColab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tbColab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
					CadastroColaboradores frame = new CadastroColaboradores();
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
	public CadastroColaboradores() {
		conecta.conexao();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1687, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE COLABORADORES");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
		lblNewLabel.setBounds(595, 0, 537, 75);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(30, 198, 291, 31);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(30, 131, 291, 31);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Telefone ");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(30, 106, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(30, 173, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(30, 265, 291, 31);
		contentPane.add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Logradouro");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(30, 240, 70, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Numero\r\n");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(30, 307, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		txtNumLog = new JTextField();
		txtNumLog.setBounds(30, 332, 100, 31);
		contentPane.add(txtNumLog);
		txtNumLog.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(30, 399, 291, 31);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Bairro");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(30, 374, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(30, 466, 291, 31);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Cidade\r\n");
		lblNewLabel_6.setBounds(30, 441, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Data de Nascimento\r\n");
		lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_7.setBounds(397, 173, 134, 14);
		contentPane.add(lblNewLabel_7);
		
		txtDataNascto = new JTextField();
		txtDataNascto.setBounds(397, 198, 188, 31);
		contentPane.add(txtDataNascto);
		txtDataNascto.setColumns(10);
		
		JComboBox cbFuncao = new JComboBox();
		cbFuncao.setModel(new DefaultComboBoxModel(new String[] {"Cabelereira", "Manicure", "Massagista", "Esteticista", "Maquiadora"}));
		cbFuncao.setBounds(397, 265, 188, 31);
		contentPane.add(cbFuncao);
		
		JLabel lblNewLabel_8 = new JLabel("Funcao");
		lblNewLabel_8.setBounds(397, 241, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JCheckBox cDomingo = new JCheckBox("Domingo\r\n");
		cDomingo.setBounds(397, 328, 81, 23);
		contentPane.add(cDomingo);
		
		JCheckBox cSegunda = new JCheckBox("Segunda\r\n");
		cSegunda.setBounds(480, 328, 81, 23);
		contentPane.add(cSegunda);
		
		JCheckBox cTerca = new JCheckBox("Terca\r\n");
		cTerca.setBounds(397, 354, 81, 23);
		contentPane.add(cTerca);
		
		JCheckBox cQuarta = new JCheckBox("Quarta");
		cQuarta.setBounds(480, 354, 70, 23);
		contentPane.add(cQuarta);
		
		JCheckBox cQuinta = new JCheckBox("Quinta\r\n");
		cQuinta.setBounds(397, 384, 57, 23);
		contentPane.add(cQuinta);
		
		JCheckBox cSexta = new JCheckBox("Sexta\r\n");
		cSexta.setBounds(480, 384, 70, 23);
		contentPane.add(cSexta);
		
		JCheckBox cSabado = new JCheckBox("Sabado");
		cSabado.setBounds(434, 407, 97, 23);
		contentPane.add(cSabado);
		
		JLabel lblNewLabel_9 = new JLabel("Dias de trabalho\r\n");
		lblNewLabel_9.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_9.setBounds(397, 307, 116, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Comissao (Sem %)");
		lblNewLabel_10.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_10.setBounds(397, 440, 116, 14);
		contentPane.add(lblNewLabel_10);
		
		txtComissao = new JTextField();
		txtComissao.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtComissao.setToolTipText("");
		txtComissao.setBounds(397, 465, 188, 31);
		contentPane.add(txtComissao);
		txtComissao.setColumns(10);
		
		tbColab = new JTable();
		tbColab.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		tbColab.setBounds(595, 131, 1089, 366);
		contentPane.add(tbColab);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String diaTrabalho="";
				try {
					
					PreparedStatement pst = conecta.conn.prepareStatement("insert into tbColab(telefoneColab,nomeColab,logradouroColab,numLogColab,bairroColab,cidadeColab,dataNasctoColab,funcaoColab,diasTrabalho,comissaoColab)values(?,?,?,?,?,?,?,?,?,?)");
					if(cDomingo.isSelected()) {
						 diaTrabalho = diaTrabalho+" Dom,";
					}
					if(cSegunda.isSelected()) {
						 diaTrabalho = diaTrabalho+" Seg,";
					}
					if(cTerca.isSelected()) {
						 diaTrabalho = diaTrabalho+" Ter,";
					}
					if(cQuarta.isSelected()) {
						 diaTrabalho = diaTrabalho+" Qua,";
					}
					if(cQuinta.isSelected()) {
						 diaTrabalho = diaTrabalho+" Qui,";
					}
					if(cSexta.isSelected()) {
						 diaTrabalho = diaTrabalho+" Sex,";
					}
					if(cSabado.isSelected()) {
						 diaTrabalho = diaTrabalho+" Sab,";
					}
					
					if(txtTelefone.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,"Preencha todos os campos");
						
					}
					else if(txtNome.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,"Preencha todos os campos");
						
					}
					else if(txtLogradouro.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,"Preencha todos os campos");
						
					}
					else if(txtNumLog.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,"Preencha todos os campos");
						
					}
					else if(txtBairro.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,"Preencha todos os campos");
						
					}
					else if(txtCidade.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,"Preencha todos os campos");
						
					}
					else if(txtDataNascto.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,"Preencha todos os campos");
						
					}
					else if(txtComissao.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,"Preencha todos os campos");
						
					}
					else {
					
					
					pst.setString(1,txtTelefone.getText());
					pst.setString(2,txtNome.getText());
					pst.setString(3,txtLogradouro.getText());
					pst.setString(4,txtNumLog.getText());
					pst.setString(5,txtBairro.getText());
					pst.setString(6,txtCidade.getText());
					pst.setString(7,txtDataNascto.getText());
					pst.setString(8,(String) cbFuncao.getSelectedItem());
					pst.setString(9,diaTrabalho);
					pst.setString(10,txtComissao.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(rootPane,"Cadastrado com sucesso");
					txtNome.setText("");
					txtDataNascto.setText("");
					txtTelefone.setText("");
					txtLogradouro.setText("");
					txtNumLog.setText("");
					txtBairro.setText("");
					txtCidade.setText("");
					cbFuncao.setSelectedItem("Cabelereira");
					txtComissao.setText("");
					  cDomingo.setSelected(false);
					  cSegunda.setSelected(false);
					  cTerca.setSelected(false);
					  cQuarta.setSelected(false);
					  cQuinta.setSelected(false);
					  cSexta.setSelected(false);
					  cSabado.setSelected(false);
					txtTelefone.requestFocus();
				}
				}
					catch(SQLException ex) {
						JOptionPane.showMessageDialog(rootPane,"Erro na insercao! \n" + ex);
						txtNome.setText("");
						txtDataNascto.setText("");
						txtTelefone.setText("");
						txtLogradouro.setText("");
						txtNumLog.setText("");
						txtBairro.setText("");
						txtCidade.setText("");
						cbFuncao.setSelectedItem("Cabelereira");
						txtComissao.setText("");
						  cDomingo.setSelected(false);
						  cSegunda.setSelected(false);
						  cTerca.setSelected(false);
						  cQuarta.setSelected(false);
						  cQuinta.setSelected(false);
						  cSexta.setSelected(false);
						  cSabado.setSelected(false);
						txtTelefone.requestFocus();
					}
				}
			
					
				
				
				
			
		});
		btnCadastrar.setBounds(30, 545, 104, 31);
		contentPane.add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String diaTrabalho = "";
				try {
					if(cDomingo.isSelected()) {
						 diaTrabalho = diaTrabalho+" Dom,";
					}
					if(cSegunda.isSelected()) {
						 diaTrabalho = diaTrabalho+" Seg,";
					}
					if(cTerca.isSelected()) {
						 diaTrabalho = diaTrabalho+" Ter,";
					}
					if(cQuarta.isSelected()) {
						 diaTrabalho = diaTrabalho+" Qua,";
					}
					if(cQuinta.isSelected()) {
						 diaTrabalho = diaTrabalho+" Qui,";
					}
					if(cSexta.isSelected()) {
						 diaTrabalho = diaTrabalho+" Sex,";
					}
					if(cSabado.isSelected()) {
						 diaTrabalho = diaTrabalho+" Sab,";
					}
				
					if(txtTelefone.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,"Preencha todos os campos");
						
					}
					else if(txtNome.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,"Preencha todos os campos");
						
					}
					else if(txtLogradouro.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,"Preencha todos os campos");
						
					}
					else if(txtNumLog.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,"Preencha todos os campos");
						
					}
					else if(txtBairro.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,"Preencha todos os campos");
						
					}
					else if(txtCidade.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,"Preencha todos os campos");
						
					}
					else if(txtDataNascto.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,"Preencha todos os campos");
						
					}
					else if(txtComissao.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,"Preencha todos os campos");
						
					}
					else {
					PreparedStatement pst = conecta.conn.prepareStatement("update tbColab set nomeColab=?, logradouroColab=?,numLogColab=?,bairroColab=?,cidadeColab=?,dataNasctoColab=?,funcaoColab=?,diasTrabalho=?,comissaoColab=? where telefoneColab=?");
					pst.setString(1,txtNome.getText());
					pst.setString(2,txtLogradouro.getText());
					pst.setString(3,txtNumLog.getText());
					pst.setString(4,txtBairro.getText());
					pst.setString(5,txtCidade.getText());
					pst.setString(6,txtDataNascto.getText());
					pst.setString(7,(String) cbFuncao.getSelectedItem());
					pst.setString(8,diaTrabalho);
					pst.setString(9,txtComissao.getText());
					pst.setString(10,txtTelefone.getText());
					pst.execute();
					JOptionPane.showMessageDialog(rootPane, "Editado com sucesso");
					}
				}
				
					catch(SQLException ex) {
						JOptionPane.showMessageDialog(rootPane,"Erro ao alterar! \n" + ex);
						txtNome.setText("");
						txtDataNascto.setText("");
						txtTelefone.setText("");
						txtLogradouro.setText("");
						txtNumLog.setText("");
						txtBairro.setText("");
						txtCidade.setText("");
						cbFuncao.setSelectedItem("Cabelereira");
						txtComissao.setText("");
						  cDomingo.setSelected(false);
						  cSegunda.setSelected(false);
						  cTerca.setSelected(false);
						  cQuarta.setSelected(false);
						  cQuinta.setSelected(false);
						  cSexta.setSelected(false);
						  cSabado.setSelected(false);
						txtTelefone.requestFocus();
					}
				}
			
			});
		btnEditar.setBounds(371, 545, 100, 31);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conecta.executaSQL("delete from tbColab where telefoneColab='"+txtTelefone.getText()+"'");
				JOptionPane.showMessageDialog(rootPane,"Excluido com sucesso");
			}
		});
		btnExcluir.setBounds(257, 545, 104, 31);
		contentPane.add(btnExcluir);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtDataNascto.setText("");
				txtTelefone.setText("");
				txtLogradouro.setText("");
				txtNumLog.setText("");
				txtBairro.setText("");
				txtCidade.setText("");
				cbFuncao.setSelectedItem("Cabelereira");
				txtComissao.setText("");
				  cDomingo.setSelected(false);
				  cSegunda.setSelected(false);
				  cTerca.setSelected(false);
				  cQuarta.setSelected(false);
				  cQuinta.setSelected(false);
				  cSexta.setSelected(false);
				  cSabado.setSelected(false);
				txtTelefone.requestFocus();
			}
		});
		btnNovo.setBounds(143, 545, 104, 31);
		contentPane.add(btnNovo);
		
		JButton btnExibir = new JButton("Exibir Todos");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherTabela("select * from tbColab order by nomeColab");
			}
		});
		btnExibir.setBounds(481, 545, 104, 31);
		contentPane.add(btnExibir);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					conecta.executaSQL("select * from tbColab where telefoneColab='"+txtTelefone.getText()+"'");
					conecta.rs.first();
					txtNome.setText(conecta.rs.getString("nomeColab"));
					txtLogradouro.setText(conecta.rs.getString("logradouroColab"));
					txtNumLog.setText(conecta.rs.getString("numLogColab"));
					txtBairro.setText(conecta.rs.getString("bairroColab"));
					txtCidade.setText(conecta.rs.getString("cidadeColab"));
					txtDataNascto.setText(conecta.rs.getString("dataNasctoColab"));
					cbFuncao.setSelectedItem(conecta.rs.getString("funcaoColab"));
					txtComissao.setText(conecta.rs.getString("comissaoColab"));
					
					
					
				} catch (SQLException e1) {
					
					JOptionPane.showMessageDialog(rootPane,"Erro ao mostrar dados!"+e1);
					txtNome.setText("");
					txtDataNascto.setText("");
					txtTelefone.setText("");
					txtLogradouro.setText("");
					txtNumLog.setText("");
					txtBairro.setText("");
					txtCidade.setText("");
					cbFuncao.setSelectedItem("Cabelereira");
					txtComissao.setText("");
					  cDomingo.setSelected(false);
					  cSegunda.setSelected(false);
					  cTerca.setSelected(false);
					  cQuarta.setSelected(false);
					  cQuinta.setSelected(false);
					  cSexta.setSelected(false);
					  cSabado.setSelected(false);
					txtTelefone.requestFocus();
				}		
				
				
			}
			
		});
		btnBuscar.setBounds(397, 131, 142, 31);
		contentPane.add(btnBuscar);
		
		JLabel lblNewLabel_11 = new JLabel("Telefone");
		lblNewLabel_11.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_11.setBounds(595, 106, 63, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Nome");
		lblNewLabel_12.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_12.setBounds(715, 106, 46, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Logradouro");
		lblNewLabel_13.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_13.setBounds(812, 106, 70, 14);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Numero");
		lblNewLabel_14.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_14.setBounds(921, 106, 57, 14);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Bairro");
		lblNewLabel_15.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_15.setBounds(1023, 106, 46, 14);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Cidade");
		lblNewLabel_16.setBounds(1143, 107, 46, 14);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Data de Nascto");
		lblNewLabel_17.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_17.setBounds(1222, 106, 89, 14);
		contentPane.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Funcao");
		lblNewLabel_18.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_18.setBounds(1349, 106, 46, 14);
		contentPane.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Dias de Trabalho");
		lblNewLabel_19.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_19.setBounds(1432, 106, 104, 14);
		contentPane.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Comissao");
		lblNewLabel_20.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_20.setBounds(1611, 106, 60, 14);
		contentPane.add(lblNewLabel_20);
	}
}
