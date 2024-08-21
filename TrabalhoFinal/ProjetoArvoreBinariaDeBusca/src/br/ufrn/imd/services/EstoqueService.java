package br.ufrn.imd.services;

import br.ufrn.imd.domain.Produto;
import br.ufrn.imd.exceptions.ProdutoJaExistenteException;
import br.ufrn.imd.exceptions.ProdutoNaoEncontradoException;

/**
 * Interface para definir as operações básicas de gerenciamento de estoque.
 */
public interface EstoqueService<T extends Produto> {
    void inserirProduto(T produto) throws ProdutoJaExistenteException;
    void removerProduto(int codigo) throws ProdutoNaoEncontradoException;
    T buscarProduto(int codigo) throws ProdutoNaoEncontradoException;
    void exibirProdutosEmOrdemCrescente();
    void exibirProdutosEmOrdemDecrescente();
    void exibirProdutosEmOrdemAlfabetica(boolean crescente);
    void exibirProdutoComMenorCodigo() throws ProdutoNaoEncontradoException;
    void exibirProdutoComMaiorCodigo() throws ProdutoNaoEncontradoException;
}
