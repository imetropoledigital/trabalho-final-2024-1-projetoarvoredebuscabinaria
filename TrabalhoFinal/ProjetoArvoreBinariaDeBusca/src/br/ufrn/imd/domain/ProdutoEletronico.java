package br.ufrn.imd.domain;

/**
 * Classe que representa um produto eletrônico.
 */
public class ProdutoEletronico extends Produto {
    public ProdutoEletronico(int codigo, String nome, int quantidade) {
        super(codigo, nome, quantidade);
    }

    @Override
    public String descreverProduto() {
        return "Produto Eletrônico: " + getNome();
    }
}
