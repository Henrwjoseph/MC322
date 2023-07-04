import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Seguro {
	private final int id;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Seguradora seguradora;
	private ArrayList<Sinistro> listasinistros;
	private ArrayList<Condutor> listacondutores;
	private double valorMensal;
	
	public Seguro (String registro, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora) {
		this.id = this.gerarId(registro);
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.seguradora = seguradora;
		this.listacondutores = new ArrayList<Condutor>();
		this.listasinistros = new ArrayList<Sinistro>();
	}

	public int getId() {
		return id;
	}
	
	public int gerarId (String registro) {
		return registro.hashCode();
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public ArrayList<Sinistro> getListasinistros() {
		return listasinistros;
	}

	public void setListasinistros(ArrayList<Sinistro> listasinistros) {
		this.listasinistros = listasinistros;
	}

	public ArrayList<Condutor> getListacondutores() {
		return listacondutores;
	}

	public void setListacondutores(ArrayList<Condutor> listacondutores) {
		this.listacondutores = listacondutores;
	}

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}
	
	public abstract void calcularValor ();
	
	public abstract boolean desautorizarCondutor ();
	
	public abstract boolean autorizarCondutor();
	
	
	
	
	
	
	
}
