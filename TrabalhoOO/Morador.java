public class Morador {
	
	String nome, email, rendimento;
	
	public Morador(String nome, String email, String rendimento) {
		
		this.nome=nome;
		this.email=email;
		this.rendimento=rendimento;
		
	}

	public void adicionarMorador() {
		System.out.println("Nome: "+nome);
		System.out.println("Email: "+email);
		System.out.println("Rendimento: "+rendimento);
		
	}
}
