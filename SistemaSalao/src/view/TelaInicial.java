package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConectaBanco.ConectaBanco;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.Font;

public class TelaInicial extends JFrame {
	
	ConectaBanco conecta = new ConectaBanco();
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaInicial() {
		conecta.conexao();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMarcarHorarios = new JMenu("Horarios");
		mnMarcarHorarios.setFont(new Font("Verdana", Font.PLAIN, 15));
		menuBar.add(mnMarcarHorarios);
		
		JMenuItem mntmMarcarHorarios = new JMenuItem("Marcar Horarios");
		mntmMarcarHorarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarcarHorario frame = new MarcarHorario();
				 frame.setVisible(true);
			}
		});
		mntmMarcarHorarios.setFont(new Font("Verdana", Font.PLAIN, 12));
		mnMarcarHorarios.add(mntmMarcarHorarios);
		
		JMenuItem mntmHorariosMarcados = new JMenuItem("Horarios marcados");
		mntmHorariosMarcados.setFont(new Font("Verdana", Font.PLAIN, 12));
		mnMarcarHorarios.add(mntmHorariosMarcados);
		
		JMenu mnNewMenu = new JMenu("Cadastros");
		mnNewMenu.setFont(new Font("Verdana", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		mntmCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCliente frame = new CadastroCliente();
				 frame.setVisible(true);
			}
		});
		mntmCadastrarCliente.setFont(new Font("Verdana", Font.PLAIN, 12));
		mnNewMenu.add(mntmCadastrarCliente);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar Colaboradores");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroColaboradores frame = new CadastroColaboradores();
				 frame.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Verdana", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmCadastrarFormaDe = new JMenuItem("Cadastrar Forma de Pagamento");
		mntmCadastrarFormaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroFormaPagto frame = new CadastroFormaPagto();
				 frame.setVisible(true); 
			}
		});
		mntmCadastrarFormaDe.setFont(new Font("Verdana", Font.PLAIN, 12));
		mnNewMenu.add(mntmCadastrarFormaDe);
		
		JMenuItem mntmCadastrarServico = new JMenuItem("Cadastrar Servico");
		mntmCadastrarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroServico frame = new CadastroServico();
				 frame.setVisible(true); 
			}
		});
		mntmCadastrarServico.setFont(new Font("Verdana", Font.PLAIN, 12));
		mnNewMenu.add(mntmCadastrarServico);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtalhoMarcar = new JButton("");
		btnAtalhoMarcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MarcarHorario frame = new MarcarHorario();
				 frame.setVisible(true);
			}
		});
		btnAtalhoMarcar.setVerticalAlignment(SwingConstants.TOP);
		btnAtalhoMarcar.setIcon(new ImageIcon("C:\\Users\\gusta\\Documents\\40739.png"));
		btnAtalhoMarcar.setBounds(67, 85, 115, 123);
		contentPane.add(btnAtalhoMarcar);
		
		JLabel lblMarcarHorario = new JLabel("Marcar horario");
		lblMarcarHorario.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblMarcarHorario.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarcarHorario.setBounds(67, 222, 119, 33);
		contentPane.add(lblMarcarHorario);
		
		JButton btnCaixa = new JButton("Caixa");
		btnCaixa.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCaixa.setBounds(610, 37, 142, 23);
		contentPane.add(btnCaixa);
		
		textField = new JTextField();
		textField.setText("0");
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Verdana", Font.PLAIN, 90));
		textField.setBounds(552, 142, 129, 132);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 90));
		textField_1.setColumns(10);
		textField_1.setBounds(710, 142, 129, 132);
		contentPane.add(textField_1);
		
		JLabel lblSeuSalaoHoje = new JLabel("Seu salao hoje");
		lblSeuSalaoHoje.setFont(new Font("Verdana", Font.PLAIN, 27));
		lblSeuSalaoHoje.setBounds(595, 44, 226, 76);
		contentPane.add(lblSeuSalaoHoje);
		
		JLabel lblHorariosMarcados = new JLabel("Horarios marcados");
		lblHorariosMarcados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorariosMarcados.setBounds(720, 285, 129, 33);
		contentPane.add(lblHorariosMarcados);
		
		JLabel lblServicosConcluidos = new JLabel("Servicos concluidos");
		lblServicosConcluidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblServicosConcluidos.setBounds(551, 294, 141, 14);
		contentPane.add(lblServicosConcluidos);
		
		JButton btnAtalhoCadastrarCliente = new JButton("");
		btnAtalhoCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCliente frame = new CadastroCliente();
				 frame.setVisible(true);
			}
		});
		btnAtalhoCadastrarCliente.setIcon(new ImageIcon("C:\\Users\\gusta\\Documents\\cliente.png"));
		btnAtalhoCadastrarCliente.setBounds(207, 85, 115, 123);
		contentPane.add(btnAtalhoCadastrarCliente);
		
		JLabel lblNewLabel = new JLabel("Cadastrar cliente\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel.setBounds(207, 231, 115, 14);
		contentPane.add(lblNewLabel);
		
	}
}
