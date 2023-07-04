import java.time.LocalDate;

public class Sinistro {
	private final int id;
	private LocalDate data; 
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;
	
	// Constructor 
	public Sinistro (LocalDate data, String endereco, String s1, Condutor condutor, Seguro seguro) {
		this.setData(data);
		this.setEndereco(endereco);
		this.id = this.geradorId(s1);
		this.setCondutor(condutor);
		this.setSeguro(seguro);
	}
	
	//getters e setters
	public int getId() {
		return id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	
	//gera o id atraves do cpf ou cnpj do cliente
	public int geradorId (String s1) { 
		return s1.hashCode();	
	}

	public String toString() {
		String s1;
		return s1 = String.format("ID: %d\n"
				+ "Data: %s\n"
				+ "Endereço: %s\n"
				+ "CPF do condutor: %s\n"
				+ "ID do seguro: %s\n"
				+ this.id, this.data, this.endereco, this.getCondutor().getCpf(), this.getSeguro().getId());
	}
}

