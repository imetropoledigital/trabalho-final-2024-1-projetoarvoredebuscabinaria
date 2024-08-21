package br.ufrn.imd.main;

import br.ufrn.imd.domain.Produto;
import br.ufrn.imd.domain.ProdutoEletronico;
import br.ufrn.imd.domain.ProdutoPeriferico;
import br.ufrn.imd.exceptions.ProdutoJaExistenteException;
import br.ufrn.imd.exceptions.ProdutoNaoEncontradoException;
import br.ufrn.imd.services.ArvoreBinariaDeBusca;
import br.ufrn.imd.services.EstoqueService;
import java.util.Scanner;

/**
 * Classe principal para executar o sistema de gerenciamento de estoque.
 */
public class Main {
    public static void main(String[] args) {
        EstoqueService<Produto> estoque = new ArvoreBinariaDeBusca<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSistema de Gerenciamento de Estoque");
            System.out.println("1. Inserir novo produto eletrônico");
            System.out.println("2. Inserir novo produto periférico");
            System.out.println("3. Remover produto existente");
            System.out.println("4. Listar produtos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    inserirProduto(estoque, scanner, true);
                    break;
                case 2:
                    inserirProduto(estoque, scanner, false);
                    break;
                case 3:
                    removerProduto(estoque, scanner);
                    break;
                case 4:
                    listarProdutos(estoque, scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void inserirProduto(EstoqueService<Produto> estoque, Scanner scanner, boolean eletronico) {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a quantidade do produto: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        try {
            Produto produto;
            if (eletronico) {
                produto = new ProdutoEletronico(codigo, nome, quantidade);
            } else {
                produto = new ProdutoPeriferico(codigo, nome, quantidade);
            }
            estoque.inserirProduto(produto);
            System.out.println("Produto inserido com sucesso.");
        } catch (ProdutoJaExistenteException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void removerProduto(EstoqueService<Produto> estoque, Scanner scanner) {
        System.out.print("Digite o código do produto a ser removido: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        try {
            estoque.removerProduto(codigo);
            System.out.println("Produto removido com sucesso.");
        } catch (ProdutoNaoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void listarProdutos(EstoqueService<Produto> estoque, Scanner scanner) {
        System.out.println("Escolha a opção de listagem:");
        System.out.println("1. Ordem alfabética crescente");
        System.out.println("2. Ordem alfabética decrescente");
        System.out.println("3. Ordem crescente pelo código");
        System.out.println("4. Ordem decrescente pelo código");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        switch (opcao) {
            case 1:
                estoque.exibirProdutosEmOrdemAlfabetica(true);
                break;
            case 2:
                estoque.exibirProdutosEmOrdemAlfabetica(false);
                break;
            case 3:
                estoque.exibirProdutosEmOrdemCrescente();
                break;
            case 4:
                estoque.exibirProdutosEmOrdemDecrescente();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
