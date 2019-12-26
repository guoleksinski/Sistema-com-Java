package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(121, 53, 46, 14);
		contentPane.add(lblLogin);

		txtLogin = new JTextField();
		txtLogin.setBounds(121, 75, 194, 31);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(121, 119, 46, 14);
		contentPane.add(lblSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkLogin(txtLogin.getText(), new String(txtSenha.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema");

					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Dados Errados");

				}

			}
		});
		btnEntrar.setBounds(171, 194, 89, 23);
		contentPane.add(btnEntrar);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(121, 144, 194, 31);
		contentPane.add(txtSenha);
	}

	public boolean checkLogin(String login, String senha) {
		return login.equals("usuario") && senha.equals("123");
	}
}
