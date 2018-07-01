package Gasto;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import Moradia.Republica;

public class Despesa {

	double valor;
	SubCategoria sub;
	Republica rep;

	public Despesa(double v, SubCategoria a, Republica r) {
		valor = v;
		sub = a;
		rep = r;

	}

	public double getValor() {
		return valor;
	}

	public SubCategoria getSub() {
		return sub;
	}


	public Republica getRep() {
		return rep;
	}


	/*// pegar nome das categorias
	public String getNomeCategoria() {
		Iterator<Categoria> it = categorias.iterator();
		String resultado = "";
		while (it.hasNext()) {
			Categoria cat = it.next();
			resultado = resultado + (cat.getDescricaoCategoria() + "\n");
		}
		return resultado;
	}*/


}
