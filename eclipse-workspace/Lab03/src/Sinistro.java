
public class Sinistro {
	private final int id;
	private String data; 
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
	// Constructor 
	public Sinistro (String data, String endereco, String s1, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		this.setData(data);
		this.setEndereco(endereco);
		this.id = this.geradorId(s1);
		this.setSeguradora(seguradora);
		this.setVeiculo(veiculo);
		this.setCliente(cliente);
	}
	
	//getters e setters
	public int getId() {
		return id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	//gera o id atraves do cpf ou cnpj do cliente
	public int geradorId (String s1) { 
		return s1.hashCode();	
	}

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String toString() {
		String s1;
		return s1 = String.format("ID: %d\n"
				+ "Data: %s\n"
				+ "Endereço: %s\n"
				+ "Seguradora: %s\n"
				+ "Veículo: %s %s %s\n"
				+ "Cliente: %s", this.id, this.data, this.endereco, this.seguradora.getNome(), this.veiculo.getMarca(), this.veiculo.getModelo(),this.veiculo.getPlaca(), this.cliente.getNome());
	}
}
