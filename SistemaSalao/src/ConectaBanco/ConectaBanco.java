
package ConectaBanco;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.sun.xml.internal.fastinfoset.sax.Properties;


public class ConectaBanco {
	private static Connection cn;
	public Statement stm;
	public ResultSet rs;
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String caminho = "jdbc:sqlserver://localhost:1433;databaseName=bdSalao";
	private String usuario = "sa";
	private String senha = "123456";
	public Connection conn;
	
	public void conexao() {
		
	System.setProperty("jdbc.Drivers", driver);
	try {
		conn=DriverManager.getConnection(caminho, usuario, senha);
		
	} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Erro de conexao" + ex);
		
		
	}
	
	}	
	public void executaSQL(String sql) {
		try {
			stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	 
			
			
	
	public void desconecta() {
		try {
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar a conexao \n Erro: "+ex.getMessage());
		}
	}
			
		
	
	
	}
//Class.forName("net.sourceforge.jtds.jbdc.Driver");
//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433,bdSalao, salao,1802e1509");