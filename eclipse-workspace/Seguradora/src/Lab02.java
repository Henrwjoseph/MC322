import java.util.Scanner;

public class Lab02 {
	public static void main (String[] args) {
		Cliente cliente;
		Veiculo veiculo;
		Seguradora seguradora;
		Sinistro sinistro;
		Scanner input = new Scanner(System.in);
		String qualclasse = input.nextLine();

		if ("cliente".equals(qualclasse)) {		
			String nome = input.nextLine();
			String cpf = input.nextLine();
			String dataNascimento = input.nextLine();
			String endereco = input.nextLine(); 
			int idade = input.nextInt();
			cliente = new Cliente (nome, cpf, dataNascimento, idade, endereco);
			if (!cliente.validarCPF()) {
				System.out.println("CPF é invalido");
			}
			else {
				System.out.print(cliente.toString());
			}
		}
		
		if ("veiculo".equals(qualclasse)) {
			String placa = input.nextLine();
			String marca = input.nextLine();
			String modelo = input.nextLine();
			veiculo = new Veiculo(placa, marca, modelo);
			System.out.printf("Placa: %s", placa,"\nMarca: %s", marca, "\nModelo: %s", modelo);
		}
		
		if ("seguradora".equals(qualclasse)) {
			String nome = input.nextLine();
			String telefone = input.nextLine();
			String email = input.nextLine();
			String endereco = input.nextLine();
			seguradora = new Seguradora(nome, telefone, email, endereco);
			System.out.printf("Nome: %s", nome, "\nTelefone: %s", telefone, "\nEmail: %s", email, "\nEndereço: %s", endereco);
		}
		
		if ("sinistro".equals(qualclasse)) {
			String data = input.nextLine();
			String endereco = input.nextLine();
			sinistro = new Sinistro (data, endereco);
			System.out.printf("Data: %s", data, "\nEndereço: %s", endereco);
		}
		
		input.close();
	}
}
