package Execao;

import javax.swing.JOptionPane;

public class CategoriaNaoInformadaException extends Exception {

	public CategoriaNaoInformadaException(String nomeCategoria) {
		super("Nome não digitado");
	}

}
