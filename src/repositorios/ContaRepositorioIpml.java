package repositorios;

import java.util.ArrayList;
import java.util.List;

import domain.entidades.Cliente;
import domain.entidades.Conta;

public class ContaRepositorioIpml implements ContaRepositorioNaMemoria {

	public List<Conta> contas = new ArrayList<>();

	@Override
	public void salvarConta(Conta conta) {

		contas.add(conta);
	}

	@Override
	public Conta buscarContaPorNome(String nome) {

		return contas.stream().filter(e -> e.getCliente().getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
	}

	@Override
	public List<Conta> listarContas() {
		System.out.println("************* Listando todas as Contas *************");
		return contas;
	}

	@Override
	public void deletarContaPorNome(String nome) {
		Conta conta = buscarContaPorNome(nome);
		if(conta != null) {
			contas.remove(conta);
			System.out.println("************* Usuario "+nome+" deletado *************");
		}else
			throw new RuntimeException("Usuario não encontrado");
	}

	@Override
	public Conta atualizarConta(String nome, String novoNome) {
		Cliente novoCliente = new Cliente();
		novoCliente.setNome(novoNome);
		Conta conta = buscarContaPorNome(nome);
		conta.setCliente(novoCliente);
		System.out.println("************* Conta atualizada *************");
		return conta;
	}

}
