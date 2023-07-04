import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Seguradora {
	private final static Scanner input = new Scanner(System.in);
	private final String cnpj;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Cliente> listaclientes;
	private ArrayList<Seguro> listaseguros;
	
	public Seguradora (String cnpj, String nome, String telefone, String email, String endereco) {
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEmail(email);
		this.setEndereco(endereco);
		this.listaclientes = new ArrayList<Cliente>();
		this.listaseguros = new ArrayList<Seguro>();
		this.cnpj = cnpj;
	}
	
	//getters e setters
	public String getCnpj () {
		return cnpj;
	}
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
	public ArrayList<Cliente> getListaclientes() {
		return listaclientes;
	}
	public void setListaclientes(ArrayList<Cliente> listaclientes) {
		this.listaclientes = listaclientes;
	}
	public ArrayList<Seguro> getListaseguros() {
		return listaseguros;
	}
	public void setListaseguros(ArrayList<Seguro> listaseguros) {
		this.listaseguros = listaseguros;
	}
	
	// metodos
	public boolean gerarSeguro () {
		System.out.print("\n**********GERAR SEGURO**********\n");
		System.out.print("Escolha o cliente: \n");
		for(int i = 0; i < this.listaclientes.size(); i++) {
			System.out.println((i + 1) + "- " + this.listaclientes.get(i).toString() + "\n");
		}
		System.out.print("\nEscreva o número da opção a ser escolhida\n");
		int index = input.nextInt();
		Cliente cliente = this.listaclientes.get(index - 1);
		System.out.print("Data de inicio: \n");
		String dataIniciof = input.nextLine();
		System.out.print("Data de fim: \n");
		String dataFimf = input.nextLine();
		
		DateTimeFormatter dataformatada =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate dataInicio = LocalDate.parse(dataIniciof, dataformatada);
		LocalDate dataFim = LocalDate.parse(dataFimf, dataformatada);
		
		if (cliente instanceof ClientePF) {
			Veiculo veiculo = Instaciar.instanciarVeiculo();
			SeguroPF seguro = new SeguroPF(((ClientePF) cliente).getNome(), dataInicio, dataFim, this, veiculo, ((ClientePF)cliente));
			System.out.print("Seguro cadastrado");
			return this.listaseguros.add(seguro);
		}
		
		else if (cliente instanceof ClientePJ) {
			Frota frota = Instaciar.instanciarFrota();
			SeguroPJ seguro = new SeguroPJ (((ClientePJ) cliente).getNome(), dataInicio, dataFim, this, frota, ((ClientePJ) cliente));
			System.out.print("Seguro cadastrado");
			return this.listaseguros.add(seguro);
		}
		return false;
	}
	
	public boolean cancelarSeguro () {
		int i;
		System.out.print("\n**********ESCOLHA O SEGURO**********\n");
		for(i = 0; i < this.listaseguros.size(); i++) {
			System.out.println(i + "- " + this.listaseguros.get(i).getId() + "\n");
		}
		System.out.print("\nEscreva o número da opção a ser escolhida\n");
		int index = input.nextInt();
		Seguro seguro = this.listaseguros.get(index - 1);
		
		return this.listaseguros.remove(seguro);
	}
	
	public ClientePF cadastrarClientePF (String nome, String endereco, String telefone, String email) {
		System.out.print("CPF: \n");
		String cpf = input.nextLine();
		System.out.print("Gênero: \n");
		String genero = input.nextLine();
		System.out.print("Educação: \n");
		String educacao = input.nextLine();
		System.out.print("Data de nascimento: \n");
		String dataNascimentof = input.nextLine();
		
		DateTimeFormatter dataformatada =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate dataNascimento = LocalDate.parse(dataNascimentof, dataformatada);
		
		ClientePF cliente = null;
		return cliente = new ClientePF(nome, endereco, telefone, email, cpf, genero, educacao, dataNascimento);
	}
	
	public ClientePJ cadastrarClientePJ (String nome, String endereco, String telefone, String email) {
		System.out.print("CNPJ: \n");
		String cnpj = input.nextLine();
		System.out.print("Data de fundação: \n");
		String dataFundacaof = input.nextLine()
		
		DateTimeFormatter dataformatada =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate dataFundacao = LocalDate.parse(dataFundacaof, dataformatada);
		
		ClientePJ cliente = null;
		return cliente = new ClientePJ (nome, endereco, telefone, email, cnpj, dataFundacao);
	}
	
	public boolean cadastrarCliente() {
		System.out.print("\n**********CADASTRAR CLIENTE**********\n");
		System.out.print("Nome: \n");
		String nome = input.nextLine();
		System.out.print("Endereço: \n");
		String endereco = input.nextLine();
		System.out.print("Telefone: \n");
		String telefone = input.nextLine();
		System.out.print("Email: \n");
		String email = input.nextLine();
		System.out.print("Cliente PF ou PJ?(Escreva PF ou PJ)\n");
		String resposta = input.nextLine();
		
		if (resposta.equals("PF")) {
			ClientePF cliente = cadastrarClientePF(nome, endereco, telefone, email);
			return this.listaclientes.add(cliente);
		}
		
		else if (resposta.equals("PJ")) {
			ClientePJ cliente = cadastrarClientePJ(nome, endereco, telefone, email);
			return this.listaclientes.add(cliente);
		}
		
		return false;
	}
	
	public boolean removerCliente () {
		System.out.print("\n**********REMOVER CLIENTE**********\n");
		System.out.print("Escolha o cliente:\n");
		int i = 0;
		for(Cliente cliente: this.listaclientes) {
			i += 1;
			System.out.println(i + "- " + cliente.getNome() + "\n");
		}
		int index = input.nextInt();
		Cliente cliente = this.listaclientes.get(index - 1);
		if (cliente instanceof ClientePF) {
			String cpf = ((ClientePF) cliente).getCpf();
			for(Seguro seguro: this.listaseguros) {
				if(seguro instanceof SeguroPF) {
					if (((SeguroPF) seguro).getClientepf().getCpf().equals(cpf)) {
						this.listaseguros.remove(seguro);
					}
				}
			}
		}
		
		if (cliente instanceof ClientePJ) {
			String cnpj = ((ClientePJ) cliente).getCnpj();
			for(Seguro seguro: this.listaseguros) {
				if(seguro instanceof SeguroPF) {
					if (((SeguroPJ) seguro).getClientepj().getCnpj().equals(cnpj)) {
						this.listaseguros.remove(seguro);
					}
				}
			}
		}
		this.listaclientes.remove(index - 1);
		System.out.print("Cliente removido\n");
		return true;
	}
	
	public ArrayList<Seguro> getSegurosPorCliente() {
		ArrayList<Seguro> listaseguroscliente = new ArrayList<Seguro>();
		System.out.print("\nEscolha o cliente: \n");
		for(int i = 0; i < this.listaclientes.size(); i++) {
			System.out.println((i + 1) + "- " + this.listaclientes.get(i).toString() + "\n");
		}
		System.out.print("\nEscreva o número da opção a ser escolhida\n");
		int index = input.nextInt();
		Cliente cliente = this.listaclientes.get(index - 1);
		for(Seguro seguro: this.listaseguros) {
			if (cliente instanceof ClientePF) {
				if(((SeguroPF) seguro).getClientepf().equals(cliente))
					listaseguroscliente.add(seguro);
			}

		if (cliente instanceof ClientePJ) {
			if(((SeguroPJ) seguro).getClientepj().equals(cliente))
				listaseguroscliente.add(seguro);
			}
		}
		return listaseguroscliente;
	}
	
	public ArrayList<Sinistro> getSinistroPorCliente() {
		System.out.print("\nEscolha o cliente: \n");
		for(int i = 0; i < this.listaclientes.size(); i++) {
			System.out.println((i + 1) + "- " + this.listaclientes.get(i).toString() + "\n");
		}
		System.out.print("\nEscreva o número da opção a ser escolhida\n");
		int index = input.nextInt();
		Cliente cliente = this.listaclientes.get(index - 1);
		for(Seguro seguro: this.listaseguros) {
			if (cliente instanceof ClientePF) {
				if(((SeguroPF) seguro).getClientepf().equals(cliente))
					return seguro.getListasinistros();
			}

			if (cliente instanceof ClientePJ) {
				if(((SeguroPJ) seguro).getClientepj().equals(cliente))
					return seguro.getListasinistros();
			}
		}
		return null;
	}
	
	public double calcularReceita ()  {
		double receita = 0; 
		for (Seguro seguro: this.listaseguros) {
			 receita += seguro.getValorMensal();
		 }
		return receita;
	}
	
	public String toString () {
		String s1;
		return s1 = String.format("\nCNPJ: %s\n"
				+ "Nome: %s\n"
				+ "Endereço: %s\n"
				+ "Telefone: %s\n"
				+ "Email: %s\n", this.cnpj, this.nome, this.endereco, this.telefone, this.email);		
	}
}
