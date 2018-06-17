package Moradia;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Republica {

	private String nome;

	public Republica(String n) {
		nome = n;
	}

	public String getNome() {
		return nome;
	}

	ArrayList moradores = new ArrayList<Morador>();

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

}
