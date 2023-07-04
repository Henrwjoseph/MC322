import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	
	
	// Constructor
	public Cliente (String nome, String telefone, String endereco, String email) {
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setEmail(email);
		this.setTelefone(telefone);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


}
