import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> listaVeiculos;
	
	// Constructor
	public Cliente (String nome, String endereco) {
		this.setNome(nome);
		this.setEndereco(endereco);
		this.listaVeiculos = new ArrayList<Veiculo>();
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
}

