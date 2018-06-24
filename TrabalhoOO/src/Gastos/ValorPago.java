package Gastos;

import Moradia.Republica;

public abstract class ValorPago {
	protected Republica rep;
	protected static double valorTotal= CalculoPagamento.Despesa.getValor();
	protected double[] valorPorPessoa=new double[rep.getMoradores().size()]; 
	protected abstract double[] calculoDaRegra(Republica rep);
	
}
