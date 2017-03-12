/*
 * ProfessorSimples.java
 * Criado em 2009/12/10 - 12:04
 */
package br.usp.gradescola.estrutura;

/**
 * Implementa��o simples da interface {@linkplain Professor}, que
 * consiste apenas do nome do professor, informado por meio do
 * par�mtero do construtor.
 * @author Victor Williams Stafusa da Silva
 */
public final class ProfessorSimples implements Professor {

    /**
     * Guarda o nome do professor, a ser retornado pelo m�todo
     * {@linkplain #toString()}.
     */
    private final String nome;

    /**
     * Cria uma inst�ncia com o nome informado.
     * @param nome O nome do professor, a ser retornado pelo m�todo
     * {@linkplain #toString()}.
     * @throws IllegalArgumentException Se o nome do professor for
     * {@code null}.
     */
    public ProfessorSimples(String nome) {
        if (nome == null) throw new IllegalArgumentException("O nome n�o pode ser nulo.");
        this.nome = nome;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public String toString() {
        return nome;
    }
}