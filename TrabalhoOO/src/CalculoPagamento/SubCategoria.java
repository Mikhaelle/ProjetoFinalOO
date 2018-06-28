package CalculoPagamento;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class SubCategoria {
	private String descricaoSubCategoria;
	private Categoria categoria;
	
	
	List <Despesa> desps = new LinkedList<Despesa>();
	
	public SubCategoria(String dec, Categoria c) {
		descricaoSubCategoria = dec;
		categoria = c;
	}

	public String getDescricaoSubCategoria() {
		return descricaoSubCategoria;
	}
	
	public void adicionarDespesa(Despesa desp) {
		desps.add(desp);
	}
	
}
