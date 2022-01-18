package main;
public class Conta extends Cliente{
	private int agencia, numero;
	private double saldo;
	
	// constructors
	public Conta(String nome, String cpf, int agencia, int numero, double saldo) {
		super(nome, cpf);
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
	}

	// Getters, Setters and Methods
	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	// Consultar saldo(Extrato)
	public double getSaldo() {
		return saldo;
	}
	
	// Depositar
	public void depositar(double valor) {
		this.saldo = this.saldo + valor;
	}
	
	// Sacar
	public void sacar(double valor) {
		this.saldo = this.saldo - valor;
	}
	/*
	public void transferir(double valor, Conta contaDestito) {
        this.sacar(valor);
        contaDestito.depositar(valor);
    }
    */
	public void transferir(double valor, String cpfDestino) {
        this.sacar(valor);
    }
}
