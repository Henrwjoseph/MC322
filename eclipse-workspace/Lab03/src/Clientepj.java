import java.util.Date;

public class Clientepj extends Cliente {
	private final String cnpj;
	private Date dataFundacao;
	
	public Clientepj (String nome, String endereco, String cnpj, Date dataFundacao) {
		super(nome, endereco);
		this.cnpj = cnpj;
		this.setDataFundacao(dataFundacao);
	}

	public String getCnpj() {
		return cnpj;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	//calculo do primeiro digito verificador
	public int calcularVum (String replaceCnpj) {
		int i, aux, vaux = 0, v1 = 0, somatorio = 0;
		for (i = 0; i < replaceCnpj.length() - 2; i++) {
			if (i <= 3) {
				aux = (replaceCnpj.charAt(i) - 48)*(5 - i);
				somatorio += aux;
			}
			if (i > 3) {
				aux = (replaceCnpj.charAt(i) - 48)*(13 - i);
				somatorio += aux;
			}
		}
		vaux = somatorio % 11;
		if (vaux < 2) {
			return v1 = 0;
		}
		return v1 = 11 - vaux;
	}

	//calculo do segundo digito verificador
	public int calcularVdois(String replaceCnpj) {
		int i, aux, vaux = 0, v1 = 0, somatorio = 0;
		for (i = 0; i < replaceCnpj.length() - 1; i++) {
			if (i <= 4) {
				aux = (replaceCnpj.charAt(i) - 48)*(6 - i);
				somatorio += aux;
			}
			if (i > 4) {
				aux = (replaceCnpj.charAt(i) - 48)*(14 - i);
				somatorio += aux;
			}
		}
		vaux = somatorio % 11;
		if (vaux < 2) {
			return v1 = 0;
		}
		return v1 = 11 - vaux;
	}
	
	public boolean validarCnpj () {
		String replaceCnpj;
		int i, v1, v2;
		replaceCnpj = this.cnpj.replaceAll("\\.","");
		replaceCnpj = replaceCnpj.replaceAll("-","");
		replaceCnpj = replaceCnpj.replaceAll("/","");
		
		if (replaceCnpj.length() != 14) {
			return false;
		}
		
		for (i = 0; i < replaceCnpj.length(); i++) {
			if (i == replaceCnpj.length() - 1) {
				return false;
			}

			if (replaceCnpj.charAt(i) != replaceCnpj.charAt(i + 1)) {
				break;
			}
		}
				
		v1 = calcularVum (replaceCnpj);
		if (v1 != (replaceCnpj.charAt(replaceCnpj.length() - 2)) - 48) {
			return false;
		}
		
		v2 = calcularVdois (replaceCnpj);
		if (v2 != (replaceCnpj.charAt(replaceCnpj.length() - 1)) - 48) {			
			return false; 
		}
		
		else {
			System.out.print("\nCPNJ válido");
			return true;
		}
	}
	
	public String toString () {
		String s1;
		super.toString();
		return s1 = String.format("CNPJ: %s\n"
				+ "Data de fundação: %s", this.getCnpj(), this.getDataFundacao());
	}
}
