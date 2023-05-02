import java.util.ArrayList;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Cliente> listacliente = new ArrayList<Cliente>();
	private ArrayList<Sinistro> listasinistro = new ArrayList<Sinistro>();
	
	// Constructor
	public Seguradora(String nome,  String telefone, String email, String endereco) {
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEmail(email);
		this.setEndereco(endereco);
	}

	//getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public boolean cadastrarCliente (Cliente cliente) {
		if (this.listacliente.contains(cliente)) 
			return false;
		this.listacliente.add(cliente);
		return true;
	}
	
	public boolean removerCliente (String cliente) {
		int i;
		for (i = 0; i < this.listacliente.size(); i++) {
			if (this.listacliente.get(i).getNome() == cliente) {
				this.listacliente.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void listarCliente (String tipocliente) {
		int i;
		if (tipocliente == "PF") {
			for (i = 0; i < this.listacliente.size(); i++) {
				if (this.listacliente.get(i) instanceof Clientepf) {
					System.out.print("Clientes PF:\n");
					System.out.printf(this.listacliente.get(i).toString() + "\n");
				}
			}
		}
		
		if (tipocliente == "PJ") {
			for (i = 0; i < this.listacliente.size(); i++) {
				if (this.listacliente.get(i) instanceof Clientepj) {
					System.out.print("Clientes PJ:\n");
					System.out.printf(this.listacliente.get(i).toString() + "\n");
				}												
			}
		}
	}
	
	public boolean gerarSinistro (Sinistro sinistro) {
		if (this.listasinistro.contains(sinistro)) 
			return false;
		this.listasinistro.add(sinistro);
		return true;
	}
	
	public boolean visualisarSinistro(String cliente) {
		int i;
		for (i = 0; i <= this.listasinistro.size(); i++) {
			if (listasinistro.get(i).getCliente().getNome() == cliente) {
				System.out.print("\nSinistro do cliente: \n");
				System.out.printf(this.listasinistro.get(i).toString() + "\n");
				return true;
			}
		}
		return false;
	}
	
	public void listaSinistro () {
		int i;
		for (i = 0; i < this.listasinistro.size(); i++) {
			System.out.print("\nSinistros: \n");
			System.out.printf(this.listasinistro.get(i).toString() + "\n");
		}
	}
	
	public String toString () {
		String s1;
		s1 = String.format("Nome: %s\n"
				+ "Endereço: %s\n"
				+ "Telefone: %s\n"
				+ "Email: %s\n", this.getNome(), this.getEndereco(), this.getTelefone(), this.getEmail());
		return s1;
		
	}
}
