package CalculoPagamento;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Despesa {

	double valorTotal;

	List<Categoria> categorias;

	public Despesa() {
		categorias = new LinkedList<Categoria>();

	}

	Categoria a = new Categoria("telecomunicações");

	public boolean novaCategoria(Categoria a) {
		boolean resposta = categorias.add(a);
		return resposta;
		// algoritimo para matricular aluno
	}

	public boolean retirarCategoria(Categoria a) {
			boolean resposta = categorias.remove(a);
			return resposta;
			// algoritimo para desmatricular o aluno
	}

	public Categoria pesquisarCategoria(String descricao) {
			Categoria resposta = null;
			for (Categoria a : categorias) {
				if (a.getDescricaoCategoria().equalsIgnoreCase(descricao)) {
					resposta = a;
				}
		
			}
			return resposta;
	}
	//public double CalculoValorTotal() {
	//	return 0;
	//}

	//public double getValor() {
	//	return valorTotal;
	//}

}
