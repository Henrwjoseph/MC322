import java.util.Date;
import java.text.ParseException;
import java.time.LocalDate;

public class Clientepj extends Cliente {
	private final String cnpj;
	private LocalDate dataFundacao;
	private int qntFuncionarios;
	
	public Clientepj (String nome, String endereco, String cnpj, LocalDate dataFundacao, int qntFuncionarios) {
		super(nome, endereco);
		this.cnpj = cnpj;
		this.setDataFundacao(dataFundacao);
		this.qntFuncionarios = qntFuncionarios;
	}

	public String getCnpj() {
		return cnpj;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	public String toString () {
		String s1;
		super.toString();
		return s1 = String.format("CNPJ: %s\n"
				+ "Data de fundação: %s", this.getCnpj(), this.getDataFundacao());
	}
	
	public double calcularScore () {
		double valor_seguro, quantidadeCarros = super.calcularScore();
		valor_seguro = CalcSeguro.VALOR_BASE.getValor()*(1 + this.qntFuncionarios/100)*quantidadeCarros;
		return valor_seguro;
	}
}
