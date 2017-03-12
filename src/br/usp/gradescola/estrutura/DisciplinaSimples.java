/*
 * DisciplinaSimples.java
 * Criado em 2009/12/10 - 12:02
 */
package br.usp.gradescola.estrutura;

/**
 * Implementa��o simples da interface {@linkplain Disciplina}, que
 * consiste apenas do nome da disciplina e da carga hor�ria, que s�o
 * informados por meio dos par�mteros do construtor.
 * @author Victor Williams Stafusa da Silva
 */
public final class DisciplinaSimples implements Disciplina {

    /**
     * Guarda o nome da disciplina, a ser retornado pelo m�todo
     * {@linkplain #toString()}.
     */
    private final String nome;

    /**
     * Guarda a carga hor�ria disciplina, a ser retornada pelo m�todo
     * {@linkplain #getCargaHoraria()}.
     */
    private final int cargaHoraria;

    /**
     * Cria uma inst�ncia com o nome e a carga hor�ria informadas.
     * @param nome O nome da disciplina, a ser retornado pelo m�todo
     * {@linkplain #toString()}.
     * @param cargaHoraria A carga hor�ria da disciplina, a ser
     * retornada pelo m�todo {@linkplain #getCargaHoraria()}.
     * @throws IllegalArgumentException Se o nome da disciplina for
     * {@code null} ou a carga hor�ria for menor ou igual a zero.
     */
    public DisciplinaSimples(String nome, int cargaHoraria) {
        if (nome == null) throw new IllegalArgumentException("O nome n�o pode ser nulo.");
        if (cargaHoraria <= 0) throw new IllegalArgumentException("A carga hor�ria da disciplina deve ser positiva.");
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public int getCargaHoraria() {
        return cargaHoraria;
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