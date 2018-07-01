package Moradia;

public class Morador {
	private String nome;
	private String email;
	private double rendimento;
	private double parcela=0;

	public Morador(String n, String e, double r) {
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
	public double getParcela() {
		return parcela;
	}
	public void setParcela(double newParcela) {
		parcela=newParcela;
	}
}
