package Principal;

import javax.swing.JOptionPane;


import Moradia.Republica;

public class Main {

	public static void main(String[] args) {
		
		// cadastrando republica
		String nomeRep = JOptionPane.showInputDialog("Qual o nome da republica ?");
		Republica rep = new Republica(nomeRep);

		JOptionPane.showMessageDialog(null, "O nome da republica é: " + rep.getNome());
		
		rep.cadastroMorador();
		rep.cadastrarDespesa();
	}

}
