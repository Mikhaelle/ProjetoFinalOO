package Gasto;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import Moradia.Republica;

public class Despesa {

	double valor;
	String descricao;
	SubCategoria sub;
	Republica rep;

	public Despesa(double v,String desc, SubCategoria a, Republica r) {
		valor = v;
		descricao=desc;
		sub = a;
		rep = r;

	}

	public double getValor() {
		return valor;
	}
	
	public String getDesc() {
		return descricao;
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
