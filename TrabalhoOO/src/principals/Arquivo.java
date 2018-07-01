package principals;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import Moradia.Republica;
import Moradia.Morador;


public class Arquivo {

	public static void escreverMorador(Morador novo) {
		
		try {
			
			File f= new File("Moradores.txt");
			FileWriter fw;
			BufferedWriter bw;
			
			if(f.exists() && f.length() != 0) {
				fw= new FileWriter(f,true);
				bw=new BufferedWriter(fw);
				bw.newLine();
				bw.write(novo.getNome()+","+novo.getEmail()+","+novo.getRend());
			}
			else {
				
				fw= new FileWriter(f);
				bw=new BufferedWriter(fw);
				bw.write(novo.getNome()+","+novo.getEmail()+","+novo.getRend());
				
			}
			bw.close();
			fw.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void excluirTxt(Morador mor) {
		try {
		File f= new File("Moradores.txt");
		if(f.exists()) {
			FileReader fr= new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linha;
			
			int numLinhas=0;
			
			while((linha = br.readLine())!=null) {
				
			numLinhas++;
			}
			
			String contatos [] = new String[numLinhas];
			br.close();
			fr.close();
			
			br = new BufferedReader(fr = new FileReader(f));
			
			int i=0;
			while((linha = br.readLine())!=null) {
				
				contatos[i]= linha;
				i++;
			}
			br.close();
			fr.close();
			FileWriter fw= new FileWriter(f);
			BufferedWriter bw=new BufferedWriter(fw);
			
			boolean sinal=false;
			boolean primeiraLinha = true;
			
			for(int j=0; j<contatos.length; j++) {
				
				String l []= contatos[j].split(",");
				if(l[0].equals(mor.getNome())) {
					sinal=true;
					System.out.println("Morador Eliminado!!");
				}else {
					if(primeiraLinha == true) {
					
						bw.write(contatos[j]);
						primeiraLinha = false;
					}
					else {
						bw.newLine();
						bw.write(contatos[j]);
					}
				}
			}
				if(sinal==false) {
					System.out.println("Contato não Encontrado!");
				}
				bw.close();
				fw.close();
				if(numLinhas==1 && sinal==true) {
					f.delete();
				}
		}
				else {
					System.out.println("Esse nome não Existe!!");
		}
	}
		catch(Exception e)
		{
		System.out.println(e);
	    }
}
	
	public void buscar(String nomeB,Republica rep) {
		try {
			File f= new File("Moradores.txt");
			if(f.exists()) {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String linha;
				
				boolean sinal=false;
	
				while((linha = br.readLine())!= null) {
					String contato [] = linha.split(",");
					if(contato[0].equals(nomeB)) {
					sinal = true;	
					Morador mor = new Morador(contato[0],contato[1],Double.parseDouble(contato[2]));
					
					System.out.println("Nome Encontrado!");
					rep.cadastroMorador();
					}
				}
				br.close();
				fr.close();
			}
				
			
			
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	 

////	public void imprimir() {
//		try {
//			File f=new File("Moradores.txt");
//			if(f.exists()) {
//				FileReader fr = new FileReader(f);
//				BufferedReader br = new BufferedReader(fr);
//				String linha;
//				while((linha = br.readLine()) != null) {
//					
//					//(String nome, String email, String rendimento)
//					
//					String [] contato = linha.split(",");
//					
//					Morador m = new Morador(contato[0],contato[1],contato[2]);
//					
//					m.adicionarMorador();
//					System.out.println("***********************");
//						
//				}
//				fr.close();
//				br.close();
//			}
//			else 
//				{
//				
//				System.out.println("Arquivo não existe");
//				}
//				}catch(Exception e) {
//					System.out.println(e);
//				}
//	}
}
