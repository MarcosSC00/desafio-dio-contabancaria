# **Desafio-DIO-Conta_Bancaria**

Nesse projeto desenvolvo uma aplicação com base nos pilares da **Programação Orientada a Objetos (POO)** - **`Encapsulamento`, `Abstração`, `Herança` e `Polimorfismo`**.

## **Descrição**

O programa consiste em reproduzir funcionalidades básicas de uma conta bancária utilizando a linguagem **`Java`** apicando a **`Clean Architecture`** na estrutura do projeto.

## **Funcionalidades**

- **`Criar conta bancária`**: Permite a criação de novas contas bancárias com um saldo inicial zerado, um valor predefinido para a agência e um valor para o número da conta que será incrementado a cada criação de uma nova conta.

  > [!NOTE]
  > O nome do cliente e tipo de conta devem ser informados ao criar uma conta.

  ```java
  public void criarConta(String nome, String tipoConta) {
    //Implementação
  }
  ```

- **`Sacar`**: Permite retirar fundos da conta bancária, se houver saldo disponível. Aqui são lançadas exceções em caso de erros de entrada.

  ```java
  public void sacar(String nome, double valor) {
    //Implentação
  }
  ```

- **`Depositar`**: Permite adicionar fundos à conta bancária. Aqui também são lançadas exceções em caso de erros de entrada.

  ```java
  public void depositar(String nome, double valor) {
    //Implentação
  }
  ```

- **`Transferir`**: Permite transferir um determinado valor de uma conta origem para uma conta destino.

  ```java
  public void transferir(double valor, String clienteOrigem, String clienteDestino) {
      //Implementação
    }
  ```

- **`Deletar Conta`**: Permite deletar uma conta por meio do nome de um cliente existente, lançando uma exceção caso não o encontre.
  ```java
  public void deletarContaPorNome(String nome) {
  	//Implementação
  }
  ```
- **`Atualizar Conta`**: Permite atualizar o nome do cliente da conta.

  ```java
  public Conta atualizarConta(String nome, String novoNome) {
      //Implementação
    }
  ```

- **`Buscar conta por nome`**: Retorna uma conta a partir do nome de usuário caso exista.

  ```java
  public Conta buscarContaPorNome(String nome){
    //Implementação
  }
  ```

- **`Listar Contas`**: Exibe as contas existentes em memória.
  ```java
  public List<Conta> listarContas() {
    //Implementação
  }
  ```

## **Conclusão**

Esse projeto proporcionou grande aprendizados em relação as possibilidades oferecidas pelos paradigmas da **`POO`**.

Usar o padrão da **`Clean Architecture`** possibilita a essa aplicação, caso necessário, a integração de um banco de dados e frameworks relacionados para armazenamento de dados sem muitas alterações na estrutura do projeto.

Os estudos de casos e teorias relacionados à implentação desse projeto foram oferdados pela plataforma [**DIO**](https://www.dio.me).
