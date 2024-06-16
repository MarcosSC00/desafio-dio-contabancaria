package aplicacao.servicos;

import java.util.List;

import domain.entidades.Conta;
import repositorios.ContaRepositorioNaMemoria;

public class ContaServico {

	private ContaRepositorioNaMemoria contaRepositorio;

	public ContaServico(ContaRepositorioNaMemoria contaRepositorio) {
		this.contaRepositorio = contaRepositorio;
	}

	public void criarConta(Conta conta) {
		contaRepositorio.salvarConta(conta);
	}

	public Conta buscarContaPorNome(String nome) {
		return contaRepositorio.buscarContaPorNome(nome);
	}

	public List<Conta> listarContas() {
		return contaRepositorio.listarContas();
	}

	public void deletarContaPorNome(String nome) {
		this.contaRepositorio.deletarContaPorNome(nome);
	}

	public Conta atualizarConta(String nome, String novoNome) {
		return contaRepositorio.atualizarConta(nome, novoNome);
	}
}
