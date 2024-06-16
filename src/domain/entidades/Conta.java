package domain.entidades;

import entidades.IConta;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected String tipoConta;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.tipoConta = null;
		this.saldo = 0d;
	}

	@Override
	public void sacar(double valor) {
		try {
			if (valor <= 0d)
				throw new IllegalArgumentException("O valor do deposito deve ser positivo.");
			if (valor >= this.saldo)
				throw new RuntimeException("Saldo insuficiente para realizar o saque");
		} catch (NumberFormatException e) {
			throw new RuntimeException("Valor de saque invalido");
		}
		this.saldo -= valor;
	}

	public void depositar(double valor) {

		try {
			if (valor <= 0d)
				throw new IllegalArgumentException("O valor do deposito deve ser positivo.");
		} catch (NumberFormatException e) {
			throw new RuntimeException("Valor de deposito invalido");
		}
		this.saldo += valor;

	}

	@Override
	public void transferir(double valor, IConta contaOrigem, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);

	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

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

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	@Override
	public String toString() {
		return "{ agencia=" + agencia + "\n numero=" + numero + "\n saldo=" + saldo + "\n cliente= " + cliente + "\n tipo de conta: "+tipoConta+"}";
	}

}
