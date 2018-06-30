package Moradia;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import CalculoPagamento.Categoria;
import CalculoPagamento.Despesa;
import CalculoPagamento.SubCategoria;

public class Republica {

	private String nome;

	public List<Categoria> categorias = new LinkedList<Categoria>();

	public List<Despesa> despesas = new LinkedList<Despesa>();

	public Republica(String n) {
		nome = n;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String novoNome) {
		nome=novoNome;
		JOptionPane.showMessageDialog(null, "Nome da república atualizado com sucesso! ");
	}

	List<Morador> moradores = new LinkedList<Morador>();

	public List<Morador> getMoradores() {
		return moradores;
	}

	public void cadastroMorador() {
		int opcao=0;

		while (opcao == 0) {
			String nomeMorador = JOptionPane.showInputDialog("Qual o nome do morador?");
			String emailMorador = JOptionPane.showInputDialog("Qual o email do morador ?");
			float rendMorador = Float.parseFloat(JOptionPane.showInputDialog("Qual o rendimento do morador"));

			Morador morador = new Morador(nomeMorador, emailMorador, rendMorador);
			moradores.add(morador);
			opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro morador?", "Cadastro de moradores", 0);

		}
		if(moradores.size()>0) {
			JOptionPane.showMessageDialog(null, "Foram cadastrados " + moradores.size() + " moradores");
		}
	}

	// retorna verdadeiro ou falso quando cria nova categoria ---- EXISTE EXCEÇÃO
	public Categoria novaCategoria(String nomeCategoria) {

		Categoria cat = new Categoria(nomeCategoria);

		return cat;
	}

	// retorna a categoria pesquisada
	public Categoria pesquisarCategoria(String nomeCategoria) {
		Categoria resposta = null;
		for (Categoria cat : categorias) {

			if (cat.getDescricaoCategoria().equalsIgnoreCase(nomeCategoria)) {

				resposta = cat;
			}
		}

		return resposta;
	}

	// retirar categoria, retorna uma string
	public String retirarCategoria(String nomeCategoria) {

		Categoria cat = pesquisarCategoria(nomeCategoria);

		if (cat == null) {
			return "Categoria não encontrada";
		}

		if (categorias.remove(cat)) {
			return "Categoria removida";
		}

		else
			return "Houve um erro";

	}

	// cadastra uma despesa, a pessoa coloca o nome da subcategoria e o valor
	// é procurado em todas as categroias uma subcategoria com o nome, quando
	// encontrada ela adiciona a despesa
	public boolean cadastrarDespesa(String nomeSubCategoria, double valor) {
		Despesa desp = null;

		for (Categoria cat : categorias) {

			SubCategoria subCat = cat.pesquisarSubCategoria(nomeSubCategoria);

			if (subCat != null) {
				desp = new Despesa(valor, subCat, this);
				subCat.adicionarDespesa(desp); // adc despesa na subCategoria
				return despesas.add(desp); // retorna verdadeiro para despesa cadastrada

			}

		}

		return false; // despesa não cadastrada, porque o nome da subcategoria nao foi encontrado
		// tratar na main
	}
	
	public double getValorDespesas() {
		double valorTotalDespesas=0;
		for(int i=0;i<despesas.size();i++) {
			valorTotalDespesas+=despesas.get(i).getValor();
		}
		return valorTotalDespesas;
	}
}
