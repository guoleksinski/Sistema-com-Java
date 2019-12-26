package view;




public class Clientes {
	    private int id;
		private String nome;
		private String telefone;
		private String dataNascto;
		
		public Clientes() {
			
		}
		public Clientes(int id, String nome, String telefone, String dataNascto) {
			this.id = id;
			this.nome = nome;
			this.telefone = telefone;
			this.dataNascto = dataNascto;
		}
		public int getId() {
			return id;
		}
		public int setId() {
			return id;
		}
		public String getNome() {
			return nome;
		}
		public String setNome() {
			return nome;
		}
		public String getTelefone() {
			return telefone;
		}
		public String setTelefone() {
			return telefone;
		}
		public String getDataNascto() {
			return dataNascto;
		}
		public String setDataNascto() {
			return dataNascto;
		}
	
}
 