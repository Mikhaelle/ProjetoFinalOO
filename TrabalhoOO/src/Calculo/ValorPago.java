package Calculo;

import Moradia.Republica;

public abstract class ValorPago {
	protected Republica rep;
	protected double valorTotal= rep.getValorDespesas();
	protected double[] valorPorPessoa=new double[rep.getMoradores().size()]; 
	protected abstract double[] calculoDaRegra(Republica rep);
	
}
