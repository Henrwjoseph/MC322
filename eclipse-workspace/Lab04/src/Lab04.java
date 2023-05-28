import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Lab04 {
		private static ArrayList<Seguradora> listaseguradoras = new ArrayList<Seguradora>();
		private final static Scanner input = new Scanner(System.in);
		
		public static void escolherTipoCliente ()  {
			System.out.print("Qual o tipo de cliente?\n");
			System.out.print("Escreva PF ou PJ\n");
			String resposta = input.nextLine();
			if (resposta.equals("PF")) {
				cadastrarClientepf();
			}
			
			else if (resposta.equals("PJ")) {
				cadastrarClientepj();
			}
		
		}
		
		//criando cliente PF
		public static Clientepf criarClientepf ()  {
			System.out.print("**************Cadastrar PF**************\n");
			System.out.print("Nome: \n");
			String nomepf = input.nextLine();
			System.out.print("Endereço: \n");
			String endereco = input.nextLine();
			System.out.print("CPF: \n");
			String cpf = input.nextLine();
			while (!Validacao.validarCPF(cpf)) {
				System.out.println("CPF é invalido\n");
				System.out.print("Insira um CPF válido\n");
				cpf = input.nextLine();
			}
			System.out.print("CPF válido\n");
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
		
			DateTimeFormatter dataFormatada =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
			LocalDate dataLicensa = LocalDate.parse(dataLincesaf, dataFormatada);
			LocalDate dataNascimento = LocalDate.parse(dataNascimentof, dataFormatada);
			
			Clientepf clientepf; 
			
			return clientepf = new Clientepf (nomepf, endereco, cpf, genero, dataLicensa, educacao, dataNascimento, classeEconomica);
			
		}
			
		public static void cadastrarClientepf () {
			int i;
			Clientepf clientepf = criarClientepf();
			if(listaseguradoras.size() == 0) {
				System.out.print("Não há seguradoras cadastradas, deseja cadastrar uma?\n");
				System.out.print("Sim ou Não: \n");
				String resposta = input.nextLine();
				if (resposta == "Sim") {
					criarSeguradora();
				}
				
				else if (resposta == "Não") {
					return;
				}
			}
			
			System.out.print("Escolha o número da seguradora em que você deseja cadastrar\n");
			
			for (i = 0; i < listaseguradoras.size(); i++) {
				System.out.printf(i+". " + listaseguradoras.get(i).getNome()+"\n");
			}
			
			String resposta = input.nextLine();
			int index =  Integer. parseInt(resposta);
		
			if (listaseguradoras.get(index).cadastrarCliente(clientepf)) {
				System.out.print("Cliente cadastrado\n");
			}
			
			else {
				System.out.print("\nCliente já cadastrado\n");
			}
			System.out.println("Preço do seguro: \n" + listaseguradoras.get(index).cacluclarPrecoSeguro(clientepf));
		
		}
		
		public static Clientepj criarClientepj () {
			System.out.print("**************Cadastrar PJ**************\n");
			System.out.print("Nome: \n");
			String nomepj = input.nextLine();
			System.out.print("Endereço: \n");
			String endereco = input.nextLine();
			System.out.print("CNPJ: /n");
			String cnpj = input.nextLine();
			while (!Validacao.validarCnpj(cnpj)) {
				System.out.println("CNPJ é invalido\n");
				System.out.print("Insira um CNPJ válido\n");
				cnpj = input.nextLine();
			}
			System.out.print("CNPJ válido\n");
			System.out.print("Data de fundação: \n");
			String dataFundacaof = input.nextLine();
			System.out.print("Quantidade de funcionarios: \n");
			int qntFuncionarios = input.nextInt();
			
			DateTimeFormatter dataFormatada =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			LocalDate dataFundacao = LocalDate.parse(dataFundacaof, dataFormatada);

			
			Clientepj clientepj = new Clientepj (nomepj, endereco, cnpj, dataFundacao, qntFuncionarios);
			return clientepj;
		}
		
		public static void cadastrarClientepj ()  {
			int i;
			Clientepj clientepj = criarClientepj();
			if(listaseguradoras.size() == 0) {
				System.out.print("Não há seguradoras cadastradas, deseja cadastrar uma?\n");
				System.out.print("Sim ou Não: \n");
				String resposta = input.nextLine();
				if (resposta == "Sim") {
					criarSeguradora();
				}
				
				else if (resposta == "Não") {
					return;
				}
			}
			
			System.out.print("Escolha o número da seguradora em que você deseja cadastrar\n");
			
			for (i = 0; i < listaseguradoras.size(); i++) {
				System.out.printf(i+". " + listaseguradoras.get(i).getNome()+"\n");
			}
			
			String resposta = input.nextLine();
			int index =  Integer. parseInt(resposta);
			
			if (listaseguradoras.get(index).cadastrarCliente(clientepj)) {
				System.out.print("Cliente cadastrado\n");
			}
			
			else {
				System.out.print("Cliente já cadastrado\n");
			}
			System.out.println("Preço do seguro: \n" + listaseguradoras.get(index).cacluclarPrecoSeguro(clientepj));
		}
		
		public static Sinistro gerarSinistro ()  {
			int i;
			Sinistro sinistro = null;
			
			System.out.print("**************Gerar sinistro**************\n");
			
			System.out.print("Data: \n");
			String dataf = input.nextLine();
			
			System.out.print("Endereço: \n");
			String endereco = input.nextLine();
			
			for (i = 0; i < listaseguradoras.size(); i++) {
				System.out.printf(i+". " + listaseguradoras.get(i).getNome()+"\n");
			}
			System.out.print("Escolha a seguradora: \n");
			String resposta = input.nextLine();
			int index =  Integer. parseInt(resposta);
			
			System.out.print("Escolha o tipo do cliente, escreva PF ou PJ: \n");
			String tipo = input.nextLine(); // será usado para conseguir o cpf ou cnpj do cliente posteriormente
			listaseguradoras.get(index).listarCliente(tipo);
			System.out.print("\nEscreva um dos cpf ou cnpj listados: \n");
			resposta = input.nextLine();
			Cliente cliente = listaseguradoras.get(index).getCliente(resposta);
			
			cliente.listarVeiculos();
			System.out.print("Escreva a placa do veiculo: \n");
			resposta = input.nextLine();
			Veiculo veiculo = cliente.getVeiculo(resposta);
			
			DateTimeFormatter dataformatada =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			LocalDate data = LocalDate.parse(dataf, dataformatada);
			
			if (tipo.equals("PF")) {
				String cpf = ((Clientepf) cliente).getCpf();
				Seguradora seguradora = listaseguradoras.get(index);
				sinistro = new Sinistro(data, endereco, cpf, seguradora, veiculo, cliente);
			}
			
			if (tipo.equals("PJ")) {
				String cnpj = ((Clientepj) cliente).getCnpj();
				Seguradora seguradora = listaseguradoras.get(index);
				sinistro = new Sinistro(data, endereco, cnpj, seguradora, veiculo, cliente);
			}
			
			return sinistro;
		}
		
		public static Veiculo criarVeiculo () {
			System.out.print("**************Cadastrar veiculo**************/n");
			System.out.print("Placa: /n");
			String placa = input.nextLine();
			System.out.print("Marca: /n");
			String marca = input.nextLine();
			System.out.print("Modelo: /n");
			String modelo = input.nextLine();
			System.out.print("Ano de fabricação: /n");
			int anoFabricacao = input.nextInt();
			Veiculo veiculo = new Veiculo (placa, marca, modelo, anoFabricacao);
			return veiculo;
		
		}
		
		public static Seguradora criarSeguradora () {
			System.out.print("**************Cadastrar Seguradora**************\n");
			System.out.print("Nome: \n");
			String nome = input.nextLine();
			System.out.print("Telefone: \n");
			String telefone = input.nextLine();
			System.out.print("E-mail: \n");
			String email = input.nextLine();
			System.out.print("Endereço: ");
			String endereco = input.nextLine();
			Seguradora seguradora;
			return seguradora = new Seguradora(nome, telefone, email, endereco);
		}
		
		public static void cadastrarSeguradora (Seguradora seguradora) {
			listaseguradoras.add(seguradora);
		}
		
		public static void excluirCliente () {
			int i;
			for (i = 0; i < listaseguradoras.size(); i++) {
				System.out.printf(i+". " + listaseguradoras.get(i).getNome()+"\n");
			}
			System.out.print("Escolha a seguradora: \n");
			String resposta = input.nextLine();
			int index =  Integer. parseInt(resposta);
			
			System.out.print("Escolha o tipo do cliente a ser excluido, escreva PF ou PJ: \n");
			resposta = input.nextLine();
			listaseguradoras.get(index).listarCliente(resposta);
			System.out.print("Escreva o cpf ou cnpj do cliente que você deseja excluir dessa lista: \n");
			resposta = input.nextLine();
			if(listaseguradoras.get(index).removerCliente(resposta)) {
				System.out.print("Cliente removido");
			}
		}
		
		public static void excluirVeiculo () {
			int i;
			for (i = 0; i < listaseguradoras.size(); i++) {
				System.out.printf(i+". " + listaseguradoras.get(i).getNome()+"\n");
			}
			System.out.print("Escolha a seguradora: \n");
			String resposta = input.nextLine();
			int index =  Integer. parseInt(resposta);
			
			System.out.print("Escolha o tipo do cliente a ser excluido, escreva PF ou PJ: \n");
			resposta = input.nextLine();
			listaseguradoras.get(index).listarCliente(resposta);
			
			System.out.print("Escreva o cpf ou cnpj do cliente dessa lista: \n");
			
			resposta = input.nextLine();
	
			Cliente cliente = listaseguradoras.get(index).getCliente(resposta);
	
			cliente.listarVeiculos();;
			System.out.print("Escreva a placa do veiculo a ser removido: \n");
			resposta = input.nextLine();
			if (cliente.removerVeiculo(resposta)) {
				System.out.print("Veiculo removido");
			}
			else {
				System.out.print("Veiculo não encontrado para remoção");
			}
		}
		
		public static void excluirSinistro () {
			int i;
			for (i = 0; i < listaseguradoras.size(); i++) {
				System.out.printf(i+". " + listaseguradoras.get(i).getNome()+"\n");
			}
			System.out.print("Escolha a seguradora: \n");
			String resposta = input.nextLine();
			int index = Integer. parseInt(resposta);
			
			listaseguradoras.get(index).listarSinistro();
			
			System.out.print("Escreva o id do sinistro a ser removido: \n");
			int resposta2 = input.nextInt();
			if (listaseguradoras.get(index).removerSinistro(resposta2)){
				System.out.print("Sinistro removido\n");
			}
			
		}	

		public static void listarClientes () {
			int i;
			System.out.print("Escolha a seguradora: \n");
			for (i = 0; i < listaseguradoras.size(); i++) {
				System.out.printf(i+". " + listaseguradoras.get(i).getNome()+"\n");
			}
			String resposta = input.nextLine();
			int index =  Integer. parseInt(resposta);
			
			System.out.print("Tipo do cliente, escreva PF ou PJ: \n");
			resposta = input.nextLine();

			listaseguradoras.get(index).listarCliente(resposta);
		}

		public static void listarSinistro () {
			int i;
			System.out.print("Escolha a seguradora: \n");
			for (i = 0; i < listaseguradoras.size(); i++) {
				System.out.printf(i+". " + listaseguradoras.get(i).getNome()+"\n");
			}
			String resposta = input.nextLine();
			int index =  Integer. parseInt(resposta);
			
			listaseguradoras.get(index).listarSinistro();
		}
		
		public static void listarVeiculosSeguradora () {
			int i;
			System.out.print("Escolha a seguradora: \n");
			for (i = 0; i < listaseguradoras.size(); i++) {
				System.out.printf(i+". " + listaseguradoras.get(i).getNome()+"\n");
			}
			String resposta = input.nextLine();
			int index =  Integer. parseInt(resposta);
			
			System.out.print("Veiculos cadastrados na seguradora: \n");
			listaseguradoras.get(index).listarveiculos();
		}

		public static void calcularReceita() {
			int i;
			System.out.print("Escolha a seguradora: \n");
			for (i = 0; i < listaseguradoras.size(); i++) {
				System.out.printf(i+". " + listaseguradoras.get(i).getNome()+"\n");
			}
			String resposta = input.nextLine();
			int index =  Integer. parseInt(resposta);

			System.out.println("Receita da seguradora: \n" + listaseguradoras.get(index).calcularReceita());
		}
		
		public static void main(String[] args)   {
			Clientepf clientepf;
			Clientepj clientepj1;
			Clientepj clientepj2;
			Veiculo veiculo1;
			Veiculo veiculo2;
			Seguradora seguradora;
			Sinistro sinistropf;
			Sinistro sinistropj;
			
			
			DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			//criando seguradora
			seguradora = new Seguradora("PortoSeguro","11999810117", "portoseguro@gmail.com", "Rua Santo Antonio, 191");
			
			//cadastrando cliente PF
			clientepf = new Clientepf ("Henrique", "Rua Da Muriçoca","09464715502", "Masculino", LocalDate.parse("25/08/2017", dataFormatada), "Ensino Medio Completo", LocalDate.parse("04/09/2004", dataFormatada), "Classe media");
			
			//criando cliente PJ
			clientepj1 = new Clientepj ("Empresa", "Rua Rio Purus", "49708505000102",  LocalDate.parse("28/07/2004", dataFormatada), 100);
			
			//criando cliente PJ
			clientepj2 = new Clientepj ("Locadora", "Rua da muriçoca", "12345678000100",  LocalDate.parse("10/05/2010", dataFormatada), 10);
			
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
			sinistropf = new Sinistro ( LocalDate.parse("30/05/2013", dataFormatada), "Av. Paralela", clientepf.getCpf(), seguradora, veiculo1, clientepf);
			sinistropj = new Sinistro ( LocalDate.parse("15/06/2018", dataFormatada), "Av. Sete", clientepj1.getCnpj(), seguradora, veiculo2, clientepj1);
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
			
			seguradora.listarSinistro();
			
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
			
			//exibir menu externo
			private static void exibirMenuExterno() {
				MenuOperacoes menuOpcoes[] = MenuOperacoes.values();
				System.out.println("Menu principal");
				for(MenuOperacoes op: menuOpcoes) {
					System.out.println(op.ordinal() + " - " + op.getDescricao());
				}
			}
			
			/* exibir submenus
			 * se a lista de constantes do submenu for percorrida da mesma forma que o meu externo, a opção Voltar
			 * é printada com a posição que está na lista do enum (9 - Voltar). Por isso, a lista é percorrida 
			 * de forma diferente, tendo i como o inteiro correspondente. Assim, para listar o submenu de cadastros,
			 * por exemplo, vai ser printado "3 - Voltar".
			 */
			private static void exibirSubmenu(MenuOperacoes op) {
				SubmenuOperacoes[] submenu = op.getSubmenu();
				System.out.println(op.getDescricao());
				for(int i=0; i<submenu.length; i++) {
					System.out.println(i +" - " + submenu[i].getDescricao());
				}
			}
			
			//ler opções do menu externo
			private static MenuOperacoes lerOpcaoMenuExterno() {
				Scanner scanner = new Scanner(System.in);
				int opUsuario;
				MenuOperacoes opUsuarioConst;
				do {
					System.out.println("Digite uma opcao: ");
					opUsuario = scanner.nextInt();
				}while(opUsuario < 0 || opUsuario > MenuOperacoes.values().length - 1);
				opUsuarioConst = MenuOperacoes.values()[opUsuario];
				return opUsuarioConst;
			}
			
			//ler opção dos submenus
			private static SubmenuOperacoes lerOpcaoSubmenu(MenuOperacoes op) {
				Scanner scanner = new Scanner(System.in);
				int opUsuario;
				SubmenuOperacoes opUsuarioConst;
				do {
					System.out.println("Digite uma opcao: ");
					opUsuario = scanner.nextInt();
				}while(opUsuario < 0 || opUsuario > op.getSubmenu().length - 1);
				opUsuarioConst = op.getSubmenu()[opUsuario];
				return opUsuarioConst;
			}
			
			//executar opções do menu externo
			private static void executarOpcaoMenuExterno(MenuOperacoes op)  {
				switch(op) {
					case CADASTROS:
					case LISTAR:
					case EXCLUIR:
						executarSubmenu(op);
						break;
					case GERAR_SINISTRO:
						gerarSinistro();
						break;

					case TRANSFERIR_SEGURO:
						break;
					case CALCULAR_RECEITA:
						calcularReceita();
						break;
					//case SAIR:
				}
			}
			
			public static void executarOpcaoSubMenu(SubmenuOperacoes opSubmenu) {
				switch(opSubmenu) {
				case CADASTRAR_CLIENTE:
					escolherTipoCliente ();
					break;
					
				case CADASTRAR_VEICULO:
					criarVeiculo();
					break;
					
				case CADASTRAR_SEGURADORA:
					criarSeguradora();
					break;
					
				case LISTAR_CLIENTES:
					listarClientes();
					break;
					
				case LISTAR_SINISTROS:
					listarSinistro();
					break;

				case LISTAR_VEICULOS:					
					listarVeiculosSeguradora();
					break;
				
				case EXCLUIR_CLIENTE:
					excluirCliente();
					break;
				
				case EXCLUIR_VEICULO:
					excluirVeiculo();
					break;
				
				case EXCLUIR_SINISTRO:
					excluirSinistro();
					break;
				//case VOLTAR:
				//	break;
				}
			}
			
			//executa os submenus: exibição do menu, leitura da opção e execução dos métodos
			private static void executarSubmenu(MenuOperacoes op) {
				SubmenuOperacoes opSubmenu;
				do {
					exibirSubmenu(op);
					opSubmenu = lerOpcaoSubmenu(op);
					executarOpcaoSubMenu(opSubmenu);
				}while(opSubmenu != SubmenuOperacoes.VOLTAR);
			}
			
			//executa o menu externo: exibição do menu, leitura da opção e execução da opção
			
			MenuOperacoes op; {
			do {
				exibirMenuExterno();
				op = lerOpcaoMenuExterno();
				executarOpcaoMenuExterno(op);
			}while(op != MenuOperacoes.SAIR);
			System.out.println("Saiu do sistema");
		}

}
