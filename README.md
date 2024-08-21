# Sistema de Gerenciamento de Estoque

## Propósito do Projeto

Este projeto foi desenvolvido para implementar um sistema de gerenciamento de estoque em Java, utilizando uma árvore binária de busca (BST - Binary Search Tree). O sistema é capaz de realizar operações de inserção, remoção, busca e listagem de produtos, mantendo os dados organizados de maneira eficiente.

## Organização do Projeto

O projeto está organizado da seguinte forma:

# Estrutura do Projeto
 ```\
├── src\
│   ├── main\
│   │   └── java\
│   │       └── br\
│   │           └── ufrn\
│   │               ├── domain\
│   │               │   ├── Produto.java\
│   │               │   ├── ProdutoEletronico.java\
│   │               │   └── ProdutoPeriferico.java\
│   │               ├── exceptions\
│   │               │   ├── ProdutoJaExistenteException.java\
│   │               │   └── ProdutoNaoEncontradoException.java\
│   │               ├── services\
│   │               │   ├── ArvoreBinariaDeBusca.java\
│   │               │   └── EstoqueService.java\
│   │               └── main\
│   │                   └── Main.java\
└── README.md\
 ```

### Diagrama de Classes

Abaixo está o diagrama de classes que representa a organização das principais classes do sistema:

```plaintext
┌────────────────────────┐          ┌──────────────────────────────┐
│        Produto         │◄─────────│      ProdutoEletronico       │
│────────────────────────│          └──────────────────────────────┘
│ - codigo: int          │          ┌──────────────────────────────┐
│ - nome: String         │◄─────────│      ProdutoPeriferico       │
│ - quantidade: int      │          └──────────────────────────────┘
│────────────────────────│          
│ + getCodigo(): int     │          
│ + getNome(): String    │          
│ + getQuantidade(): int │          
│ + setQuantidade(qtd):  │          
│ + descreverProduto():  │ (abstrato)
└────────────────────────┘          
          ▲                           
          │                           
          │                           
┌─────────────────────────────────────┐         
│  EstoqueService<T>   │  Interface   │
│─────────────────────────────────────│          
│ + inserirProduto(produto: T)        │
│ + removerProduto(codigo: int)       │
│ + buscarProduto(codigo: int): T     │
│ + exibirProdutosEmOrdemCrescente()  │
│ + exibirProdutosEmOrdemDecrescente()│
│ + exibirProdutosEmOrdemAlfabetica() │
│ + exibirProdutoComMenorCodigo()     │
│ + exibirProdutoComMaiorCodigo()     │
└─────────────────────────────────────┘          
          ▲                           
          │                           
          │                           
┌─────────────────────────────────────┐     
│     ArvoreBinariaDeBusca<T>         │  
│─────────────────────────────────────│     
│ - raiz: No                          │      
│─────────────────────────────────────│     
│ + inserirProduto(produto: T)        │      
│ + removerProduto(codigo: int)       │     
│ + buscarProduto(codigo: int)        │      
│ + exibirProdutosEmOrdemCrescente()  │
│ + exibirProdutosEmOrdemDecrescente()│
│ + exibirProdutosEmOrdemAlfabetica() │
│ + exibirProdutoComMenorCodigo()     │
│ + exibirProdutoComMaiorCodigo()     │
└─────────────────────────────────────┘
 ```
Descrição dos Componentes
1. Produto.java
Classe abstrata que representa um produto no estoque. Possui atributos como código, nome e quantidade, além de métodos abstratos para descrever o produto.

2. ProdutoEletronico.java
Subclasse de Produto que representa produtos eletrônicos no estoque.

3. ProdutoPeriferico.java
Subclasse de Produto que representa produtos periféricos no estoque.

4. EstoqueService.java
Interface que define as operações básicas de gerenciamento de estoque, incluindo inserção, remoção, busca e listagem de produtos.

5. ArvoreBinariaDeBusca.java
Implementação da árvore binária de busca (BST) que gerencia os produtos no estoque. Esta classe implementa a interface EstoqueService.

6. ProdutoJaExistenteException.java
Exceção personalizada lançada quando um produto com o mesmo código já existe no estoque.

7. ProdutoNaoEncontradoException.java
Exceção personalizada lançada quando um produto não é encontrado no estoque.

8. Main.java
Classe principal que executa o sistema de gerenciamento de estoque. Apresenta um menu interativo para o usuário inserir, remover e listar produtos.

Funcionalidades
Inserir Produto: Inserir um novo produto no estoque. Caso um produto com o mesmo código já exista, uma exceção será lançada.
Remover Produto: Remover um produto do estoque pelo código.
Buscar Produto: Buscar um produto pelo código.
Listar Produtos: Listar todos os produtos do estoque, com opções de ordenação por nome (alfabética) ou código (numérica).

Exemplo de Uso
Ao executar o sistema, você verá um menu com opções para inserir, remover, e listar produtos no estoque.

Exceções Tratadas
ProdutoJaExistenteException: Lançada ao tentar inserir um produto com código duplicado.
ProdutoNaoEncontradoException: Lançada ao tentar remover ou buscar um produto que não existe no estoque.

# Instruções de Como Realizar o Build
Para compilar o projeto, siga os passos abaixo:

## Clone o repositório:

git clone https://github.com/imetropoledigital/trabalho-final-2024-1-projetoarvoredebuscabinaria.git

cd inventory-management

## Compile o projeto:

javac -d bin src/main/java/br/ufrn/imd/**/*.java

Isso compilará todos os arquivos .java e colocará os arquivos .class resultantes no diretório bin.

## Instruções de Como Executar:
Após compilar o projeto, você pode executá-lo da seguinte maneira:

## Execute o projeto:

java -cp bin br.ufrn.imd.main.Main

## Interaja com o sistema:

O sistema apresentará um menu interativo no terminal.
Você poderá inserir novos produtos, remover produtos existentes, listar produtos, e muito mais.
Exemplo de Uso
Após executar o comando acima, o sistema exibirá um menu com as seguintes opções:

```markdown
Sistema de Gerenciamento de Estoque
1. Inserir novo produto eletrônico
2. Inserir novo produto periférico
3. Remover produto existente
4. Listar produtos
5. Sair
Escolha uma opção:
Você pode então inserir o número da opção desejada e seguir as instruções fornecidas pelo sistema.
```
