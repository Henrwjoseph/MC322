
public enum MenuOperacoes {
	SEGURADORAS("Seguradoras", new SubmenuOperacoes[] {
			SubmenuOperacoes.CADASTRAR_CLIENTE,
			SubmenuOperacoes.GERAR_SEGURO,
			SubmenuOperacoes.LISTAR_CLIENTES,
			SubmenuOperacoes.SEGUROS_POR_CLIENTE,
			SubmenuOperacoes.SINISTROS_POR_CLIENTE,
			SubmenuOperacoes.CALCULAR_RECEITA,
			SubmenuOperacoes.EXCLUIR,
	}),
	CADASTRAR_SEGURADORAS("Cadastrar seguradoras", new SubmenuOperacoes[] {}),
	SAIR("Sair", new SubmenuOperacoes[] {});
	//atributos
	private final String descricao;
	private final SubmenuOperacoes[] submenu;
	
	//Construtor
	MenuOperacoes(String descricao, SubmenuOperacoes[] submenu){
		this.descricao = descricao;
		this.submenu = submenu;
	}
	
	//getters
	public String getDescricao() {
		return descricao;
	}
	
	public SubmenuOperacoes[] getSubmenu() {
		return submenu;
	}
}
