package CalculoPagamento;

public class SubCategoria {
	private String descricaoSubCategoria;
	private double valorCat;
	
	public SubCategoria(String dec, double v) {
		descricaoSubCategoria = dec;
		valorCat = v;
	}

	public String getDescricaoSubCategoria() {
		return descricaoSubCategoria;
	}


	public double getValorCat() {
		return valorCat;
	}

	
}
