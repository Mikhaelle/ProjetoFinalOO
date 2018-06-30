public class Morador {
	
	private String nome;
	private String email;
	private String rendimento;
	
	Morador(String nome, String email, String rendimento){
		
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

	public String getRendimento() {
		return rendimento;
	}

	public void setRendimento(String rendimento) {
		this.rendimento = rendimento;
	}


}

