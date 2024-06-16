package adaptadores.controladores;

import aplicacao.servicos.ContaServico;
import domain.entidades.Cliente;
import domain.entidades.Conta;
import domain.entidades.ContaCorrente;
import domain.entidades.ContaPoupanca;

public class ContaController {

	private ContaServico contaServico;

	public ContaController(ContaServico contaServico) {
		this.contaServico = contaServico;
	}

	public void criarConta(String nome, String tipoConta) {

		Conta conta;

		Cliente cliente = new Cliente();

		cliente.setNome(nome);

		switch (tipoConta) {
		case "cc":
			conta = new ContaCorrente(cliente);
			conta.setTipoConta("Conta Corrente");
			break;
		case "cp":
			conta = new ContaPoupanca(cliente);
			conta.setTipoConta("Conta Poupanca");
			break;
		default:
			throw new RuntimeException("Insira 'cc' para conta corrente ou 'cp' para conta poupanca.");
		}
		contaServico.criarConta(conta);
	}

	public void sacar(String nome, double valor) {
		Conta conta = contaServico.buscarContaPorNome(nome);
		conta.sacar(valor);
		System.out.println("************* Sacando: " + valor + " da conta do usuario " + nome+"*************");
	}

	public void depositar(String nome, double valor) {
		Conta conta = contaServico.buscarContaPorNome(nome);
		conta.depositar(valor);
		System.out.println("************* Depositando: " + valor + " na conta do usuario " + nome+"*************");
	}
	
	public void transferir(double valor, String clienteOrigem, String clienteDestino) {
		Conta contaOrigem = contaServico.buscarContaPorNome(clienteOrigem);
		Conta contaDestino = contaServico.buscarContaPorNome(clienteDestino);
		contaOrigem.transferir(valor, contaOrigem, contaDestino);
		System.out.println("************* Valor transferido: "+valor+" - Cliente Origem: "+clienteOrigem+" - Cliente Destino: "+clienteDestino);
	}

	public void deletarContaPorNome(String nome) {
		contaServico.deletarContaPorNome(nome);
	}

	public Conta atualizarConta(String nome, String novoNome) {
		return contaServico.atualizarConta(nome, novoNome);
	}
}
