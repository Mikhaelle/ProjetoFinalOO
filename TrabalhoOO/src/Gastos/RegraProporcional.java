package Gastos;

import Moradia.Republica;

public class RegraProporcional extends ValorPago {

	protected double[] calculoDaRegra(Republica rep) {
		double[] rends=new double[rep.getMoradores().size()];
		double totalRends=0;
		double[] parcela=new double[rep.getMoradores().size()];
		for (int i=0;i==rep.getMoradores().size();i++) {
			rends[i]=rep.getMoradores().get(i).getRend();
			totalRends=totalRends+rends[i];
		}
		for (int i=0;i==rep.getMoradores().size();i++) {
			parcela[i]=rends[i]/totalRends;
			valorPorPessoa[i]=parcela[i]*totalRends;
		}
		
		return valorPorPessoa;
	}
	
}
