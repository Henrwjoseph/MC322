import java.text.ParseException;
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
	
	public Cliente getCliente(String registro) {
		int i; 
		Cliente cliente = null;
		if (Validacao.validarCPF(registro)) {
			for (i = 0; i < this.listacliente.size(); i++) {
				if (this.listacliente.get(i) instanceof Clientepf ) {
					if (((Clientepf)this.listacliente.get(i)).getCpf().equals(registro)) {
						cliente = this.listacliente.get(i);
					}
				}
			}
		}
		
		if (Validacao.validarCnpj(registro)) {
			for (i = 0; i < this.listacliente.size(); i++) {
				if (this.listacliente.get(i) instanceof Clientepj ) {
					if (((Clientepj)this.listacliente.get(i)).getCnpj().equals(registro)) {
						cliente = this.listacliente.get(i);
					}
				}
			}
		}
		
		return cliente;
		
		
	}
	
	public boolean removerSinistro (int id) {
		int i;
		for (i = 0; i < this.listasinistro.size(); i++) {
			if (this.listasinistro.get(i).getId() == id) {
				this.listasinistro.remove(i); 
			}
			return true;
		}
		return false;
	}
	
	public boolean removerCliente (String registro) {
		int i;
		if (Validacao.validarCPF(registro)) {
			for (i = 0; i < this.listacliente.size(); i++) {
				if (this.listacliente.get(i) instanceof Clientepf ) {
					if (((Clientepf)this.listacliente.get(i)).getCpf().equals(registro)) {
						this.listacliente.remove(i);
					}
				}
			}
			for (i = 0; i < this.listasinistro.size(); i++) {
				if (this.listacliente.get(i) instanceof Clientepf ) {
					if (((Clientepf)this.listasinistro.get(i).getCliente()).getCpf().equals(registro)); {
						this.listasinistro.remove(i); 
					}
					return true;
				}
			}
		}
		if (Validacao.validarCnpj(registro)) {
			for (i = 0; i < this.listacliente.size(); i++) {
				if (this.listacliente.get(i) instanceof Clientepj ) {
					if (((Clientepj)this.listacliente.get(i)).getCnpj().equals(registro)) {
						this.listacliente.remove(i);
					}
				}
			}
			for (i = 0; i < this.listasinistro.size(); i++) {
				if (this.listacliente.get(i) instanceof Clientepj ) {
					if (((Clientepj)this.listasinistro.get(i).getCliente()).getCnpj().equals(registro)); {
						this.listasinistro.remove(i); 
					}
					return true;
				}
			}
		}
		return false;
	}
	
	public void listarCliente (String tipocliente) {
		int i;
		if (tipocliente == "PF") {
			for (i = 0; i < this.listacliente.size(); i++) {
				if (this.listacliente.get(i) instanceof Clientepf) {
					System.out.print("\nClientes PF:\n");
					System.out.printf(this.listacliente.get(i).toString() + "\n");
				}
			}
		}
		
		if (tipocliente == "PJ") {
			for (i = 0; i < this.listacliente.size(); i++) {
				if (this.listacliente.get(i) instanceof Clientepj) {
					System.out.print("\nClientes PJ:\n");
					System.out.printf(this.listacliente.get(i).toString() + "\n");
				}												
			}
		}
	}
	
	public void listarVeiculoSeguradora () {
		for (Cliente cliente: this.listacliente) {
			System.out.printf("\nCliente: " + cliente.getNome() + "\n");
			cliente.listarVeiculos();
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
	
	public void listarSinistro () {
		int i;
		for (i = 0; i < this.listasinistro.size(); i++) {
			System.out.print("\nSinistros: \n");
			System.out.printf(this.listasinistro.get(i).toString() + "\n");
		}
	}
	
	public void listarveiculos () {
		for (Cliente cliente: this.listacliente) {
			cliente.listarVeiculos();
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
	
	public double cacluclarPrecoSeguro (Cliente cliente)  {
		double preco_seguro = 0;
		int i, qntSinistros = 0;
		if (cliente instanceof Clientepf) {
			for (i = 0; i < this.listasinistro.size(); i++) {
				if (this.listasinistro.get(i).getCliente() == cliente) {
					qntSinistros += 1;
				}
			}
			preco_seguro = ((Clientepf)cliente).calcularScore() * (1 + qntSinistros);
			cliente.setValorSeguro(preco_seguro);
		}
		
		if (cliente instanceof Clientepj) {
			for (i = 0; i < this.listasinistro.size(); i++) {
				if (this.listasinistro.get(i).getCliente() == cliente) {
					qntSinistros += 1;
				}
			}
			preco_seguro = ((Clientepf)cliente).calcularScore() * (1 + qntSinistros);
			cliente.setValorSeguro(preco_seguro);
		}

		return preco_seguro;
	}
	
	public double calcularReceita ()  {
		double receita = 0; 
		for (Cliente cliente: this.listacliente) {
			 receita += this.cacluclarPrecoSeguro(cliente);
		 }
		return receita;
		
	}
}
