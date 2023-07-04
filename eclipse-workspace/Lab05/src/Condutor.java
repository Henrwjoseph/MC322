import java.time.LocalDate;
import java.util.ArrayList;

public class Condutor {
	private final String cpf;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private LocalDate dataNascimento;
	private ArrayList<Sinistro> listasinistros;
	
	public Condutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNascimento) {
		this.cpf = cpf;
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		this.setEmail(email);
		this.setDataNascimento(dataNascimento);
		this.listasinistros = new ArrayList<Sinistro>();
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public ArrayList<Sinistro> getListasinistros() {
		return listasinistros;
	}
	public void setListasinistros(ArrayList<Sinistro> listasinistros) {
		this.listasinistros = listasinistros;
	}

	public String getCpf() {
		return cpf;
	}
	public void adicionarSinistro (Sinistro sinistro) {
		this.listasinistros.add(sinistro);
	}
}
