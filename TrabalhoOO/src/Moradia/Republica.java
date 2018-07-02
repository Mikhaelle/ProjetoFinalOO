package Moradia;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import Calculo.RegraIgualitaria;
import Execao.CategoriaNaoInformadaException;
import Execao.DadosPessoaisIncompletosException;
import Execao.ValorNaoInformadoException;
import Gasto.Categoria;
import Gasto.Despesa;
import Gasto.SubCategoria;
import principals.Arquivo;

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
		nome = novoNome;
		JOptionPane.showMessageDialog(null, "Nome da república atualizado com sucesso! ");
	}

	List<Morador> moradores = new LinkedList<Morador>();

	public List<Morador> getMoradores() {
		return moradores;
	}

	public void cadastroMorador(Republica rep) throws DadosPessoaisIncompletosException{
		int opcao=0;
		while (opcao == 0) {
			String nomeMorador = JOptionPane.showInputDialog("Qual o nome do morador?");
			if (nomeMorador.equals("")) {
				throw new DadosPessoaisIncompletosException();
			}
			String emailMorador = JOptionPane.showInputDialog("Qual o email do morador ?");
			if (emailMorador.equals("")) {
				throw new DadosPessoaisIncompletosException();
			}
			
			String rend = JOptionPane.showInputDialog("Qual o rendimento do morador");
			double rendMorador;
			rendMorador = tryParseDouble(rend,rep);
			Morador morador = new Morador(nomeMorador, emailMorador, rendMorador);
			moradores.add(morador);
			Arquivo.escreverMorador(rep,morador);
			opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro morador?", "Cadastro de moradores", 0);

			
				if (moradores.size() > 0) {
					JOptionPane.showMessageDialog(null, "Foram cadastrados " + moradores.size() + " moradores");
				
			}
		}
	}

	// retorna verdadeiro ou falso quando cria nova categoria ---- EXISTE EXCEÇÃO
	public Categoria novaCategoria(String nomeCategoria) throws CategoriaNaoInformadaException {

		if (nomeCategoria.equals("")) {
			throw new CategoriaNaoInformadaException(nomeCategoria);
		}

		Categoria cat = new Categoria(nomeCategoria);
		categorias.add(cat);
		return cat;
	}

	// retorna a categoria pesquisada
	public Categoria pesquisarCategoria(String nomeCategoria) {
		// Categoria resposta = null;
		for (Categoria cat : categorias) {

			if (cat.getDescricaoCategoria().equalsIgnoreCase(nomeCategoria)) {

				return cat;
			}
		}

		return null;
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
	public boolean cadastrarDespesa(String nomeSubCategoria, double valor, String descricao) {
		Despesa desp = null;

		for (Categoria cat : categorias) {

			SubCategoria subCat = cat.pesquisarSubCategoria(nomeSubCategoria);

			if (subCat != null) {
				desp = new Despesa(valor, descricao, subCat, this);
				subCat.adicionarDespesa(desp); // adc despesa na subCategoria
				return despesas.add(desp); // retorna verdadeiro para despesa cadastrada

			}

		}

		return false; // despesa não cadastrada, porque o nome da subcategoria nao foi encontrado
		// tratar na main
	}

	public boolean retirarDespesa(String nomeSubCategoria, double valor, String descricao) {
		Despesa desp = null;

		for (Categoria cat : categorias) {

			SubCategoria subCat = cat.pesquisarSubCategoria(nomeSubCategoria);
			if (subCat != null) {
				desp = new Despesa(valor, descricao, subCat, this);
				subCat.retirarDespesa(desp); // retira despesa na subCategoria
				return despesas.remove(desp); // retorna verdadeiro para despesa retirada
			}

		}
		return false;
	}

	public double getValorDespesas() {
		double valorTotalDespesas = 0;
		for (int i = 0; i < categorias.size(); i++) {
			valorTotalDespesas += categorias.get(i).getTotalCategoria();
		}
		return valorTotalDespesas;
	}

	public void Divisao() {
		RegraIgualitaria regra = new RegraIgualitaria(this);
		regra.aplicarRegra(this);
	}

	static double tryParseDouble(String value,Republica rep) throws DadosPessoaisIncompletosException{
		try {
			Double valor = Double.parseDouble(value);
			return valor;
		} catch (NumberFormatException e) {
			throw new DadosPessoaisIncompletosException();
		}
	}
}
