package Morador;
	
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

	public class ListaMoradores {
		
		static Scanner reader = new Scanner(System.in);
		
		ArrayList<Morador> cadastro = new ArrayList<>();
	
		private String nome;
		private String email;
		private double rendimento;
		
		
		public static void main(String [] args) throws IOException {
			
			File fileName = new File("Moradores.txt");
			
			ListaMoradores obj = new ListaMoradores();
			
			String nome, email;
			double rendimento;
			
			Morador m;
			
			do {
				
				nome=JOptionPane.showInputDialog("Digite o nome do Morador:");
				email=JOptionPane.showInputDialog("Digite o email do Morador:");
				rendimento= Integer.parseInt(JOptionPane.showInputDialog("Digite o Rendimento do Morador:"));

				
				m = new Morador(nome,email,rendimento);
				
				obj.cadastro.add(m);
				
			}while("1".equals(JOptionPane.showInputDialog("Digite 1 para continuar")));
			
			
			for(int i=0; i<obj.cadastro.size();i++) {
				
				
				JOptionPane.showMessageDialog(null, obj.cadastro.get(i).getNome() + "\n" + obj.cadastro.get(i).getEmail() + "\n"+ obj.cadastro.get(i).getRendimento());
				
				try {
		            
					fileName.createNewFile();
		           
		            FileWriter fileWriter = new FileWriter(fileName, false);
		            PrintWriter printWriter = new PrintWriter(fileWriter);
		            
		            //Utilizo o método print() para escrever na
		            // mesma linha e um ponto e vírgula no final.
		            //O println forçará a troca de linha
		            // para o próximo Morador.
		            
		            int sz = obj.cadastro.size();
		            
		            for (int j=0; j<sz ; j++) {
		                printWriter.print(obj.cadastro.get(j).getNome() + ",");
		                printWriter.print(obj.cadastro.get(j).getEmail() + ",");
		                printWriter.println(obj.cadastro.get(j).getRendimento());
		            }
		            printWriter.flush();
		            printWriter.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				
				try {
		            FileReader fileReader = new FileReader(fileName);
		            BufferedReader bufferedReader = new BufferedReader(fileReader);
		            String linha = "";

		            //Lista que irá guardar o resultado, ou seja,
		            // cada linha do arquivo que corresponde a um Morador
		           
		            ArrayList result = new ArrayList();

		            while ((linha = bufferedReader.readLine()) != null) {
		                System.out.println(linha);
		                if (linha != null && !linha.isEmpty()) 
		                {
		                    result.add(linha);
		                }
		            }
		            fileReader.close();
		            bufferedReader.close();

		            for (String s : result) {
		                //Uso do método split da classe String
		                // para separar as partes entre os ponto e vírgulas.
		                //Guardando o resultado em um array
		                
				 String[] user = s.split(";");

		                //Criando um objeto Morador e setando em seus atributos
		                //as posições correspondentes do array
		              
		                Morador m1 = new Morador(s, s, rendimento);
		              
		                m1.setNome(user[0]);
		                m1.setEmail(user[1]);
		                m1.setRendimento(Integer.valueOf(user[2]));

		                //exibe o conteúdo do objeto m1
		                System.out.println(m1.toString());
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

		    }
		
			JOptionPane.showMessageDialog(null,"Dados cadastrados com sucesso!");	
	}
}
		
		



	
	
