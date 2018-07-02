package Gasto;

import java.util.LinkedList;

public class SubCategoria {
	private String descricaoSubCategoria;
	
	
	
	public LinkedList <Despesa> desps = new LinkedList<Despesa>();
	
	public SubCategoria(String dec) {
		descricaoSubCategoria = dec;
	}

	public String getDescricaoSubCategoria() {
		return descricaoSubCategoria;
	}
	
	public double getTotalSub() {
		double totalSub=0;
		for (int i=0;i<desps.size();i++) {
			totalSub+=totalSub+desps.get(i).valor;
		}
		return totalSub;
	}
	
	public LinkedList<Despesa> getDesps() {
		return desps;
	}
	
	public void adicionarDespesa(Despesa desp) {
		desps.add(desp);
	}
	
	public void retirarDespesa(Despesa desp) {
		desps.remove(desp);
	}
	
	
}
