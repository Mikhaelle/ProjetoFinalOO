package CalculoPagamento;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Categoria {
	private String descricaoCategoria;
	private double valorCat = 0;

	public Categoria(String desc) {
		descricaoCategoria = desc;

	}

	// Pegar a descrição da categoria
	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	List<SubCategoria> subs = new LinkedList<SubCategoria>(); // Lista de subcategorias

	//Metodo para cadastro de subcategorias
	public void cadastrarSubcategoria() {

		int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar uma subcategoria?");

		while (opcao == JOptionPane.YES_OPTION) {

			String nomeSubcategoria = JOptionPane.showInputDialog("Qual o nome da subCategoria?");
			double valorSubcategoria = Double
					.parseDouble(JOptionPane.showInputDialog("Qual o valor da despesa da subcategoria?"));

			SubCategoria sub = new SubCategoria(nomeSubcategoria, valorSubcategoria);
			subs.add(sub);

			opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar uma subcategoria?");
		}
		
		JOptionPane.showMessageDialog(null, "Foram cadastradas" + subs.size() + " Subcategorias");
		
		double valorTotal = calculoValorTotal(); //Chama o calculo total dos valores das subcategorias
		JOptionPane.showMessageDialog(null, "Valor total de despesas para essa categoria é: \n" + valorTotal);

	}

	//retira as subcategoria
	public boolean retirarSubCategoria(SubCategoria sub) {
		boolean resposta = subs.remove(sub);
		return resposta;
	}

	//pesquisa categoria por descricao
	public SubCategoria pesquisarSubCategoriaDesc(String descricao) {
		SubCategoria resposta = null;
		for (SubCategoria a : subs) {
			
			if (a.getDescricaoSubCategoria().equalsIgnoreCase(descricao)) {
				
				resposta = a;
			}
		}

		return resposta;
	}
	
	//pesquisa categoria por valor
	public SubCategoria pesquisarSubCategoriaVal(double valor) {
		SubCategoria resposta = null;
		for (SubCategoria a : subs) {
			
			if (a.getValorCat() == valor) {
				
				resposta = a;
			}
		}
		
		return resposta;
	}

	// Calcular valor total de subcategorias na categoria
	public double calculoValorTotal() {
		Iterator<SubCategoria> it = subs.iterator();
		double valorTotalSub = 0;
		while (it.hasNext()) {
			SubCategoria sub = it.next();
			valorTotalSub = valorTotalSub + (sub.getValorCat());
		}
		return valorTotalSub;
	}

	// pegar valor total da categoria
	public double getValorCat() {
		return valorCat = calculoValorTotal();
	}
	
	//pegar as subcategorias com nome e valor
	public String getNomeValCategoria() {
		Iterator<SubCategoria> it = subs.iterator();
		String resultado = "";
		while (it.hasNext()) {
			SubCategoria sub = it.next();
			resultado = resultado + (sub.getDescricaoSubCategoria()+ ":" + sub.getValorCat() + " R$" + "\n");
		}
		return resultado;
	}

}
