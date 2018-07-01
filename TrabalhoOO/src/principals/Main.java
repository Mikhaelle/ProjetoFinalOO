package principals;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import Calculo.RegraIgualitaria;
import Calculo.RegraProporcional;
import Gasto.Categoria;
import Gasto.Despesa;
import Gasto.SubCategoria;
import Moradia.Morador;
import Moradia.Republica;

public class Main {
	private static int seletorDeRepublica(LinkedList<Republica> rep) {
		String[] optMenu = new String[rep.size() + 3];
		optMenu[rep.size()] = "Nova República";
		optMenu[rep.size() + 1] = "excluir república";
		optMenu[rep.size() + 2] = "Fechar";
		for (int i = 0; i < rep.size(); i++) {
			optMenu[i] = rep.get(i).getNome();
		}
		int escolhaRep = JOptionPane.showOptionDialog(null,
				
				"Bem vindo ao Gerenciador Financeiro para repúblicas\n\n Crie, delete ou escolha uma república que deseja editar",
				"Gerenciador Financeiro - Seletor de República", 0, 1, null, optMenu, null);
		return escolhaRep;
	}

	private static LinkedList<Republica> criarRepublica(LinkedList<Republica> rep) {
		String nomeRep = JOptionPane.showInputDialog(null, "Por favor, insira o nome da nova república",
				"Nova república", 1);		
		Republica newRep = new Republica(nomeRep);
		rep.add(newRep);
		return rep;
	}

	private static LinkedList<Republica> apagarRepublica(LinkedList<Republica> rep) {
		if(rep.size()==0) {
			JOptionPane.showMessageDialog(null, "não há nenhuma república para apagar!");
		}
		else {
			String titleApagar = "Apagar República";
			String messageApagar = "Clique na república que deseja apagar";
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
		String message = "República " + rep.get(escolhaRep).getNome() + "\n\nO que deseja fazer?";
		String[] options = new String[4];
		options[0] = "Editar Nome";
		options[1] = "Editar Moradores";
		options[2] = "Editar Despesas";
		options[3] = "Voltar à seleção de repúblicas";
		String title = "Editar República " + rep.get(escolhaRep).getNome();
		int escolha = JOptionPane.showOptionDialog(null, message, title, 0, 1, null, options, null);
		return escolha;
	}

	private static LinkedList<Republica> mudarNome(LinkedList<Republica> rep, int escolhaRep) {
		String novoNome = JOptionPane
				.showInputDialog("Insira o novo nome da República " + rep.get(escolhaRep).getNome());
		rep.get(escolhaRep).setNome(novoNome);
		return rep;
	}

	private static LinkedList<Republica> editarMoradores(LinkedList<Republica> rep, int escolhaRep) {
		if (rep.get(escolhaRep).getMoradores().size() == 0) {
			int yesNo = JOptionPane.showConfirmDialog(null,
					"Não há nenhum morador cadastrado nessa república!\n\nDeseja cadastrar um morador?",
					"Editar Moradores", 0);
			if (yesNo == 0) {
				// essa é a opção "sim"
				rep.get(escolhaRep).cadastroMorador();
			}
		} else {
			List<Morador> moradores = rep.get(escolhaRep).getMoradores();
			String listaNomes = "Há " + moradores.size() + " moradores estão cadastrados na república "
					+ rep.get(escolhaRep).getNome() + "\n";
			String[] optionsMoradores = new String[moradores.size() + 2];
//			if(rep.get(escolhaRep).categorias.size()>0) {
//				RegraIgualitaria novaregra=new RegraIgualitaria(rep.get(escolhaRep));
//				novaregra.aplicarRegra(rep.get(escolhaRep));
//			}
			for (int i = 0; i < moradores.size(); i++) {
				listaNomes = listaNomes +"-"+ moradores.get(i).getNome() +"   =>R$"+moradores.get(i).getParcela() +"\n";
				optionsMoradores[i] = moradores.get(i).getNome();
			}
			optionsMoradores[moradores.size()] = "Escolher Regra de divisão";
			optionsMoradores[moradores.size()+1] = "cancelar";
			int escolhaMorador = JOptionPane.showOptionDialog(null, listaNomes, "Editar Moradores", 0, 1, null,
					optionsMoradores, null);
			String detalhesMorador = "Morador da república " + rep.get(escolhaRep).getNome() + "\nNome:";
			if (escolhaMorador < moradores.size()&&escolhaMorador>=0) {
				detalhesMorador = detalhesMorador + moradores.get(escolhaMorador).getNome() + "\nEmail:"
						+ moradores.get(escolhaMorador).getEmail() + "\nRendimento:"
						+ moradores.get(escolhaMorador).getRend();
				String[] opcoesMorador = new String[4];
				opcoesMorador[0] = "Editar Nome";
				opcoesMorador[1] = "Editar email";
				opcoesMorador[2] = "Editar rendimento";
				opcoesMorador[3] = "sair";
				int escolhaEditarMorador = JOptionPane.showOptionDialog(null, detalhesMorador, "Editar Morador", 0, 1,
						null, opcoesMorador, null);
				if (escolhaEditarMorador == 0) {
					moradores.get(escolhaMorador)
							.setNome(JOptionPane.showInputDialog("Digite o novo Nome para o Morador"));
				}
				if (escolhaEditarMorador == 1) {
					moradores.get(escolhaMorador)
							.setEmail(JOptionPane.showInputDialog("Digite o novo email para o Morador"));
				}
				if (escolhaEditarMorador == 2) {
					moradores.get(escolhaMorador).setRend(
							Double.parseDouble(JOptionPane.showInputDialog("Digite o novo Rendimento para o Morador")));
				}
			}
			if(escolhaMorador==moradores.size()) {
				String Mensagem="Qual dos métodos de divisão abaixo deseja aplicar na república "+ rep.get(escolhaRep).getNome()+"?";
				String[] opcoesRegra=new String[2];
				opcoesRegra[0]="Regra Igualitária";
				opcoesRegra[1]="Regra Proporcional";
				int escolhaRegra=JOptionPane.showOptionDialog(null, Mensagem, "Escolha do método de divisão", 0, 1, null, opcoesRegra, null);
				if(escolhaRegra==0) {
					RegraIgualitaria novaregra=new RegraIgualitaria(rep.get(escolhaRep));
					novaregra.aplicarRegra(rep.get(escolhaRep));
				}
				if(escolhaRegra==1) {
					RegraProporcional novaregra=new RegraProporcional(rep.get(escolhaRep));
					novaregra.aplicarRegra(rep.get(escolhaRep));
				}
			}
		}

		return rep;
	}
	
	private static int editarDespesaTotal(LinkedList<Republica> rep, int escolhaRep) {
		String mensagem="Há um total de R$"+rep.get(escolhaRep).getValorDespesas()+" em despesas.\n As despesas estão divididas em "+rep.get(escolhaRep).categorias.size()+" categorias:\n\nSão essas:";
		String listaCat="";
		String[] opcoesCat=new String[rep.get(escolhaRep).categorias.size()+2];
		for(int i=0;i<rep.get(escolhaRep).categorias.size();i++) {
			listaCat=listaCat+"\n"+rep.get(escolhaRep).categorias.get(i).getDescricaoCategoria();
			listaCat=listaCat+"     =>    "+rep.get(escolhaRep).categorias.get(i).getTotalCategoria();
			opcoesCat[i]=rep.get(escolhaRep).categorias.get(i).getDescricaoCategoria();	
		}
		opcoesCat[rep.get(escolhaRep).categorias.size()]="Criar nova Despesa";
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
		String desc=JOptionPane.showInputDialog("Insira uma descrição ou data para a despesa");
		Despesa desp=new Despesa(valor,desc,rep.pesquisarCategoria(cat).pesquisarSubCategoria(sub),rep);
		rep.pesquisarCategoria(cat).pesquisarSubCategoria(sub).adicionarDespesa(desp);
	}

	private static void editarSub(SubCategoria sub) {
		String listDesp="A SubCategoria "+sub.getDescricaoSubCategoria()+" corresponde a R$"+sub.getTotalSub()+" em despesas.\n As despesas dessa Subcategoria são:\n";
		String[] opcoesDesp=new String[sub.getDesps().size()+1];
		for(int i=0;i<sub.getDesps().size();i++) {
			listDesp+="\n"+sub.getDesps().get(i).getDesc()+"   =>   "+sub.getDesps().get(i).getValor();
			opcoesDesp[i]=sub.getDesps().get(i).getDesc();
		}
		listDesp+="\n\n Deseja apagar alguma despesa, ou voltar?";
		opcoesDesp[sub.getDesps().size()]="Voltar";
		int apagarDesp=JOptionPane.showOptionDialog(null, listDesp, "Apagar Despesa", 0, 0, null, opcoesDesp, null);
		if (apagarDesp>=0&&apagarDesp<sub.getDesps().size()) {
			sub.retirarDespesa(sub.getDesps().get(apagarDesp));
		}
		
	}
	
	public static void main(String[] args) {
		// core
		int escolhaRep = 0;
		boolean isOpen = true;
		boolean republicaEscolhida = false;
		LinkedList<Republica> rep = new LinkedList<Republica>();
		while (isOpen == true) {
			escolhaRep = seletorDeRepublica(rep);
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
				republicaEscolhida = true;
				while (republicaEscolhida == true) {
					int escolha = editarRepublica(rep, escolhaRep);
					if (escolha == 0) {
						rep = mudarNome(rep, escolhaRep);
					}
					if (escolha == 1) {
						rep = editarMoradores(rep, escolhaRep);
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
								String[] opcaoSub= new String[sub.size()+1]; 
								for(int i=0; i<sub.size();i++) {
									listSubs+="\n"+sub.get(i).getDescricaoSubCategoria()+"   =>   "+sub.get(i).getTotalSub();
									opcaoSub[i]=sub.get(i).getDescricaoSubCategoria();
									
								}
								opcaoSub[sub.size()]="Voltar";
								String mensagem="A categoria "+rep.get(escolhaRep).categorias.get(escolhaCat).getDescricaoCategoria()+
										" corresponde a R$"+rep.get(escolhaRep).categorias.get(escolhaCat).getTotalCategoria()+
										" das despesas da república.\n"+rep.get(escolhaRep).categorias.get(escolhaCat).getDescricaoCategoria()+
										" possui as seguintes subCategorias:\n"+listSubs;
								int escolhaSub=JOptionPane.showOptionDialog(null, mensagem, "Editar Categorias", 0, 1, null, opcaoSub, null);
								if (escolhaSub>=0&&escolhaSub<sub.size()) {
									editarSub(sub.get(escolhaSub));
								}
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

