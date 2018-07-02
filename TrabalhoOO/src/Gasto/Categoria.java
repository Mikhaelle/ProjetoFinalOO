package Gasto;

import java.util.LinkedList;

import Execao.DescricaoNaoInformadaException;


public class Categoria {
	private String descricaoCategoria;
	
	public Categoria(String desc) {
		descricaoCategoria = desc;

	}

	// Pegar a descrição da categoria
	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	LinkedList<SubCategoria> subs = new LinkedList<SubCategoria>(); // Lista de subcategorias

	public double getTotalCategoria() {
		double total=0;
		for (int i=0;i<subs.size();i++) {
			total=total+subs.get(i).getTotalSub();
		}
		return total;
	}
	public LinkedList<SubCategoria> getSubs(){
		return subs;
	}
	
	//Metodo para cadastro de subcategorias, retorna verdadeiro ou falso ----- EXISTE EXCEÇÃO FALSO
	public boolean cadastrarSubcategoria(String nomeSubcategoria)throws  DescricaoNaoInformadaException {

		if (nomeSubcategoria.equals("")) {
			throw new DescricaoNaoInformadaException(nomeSubcategoria) ;
		}
			SubCategoria sub = new SubCategoria(nomeSubcategoria);
			
			return subs.add(sub);

		}
		
	//pesquisa categoria por descricao
		public SubCategoria pesquisarSubCategoria(String descricao) {
			for (SubCategoria sub : subs) {
				
				if (sub.getDescricaoSubCategoria().equalsIgnoreCase(descricao)) {
					
					return sub;
				}
			}

			return null;
		}

	//retirar as subcategoria ---- TRATAR EXCEÇÃO EM ELSE "HOUVE ERRO"
	public String retirarSubCategoria(String nomeCategoria) {
		SubCategoria sub = pesquisarSubCategoria(nomeCategoria);
		
		if (subs == null) {
			return "Subcategoria não encontrada";
		}
		
		if (subs.remove(sub)) {
			return "Subcategoria removida";
		}
		
		else 
			return "Houve um erro";
		
	}
	
	
	

}
