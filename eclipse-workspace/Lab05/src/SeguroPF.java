import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SeguroPF extends Seguro{
	private final static Scanner input = new Scanner(System.in);
	private Veiculo veiculo;
	private ClientePF cliente;
	
	public SeguroPF(String registro, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
		super(registro, dataInicio, dataFim, seguradora);
		this.veiculo = veiculo;
		this.cliente = cliente;
	}

	public ClientePF getClientepf() {
		return cliente;
	}

	public void setClientepf(ClientePF cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public boolean autorizarCondutor () {
		Condutor condutor = Instaciar.instanciarCondutor();
		return this.getListacondutores().add(condutor);
	}
	
	public boolean desautorizarCondutor () {
		System.out.print("\nEscolha o condutor a ser desautorizado\n");
		for (int i = 0; i < this.getListacondutores().size(); i++) {
			System.out.println((i + 1) + "- " + this.getListacondutores().get(i).getCpf() + "\n");
		}
		int index = input.nextInt();
		Condutor condutor = this.getListacondutores().get(index - 1);
		return this.getListacondutores().remove(condutor);
	}
	
	public void gerarSinistro() {
		System.out.print("\n**********GERAR SINISTRO**********\n");
		System.out.print("Data: \n");
		String dataf = input.nextLine();
		System.out.print("Endereço: \n");
		String endereco = input.nextLine();
		System.out.print ("Escreva o cpf do condutor entre os listados: \n");
		for(int i = 0; i < this.getListacondutores().size(); i++) {
			System.out.printf(this.getListacondutores().get(i).getCpf() + "\n");
		} 
		String cpf = input.nextLine();
		Condutor condutor = null; 
		for(int i = 0; i < this.getListacondutores().size(); i++) {
			if (this.getListacondutores().get(i).getCpf().equals(cpf)) {
				condutor =  this.getListacondutores().get(i);
				break;
			}
		}
		
		DateTimeFormatter dataformatada =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate data = LocalDate.parse(dataf, dataformatada);
		
		Sinistro sinistro = new Sinistro(data, endereco, this.cliente.getCpf(), condutor, this);
		if (this.getListasinistros().add(sinistro)) {
			System.out.print("\nSinistro gerado e adicionado a lista de sinistros\n");
		}
		condutor.getListasinistros().add(sinistro);
		System.out.print("\nSinistro adicionado a lista de sinistros do condutor");
	}
	
	//terminar a função
	public void calcularValor() {
		double valorMensal = 0;
		int qntdveiculos = this.cliente.getListaveiculos().size();
		int qntdSinistrosCliente = this.getListasinistros().size();
		int qntdSinistrosCondutor = 0;
		for(Condutor condutor: this.getListacondutores()) {
			qntdSinistrosCondutor += condutor.getListasinistros().size();
		}
		if(this.cliente.calcularIdade() <= 30) {
			valorMensal = CalcSeguro.VALOR_BASE.getValor() * CalcSeguro.FATOR_IDADE_30.getValor() * (1 + 1/(qntdveiculos + 2)) * (2 + (qntdSinistrosCliente /10)) * (5 + (qntdSinistrosCondutor /10));
		}
		
		if(((ClientePF)this.cliente).calcularIdade() <= 60) {
			valorMensal = CalcSeguro.VALOR_BASE.getValor() * CalcSeguro.FATOR_IDADE_30_60.getValor() * (1 + 1/(qntdveiculos + 2)) * (2 + (qntdSinistrosCliente /10)) * (5 + (qntdSinistrosCondutor /10));
		}
		
		if(((ClientePF)this.cliente).calcularIdade() <= 90) {
			valorMensal = CalcSeguro.VALOR_BASE.getValor() * CalcSeguro.FATOR_IDADE_60_90.getValor() * (1 + 1/(qntdveiculos + 2)) * (2 + (qntdSinistrosCliente /10)) * (5 + (qntdSinistrosCondutor /10));
		}
		
		super.setValorMensal(valorMensal);
	}
}
