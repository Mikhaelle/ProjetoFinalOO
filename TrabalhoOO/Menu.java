import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		
		Arquivo a = new Arquivo();
		Scanner leerN=new Scanner(System.in);
		Scanner leerC=new Scanner(System.in);
		
		int option = 0;
		
		while(option!=4){
		System.out.println("Menu");
		System.out.println("1 - Para inserir novo Morador");
		System.out.println("2 - Para ler o arquivo");
		System.out.println("3 - Buscar nome no Arquivo");
		System.out.println("4 - Excluir Nome: ");
		System.out.println("5 - Sair");
		try {
			option=leerN.nextInt();
			}
		catch(Exception e) {
			leerN=new Scanner(System.in);
		
		}
		switch(option) {
		
		case 1:
			System.out.println("Escreva o nome: ");
			String nome=leerC.nextLine();
			System.out.println("Escreva o Email: ");
			String email=leerC.nextLine();
			System.out.println("Escreva o Rendimento: ");
			String rendimento=leerC.nextLine();
			
			Morador m = new Morador(nome,email,rendimento);
			
			a.escreverMorador(m);
			break;
			
		case 2:
			a.imprimir();
			break;
			
		case 3: 
			System.out.println("Escreva o nome que deseja buscar: ");
			String nomeB = leerC.nextLine();
			a.buscar(nomeB);
			break;
			
		case 4:
			System.out.println("Escreva o nome que deseja EXCLUIR: ");
			String nomeE = leerC.nextLine();
			a.excluir(nomeE);
			break;
		case 5:
			break;
		default:
			System.out.println("Opcao Invalida!!");
			break;
		
		}
		
		}
	}

}
