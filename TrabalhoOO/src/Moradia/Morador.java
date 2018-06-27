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
}
