
public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	
	// Constructor
	public Veiculo (String placa, String marca, String modelo, int anoFabricacao) {
		this.setPlaca(placa);
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setAnoFabricacao(anoFabricacao);
	}

	//getters e setters
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	public String toString () {
		String s1;
		return s1 = String.format("\nMarca: %s\n"
				+ "Modelo: %s\n"
				+ "Placa: %s\n", this.getMarca(), this.getModelo(), this.getPlaca());
	}
	
}
