/*
 * SalaSimples.java
 * Criado em 2009/11/16 - 10:44
 */
package br.usp.gradescola.estrutura;

/**
 * N�O SUPORTADO!
 * Implementa��o simples da interface {@linkplain Sala}, que consiste
 * apenas do nome da sala, informado por meio do par�metro do
 * construtor.
 * @author Victor Williams Stafusa da Silva
 */
public final class SalaSimples implements Sala {

    /**
     * Guarda o nome da sala, a ser retornado pelo m�todo
     * {@linkplain #toString()}.
     */
    private final String nome;

    public SalaSimples(String nome) {
        this.nome = nome;
        throw new UnsupportedOperationException();
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