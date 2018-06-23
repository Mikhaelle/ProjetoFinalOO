package CalculoPagamento;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Despesa {

	double valorTotal;

	public List<Categoria> categorias;

	public Despesa() {
		categorias = new LinkedList<Categoria>();

	}

	public boolean novaCategoria() {
		String nomeCategoria = JOptionPane.showInputDialog(null, "Qual o nome da categoria?");
		Categoria cat = new Categoria(nomeCategoria);
		boolean resposta = categorias.add(cat);
		return resposta;
	}

	public boolean retirarCategoria(Categoria cat) {
		boolean resposta = categorias.remove(cat);
		return resposta;
	}

	public Categoria pesquisarCategoria(String descricao) {
		Categoria resposta = null;
		for (Categoria a : categorias) {
			if (a.getDescricaoCategoria().equalsIgnoreCase(descricao)) {
				resposta = a;
				JOptionPane.showMessageDialog(null, "Categoria excluida!");
			}
		}
		
		return resposta;
	}

	public int numCategorias() {
		return categorias.size();
	}

	public String getNomeCategoria() {
		Iterator<Categoria> it = categorias.iterator();
		String resultado = "";
		while (it.hasNext()) {
			Categoria cat = it.next();
			resultado = resultado + (cat.getDescricaoCategoria() + "\n");
		}
		return resultado;
	}

	// public double CalculoValorTotal() {
	// return 0;
	// }

	// public double getValor() {
	// return valorTotal;
	// }

}
