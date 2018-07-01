package Gasto;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Categoria {
	private String descricaoCategoria;
	private Double valorCategoria;
	
	public Categoria(String desc) {
		descricaoCategoria = desc;

	}

	// Pegar a descri��o da categoria
	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	List<SubCategoria> subs = new LinkedList<SubCategoria>(); // Lista de subcategorias

	public double getTotalCategoria() {
		double total=0;
		for (int i=0;i<subs.size();i++) {
			total=total+subs.get(i).getTotalSub();
		}
		return total;
	}
	public List<SubCategoria> getSubs(){
		return subs;
	}
	
	//Metodo para cadastro de subcategorias, retorna verdadeiro ou falso ----- EXISTE EXCE��O FALSO
	public boolean cadastrarSubcategoria(String nomeSubcategoria) {

			SubCategoria sub = new SubCategoria(nomeSubcategoria, this);
			
			return subs.add(sub);

		}
		
	//pesquisa categoria por descricao
		public SubCategoria pesquisarSubCategoria(String descricao) {
			SubCategoria resposta = null;
			for (SubCategoria sub : subs) {
				
				if (sub.getDescricaoSubCategoria().equalsIgnoreCase(descricao)) {
					
					resposta = sub;
				}
			}

			return resposta;
		}

	//retirar as subcategoria ---- TRATAR EXCE��O EM ELSE "HOUVE ERRO"
	public String retirarSubCategoria(String nomeCategoria) {
		SubCategoria sub = pesquisarSubCategoria(nomeCategoria);
		
		if (subs == null) {
			return "Subcategoria n�o encontrada";
		}
		
		if (subs.remove(sub)) {
			return "Subcategoria removida";
		}
		
		else 
			return "Houve um erro";
		
	}
	
	
	

}
