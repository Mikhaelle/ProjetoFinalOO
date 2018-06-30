package Moradia;

public class Morador {
	private String nome;
	private String email;
	private double rendimento;

	public Morador(String n, String e, float r) {
		nome = n;
		email = e;
		rendimento = r;
	}
	public double getRend() {
		return rendimento;
	}
	public void setRend(double novoRend) {
		rendimento=novoRend;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String novoNome) {
		nome=novoNome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String novoEmail) {
		email=novoEmail;
	}
}
