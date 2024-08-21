package br.ufrn.imd.exceptions;

/**
 * Exceção lançada quando um produto não é encontrado no estoque.
 */
public class ProdutoNaoEncontradoException extends Exception {
    public ProdutoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
