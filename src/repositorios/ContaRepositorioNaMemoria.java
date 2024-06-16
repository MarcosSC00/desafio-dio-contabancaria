package repositorios;

import java.util.List;

import domain.entidades.Conta;

public interface ContaRepositorioNaMemoria {
	void salvarConta(Conta conta);
	Conta buscarContaPorNome(String nome);
	List<Conta> listarContas();
	void deletarContaPorNome(String nome);
	Conta atualizarConta(String nome, String novoNome);
}
