/*
 * Colecoes.java
 * Criado em 2009/12/03 - 10:15
 */
package br.usp.gradescola.utilidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe utilit�ria contendo m�todos �teis para manipular cole��es.
 * @author Victor Williams Stafusa da Silva
 */
public final class Colecoes {

    /**
     * Construtor privado para impedir a instancia��o. Esta classe n�o
     * deve ser instanci�vel.
     */
    private Colecoes() {}

    /**
     * Cria uma lista contendo os elementos informados nos par�metros.
     * Este m�todo, diferentemente do m�todo
     * {@linkplain java.util.Arrays.asList(E...)} retorna uma lista
     * que pode ser modificada sem afetar o array original e que n�o
     * tem tamanho fixo. O array correspondente aos par�metros �
     * independente � lista retornada, o que significa que altera��es
     * em um n�o se refletem no outro.
     * @param it Os elementos a serem colocados na lista.
     * @param <E> O tipo dos elementos.
     * @return Uma lista contendo os elementos informados nos
     * par�metros, ou {@code null} se o par�metro for {@code null}.
     */
    public static <E> List<E> copiarElementos(E... it) {
        // Verifica se � nulo antes de tudo.
        if (it == null) return null;

        // Cria uma lista e adiciona todos os elementos do array.
        List<E> lista = new ArrayList<E>(it.length);
        Collections.addAll(lista, it);
        return lista;
    }

    /**
     * Copia uma lista dada. Para fazer esta c�pia, cria uma lista e
     * insere nela os mesmos elementos do {@code Iterable} informado
     * no par�metro. O {@code Iterable} informado no par�metro �
     * independente � lista retornada, o que significa que altera��es
     * em um n�o se refletem no outro.
     * @param it O {@code Iterable} de onde os elementos ser�o
     * copiados. Pode ser {@code null}.
     * @param <E> O tipo dos elementos.
     * @return Uma lista contendo os mesmos elementos do
     * {@code Iterable} do par�metro {@code it}, ou {@code null} se
     * o par�metro {@code it} for {@code null}.
     */
    public static <E> List<E> copiarElementos(Iterable<E> it) {
        // Verifica se � nulo antes de tudo.
        if (it == null) return null;

        // Verifica se � uma Collection e usa o addAll se for.
        if (it instanceof Collection) {
            List<E> lista = new ArrayList<E>(((Collection<E>) it).size());
            lista.addAll((Collection<E>) it);
            return lista;
        }

        // N�o � Collection, ent�o acrescenta os elementos um a um.
        List<E> lista = new ArrayList<E>();
        for (E elem : it) {
            lista.add(elem);
        }
        return lista;
    }

    /**
     * Cria um conjunto contendo os elementos informados nos
     * par�metros, n�o permitindo repeti��es no conjunto retornado.
     * Este m�todo, diferentemente do m�todo
     * {@linkplain java.util.Arrays.asList(E...)} retorna um conjunto
     * que pode ser modificado sem afetar o array original e que n�o
     * tem tamanho fixo. O array correspondente aos par�metros �
     * independente ao conjunto retornado, o que significa que
     * altera��es em um n�o se refletem no outro.
     * A ordem dos elementos n�o � garantida, o que significa que no
     * conjunto retornado, os elementos podem estar em qualquer ordem
     * arbitr�ria e aleat�ria.
     * @param it Os elementos a serem colocados na lista.
     * @param <E> O tipo dos elementos.
     * @return Um conjunto contendo todos os elementos informados nos
     * par�metros, ou {@code null} se o par�metro for {@code null}.
     * Tal conjunto n�o cont�m itens repetidos. A ordem dos elementos
     * no conjunto retornado n�o � garantida.
     */
    public static <E> Set<E> copiarUnicos(E... it) {
        // Verifica se � nulo antes de tudo.
        if (it == null) return null;

        // Cria um HashSet e adiciona todos os elementos do array.
        Set<E> lista = new HashSet<E>(it.length);
        Collections.addAll(lista, it);
        return lista;
    }

    /**
     * Cria uma c�pia de uma lista dada e a retorna em um conjunto,
     * evitando-se elementos repetidos. Para fazer esta c�pia, cria
     * uma lista e insere nela os mesmos elementos do {@code Iterable}
     * informado no par�metro. O {@code Iterable} informado no
     * par�metro � independente � lista retornada, o que significa que
     * altera��es em um n�o se refletem no outro.
     * A ordem dos elementos n�o � garantida, o que significa que no
     * conjunto retornado, os elementos podem estar em qualquer ordem
     * arbitr�ria e aleat�ria.
     * @param it O {@code Iterable} de onde os elementos ser�o
     * copiados. Pode ser {@code null}.
     * @param <E> O tipo dos elementos.
     * @return Um conjunto contendo os mesmos elementos do
     * {@code Iterable} do par�metro {@code it}, ou {@code null} se
     * o par�metro {@code it} for {@code null}. Tal conjunto n�o
     * cont�m itens repetidos. A ordem dos elementos no conjunto
     * retornado n�o � garantida.
     */
    public static <E> Set<E> copiarUnicos(Iterable<E> it) {
        // Verifica se � nulo antes de tudo.
        if (it == null) return null;

        Set<E> lista = new HashSet<E>();

        // Verifica se � uma Collection e usa o addAll se for.
        if (it instanceof Collection) {
            lista.addAll((Collection<E>) it);
            return lista;
        }

        // N�o � Collection, ent�o acrescenta os elementos um a um.
        for (E elem : it) {
            lista.add(elem);
        }
        return lista;
    }
}