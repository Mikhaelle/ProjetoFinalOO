package Execao;

public class DescricaoNaoInformadaException extends Exception {

	public DescricaoNaoInformadaException(String nomeSubcategoria) {
		super ("Formato de nome inválido");
	}

}
