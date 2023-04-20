
public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	// Constructor
	public Cliente (String nome, String cpf, String dataNascimento, int idade, String endereco) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setDataNascimento(dataNascimento);
		this.setIdade(idade);
		this.setEndereco(endereco);
	}
	
	// getters e setters
	public String getNome() {
		return nome;
	}
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf (String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	//calculo do primeiro digito varificador
	public int calcularVum (String replaceCpf) {
		int i, aux, vaux = 0, v1 = 0, acumulador = 0;
		for (i = 0; i < replaceCpf.length() - 2; i++) {
			aux = (replaceCpf.charAt(i) - 48)*(10 - i);
			acumulador += aux;
		}
		vaux = acumulador%11;
		if (vaux == 0 || vaux == 1) {
			v1 = 0;
		}
		else {
			v1 = 11 - (acumulador % 11);
		}
		return v1;
	}
	
	//calculo do segundo digito varificador
	public int calcularVdois (String replaceCpf) {
		int i, aux,vaux = 0, v2 = 0, acumulador = 0;
		for (i = 0; i < replaceCpf.length() - 2; i++) {
			aux = (replaceCpf.charAt(i + 1) - 48)*(10 - i);
			acumulador += aux;
		}
		vaux = acumulador%11;
		if (vaux == 0 || vaux == 1) {
			v2 = 0;
		}
		else {
			v2 = 11 - (acumulador % 11);
		}
		return v2;
	}
		
	public boolean validarCPF() {
		int i, v2 = 0, v1 = 0;
		String replaceCpf;	
		replaceCpf = this.cpf.replaceAll("\\.","");
		replaceCpf = replaceCpf.replaceAll("-","");
		
		if (replaceCpf.length() != 11) {
			return false;
		}
		
		for (i = 0; i < replaceCpf.length(); i++) {
			if (i == replaceCpf.length() - 1) {
				return false;
			}

			if (replaceCpf.charAt(i) != replaceCpf.charAt(i + 1)) {
				break;
			}
		}
				
		v1 = calcularVum (replaceCpf);
		if (v1 != (replaceCpf.charAt(replaceCpf.length() - 2)) - 48) {
			return false;
		}
		
		v2 = calcularVdois (replaceCpf);
		if (v2 != (replaceCpf.charAt(replaceCpf.length() - 1)) - 48) {
			return false; 
		}
		
		else {
			System.out.println("CPF válido");
			return true;
		}
		
	}
	
	public String toString () {
		String s1;
		return  s1 = String.format("Nome: %s\n"
				+ "Cpf: %s\n"
				+ "Data de nascimento: %s\n"
				+ "Endereço: %s\n"
				+ "Idade: %d",this.nome, this.cpf, this.dataNascimento, this.endereco, this.idade);
	}
}

