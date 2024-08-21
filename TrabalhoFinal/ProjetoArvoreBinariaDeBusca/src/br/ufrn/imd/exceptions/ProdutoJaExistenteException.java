package br.ufrn.imd.exceptions;

/**
 * Exceção lançada quando um produto já existente é adicionado ao estoque.
 */
public class ProdutoJaExistenteException extends Exception {
    public ProdutoJaExistenteException(String mensagem) {
        super(mensagem);
    }
}
