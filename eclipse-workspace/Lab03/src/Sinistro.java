
public class Sinistro {
	private int id;
	private String data; 
	private String endereco;
	
	// Constructor 
	public Sinistro (String data, String endereco) {
		this.setData(data);
		this.setEndereco(endereco);
		this.geradorId(endereco);
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
	
	public void geradorId (String endereco) { 
		this.id = endereco.hashCode();	
	}
}
