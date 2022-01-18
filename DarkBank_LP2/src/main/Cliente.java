package main;
public class Cliente {
	private String nome, cpf;

	// constructor
	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	
	// Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
