package Calculo;

import Moradia.Republica;


public class RegraIgualitaria extends ValorPago {
	protected double[] calculoDaRegra(Republica rep) {
		valorPorPessoa=new double[rep.getMoradores().size()];
		double valorIgualitario=valorTotal/valorPorPessoa.length;
		for(int i=0;i<valorPorPessoa.length;i++) {
			valorPorPessoa[i]=valorIgualitario;
		}
		return valorPorPessoa;
	}
	public RegraIgualitaria(Republica republica) {
		super(republica);
	}

}
