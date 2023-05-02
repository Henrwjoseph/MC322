import java.util.ArrayList;
import java.util.Date;

public class Clientepf extends Cliente {
	private final String cpf;
	private String genero;
	private Date dataLicensa;
	private String educacao;
	private Date dataNascimento;
	private String classeEconomica;
	
	public Clientepf (String nome, String endereco, String cpf, String genero, Date dataLicensa, String educacao, Date dataNascimento, String classeEconomica) {
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

	public Date getDataLicensa() {
		return dataLicensa;
	}

	public void setDataLicensa(Date dataLicensa) {
		this.dataLicensa = dataLicensa;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
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
	
	//calculo do primeiro digito varificador
	public int calcularVum (String replaceCpf) {
		int i, aux, vaux = 0, v1 = 0, acumulador = 0;
		for (i = 0; i < replaceCpf.length() - 2; i++) {
			aux = (replaceCpf.charAt(i) - 48)*(10 - i);
			acumulador += aux;
		}
		vaux = acumulador%11;
		if (vaux == 0 || vaux == 1) {
			v1 = 0;
		}
		else {
			v1 = 11 - (acumulador % 11);
		}
		return v1;
	}
	
	//calculo do segundo digito varificador
	public int calcularVdois (String replaceCpf) {
		int i, aux,vaux = 0, v2 = 0, acumulador = 0;
		for (i = 0; i < replaceCpf.length() - 2; i++) {
			aux = (replaceCpf.charAt(i + 1) - 48)*(10 - i);
			acumulador += aux;
		}
		vaux = acumulador%11;
		if (vaux == 0 || vaux == 1) {
			v2 = 0;
		}
		else {
			v2 = 11 - (acumulador % 11);
		}
		return v2;
	}
		
	public boolean validarCPF() {
		int i, v2 = 0, v1 = 0;
		String replaceCpf;	
		replaceCpf = this.cpf.replaceAll("\\.","");
		replaceCpf = replaceCpf.replaceAll("-","");
		
		if (replaceCpf.length() != 11) {
			return false;
		}
		
		for (i = 0; i < replaceCpf.length(); i++) {
			if (i == replaceCpf.length() - 1) {
				return false;
			}

			if (replaceCpf.charAt(i) != replaceCpf.charAt(i + 1)) {
				break;
			}
		}
				
		v1 = calcularVum (replaceCpf);
		if (v1 != (replaceCpf.charAt(replaceCpf.length() - 2)) - 48) {
			return false;
		}
		
		v2 = calcularVdois (replaceCpf);
		if (v2 != (replaceCpf.charAt(replaceCpf.length() - 1)) - 48) {
			return false; 
		}
		
		else {
			System.out.println("CPF válido");
			return true;
		}
		
	}
	
	public String toString () {
		String s1;
		super.toString();
		return  s1 = String.format("Gênero: %s\n"
				+ "Cpf: %s\n"
				+ "Data de nascimento: %s\n"
				+ "Educação: %s\n"
				+ "Data da licensa: %s\n"
				+ "Classe Econômica: %s",this.getGenero(), this.getCpf(), this.getDataNascimento(), this.getEducacao(), this.getDataLicensa(), this.getClasseEconomica());
	}
}
