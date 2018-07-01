package Calculo;

import javax.swing.JOptionPane;

import Moradia.Republica;

public abstract class ValorPago {
	protected Republica rep;
	protected double valorTotal= 0;
	protected double[] valorPorPessoa; 
	protected abstract double[] calculoDaRegra(Republica rep);
	public ValorPago(Republica republica) {
		rep=republica;
	}
	
	public void setRepublica(Republica republica) {
		rep=republica;
	}
	public void aplicarRegra(Republica republica) {
		valorTotal=rep.getValorDespesas();
		for(int i=0;i<rep.getMoradores().size();i++) {
			double valorIndividual=calculoDaRegra(rep)[i];
			System.out.println(valorIndividual);
			rep.getMoradores().get(i).setParcela(valorIndividual);	
		}
	}
	
}
