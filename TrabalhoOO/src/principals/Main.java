package principals;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import Moradia.Republica;

public class Main {
	private static LinkedList<Republica> criarRepublica(LinkedList<Republica> rep) {
		String nomeRep=JOptionPane.showInputDialog(null, "Por favor, insira o nome da nova rep�blica", "Nova rep�blica", 0);
		Republica newRep= new Republica(nomeRep);
		rep.add(newRep);
		return rep;
	}
	
	private static LinkedList<Republica> apagarRepublica(LinkedList<Republica> rep) {
		String titleApagar="Apagar Rep�blica";
		String messageApagar="Clique na rep�blica que deseja apagar";
		String[] optApagar=new String[rep.size()+1];
		for (int i=0;i<rep.size();i++) {
			optApagar[i]=rep.get(i).getNome();
		}
		optApagar[rep.size()]="Cancelar";
		int escolha=JOptionPane.showOptionDialog(null, messageApagar, titleApagar, 0, 0, null, optApagar, null);
		if (escolha>=0 && escolha<=rep.size()) {
			rep.remove(escolha);
		}
		return rep;
	}
		
	
	
	public static void main(String[] args) {
		//core
		int escolhaRep=0;
		boolean isOpen=true;
		LinkedList<Republica> rep= new LinkedList<Republica>();
		while(isOpen==true) {
			String[] optMenu=new String[rep.size()+3];
			optMenu[rep.size()]="Nova Rep�blica";
			optMenu[rep.size()+1]="excluir rep�blica";
			optMenu[rep.size()+2]="Fechar";
			for(int i=0;i<rep.size();i++) {
					optMenu[i]=rep.get(i).getNome();
				}
			escolhaRep=JOptionPane.showOptionDialog(null, "Bem vindo ao Gerenciador Financeiro para rep�blicas\n\n Crie, delete ou escolha uma rep�blica que deseja editar", "Gerenciador Financeiro - Seletor de Rep�blica", 0, 0, null, optMenu, null);
			if(escolhaRep==rep.size()+2) {
				isOpen=false;
			}
			if (escolhaRep==rep.size()) {
				rep=criarRepublica(rep);
			}
			if (escolhaRep==rep.size()+1) {
				rep=apagarRepublica(rep);
				}
			if(escolhaRep>=0 && escolhaRep<rep.size()) {
				String message="Rep�blica "+rep.get(escolhaRep).getNome()+"\n\nO que deseja fazer?";
				String[] options=new String[4];
				options[0]="Editar Nome";
				options[1]="Editar Moradores";
				options[2]="Editar Despesas";
				options[3]="Voltar � sele��o de rep�blicas";
				String title="Editar Rep�blica "+rep.get(escolhaRep).getNome();
				int escolha=JOptionPane.showOptionDialog(null, message, title, 0, 0, null, options, null); 
			}
			
		}
	}
}