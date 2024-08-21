# Sistema de Gerenciamento de Estoque

## Propósito do Projeto

Este projeto foi desenvolvido para implementar um sistema de gerenciamento de estoque em Java, utilizando uma árvore binária de busca (BST - Binary Search Tree). O sistema é capaz de realizar operações de inserção, remoção, busca e listagem de produtos, mantendo os dados organizados de maneira eficiente.

## Organização do Projeto

O projeto está organizado da seguinte forma:



Estrutura do Projeto
'''
inventory-management
├── src
│   ├── main
│   │   └── java
│   │       └── br
│   │           └── ufrn
│   │               ├── domain
│   │               │   ├── Produto.java
│   │               │   ├── ProdutoEletronico.java
│   │               │   └── ProdutoPeriferico.java
│   │               ├── exceptions
│   │               │   ├── ProdutoJaExistenteException.java
│   │               │   └── ProdutoNaoEncontradoException.java
│   │               ├── services
│   │               │   ├── ArvoreBinariaDeBusca.java
│   │               │   └── EstoqueService.java
│   │               └── main
│   │                   └── Main.java
└── README.md
'''


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
