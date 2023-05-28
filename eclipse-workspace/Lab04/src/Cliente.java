import java.text.ParseException;
import java.util.ArrayList;
import java.time.LocalDate;

public class Cliente {
	private String nome;
	private String endereco;
	private double valorSeguro;
	private ArrayList<Veiculo> listaVeiculos;
	private ArrayList <Sinistro> listaSinistroCl;
	
	// Constructor
	public Cliente (String nome, String endereco) {
		this.setNome(nome);
		this.setEndereco(endereco);
		this.listaVeiculos = new ArrayList<Veiculo>();
		this.listaSinistroCl = new ArrayList<Sinistro>();
	}
	
	// getters e setters
	public String getNome() {
		return nome;
	}
	public void setNome (String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void addVeiculo (Veiculo veiculo) {
		this.listaVeiculos.add(veiculo);
	}
	
	public void addSinsitro (Sinistro sinistro) {
		this.listaSinistroCl.add(sinistro);
	}
	
	public void listarVeiculos () {
		for (Veiculo veiculo: this.listaVeiculos) {
			System.out.print("Veiculos: \n");
			System.out.println(veiculo.toString());
		}
		System.out.print("\n");
	}
	
	public void listarSinistrosCl () {
		for (Sinistro sinistro: this.listaSinistroCl) {
			System.out.print("Sinistros: \n");
			System.out.println(sinistro);
		}
		System.out.print("\n");
	}
	
	public Veiculo getVeiculo (String placa) {
		int i;
		Veiculo veiculo = null;
		for (i = 0; i < this.listaVeiculos.size(); i++) {
			if (this.listaVeiculos.get(i).getPlaca().equals(placa)) {
				veiculo = this.listaVeiculos.get(i);
			}
		}
		return veiculo;
	}
	
	public String toString () {
		String s1, veiculos;
		int i;

		System.out.printf(s1 = String.format("Nome: %s\n"
				+ "Endereço: %s\n"
				+ "Veiculos: \n", this.getNome(), this.getEndereco()));
		
		for (i = 0; i < this.listaVeiculos.size(); i++) {
			System.out.print(veiculos = this.listaVeiculos.get(i).getPlaca() + "\n");
		}
		return "\n";
	}
	
	public double calcularScore ()  {
		double quantidadeCarros;
		return quantidadeCarros = this.listaVeiculos.size();
	}

	public double getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}
	
	public boolean removerVeiculo(String placa) {
		int i;
		for (i = 0; i < this.listaVeiculos.size(); i++) {
			if (this.listaVeiculos.get(i).getPlaca().equals(placa)) {
				this.listaVeiculos.remove(i);
				return true;
			}
		}
		return false;
	}
}

