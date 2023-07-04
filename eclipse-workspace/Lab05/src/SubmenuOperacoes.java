
public enum SubmenuOperacoes {
	CLIENTEPJ ("Cliente pj", new OutrasOperacoes[] {
			OutrasOperacoes.CADASTRAR_FROTA,
			OutrasOperacoes.ATUALIZAR_FROTA,
	}),
	CLIENTEPF ("Cleinte pf", new OutrasOperacoes[] {
			OutrasOperacoes.CADASTRAR_VEICULO,
			OutrasOperacoes.REMOVER_VEICULO,
	}),
	CADASTRAR_CLIENTE("Cadastrar cliente", new OutrasOperacoes[] {}),
	GERAR_SEGURO("Gerar seguro", new OutrasOperacoes[] {}),
	EXCLUIR("Excluir", new OutrasOperacoes[] {
			OutrasOperacoes.EXCLUIR_CLIENTE,
			OutrasOperacoes.EXCLUIR_SEGURO,
			OutrasOperacoes.VOLTAR}),
	SEGUROS_POR_CLIENTE("Seguro por cliente", new OutrasOperacoes[] {}),
	SINISTROS_POR_CLIENTE("Sinistros por cliente", new OutrasOperacoes[] {}),
	CALCULAR_RECEITA("Calcular Receita", new OutrasOperacoes[] {OutrasOperacoes.VOLTAR}),
	VOLTAR("Voltar", new OutrasOperacoes[] {});
	
	//atributos
		private final String descricao;
		private final OutrasOperacoes[] outrasmenu;
		
		//Construtor
		SubmenuOperacoes(String descricao, OutrasOperacoes[] outrasmenu){
			this.descricao = descricao;
			this.outrasmenu = outrasmenu;
		}
		
		//getters
		public String getDescricao() {
			return descricao;
		}
		
		public OutrasOperacoes[] getOutrasmenu() {
			return outrasmenu;
		}
}
