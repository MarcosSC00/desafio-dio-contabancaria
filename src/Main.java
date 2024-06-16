import adaptadores.controladores.ContaController;
import aplicacao.servicos.ContaServico;
import repositorios.ContaRepositorioIpml;

public class Main {

	public static void main(String[] args) {

		ContaRepositorioIpml contaRepository = new ContaRepositorioIpml();
		ContaServico contaService = new ContaServico(contaRepository);
		ContaController contaController = new ContaController(contaService);

		//Criando contas
		contaController.criarConta("Marcos", "cc");
		contaController.criarConta("Joao", "cc");
		
		//Depositando em uma conta
		contaController.depositar("marcos", 1000);
		
		//Transferencia
		contaController.transferir(500, "marcos", "Joao");;

		//Impressao das contas existentes
		System.out.println(contaRepository.listarContas());

		//Deletando uma conta
		contaController.deletarContaPorNome("paulo");
		
		//Atualizando uma conta
		contaController.atualizarConta("Joao", "Fabio");

		//Impressao das contas existentes apos aplicacoes de metodos
		System.out.println(contaRepository.listarContas());

	}

}
