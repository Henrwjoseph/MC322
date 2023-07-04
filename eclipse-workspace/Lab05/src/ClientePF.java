import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientePF extends Cliente {
	private final static Scanner input = new Scanner(System.in);
	private final String cpf;
	private String genero;
	private String educacao;
	private LocalDate dataNascimento;
	private ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
	
	public ClientePF (String nome, String endereco, String telefone, String email, String cpf, String genero, String educacao, LocalDate dataNascimento) {
		super(nome, telefone, endereco, email);
		this.cpf = cpf;
		this.setGenero(genero);
		this.setEducacao(educacao);
		this.setDataNascimento(dataNascimento);
	}

	public String getCpf() {
		return cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}
	
	public ArrayList<Veiculo> getListaveiculos () {
		return listaVeiculos;
	}
	
	public void setListaveiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public boolean cadastrarVeiculo () {
		Veiculo veiculo; 
		veiculo = Instaciar.instanciarVeiculo();
		return this.listaVeiculos.add(veiculo);
	}
	
	public boolean removerVeiculo () {
		int i;
		System.out.print("\nEscolha o veiculo a ser removido\n");
		for (i = 0; i < this.listaVeiculos.size(); i++) {
			System.out.println((i + 1) + "- " + this.listaVeiculos.get(i).getPlaca() + "\n");
		}
		int index = input.nextInt();
		Veiculo veiculo = this.listaVeiculos.get(index - 1);
		return this.listaVeiculos.remove(veiculo);
	}
	
	public String toString () {
		String s1;
		super.toString();
		return  s1 = String.format("Gênero: %s\n"
				+ "Cpf: %s\n"
				+ "Data de nascimento: %s\n"
				+ "Educação: %s\n"
				+ "Data da licensa: %s\n"
				+ "Classe Econômica: %s\n",this.getGenero(), this.getCpf(), this.getDataNascimento(), this.getEducacao());
	}
	
	public int calcularIdade ()  {
		SimpleDateFormat data_format = new SimpleDateFormat("dd/MM/yyyy");
		String data_formatada = data_format.format(this.dataNascimento);
		String[] separar = data_formatada.split("/");
		String srtAno = separar[2];
		int ano = Integer.parseInt(srtAno);
		int idade = 2023 - ano;
		return idade;
	}
}
