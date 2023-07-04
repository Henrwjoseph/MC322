
public enum OutrasOperacoes {
	CADASTRAR_VEICULO("Cadastrar veiculo"),
	REMOVER_VEICULO("Remover veiculo"),
	CADASTRAR_FROTA("Cadastrar frota"),
	ATUALIZAR_FROTA("Atualizar frota"),
	EXCLUIR_CLIENTE("Excluir cliente"),
	EXCLUIR_SEGURO("Excluir seguro"),
	VOLTAR("Voltar");
	
	//atributo
	private final String descricao;
	
	//Construtor
	OutrasOperacoes(String descricao){
		this.descricao = descricao;
	}
	
	//getter
	public String getDescricao() {
		return descricao;
	}
}
