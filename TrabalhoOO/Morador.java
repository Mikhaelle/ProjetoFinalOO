public class Morador {
	
	private String nome;
	private String email;
	private Double rendimento;
	
	Morador(String nome, String email, double rendimento){
		
		this.nome=nome;
		this.email=email;
		this.rendimento=rendimento;
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}


}

