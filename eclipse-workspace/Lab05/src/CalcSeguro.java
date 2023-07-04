
public enum CalcSeguro {
	VALOR_BASE (10),
	FATOR_IDADE_30(1.25),
	FATOR_IDADE_30_60(1.0),
	FATOR_IDADE_60_90(1.5);

	private final double valor;
	
	CalcSeguro(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}
}
