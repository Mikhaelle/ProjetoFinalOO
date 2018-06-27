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

	// cadastra nova categoria
	public boolean novaCategoria() {
		String nomeCategoria = JOptionPane.showInputDialog(null, "Qual o nome da categoria?");

		Categoria cat = new Categoria(nomeCategoria);
		boolean resposta = categorias.add(cat);

		cat.cadastrarSubcategoria();
		return resposta;
	}

	// Retirar uma categoria
	public boolean retirarCategoria(Categoria cat) {
		boolean resposta = categorias.remove(cat);
		return resposta;
	}

	// pesquisar uma categoria
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

	// pegar numero de categorias
	public int numCategorias() {
		return categorias.size();
	}

	// pegar nome das categorias
	public String getNomeCategoria() {
		Iterator<Categoria> it = categorias.iterator();
		String resultado = "";
		while (it.hasNext()) {
			Categoria cat = it.next();
			resultado = resultado + (cat.getDescricaoCategoria() + "\n");
		}
		return resultado;
	}

	// calculo valor total de despesas
	public double CalculoValorTotal() {
		double valorTotalDespesa = 0;
		Iterator<Categoria> it = categorias.iterator();
		while (it.hasNext()) {
			Categoria cat = it.next();
			valorTotalDespesa = valorTotalDespesa + cat.calculoValorTotal();
		}

		return valorTotalDespesa;
	}

	// metodo para retornar o valor total
	public double getValor() {
		return valorTotal = CalculoValorTotal();
	}

}
