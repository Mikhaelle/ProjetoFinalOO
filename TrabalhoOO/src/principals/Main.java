package principals;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import CalculoPagamento.Categoria;
import CalculoPagamento.Despesa;
import CalculoPagamento.SubCategoria;
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
		if(rep.size()==0) {
			JOptionPane.showMessageDialog(null, "n�o h� nenhuma rep�blica para apagar!");
		}
		else {
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
	
	private static int editarDespesaTotal(LinkedList<Republica> rep, int escolhaRep) {
		String mensagem="H� um total de R$"+rep.get(escolhaRep).getValorDespesas()+" em despesas.\n As despesas est�o divididas em "+rep.get(escolhaRep).categorias.size()+" categorias:\n\nS�o essas:";
		String listaCat="";
		String[] opcoesCat=new String[rep.get(escolhaRep).categorias.size()+2];
		for(int i=0;i<rep.get(escolhaRep).categorias.size();i++) {
			listaCat=listaCat+"\n"+rep.get(escolhaRep).categorias.get(i).getDescricaoCategoria();
			listaCat=listaCat+"     =>    "+rep.get(escolhaRep).categorias.get(i).getTotalCategoria();
			opcoesCat[i]=rep.get(escolhaRep).categorias.get(i).getDescricaoCategoria();	
		}
		opcoesCat[rep.get(escolhaRep).categorias.size()]="Criar nova Categoria";
		opcoesCat[rep.get(escolhaRep).categorias.size()+1]="Voltar";
		
		int escolhaCat=JOptionPane.showOptionDialog(null, mensagem+listaCat, "Editar Despesas", 0, 1, null, opcoesCat, null);
		
		return escolhaCat;
	}
	
	private static void criarDespesa(Republica rep) {
		String cat=JOptionPane.showInputDialog("Qual a Categoria da despesa?");
		Categoria catExiste=rep.pesquisarCategoria(cat);
		if (catExiste==null) {
			rep.categorias.add(rep.novaCategoria(cat));
		}
		String sub=JOptionPane.showInputDialog("Qual a Subcategoria da despesa?");
		SubCategoria subExiste=rep.pesquisarCategoria(cat).pesquisarSubCategoria(sub);
		if (subExiste==null) {
			rep.pesquisarCategoria(cat).cadastrarSubcategoria(sub);
		}
		double valor=Double.parseDouble(JOptionPane.showInputDialog("Qual o valor da despesa?"));
		Despesa desp=new Despesa(valor,rep.pesquisarCategoria(cat).pesquisarSubCategoria(sub),rep);
		rep.pesquisarCategoria(cat).pesquisarSubCategoria(sub).adicionarDespesa(desp);
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
						int escolhaCat=0;
						while(escolhaCat>=0&&escolhaCat<=rep.get(escolhaRep).categorias.size()) {
							escolhaCat=editarDespesaTotal(rep,escolhaRep);			
							if(escolhaCat==rep.get(escolhaRep).categorias.size()) {
								criarDespesa(rep.get(escolhaRep));
							}
							if(escolhaCat>=0&&escolhaCat<rep.get(escolhaRep).categorias.size()){
								LinkedList<SubCategoria> sub=rep.get(escolhaRep).categorias.get(escolhaCat).getSubs();
								String listSubs="";
								String[] opcaoSub= new String[sub.size()+2]; 
								for(int i=0; i<sub.size();i++) {
									listSubs+="\n"+sub.get(i).getDescricaoSubCategoria()+"   =>   "+sub.get(i).getTotalSub();
									opcaoSub[i]=sub.get(i).getDescricaoSubCategoria();
									
								}
								opcaoSub[sub.size()]="Excluir despesa";
								opcaoSub[sub.size()+1]="Voltar";
								String mensagem="A categoria "+rep.get(escolhaRep).categorias.get(escolhaCat).getDescricaoCategoria()+" possui as seguintes subCategorias:\n"+listSubs;
								int escolhaSub=JOptionPane.showOptionDialog(null, mensagem, "Editar SubCategorias", 0, 1, null, opcaoSub, null);
							}
						
						//editarSubs(rep,escolhaRep,escolhaCat);
					
						}
					}
					if(escolha==3) {
						republicaEscolhida=false;
					}
				}
			}
					
				
		}

			}

	}

	
