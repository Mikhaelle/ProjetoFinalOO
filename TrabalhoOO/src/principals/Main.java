package principals;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

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
			String listaNomes = "Há" + moradores.size() + "moradores estão cadastrados na república "
					+ rep.get(escolhaRep).getNome() + "\n";
			String[] optionsMoradores = new String[moradores.size() + 1];
			for (int i = 0; i < moradores.size(); i++) {
				listaNomes = listaNomes + moradores.get(i).getNome() + "\n";
				optionsMoradores[i] = moradores.get(i).getNome();
			}
			optionsMoradores[moradores.size()] = "cancelar";
			int escolhaMorador = JOptionPane.showOptionDialog(null, listaNomes, "Editar Moradores", 0, 1, null,
					optionsMoradores, null);
			String detalhesMorador = "Morador da república " + rep.get(escolhaRep).getNome() + "\nNome:";
			if (escolhaMorador < moradores.size()) {
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
		opcoesCat[rep.get(escolhaRep).categorias.size()]="Criar nova Categoria";
		opcoesCat[rep.get(escolhaRep).categorias.size()+1]="Voltar";
		
		int escolhaCat=JOptionPane.showOptionDialog(null, mensagem+listaCat, "Editar Despesas", 0, 1, null, opcoesCat, null);
		
		return escolhaCat;
	}
	private static int editarDespesas(LinkedList<Republica> rep, int escolhaRep) {
		String mensagem = "Há um total de R$" + rep.get(escolhaRep).getValorDespesas()
				+ " em despesas.\n As despesas estão divididas em " + rep.get(escolhaRep).categorias.size()
				+ " categorias:\n\nSão essas:";
		String listaCat = "";
		String[] opcoesCat = new String[rep.get(escolhaRep).categorias.size() + 2];
		for (int i = 0; i < rep.get(escolhaRep).categorias.size(); i++) {
			listaCat = listaCat + "\n" + rep.get(escolhaRep).categorias.get(i).getDescricaoCategoria();
			listaCat = listaCat + "     =>    " + rep.get(escolhaRep).categorias.get(i).getTotalCategoria();
			opcoesCat[i] = rep.get(escolhaRep).categorias.get(i).getDescricaoCategoria();

		}
		opcoesCat[rep.get(escolhaRep).categorias.size()] = "Criar nova Categoria";
		opcoesCat[rep.get(escolhaRep).categorias.size() + 1] = "Voltar";

		int escolhaCat = JOptionPane.showOptionDialog(null, mensagem + listaCat, "Editar Despesas", 0, 1, null,
				opcoesCat, null);

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
					
					if (escolha == 2) {
						int escolhaCat = 0;
						while (escolhaCat >= 0 && escolhaCat <= rep.get(escolhaRep).categorias.size()) {
							escolhaCat = editarDespesas(rep, escolhaRep);

							if (escolhaCat < rep.get(escolhaRep).categorias.size() && escolhaCat != -1) {
								Categoria cat = rep.get(escolhaRep).categorias.get(escolhaCat);
								double parcelaCat = 100 * rep.get(escolhaRep).getValorDespesas()
										/ cat.getTotalCategoria();
								String mensagem = "A categoria " + cat.getDescricaoCategoria() + " é responsável por "
										+ parcelaCat + "% das despesas da república " + rep.get(escolhaRep).getNome();
								String listaSub = "";
								for (int i = 0; i < cat.getSubs().size(); i++) {
									SubCategoria subCat = cat.getSubs().get(i);
									listaSub += "\n" + subCat.getDescricaoSubCategoria() + "     =>    "
											+ subCat.getTotalSub() + "\n 	Despesas:";
									for (int i2 = 0; i2 < subCat.getDesps().size(); i++) {
										Despesa desp = subCat.getDesps().get(i2);
										listaSub += "/n		" + desp.getValor();
									}
								}
								String[] opcaoCat = new String[1];
								opcaoCat[0] = "O O O";
								JOptionPane.showOptionDialog(null, listaSub, "Editar Categorias", 0, 1, null, opcaoCat,
										null);

							}
							if (escolhaCat == rep.get(escolhaRep).categorias.size()) {
								rep.get(escolhaRep).categorias.add(rep.get(escolhaRep).novaCategoria(
										JOptionPane.showInputDialog("Digite o nome da nova categoria:")));
							}
						
						//editarSubs(rep,escolhaRep,escolhaCat);
					
						}
					}
					if (escolha == 3) {
						republicaEscolhida = false;
					}
				}
			}
					
				
		}

			}

}


