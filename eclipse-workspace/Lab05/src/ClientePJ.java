import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientePJ extends Cliente {
	private final static Scanner input = new Scanner(System.in);
	private final String cnpj;
	private LocalDate dataFundacao;
	private ArrayList<Frota> listafrota;
	
	public ClientePJ (String nome, String telefone, String endereco, String email, String cnpj, LocalDate dataFundacao) {
		super(nome, telefone, endereco, email);
		this.cnpj = cnpj;
		this.setDataFundacao(dataFundacao);
		this.listafrota = new ArrayList<Frota>();
	}
	
	public ArrayList<Frota> getListafrota() {
		return listafrota;
	}
	public void setListafrota(ArrayList<Frota> listafrota) {
		this.listafrota = listafrota;
	}
	public LocalDate getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public boolean cadastarFrota () {
		Frota frota = Instaciar.instanciarFrota();
		Veiculo veiculo = Instaciar.instanciarVeiculo();
		frota.getListaveiculos().add(veiculo);
		return this.listafrota.add(frota);
	}
	
	public boolean atualizarFrota () {
		System.out.print("\n**********ATUALIZAR FROTA**********\n");
		System.out.print("\nEscolha frota\n");
		for(int i = 0; i < this.listafrota.size(); i++) {
			System.out.println((i + 1) + "- " + this.listafrota.get(i).getCode() + "\n");
		}
		int index = input.nextInt();
		Frota frota = this.listafrota.get(index);
		System.out.print("\nEscolha a atualização: \n");
		System.out.print("1- Adicionar veículo\n");
		System.out.print("2- Remover veículo\n");
		System.out.print("3- Excluir frora\n");
		int index2 = input.nextInt();
		if (index2 == 1) {
			Veiculo veiculo = Instaciar.instanciarVeiculo();
			if (frota.getListaveiculos().add(veiculo)) {
				System.out.print("\nVeículo adicionado a frota\n");
				return true;
			}
		}
		else if (index2 == 2) {
			System.out.print("\nEscolha o veiculo a ser removido\n");
			if (frota.getListaveiculos().size() == 1) {
				System.out.print("\nA frota tem apenas 1 veiculo, ao remover o veiculo, excluirá a frota\n");
				System.out.print("Deseja excluir a frota? Sim ou Não\n");
				String resposta = input.nextLine();
				if (resposta.equals("Sim")) {
					this.listafrota.remove(frota);
					return true;
				}
				else if (resposta.equals("Não"))
					return true;
			}
			for(int i = 0; i < frota.getListaveiculos().size(); i++) {
				System.out.println((i + 1) + "- " + frota.getListaveiculos().get(i).getPlaca() + "\n");
			}
			int index3 = input.nextInt();
			Veiculo veiculo = frota.getListaveiculos().get(index3 - 1);
			if (frota.getListaveiculos().remove(veiculo)) {
				System.out.print("\nVeículo removido da frota\n");
				return true;
			}
		}
		else if (index2 == 3) {
			this.listafrota.remove(frota);
			System.out.print("\nFrota removida\n");
			return true;
		}
		return false;
	}
	
	public boolean getVeiculosPorFrota () {
		System.out.print("\n**********Escolha a frota**********\n");
		System.out.print("Escreva o code da frota:\n");
		String code = input.nextLine();
		for(Frota frota: this.listafrota) {
			if (frota.getCode().equals(code)) {
				System.out.println("Veiculos da frota ");
				for (Veiculo veiculo: frota.getListaveiculos()) {
					System.out.println(frota.getCode() + ":\n" + veiculo.toString());
				}
				return true;
			}
		}
		return false;
	}
	
	public int calcularIdade ()  {
		SimpleDateFormat data_format = new SimpleDateFormat("dd/MM/yyyy");
		String data_formatada = data_format.format(this.dataFundacao);
		String[] separar = data_formatada.split("/");
		String srtAno = separar[2];
		int ano = Integer.parseInt(srtAno);
		int idade = 2023 - ano;
		return idade;
	}
	
}
