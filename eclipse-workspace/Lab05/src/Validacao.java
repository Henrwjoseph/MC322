
public class Validacao {
	public static boolean validarCPF(String cpf) {
		int i, aux1, vaux1 = 0, v1 = 0, acumulador1 = 0, aux2, vaux2 = 0, v2 = 0, acumulador2 = 0;
		String replaceCpf;	
		replaceCpf = cpf.replaceAll("\\.","");
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
				
		for (i = 0; i < replaceCpf.length() - 2; i++) {
			aux1 = (replaceCpf.charAt(i) - 48)*(10 - i);
			acumulador1 += aux1;
		}
		vaux1 = acumulador1%11;
		if (vaux1 == 0 || vaux1 == 1) {
			v1 = 0;
		}
		else {
			v1 = 11 - (acumulador1 % 11);
		}
		
		if (v1 != (replaceCpf.charAt(replaceCpf.length() - 2)) - 48) {
			return false;
		}
		
		for (i = 0; i < replaceCpf.length() - 2; i++) {
			aux2 = (replaceCpf.charAt(i + 1) - 48)*(10 - i);
			acumulador2 += aux2;
		}
		vaux2 = acumulador2%11;
		if (vaux2 == 0 || vaux2 == 1) {
			v2 = 0;
		}
		else {
			v2 = 11 - (acumulador2 % 11);
		}
		
		if (v2 != (replaceCpf.charAt(replaceCpf.length() - 1)) - 48) {
			return false; 
		}
		
		else {
			return true;
		}
	}
	
	public static boolean validarCnpj(String cnpj) {
		int i, aux1, aux2, vaux1 = 0, vaux2 = 0, v1 = 0, v2 = 0, somatorio1 = 0, somatorio2 = 0;		
		String replaceCnpj;
		replaceCnpj = cnpj.replaceAll("\\.","");
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
			
		for (i = 0; i < replaceCnpj.length() - 2; i++) {
			if (i <= 3) {
				aux1 = (replaceCnpj.charAt(i) - 48)*(5 - i);
				somatorio1 += aux1;
			}
			if (i > 3) {
				aux1 = (replaceCnpj.charAt(i) - 48)*(13 - i);
				somatorio1 += aux1;
			}
			vaux1 = somatorio1 % 11;
			if (vaux1 < 2) {
				v1 = 0;
			}
		}
			
		if (v1 != (replaceCnpj.charAt(replaceCnpj.length() - 2)) - 48) {
			return false;
		}
		
		for (i = 0; i < replaceCnpj.length() - 1; i++) {
			if (i <= 4) {
				aux2 = (replaceCnpj.charAt(i) - 48)*(6 - i);
				somatorio2 += aux2;
			}
			if (i > 4) {
				aux2 = (replaceCnpj.charAt(i) - 48)*(14 - i);
				somatorio2 += aux2;
			}
		}
		vaux2 = somatorio2 % 11;
		if (vaux2 < 2) {
			v2 = 0;
		}
		v2 = 11 - vaux2;
			
		if (v2 != (replaceCnpj.charAt(replaceCnpj.length() - 1)) - 48) {			
			return false; 
		}
			
		else {
			return true;
		}
	}
	
	public static boolean validarNome (String nome) {
		if(!nome.matches("^[a-zA-Z]*$")) {
			return false;
		}
		
		if (nome.equals(null)) {
			return false;
		}
		
		return true;
	}
}
