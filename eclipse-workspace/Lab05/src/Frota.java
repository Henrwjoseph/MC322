import java.util.ArrayList;

public class Frota {
	private int code;
	private ArrayList<Veiculo> listaveiculos;
	
	public Frota (String codigo) {
		int code = codigo.hashCode();
		this.setCode(code);
		this.listaveiculos = new ArrayList<Veiculo>();
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public ArrayList<Veiculo> getListaveiculos() {
		return listaveiculos;
	}
	public void setListaveiculos(ArrayList<Veiculo> listaveiculos) {
		this.listaveiculos = listaveiculos;
	}
	
}
