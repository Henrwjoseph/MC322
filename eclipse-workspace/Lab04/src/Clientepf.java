import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

public class Clientepf extends Cliente {
	private final String cpf;
	private String genero;
	private LocalDate dataLicensa;
	private String educacao;
	private LocalDate dataNascimento;
	private String classeEconomica;
	
	public Clientepf (String nome, String endereco, String cpf, String genero, LocalDate dataLicensa, String educacao, LocalDate dataNascimento, String classeEconomica) {
		super(nome, endereco);
		this.cpf = cpf;
		this.setGenero(genero);
		this.setDataLicensa(dataLicensa);
		this.setEducacao(educacao);
		this.setDataNascimento(dataNascimento);
		this.setClasseEconomica(classeEconomica);
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataLicensa() {
		return dataLicensa;
	}

	public void setDataLicensa(LocalDate dataLicensa) {
		this.dataLicensa = dataLicensa;
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

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
	
	public String toString () {
		String s1;
		super.toString();
		return  s1 = String.format("Gênero: %s\n"
				+ "Cpf: %s\n"
				+ "Data de nascimento: %s\n"
				+ "Educação: %s\n"
				+ "Data da licensa: %s\n"
				+ "Classe Econômica: %s\n",this.getGenero(), this.getCpf(), this.getDataNascimento(), this.getEducacao(), this.getDataLicensa(), this.getClasseEconomica());
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
	
	public double calcularScore ()  {
		int idade = this.calcularIdade();
		double valor_seguro = 0;
		double quantidadeCarros = super.calcularScore();
		if (idade >= 18 && idade < 30)
			valor_seguro = CalcSeguro.VALOR_BASE.getValor()*CalcSeguro.FATOR_18_30.getValor()*quantidadeCarros;
		if (idade >= 30 && idade < 60)
			valor_seguro = CalcSeguro.VALOR_BASE.getValor()*CalcSeguro.FATOR_30_60.getValor()*quantidadeCarros;
		if (idade >= 60 && idade < 90)
			valor_seguro = CalcSeguro.VALOR_BASE.getValor()*CalcSeguro.FATOR_60_90.getValor()*quantidadeCarros;
		return valor_seguro;
	}
}
