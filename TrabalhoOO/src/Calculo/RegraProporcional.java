package Calculo;

import Moradia.Republica;

public class RegraProporcional extends ValorPago {

	protected double[] calculoDaRegra(Republica rep) {
		double[] rends=new double[rep.getMoradores().size()];
		double totalRends=0;
		double[] parcela=new double[rep.getMoradores().size()];
		valorPorPessoa=new double[rep.getMoradores().size()];
		for (int i=0;i<rep.getMoradores().size();i++) {
			rends[i]=rep.getMoradores().get(i).getRend();
			totalRends=totalRends+rends[i];
		}
		for (int i2=0;i2<rep.getMoradores().size();i2++) {
			parcela[i2]=rends[i2]/totalRends;
			valorPorPessoa[i2]=parcela[i2]*totalRends;	
		}
		
		return valorPorPessoa;
	}
	public RegraProporcional(Republica republica) {
		super(republica);
	}
	
}
