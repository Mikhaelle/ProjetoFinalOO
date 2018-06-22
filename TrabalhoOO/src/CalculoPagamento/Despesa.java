package CalculoPagamento;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Despesa {

	double valorTotal;

	List<Categoria> categorias;

	public Despesa() {
		categorias = new LinkedList<Categoria>();

	}


	public boolean novaCategoria() {
		String nomeCategoria = JOptionPane.showInputDialog(null, "Qual o nome da categoria?");
		Categoria cat = new Categoria(nomeCategoria);
		boolean resposta = categorias.add(cat);
		return resposta;
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
	
	public int numCategorias()
	{
		return categorias.size();
	}
	//public double CalculoValorTotal() {
	//	return 0;
	//}

	//public double getValor() {
	//	return valorTotal;
	//}

}
