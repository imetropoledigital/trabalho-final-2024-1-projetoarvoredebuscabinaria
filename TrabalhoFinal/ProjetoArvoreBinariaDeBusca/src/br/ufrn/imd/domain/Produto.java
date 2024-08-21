package br.ufrn.imd.domain;

/**
 * Classe abstrata que representa um produto no estoque.
 */
public abstract class Produto {
    private int codigo;
    private String nome;
    private int quantidade;

    public Produto(int codigo, String nome, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Quantidade: " + quantidade;
    }

    /**
     * Método abstrato para descrever o tipo de produto.
     */
    public abstract String descreverProduto();
}
