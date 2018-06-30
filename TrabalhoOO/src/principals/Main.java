package principals;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import Moradia.Morador;
import Moradia.Republica;

public class Main {
	private static int seletorDeRepublica (LinkedList<Republica> rep) {
		String[] optMenu = new String[rep.size() + 3];
		optMenu[rep.size()] = "Nova Rep�blica";
		optMenu[rep.size() + 1] = "excluir rep�blica";
		optMenu[rep.size() + 2] = "Fechar";
		for (int i = 0; i < rep.size(); i++) {
			optMenu[i] = rep.get(i).getNome();
		}
		int escolhaRep = JOptionPane.showOptionDialog(null,
				"Bem vindo ao Gerenciador Financeiro para rep�blicas\n\n Crie, delete ou escolha uma rep�blica que deseja editar",
				"Gerenciador Financeiro - Seletor de Rep�blica", 0, 1, null, optMenu, null);
		return escolhaRep;
	}
	
	private static LinkedList<Republica> criarRepublica(LinkedList<Republica> rep) {
		String nomeRep = JOptionPane.showInputDialog(null, "Por favor, insira o nome da nova rep�blica",
				"Nova rep�blica", 1);
		Republica newRep = new Republica(nomeRep);
		rep.add(newRep);
		return rep;
	}

	private static LinkedList<Republica> apagarRepublica(LinkedList<Republica> rep) {
		String titleApagar = "Apagar Rep�blica";
		String messageApagar = "Clique na rep�blica que deseja apagar";
		String[] optApagar = new String[rep.size() + 1];
		for (int i = 0; i < rep.size(); i++) {
			optApagar[i] = rep.get(i).getNome();
		}
		optApagar[rep.size()] = "Cancelar";
		int escolha = JOptionPane.showOptionDialog(null, messageApagar, titleApagar, 0, 1, null, optApagar, null);
		if (escolha >= 0 && escolha <= rep.size()) {
			rep.remove(escolha);
		}
		return rep;
	}
	
	private static int editarRepublica(LinkedList<Republica> rep, int escolhaRep) {
		String message = "Rep�blica " + rep.get(escolhaRep).getNome() + "\n\nO que deseja fazer?";
		String[] options = new String[4];
		options[0] = "Editar Nome";
		options[1] = "Editar Moradores";
		options[2] = "Editar Despesas";
		options[3] = "Voltar � sele��o de rep�blicas";
		String title = "Editar Rep�blica " + rep.get(escolhaRep).getNome();
		int escolha = JOptionPane.showOptionDialog(null, message, title, 0, 1, null, options, null);
		return escolha;
	}
	
	private static LinkedList<Republica> mudarNome(LinkedList<Republica> rep, int escolhaRep){
		String novoNome=JOptionPane.showInputDialog("Insira o novo nome da Rep�blica "+rep.get(escolhaRep).getNome());
		rep.get(escolhaRep).setNome(novoNome);
		return rep;
	}
	
	private static LinkedList<Republica> editarMoradores(LinkedList<Republica> rep, int escolhaRep){
		if(rep.get(escolhaRep).getMoradores().size()==0) {
			int yesNo=JOptionPane.showConfirmDialog(null, "N�o h� nenhum morador cadastrado nessa rep�blica!\n\nDeseja cadastrar um morador?", "Editar Moradores", 0);
			if (yesNo==0) {
				//essa � a op��o "sim"
				rep.get(escolhaRep).cadastroMorador();
			}
		}
		else {
			List<Morador> moradores = rep.get(escolhaRep).getMoradores();
			String listaNomes="H�"+moradores.size() +"moradores est�o cadastrados na rep�blica "+rep.get(escolhaRep).getNome()+"\n";
			String[] optionsMoradores= new String[moradores.size()+1];
			for(int i=0;i<moradores.size();i++) {
				listaNomes=listaNomes+moradores.get(i).getNome()+"\n";
				optionsMoradores[i]=moradores.get(i).getNome();
			}
			optionsMoradores[moradores.size()]="cancelar";
			int escolhaMorador=JOptionPane.showOptionDialog(null, listaNomes, "Editar Moradores", 0, 1, null, optionsMoradores, null);
			String detalhesMorador="Morador da rep�blica "+ rep.get(escolhaRep).getNome()+"\nNome:";
			if(escolhaMorador<moradores.size()) {
				detalhesMorador=detalhesMorador+moradores.get(escolhaMorador).getNome()+"\nEmail:"+moradores.get(escolhaMorador).getEmail()+"\nRendimento:"+moradores.get(escolhaMorador).getRend();
				String[] opcoesMorador= new String[4];
				opcoesMorador[0]="Editar Nome";
				opcoesMorador[1]="Editar email";
				opcoesMorador[2]="Editar rendimento";
				opcoesMorador[3]="sair";
				int escolhaEditarMorador=JOptionPane.showOptionDialog(null, detalhesMorador, "Editar Morador", 0, 1, null, opcoesMorador, null);
				if(escolhaEditarMorador==0) {
					moradores.get(escolhaMorador).setNome(JOptionPane.showInputDialog("Digite o novo Nome para o Morador"));
				}
				if(escolhaEditarMorador==1) {
					moradores.get(escolhaMorador).setEmail(JOptionPane.showInputDialog("Digite o novo email para o Morador"));
				}
				if(escolhaEditarMorador==2) {
					moradores.get(escolhaMorador).setRend(Double.parseDouble(JOptionPane.showInputDialog("Digite o novo Rendimento para o Morador")));
				}
			}
		}
		
		return rep;
	}
	
	public static void main(String[] args) {
		// core
		int escolhaRep = 0;
		boolean isOpen = true;
		boolean republicaEscolhida=false;
		LinkedList<Republica> rep = new LinkedList<Republica>();
		while (isOpen == true) {
			escolhaRep=seletorDeRepublica(rep);
			if (escolhaRep == rep.size() + 2) {
				isOpen = false;
			}
			if (escolhaRep == rep.size()) {
				rep = criarRepublica(rep);
			}
			if (escolhaRep == rep.size() + 1) {
				rep = apagarRepublica(rep);
			}
			if (escolhaRep >= 0 && escolhaRep < rep.size()) {
				republicaEscolhida=true;
				while (republicaEscolhida==true) {
					int escolha=editarRepublica(rep,escolhaRep);
					if(escolha==0) {
						rep=mudarNome(rep,escolhaRep);
					}
					if(escolha==1) {
						rep=editarMoradores(rep,escolhaRep);
					}
					if(escolha==2) {
						//despesas
					}
					if(escolha==3) {
						republicaEscolhida=false;
					}
				
				}

			}

		}
	}
}