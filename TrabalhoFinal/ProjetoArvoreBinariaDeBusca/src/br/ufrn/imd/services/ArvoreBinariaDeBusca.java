package br.ufrn.imd.services;

import br.ufrn.imd.domain.Produto;
import br.ufrn.imd.exceptions.ProdutoJaExistenteException;
import br.ufrn.imd.exceptions.ProdutoNaoEncontradoException;
import java.util.*;

public class ArvoreBinariaDeBusca<T extends Produto> implements EstoqueService<T> {

    private class No {
        T produto;
        No esquerda, direita;

        No(T produto) {
            this.produto = produto;
        }
    }

    private No raiz;

    @Override
    public void inserirProduto(T produto) throws ProdutoJaExistenteException {
        raiz = inserirProduto(raiz, produto);
    }

    private No inserirProduto(No no, T produto) throws ProdutoJaExistenteException {
        if (no == null) {
            return new No(produto);
        }

        if (produto.getCodigo() < no.produto.getCodigo()) {
            no.esquerda = inserirProduto(no.esquerda, produto);
        } else if (produto.getCodigo() > no.produto.getCodigo()) {
            no.direita = inserirProduto(no.direita, produto);
        } else {
            throw new ProdutoJaExistenteException("Produto com código " + produto.getCodigo() + " já existe.");
        }

        return no;
    }

    @Override
    public void removerProduto(int codigo) throws ProdutoNaoEncontradoException {
        raiz = removerProduto(raiz, codigo);
    }

    private No removerProduto(No no, int codigo) throws ProdutoNaoEncontradoException {
        if (no == null) {
            throw new ProdutoNaoEncontradoException("Produto com código " + codigo + " não encontrado.");
        }

        if (codigo < no.produto.getCodigo()) {
            no.esquerda = removerProduto(no.esquerda, codigo);
        } else if (codigo > no.produto.getCodigo()) {
            no.direita = removerProduto(no.direita, codigo);
        } else {
            // Caso 1: Nó é uma folha
            if (no.esquerda == null && no.direita == null) {
                return null;
            }

            // Caso 2: Nó tem um filho
            if (no.esquerda == null) {
                return no.direita;
            } else if (no.direita == null) {
                return no.esquerda;
            }

            // Caso 3: Nó tem dois filhos
            No substituto = encontrarMinimo(no.direita);
            no.produto = substituto.produto;
            no.direita = removerProduto(no.direita, substituto.produto.getCodigo());
        }

        return no;
    }

    private No encontrarMinimo(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }

    @Override
    public T buscarProduto(int codigo) throws ProdutoNaoEncontradoException {
        No no = buscarProduto(raiz, codigo);
        if (no == null) {
            throw new ProdutoNaoEncontradoException("Produto com código " + codigo + " não encontrado.");
        }
        return no.produto;
    }

    private No buscarProduto(No no, int codigo) {
        if (no == null || no.produto.getCodigo() == codigo) {
            return no;
        }

        if (codigo < no.produto.getCodigo()) {
            return buscarProduto(no.esquerda, codigo);
        } else {
            return buscarProduto(no.direita, codigo);
        }
    }

    @Override
    public void exibirProdutosEmOrdemCrescente() {
        exibirProdutosEmOrdem(raiz);
    }

    private void exibirProdutosEmOrdem(No no) {
        if (no != null) {
            exibirProdutosEmOrdem(no.esquerda);
            System.out.println(no.produto);
            exibirProdutosEmOrdem(no.direita);
        }
    }

    @Override
    public void exibirProdutosEmOrdemDecrescente() {
        List<T> produtos = new ArrayList<>();
        listarProdutos(raiz, produtos);
        produtos.sort(Comparator.comparingInt(Produto::getCodigo).reversed());
        produtos.forEach(System.out::println);
    }

    private void listarProdutos(No no, List<T> produtos) {
        if (no != null) {
            listarProdutos(no.esquerda, produtos);
            produtos.add(no.produto);
            listarProdutos(no.direita, produtos);
        }
    }

    @Override
    public void exibirProdutosEmOrdemAlfabetica(boolean crescente) {
        List<T> produtos = new ArrayList<>();
        listarProdutos(raiz, produtos);
        produtos.sort(Comparator.comparing(Produto::getNome));
        if (!crescente) {
            Collections.reverse(produtos);
        }
        produtos.forEach(System.out::println);
    }

    @Override
    public void exibirProdutoComMenorCodigo() throws ProdutoNaoEncontradoException {
        No minimo = encontrarMinimo(raiz);
        if (minimo != null) {
            System.out.println("Produto com menor código: " + minimo.produto);
        } else {
            throw new ProdutoNaoEncontradoException("Nenhum produto encontrado.");
        }
    }

    private No encontrarMaximo(No no) {
        while (no != null && no.direita != null) {
            no = no.direita;
        }
        return no;
    }

    @Override
    public void exibirProdutoComMaiorCodigo() throws ProdutoNaoEncontradoException {
        No maximo = encontrarMaximo(raiz);
        if (maximo != null) {
            System.out.println("Produto com maior código: " + maximo.produto);
        } else {
            throw new ProdutoNaoEncontradoException("Nenhum produto encontrado.");
        }
    }
}
