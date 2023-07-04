import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Instaciar {
	private final static Scanner input = new Scanner(System.in);
	public static Condutor instanciarCondutor () {
		Condutor condutor = null;
		System.out.print("\n**********CADASTAR CONDUTOR**********\n");
		System.out.print("Nome: \n");
		String nome = input.nextLine();
		System.out.print("CPF: \n");
		String cpf = input.nextLine();
		System.out.print("Telefone: \n");
		String telefone = input.nextLine();
		System.out.print("Endereço: \n");
		String endereco = input.nextLine();
		System.out.print("Email: \n");
		String email = input.nextLine();
		System.out.print("Data de nascimento: \n");
		String datanascimentof = input.nextLine();
		
		DateTimeFormatter dataformatada =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate datanascimento = LocalDate.parse(datanascimentof, dataformatada);
		
		return condutor = new Condutor (cpf, nome, telefone, endereco, email, datanascimento);
		
	}
	
	public static Veiculo instanciarVeiculo() {
		Veiculo veiculo = null;
		System.out.print("\n**********CADASTRAR VEICULO**********\n");
		System.out.print("Placa: \n");
		String placa = input.nextLine();
		System.out.print("Marca: \n");
		String marca = input.nextLine();
		System.out.print("Modelo: \n");
		String modelo = input.nextLine();
		System.out.print("Ano de fabricação: \n");
		int anoFabricacao = input.nextInt();
	
		return veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
	}
	
	public static Frota instanciarFrota() {
		Frota frota;
		System.out.print("\n**********CADASTRAR FROTA**********\n");
		System.out.print("Escreva um código para a frota: \n");
		String code = input.nextLine();
		
		return frota =  new Frota (code); 
	}
}
