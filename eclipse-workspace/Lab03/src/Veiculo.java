
public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	
	// Constructor
	public Veiculo (String placa, String marca, String modelo) {
		this.setPlaca(placa);
		this.setMarca(marca);
		this.setModelo(modelo);
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
	
}
