package Moradia;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import CalculoPagamento.Categoria;
import CalculoPagamento.Despesa;

public class Republica {

	private String nome;
	Despesa desp = new Despesa();

	public Republica(String n) {
		nome = n;
	}

	public String getNome() {
		return nome;
	}

	List<Morador> moradores = new LinkedList<Morador>();
	
	public List<Morador> getMoradores(){
		return moradores;
	}
	public void cadastroMorador() {
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar um morador ?");

		while (opcao == JOptionPane.YES_OPTION) {
			String nomeMorador = JOptionPane.showInputDialog("Qual o nome do morador?");
			String emailMorador = JOptionPane.showInputDialog("Qual o email do morador ?");
			float rendMorador = Float.parseFloat(JOptionPane.showInputDialog("Qual o rendimento do morador"));

			Morador morador = new Morador(nomeMorador, emailMorador, rendMorador);
			moradores.add(morador);
			opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar um morador ?");

		}
		JOptionPane.showMessageDialog(null, "Foram cadastrados " + moradores.size() + " moradores");
	}

	public void cadastrarDespesa() {

		int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar uma categoria de despesa ?");

		while (opcao == JOptionPane.YES_OPTION) {
			boolean respostaCriarCategoria = desp.novaCategoria();
			opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar uma categoria de despesa ?");
			if (respostaCriarCategoria) {
				JOptionPane.showMessageDialog(null, "Categora cadastrada");
			}
		}
		JOptionPane.showMessageDialog(null, "Foram cadastradas " + desp.numCategorias() + " categorias de despesa");
		JOptionPane.showMessageDialog(null, "As categorias cadastradas foram :\n" + desp.getNomeCategoria());
	}

	public void pesquisarCategoraDespesa() {
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja pesquisar uma categoria de despesa?");

		while (opcao == JOptionPane.YES_OPTION) {
			String nomeCategoria = JOptionPane.showInputDialog(null, "Qual o nome da categoria?");
			Categoria respostaPesquisarCategoria = desp.pesquisarCategoria(nomeCategoria);
			if (respostaPesquisarCategoria == null) {
				JOptionPane.showMessageDialog(null, "Não existe categoria com esse nome");
			} else {
				JOptionPane.showMessageDialog(null, "Categoria " + nomeCategoria + " encontrada.");
			}
			opcao = JOptionPane.showConfirmDialog(null, "Deseja pesquisar uma categoria de despesa?");
		}
		
	}

	
	
}
