package CalculoPagamento;

import java.util.ArrayList;

public class Categoria {
	private String descricaoCategoria;
	private double valorCat;
	
	
	public Categoria(String desc) {
		descricaoCategoria = desc;
		
	}
	
	ArrayList subs = new ArrayList<SubCategoria>();

	// Pegar a descrição da categoria
	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}



	//Calcular valor total de subcategorias na categoria
	//public double calculoValorTotal() {
	//	return valorCat = 0;
	//}
	
	
	//pegar valor total da categoria
	//public double getValorCat() {
	//	return valorCat;
	//}

	//pegar as subcategorias 
	//public ArrayList getSubs() {
	//	return subs;
	//}
	
	
}
