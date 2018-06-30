import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
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
			String line;
			
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
		            
		            //Utilizamos o método print() para escrever na
		            // mesma linha e um ponto e vírgula no final.
		            //O println forçará a troca de linha
		            // para o próximo user.
		            
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

				
				
	/*		}try {
				
				FileWriter fw = new FileWriter(fileName);
				Writer output = new BufferedWriter(fw);
				int sz = obj.cadastro.size();
				
				for(int i= 0; i<sz; i++) {
					
					output.write(obj.cadastro.get(i).getNome() + "," + obj.cadastro.get(i).getEmail() + ","+ obj.cadastro.get(i).getRendimento().toString()+ "\n");
				}
				output.close();
				
			}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Não posso criar o Arquivo");
				}
			
		try {
				BufferedReader input = new BufferedReader(new FileReader(fileName));
				if(!input.ready()) {
					throw new IOException();
				}
				while ((line = input.readLine()) != null) {
					obj.cadastro.add(line);
				}
			input.close();
			}
			catch (IOException e) {
				System.out.println(e);
			}
			
			// print os nomes da lista
			
			int sz = obj.cadastro.size();
			for (int i = 0; i< sz; i++ ) {
				System.out.println(obj.cadastro.get(i).toString());
				
			} */
		
		}
			JOptionPane.showMessageDialog(null,"Dados cadastrados com sucesso!");
		}}
			
	/*			try {
		            // Conteudo
		            String content = "Teste maria";

		            // Cria arquivo
		            File file = new File("dados.txt");

		            // Se o arquivo nao existir, ele gera
		            if (!file.exists()) {
		                file.createNewFile();
		            }

		            // Prepara para escrever no arquivo
		            FileWriter fw = new FileWriter("dados.txt");
		            BufferedWriter bw = new BufferedWriter(fw);
		            
		            // Escreve e fecha arquivo
		            bw.write(content);
		            bw.close();
		            
		            // Le o arquivo
		            FileReader ler = new FileReader("dados.txt");
		            BufferedReader reader = new BufferedReader(ler);  
		            String linha;
		            while( (linha = reader.readLine()) != null ){
		                System.out.println(linha);
		            }

		            // Imprime confirmacao
		            System.out.println("Feito =D");

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				
				
			}
			JOptionPane.showMessageDialog(null,"Dados cadastrados com sucesso!");
			
			//JOptionPane.showMessageDialog(null, this.nome +this.email+ this.rendimento);
			
			
			
		//	JOptionPane.showMessageDialog(null, "Número de Cadastros", cadastro.size());
		
			
				
		}}
				
				
		/*		PrintWriter pw = new PrintWriter(fw);
				pw.println("Nome: " + d.nome);
				pw.println("Email: " + d.email);
				pw.println("Rendimento: " +d.rendimento);
				pw.close();
				fw.close();
				
			} catch (IOException ex) {
			
				Logger.getLogger(Dados.class.getName()).log(Level.SEVERE,null,ex);	
			}
			//JOptionPane.showMessageDialog(null, this.nome +this.email+ this.rendimento);
		}*/
			
		
		



	
	
