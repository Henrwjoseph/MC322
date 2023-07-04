import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SeguroPJ extends Seguro{
	private final static Scanner input = new Scanner(System.in);
	private Frota frota;
	private ClientePJ cliente;
	
	public SeguroPJ (String registro, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Frota frota, ClientePJ cliente) {
		super(registro, dataInicio, dataFim, seguradora);
		this.frota = frota;
		this.cliente = cliente;
	}
	
	public Frota getFrota() {
		return frota;
	}
	public void setFrota(Frota frota) {
		this.frota = frota;
	}
	public ClientePJ getClientepj() {
		return cliente;
	}
	public void setCliente(ClientePJ cliente) {
		this.cliente = cliente;
	}
	
	public boolean autorizarCondutor () {
		Condutor condutor = Instaciar.intanciarCondutor();
		return this.getListacondutores().add(condutor);
	}
	
	public boolean desautorizarCondutor () {
		Condutor condutor = null;
		System.out.print("\nEscolha o condutor: \n");
		for (int i = 0; i < super.getListacondutores().size(); i ++) {
			System.out.println(super.getListacondutores().get(i).getCpf() + "\n");
		}
		System.out.print("\nEscreva o cpf do condutor dentre os listados: \n");
		String cpf = input.nextLine();
		for (int i = 0; i < super.getListacondutores().size(); i ++) {
			if (super.getListacondutores().get(i).getCpf().equals(cpf)) { 
				condutor = super.getListacondutores().get(i);
				break;
			}
		}
		return this.getListacondutores().remove(condutor);
	}
	
	public void gerarSinistro () {
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
		
		Sinistro sinistro = new Sinistro(data, endereco, this.cliente.getCnpj(), condutor, this);
		if (this.getListasinistros().add(sinistro)) {
			System.out.print("\nSinistro gerado e adicionado a lista de sinistros\n");
		}
		condutor.adicionarSinistro(sinistro); 
		System.out.print("\nSinistro adicionado a lista de sinistros do condutor");
	}
	
	public void calcularValor() {
		int qntdveiculos = this.frota.getListaveiculos().size();
		int qntdfuncionarios = super.getListacondutores().size();
		int AnosPosFundacao = this.cliente.calcularIdade();
		int qntdSinistrosCliente = this.getListasinistros().size();
		int qntdSinistrosCondutor = 0;
		for(Condutor condutor: this.getListacondutores()) {
			qntdSinistrosCondutor += condutor.getListasinistros().size();
		}
		
		this.setValorMensal(CalcSeguro.VALOR_BASE.getValor() * (10 + (qntdfuncionarios/10)) * (1 + 1/(qntdveiculos + 2)) * (1 + 1/(AnosPosFundacao + 2)) * (2 + qntdSinistrosCliente/10) * (5 + qntdSinistrosCondutor/10)); 
	}
}
