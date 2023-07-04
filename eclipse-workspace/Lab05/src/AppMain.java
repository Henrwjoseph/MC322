import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {
	private final static Scanner input = new Scanner(System.in);
	private static ArrayList<Seguradora> listaseguradoras = new ArrayList<Seguradora>();
	public static void main(String[] args) {
	//instanciando os objetos
	
	//passando datas para LocalDate
	String datanascimentof = "02/07/2004";
	String datafundacaof = "28/07/2004";
	String datanascimentoCondutor2 = "28/07/2000";
	String datasinistro1 = "30/05/2013";
	String datasinistro2 = "15/06/2018";
	String dataInicioPF = "05/07/2007";
	String dataFimPF = "08/10/2010";
	String dataInicioPJ = "15/04/2008";
	String dataFimPJ = "04/10/2013";
	DateTimeFormatter dataformatada =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate dataNascimento = LocalDate.parse(datanascimentof, dataformatada);
	LocalDate dataFundacao = LocalDate.parse(datafundacaof, dataformatada);
	LocalDate dataNascimentoCondutor2 = LocalDate.parse(datanascimentoCondutor2, dataformatada);
	LocalDate dataSinistro1 = LocalDate.parse(datasinistro1, dataformatada);
	LocalDate dataSinistro2 = LocalDate.parse(datasinistro2, dataformatada);
	LocalDate dataInicioPFf = LocalDate.parse(dataInicioPF, dataformatada);
	LocalDate dataFimPFf = LocalDate.parse(dataFimPF, dataformatada);
	LocalDate dataInicioPJf = LocalDate.parse(dataInicioPJ, dataformatada);
	LocalDate dataFimPJf = LocalDate.parse(dataFimPJ, dataformatada);
	
	ClientePF clientepf = null;
	ClientePJ clientepj = null;
	Sinistro sinistropf = null;
	Sinistro sinistropj = null;
	
	//instanciando seguradora
	Seguradora seguradora = new Seguradora("44.556.254/0001-66", "PortoSeguro","11999810117", "portoseguro@gmail.com", "Rua Santo Antonio, 191");
	
	
	Condutor condutor1 = new Condutor ("87609633011", "Victor", "71999971405", "rua brasil","gmailcom", dataNascimento); 
	Condutor condutor2 = new Condutor ("28822158784", "Joana", "21889910116", "rua tocantins", "yahoo.com", dataNascimentoCondutor2); 
	
	//veiculos para lista de veiculos PF
	Veiculo veiculo1 = new Veiculo ("OXE4A45", "Mitsubishi", "Lancer", 2004);
	Veiculo veiculo2 = new Veiculo ("QUE7U19", "Nissan", "GTR", 2010);
	
	//veiculos para frota
	Veiculo veiculoFrota1 = new Veiculo ("PRA9T56", "Fiat", "Argo", 2020);
	Veiculo veiculoFrota2 = new Veiculo ("ZIR8D32", "Renault", "Sandero", 2010);
	
	if(Validacao.validarCPF("87609633011")) {
		clientepf = new ClientePF("Victor", "rua brasil", "71999971405", "gmailcom", "87609633011", "masculino", "EM", dataNascimento);
		clientepf.getListaveiculos().add(veiculo2);
		clientepf.getListaveiculos().add(veiculo1);
		
		//instanciando seguro PF
		SeguroPF seguropf = new SeguroPF(clientepf.getCpf(), dataInicioPFf, dataFimPFf, seguradora, veiculo1, clientepf); 
		
		//instanciando sinistro
		sinistropf = new Sinistro (dataSinistro1, "rua angelica", clientepf.getCpf(), condutor1, seguropf);
	}
	
	if (Validacao.validarCnpj("49708505000102")) {
		clientepj = new ClientePJ ("Empresa", "7188910415", "Rua Rio Purus","outlook.com", "49708505000102", dataFundacao);
		//cadastra frota e cadastra um veiculo 
		clientepj.cadastarFrota();
		//adicionando mais veiculos na frota criada
		clientepj.getListafrota().get(0).getListaveiculos().add(veiculoFrota2);
		clientepj.getListafrota().get(0).getListaveiculos().add(veiculoFrota1);
		
		//instanciando seguro PJ
		SeguroPJ seguropj = new SeguroPJ(clientepj.getCnpj(), dataInicioPJf, dataFimPJf, seguradora, clientepj.getListafrota().get(0), clientepj);
		
		//instanciando sinistro 
		sinistropj = new Sinistro (dataSinistro2, "Av. 7", clientepj.getCnpj(), condutor2, seguropj);
	}
	
	//tostrings
	System.out.print("\nDados Seguradora:\n");
	System.out.print(seguradora.toString() + "\n");
	System.out.print("Dados Cliente PF:\n");
	System.out.print(clientepf.toString() + "\n\n");
	System.out.print("Dados Cliente PJ:\n");
	System.out.print(clientepj.toString() + "\n\n");
	System.out.print("Dados Veiculos:\n");
	System.out.print(veiculo1.toString() + "\n\n" + veiculo2.toString() + "\n\n" + veiculoFrota1.toString() + "\n\n" + veiculoFrota2.toString() + "\n\n");
	System.out.print("Dados Sinistros: \n");
	System.out.print(sinistropf.toString() + "\n\n" + sinistropj.toString() + "\n");
	
	MenuOperacoes op; {
		do {
			exibirMenuExterno();
			op = lerOpcaoMenuExterno();
			executarOpcaoMenuExterno(op);
			}while(op != MenuOperacoes.SAIR);
			System.out.println("Saiu do sistema");
		}
	
	}
	public static Seguradora criarSeguradora () {
		System.out.print("\n**************Cadastrar Seguradora**************\n");
		System.out.print("CNPJ: \n");
		String cnpj = input.nextLine();
		System.out.print("Nome: \n");
		String nome = input.nextLine();
		System.out.print("Telefone: \n");
		String telefone = input.nextLine();
		System.out.print("E-mail: \n");
		String email = input.nextLine();
		System.out.print("Endereço: ");
		String endereco = input.nextLine();
		Seguradora seguradora;
		return seguradora = new Seguradora(cnpj, nome, telefone, email, endereco);
	}
	
	public static void cadastrarSeguradora (Seguradora seguradora) {
		listaseguradoras.add(seguradora);
	}
	
	public static Seguradora escolherSeguradora () {
		System.out.print("\nESCOLHA A SEGURADORA:\n");
		for(int i = 0; i < listaseguradoras.size(); i++) {
			System.out.println(i + "- " + listaseguradoras.get(i).getNome() + "\n");
		}
		System.out.print("Escreva o numero da seguradora:\n");
		int index = input.nextInt();
		Seguradora seguradora = listaseguradoras.get(index);
		return seguradora;
	}
	
	public static Cliente escolherCliente (Seguradora seguradora) {
		System.out.print("\nEscolha o cliente: \n");
		for(int i = 0; i < seguradora.getListaclientes().size(); i++) {
			System.out.println((i + 1) + "- " + seguradora.getListaclientes().get(i).toString() + "\n");
		}
		System.out.print("\nEscreva o número da opção a ser escolhida\n");
		int index = input.nextInt();
		Cliente cliente = seguradora.getListaclientes().get(index - 1);
		return cliente;
	}
	
	
	private static void exibirMenuExterno() {
		MenuOperacoes menuOpcoes[] = MenuOperacoes.values();
		System.out.println("Menu principal");
		for(MenuOperacoes op: menuOpcoes) {
			System.out.println(op.ordinal() + " - " + op.getDescricao());
		}
	}
	
	private static void exibirSubmenu(MenuOperacoes op) {
		SubmenuOperacoes[] submenu = op.getSubmenu();
		System.out.println(op.getDescricao());
		for(int i=0; i<submenu.length; i++) {
			System.out.println(i +" - " + submenu[i].getDescricao());
		}
	}
	
	private static void exibirOutrosmenu(SubmenuOperacoes op) {
		OutrasOperacoes[] outromenu = op.getOutrasmenu();
		System.out.println(op.getDescricao());
		for(int i=0; i<outromenu.length; i++) {
			System.out.println(i +" - " + outromenu[i].getDescricao());
		}
	}
	
	
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
	
	private static OutrasOperacoes lerOpcaoOutrasmenu(SubmenuOperacoes op) {
		Scanner scanner = new Scanner(System.in);
		int opUsuario;
		OutrasOperacoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > op.getOutrasmenu().length - 1);
		opUsuarioConst = op.getOutrasmenu()[opUsuario];
		return opUsuarioConst;
	}
	
	private static void executarOpcaoMenuExterno(MenuOperacoes op)  {
		switch(op) {
			case SEGURADORAS:	
				Seguradora seguradora = escolherSeguradora(); 
				executarSubmenu(op, seguradora);
			case CADASTRAR_SEGURADORAS:
				seguradora = criarSeguradora();
				cadastrarSeguradora(seguradora);
		}
	}
	
	public static void executarOpcaoSubMenu(SubmenuOperacoes opSubmenu, Seguradora seguradora) {
		switch(opSubmenu) {
			case CLIENTEPJ:
				Cliente cliente = escolherCliente(seguradora);
				if (cliente instanceof ClientePJ) 
					executarOutrasmenu(opSubmenu, cliente);
			case CLIENTEPF:
				cliente = escolherCliente(seguradora);
				if (cliente instanceof ClientePF) 
					executarOutrasmenu(opSubmenu, cliente);
			case CADASTRAR_CLIENTE:
				seguradora.cadastrarCliente();
			case GERAR_SEGURO:
				seguradora.gerarSeguro();
			case EXCLUIR:
				executarOutrasmenu(opSubmenu, seguradora);
			case SEGUROS_POR_CLIENTE:
				ArrayList<Seguro> lista = seguradora.getSegurosPorCliente();
				for(int i = 0; i < lista.size(); i++) {
					System.out.println(i + "- " + lista.get(i).getId() + "\n");
				}
			case SINISTROS_POR_CLIENTE:
				ArrayList<Sinistro> lista2 = seguradora.getSinistroPorCliente();
				for(int i = 0; i < lista2.size(); i++) {
					System.out.println(i + "- " + lista2.get(i).getId() + "\n");
				}
			case CALCULAR_RECEITA:
				double receita = seguradora.calcularReceita();
				System.out.println("\nReceita: "+ receita + "\n");
		}
	}
		
	public static void executarOpcaoOutrasop (OutrasOperacoes opOutras, Cliente cliente) {
		if (cliente instanceof ClientePJ) {
			switch(opOutras) {
			case CADASTRAR_FROTA:
				((ClientePJ) cliente).cadastarFrota();
				break;
			case ATUALIZAR_FROTA:
				((ClientePJ) cliente).atualizarFrota();
			}
		}
		
		if (cliente instanceof ClientePF) {
			switch(opOutras) {
			case CADASTRAR_VEICULO:
				((ClientePF) cliente).cadastrarVeiculo();
			case REMOVER_VEICULO:
				((ClientePF) cliente).removerVeiculo();
			}
			
		}
	}
	
	public static void executarOpcaoOutrasop (OutrasOperacoes opOutras, Seguradora seguradora) {
		switch(opOutras) {
		case EXCLUIR_CLIENTE:
			if(seguradora.removerCliente())
				System.out.print("\nCliente removido\n");
			else {
				System.out.print("\nFalha ao remover cliente");
			}
		case EXCLUIR_SEGURO:
			if (seguradora.cancelarSeguro())
				System.out.print("\nSeguro cancelado\n");
			else {
				System.out.print("\nFalha ao cancelar seguro\n");
			}
		}
	}
	
	private static void executarSubmenu(MenuOperacoes op, Seguradora seguradora) {
		SubmenuOperacoes opSubmenu;
		do {
			exibirSubmenu(op);
			opSubmenu = lerOpcaoSubmenu(op);
			executarOpcaoSubMenu(opSubmenu, seguradora);
		}while(opSubmenu != SubmenuOperacoes.VOLTAR);
	}
	
	private static void executarOutrasmenu(SubmenuOperacoes op, Cliente cliente) {
		OutrasOperacoes opSubmenu;
		do {
			exibirOutrosmenu(op);
			opSubmenu = lerOpcaoOutrasmenu(op);
			executarOpcaoOutrasop(opSubmenu, cliente);
		}while(opSubmenu != OutrasOperacoes.VOLTAR);
	}
	
	private static void executarOutrasmenu(SubmenuOperacoes op, Seguradora seguradora) {
		OutrasOperacoes opSubmenu;
		do {
			exibirOutrosmenu(op);
			opSubmenu = lerOpcaoOutrasmenu(op);
			executarOpcaoOutrasop(opSubmenu, seguradora);
		}while(opSubmenu != OutrasOperacoes.VOLTAR);
	}
	}
}

