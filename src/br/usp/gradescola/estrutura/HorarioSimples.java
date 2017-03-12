/*
 * HorarioSimples.java
 * Criado em 2009/12/10 - 12:03
 */
package br.usp.gradescola.estrutura;

/**
 * Implementa��o simples da interface {@linkplain Horario}, que
 * consiste apenas do nome do hor�rio, informado por meio do par�metro
 * do construtor.
 * @author Victor Williams Stafusa da Silva
 */
public final class HorarioSimples implements Horario {

    /**
     * Guarda o nome do hor�rio, a ser retornado pelo m�todo
     * {@linkplain #toString()}.
     */
    private final String nome;

    /**
     * Cria uma inst�ncia com o nome informado.
     * @param nome O nome do hor�rio, a ser retornado pelo m�todo
     * {@linkplain #toString()}.
     * @throws IllegalArgumentException Se o nome do hor�rio for
     * {@code null}.
     */
    public HorarioSimples(String nome) {
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