package br.ufrn.imd.domain;

/**
 * Classe que representa um produto periférico.
 */
public class ProdutoPeriferico extends Produto {
    public ProdutoPeriferico(int codigo, String nome, int quantidade) {
        super(codigo, nome, quantidade);
    }

    @Override
    public String descreverProduto() {
        return "Produto Periférico: " + getNome();
    }
}
