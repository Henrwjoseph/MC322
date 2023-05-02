import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Lab03 {
	public static void main (String[] args) throws ParseException{
		Clientepf clientepf;
		Clientepj clientepj1;
		Clientepj clientepj2;
		Veiculo veiculo1;
		Veiculo veiculo2;
		Seguradora seguradora;
		Sinistro sinistropf;
		Sinistro sinistropj;
		Scanner input = new Scanner(System.in);
		
		//criando seguradora
		seguradora = new Seguradora("PortoSeguro","11999810117", "portoseguro@gmail.com", "Rua Santo Antonio, 191");
		
		//criando cliente PF
		System.out.print("*************Cadastre-se**************\n");
		System.out.print("Nome: \n");
		String nomepf = input.nextLine();
		System.out.print("Endereço: \n");
		String endereco = input.nextLine();
		System.out.print("CPF: \n");
		String cpf = input.nextLine();
		System.out.print("Gênero: \n");
		String genero = input.nextLine();
		System.out.print("Data da licensa: \n");
		String dataLincesaf = input.nextLine();
		System.out.print("Educação: \n");
		String educacao = input.nextLine();
		System.out.print("Data de nascimento: \n");
		String dataNascimentof = input.nextLine();
		System.out.print("Classe econômica: \n");
		String classeEconomica = input.nextLine();
		
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dataLicensa = dataFormatada.parse(dataLincesaf);
		Date dataNascimento = dataFormatada.parse(dataNascimentof);
		
		clientepf = new Clientepf (nomepf, endereco, cpf, genero, dataLicensa, educacao, dataNascimento, classeEconomica);
		
		if (!clientepf.validarCPF()) {
			System.out.println("CPF é invalido\n");
		}
	
		if (seguradora.cadastrarCliente(clientepf)) {
			System.out.print("Cliente cadastrado\n");
		}
		
		else {
			System.out.print("\nCliente não cadastrado\n");
		}
		
		//criando cliente PJ
		clientepj1 = new Clientepj ("Empresa", "Rua Rio Purus", "49708505000102", dataFormatada.parse("28/07/2004"));
		
		if (!clientepj1.validarCnpj()) {
			System.out.println("\nCNPJ é inválido\n");
		}
		
		if (seguradora.cadastrarCliente(clientepj1)) {
			System.out.print("Cliente cadastrado\n");
		}
		
		else {
			System.out.print("Cliente não cadastrado\n");
		}
		
		//criando cliente PJ
		clientepj2 = new Clientepj ("Locadora", "Rua da muriçoca", "12345678000100", dataFormatada.parse("10/05/2013"));
		
		if (!clientepj2.validarCnpj()) {
			System.out.println("\nCNPJ é inválido\n");
		}
		
		if (seguradora.cadastrarCliente(clientepj2)) {
			System.out.print("Cliente cadastrado\n");
		}
		
		else {
			System.out.print("Cliente não cadastrado\n");
		}
		
		//remover cliente
		if (seguradora.removerCliente(clientepj2.getNome())) {
			System.out.print("\nCliente removido\n");
		}
		
		else {
			System.out.print("\nCliente não encontrado para remoção\n");
		}
		
		//alocando veiculo
		veiculo1 = new Veiculo ("OXE4A45", "Mitsubishi", "Lancer", 2004);
		veiculo2 = new Veiculo ("QUE7U19", "Nissan", "GTR", 2010);
		
		//Adicionando veículo
		clientepf.addVeiculo(veiculo1);
		clientepj1.addVeiculo(veiculo2);
		
		//gerando sinistro
		sinistropf = new Sinistro ("15/03/2021", "Av. Paralela", clientepf.getCpf(), seguradora, veiculo1, clientepf);
		sinistropj = new Sinistro ("04/05/2022", "Av. Sete", clientepj1.getCnpj(), seguradora, veiculo2, clientepj1);
		seguradora.gerarSinistro(sinistropf);
		seguradora.gerarSinistro(sinistropj);
		
		//visualizar sinistro
		if (!seguradora.visualisarSinistro(sinistropf.getCliente().getNome())) {
			System.out.print("\nNão há sinistros no nome do cliente\n");
		}
		
		if (!seguradora.visualisarSinistro(sinistropj.getCliente().getNome())) {
			System.out.print("\nNão há sinistros no nome do cliente\n");
		}
		
		//listar sinistro
		
		seguradora.listaSinistro();
		
		//chamando todos os metedos toString
		System.out.print("\nDados Seguradora:\n");
		System.out.print(seguradora.toString() + "\n");
		System.out.print("Dados Cliente PF:\n");
		System.out.print(clientepf.toString() + "\n\n");
		System.out.print("Dados Cliente PJ:\n");
		System.out.print(clientepj1.toString() + "\n\n");
		System.out.print("Dados Veiculos:\n");
		System.out.print(veiculo1.toString() + "\n\n" + veiculo2.toString() + "\n\n");
		System.out.print("Dados Sinistros: \n");
		System.out.print(sinistropf.toString() + "\n\n" + sinistropj.toString() + "\n");
		
		input.close();
	}
}
