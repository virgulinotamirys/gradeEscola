/*
 * CondicoesBasicas.java
 * Criado em 2009/12/04 - 11:43
 */
package br.usp.gradescola.condicoes;

import br.usp.gradescola.estrutura.Condicao;
import br.usp.gradescola.estrutura.Grade;

import java.math.BigDecimal;

import java.util.Arrays;

/**
 * Cont�m fun��es utilit�rias para a utiliza��o de condi��es booleanas
 * e aritm�ticas comuns.
 * @author Victor Williams Stafusa da Silva
 */
public final class CondicoesBasicas {

    /**
     * Construtor privado para impedir a instancia��o. Esta classe n�o
     * deve ser instanci�vel.
     */
    private CondicoesBasicas() {}

    private static final class CondicaoAnd implements Condicao.Booleana {

        private final Iterable<Condicao.Booleana> condicoes;

        public CondicaoAnd(Iterable<Condicao.Booleana> condicoes) {
            this.condicoes = condicoes;
        }

        @Override
        public boolean avaliar(Grade grade) {
            for (Condicao.Booleana condicao : condicoes) {
                if (!condicao.avaliar(grade)) return false;
            }
            return true;
        }
    }

    /**
     * Cria uma condi��o booleana que combina diversas condi��es
     * booleanas dadas por meio do operador booleano AND.
     * @param condicoes As condi��es a serem combinadas.
     * @return Uma condi��o que combina (por meio do operador AND) as
     * condi��es dadas.
     */
    public static Condicao.Booleana and(Iterable<Condicao.Booleana> condicoes) {
        return new CondicaoAnd(condicoes);
    }

    /**
     * Cria uma condi��o booleana que combina diversas condi��es
     * booleanas dadas por meio do operador booleano AND.
     * @param condicoes As condi��es a serem combinadas.
     * @return Uma condi��o que combina (por meio do operador AND) as
     * condi��es dadas.
     */
    public static Condicao.Booleana and(Condicao.Booleana... condicoes) {
        return and(Arrays.asList(condicoes));
    }

    private static final class CondicaoOr implements Condicao.Booleana {

        private final Iterable<Condicao.Booleana> condicoes;

        public CondicaoOr(Iterable<Condicao.Booleana> condicoes) {
            this.condicoes = condicoes;
        }

        @Override
        public boolean avaliar(Grade grade) {
            for (Condicao.Booleana condicao : condicoes) {
                if (condicao.avaliar(grade)) return true;
            }
            return false;
        }
    }

    /**
     * Cria uma condi��o booleana que combina diversas condi��es
     * booleanas dadas por meio do operador booleano OR.
     * @param condicoes As condi��es a serem combinadas.
     * @return Uma condi��o que combina (por meio do operador OR) as
     * condi��es dadas.
     */
    public static Condicao.Booleana or(Iterable<Condicao.Booleana> condicoes) {
        return new CondicaoOr(condicoes);
    }

    /**
     * Cria uma condi��o booleana que combina diversas condi��es
     * booleanas dadas por meio do operador booleano OR.
     * @param condicoes As condi��es a serem combinadas.
     * @return Uma condi��o que combina (por meio do operador OR) as
     * condi��es dadas.
     */
    public static Condicao.Booleana or(Condicao.Booleana... condicoes) {
        return or(Arrays.asList(condicoes));
    }

    private static final class CondicaoNot implements Condicao.Booleana {
        private final Condicao.Booleana condicao;

        public CondicaoNot(Condicao.Booleana condicao) {
            this.condicao = condicao;
        }

        @Override
        public boolean avaliar(Grade grade) {
            return !condicao.avaliar(grade);
        }
    }

    /**
     * Cria uma condi��o booleana que quando avaliada, inverte a
     * resposta de uma outra condi��o booleana dada.
     * @param condicoes A condi��o dada.
     * @return Uma condi��o que inverte a avalia��o de uma outra
     * condi��o.
     */
    public static Condicao.Booleana not(Condicao.Booleana condicao) {
        return new CondicaoNot(condicao);
    }

    private static final class Contagem implements Condicao.Numerica {

        private final Iterable<Condicao.Booleana> condicoes;

        public Contagem(Iterable<Condicao.Booleana> condicoes) {
            this.condicoes = condicoes;
        }

        @Override
        public BigDecimal avaliar(Grade grade) {
            int verdadeiras = 0;
            for (Condicao.Booleana condicao : condicoes) {
                if (condicao.avaliar(grade)) verdadeiras++;
            }
            return BigDecimal.valueOf(verdadeiras);
        }
    }

    /**
     * Cria uma condi��o num�rica que quando avaliada, fornece a
     * quantidade das condi��es booleanas dadas que s�o verdadeiras.
     * Em outras palavras, conta quantas condi��es s�o verdadeiras.
     * @param condicoes As condi��es a serem avaliadas.
     * @return Uma condi��o que quando avaliada, conta quantas das
     * condi��es dadas s�o verdadeiras.
     */
    public static Condicao.Numerica contagem(Iterable<Condicao.Booleana> condicoes) {
        return new Contagem(condicoes);
    }

    /**
     * Cria uma condi��o num�rica que quando avaliada, fornece a
     * quantidade das condi��es booleanas dadas que s�o verdadeiras.
     * Em outras palavras, conta quantas condi��es s�o verdadeiras.
     * @param condicoes As condi��es a serem avaliadas.
     * @return Uma condi��o que quando avaliada, conta quantas das
     * condi��es dadas s�o verdadeiras.
     */
    public static Condicao.Numerica contagem(Condicao.Booleana... condicoes) {
        return contagem(Arrays.asList(condicoes));
    }

    private static final class BooleanaParaNumerica implements Condicao.Numerica {
        private final Condicao.Booleana condicao;

        public BooleanaParaNumerica(Condicao.Booleana condicao) {
            this.condicao = condicao;
        }

        @Override
        public BigDecimal avaliar(Grade grade) {
            return condicao.avaliar(grade) ? BigDecimal.ONE : BigDecimal.ZERO;
        }
    }

    /**
     * Cria uma condi��o num�rica que quando avaliada, retorna 1 se
     * a avalia��o de uma dada condi��o booleana for verdadeira e 0
     * caso contr�rio.
     * @param condicoes A condi��o a serem avaliadas.
     * @return Uma condi��o que quando avaliada, retorna 1 se a
     * condi��o dada for verdadeira e 0 se n�o for.
     */
    public static Condicao.Numerica valor(Condicao.Booleana condicao) {
        return new BooleanaParaNumerica(condicao);
    }

    private static final class CondicaoMultiplica implements Condicao.Numerica {

        private final Iterable<Condicao.Numerica> condicoes;

        public CondicaoMultiplica(Iterable<Condicao.Numerica> condicoes) {
            this.condicoes = condicoes;
        }

        @Override
        public BigDecimal avaliar(Grade grade) {
            BigDecimal resposta = BigDecimal.ONE;
            for (Condicao.Numerica condicao : condicoes) {
                resposta = resposta.multiply(condicao.avaliar(grade));
            }
            return resposta;
        }
    }

    /**
     * Cria uma condi��o num�rica que combina diversas condi��es
     * num�ricas dadas multiplicando o valor dado pela avalia��o delas.
     * @param condicoes As condi��es a serem combinadas.
     * @return Uma condi��o que multiplica o valor da avalia��o das
     * condi��es dadas.
     */
    public static Condicao.Numerica multiplicar(Iterable<Condicao.Numerica> condicoes) {
        return new CondicaoMultiplica(condicoes);
    }

    /**
     * Cria uma condi��o num�rica que combina diversas condi��es
     * num�ricas dadas multiplicando o valor dado pela avalia��o delas.
     * @param condicoes As condi��es a serem combinadas.
     * @return Uma condi��o que multiplica o valor da avalia��o das
     * condi��es dadas.
     */
    public static Condicao.Numerica multiplicar(Condicao.Numerica... condicoes) {
        return multiplicar(Arrays.asList(condicoes));
    }

    private static final class CondicaoSoma implements Condicao.Numerica {

        private final Iterable<Condicao.Numerica> condicoes;

        public CondicaoSoma(Iterable<Condicao.Numerica> condicoes) {
            this.condicoes = condicoes;
        }

        @Override
        public BigDecimal avaliar(Grade grade) {
            BigDecimal resposta = BigDecimal.ONE;
            for (Condicao.Numerica condicao : condicoes) {
                resposta = resposta.add(condicao.avaliar(grade));
            }
            return resposta;
        }
    }

    /**
     * Cria uma condi��o num�rica que combina diversas condi��es
     * num�ricas dadas somando o valor dado pela avalia��o delas.
     * @param condicoes As condi��es a serem combinadas.
     * @return Uma condi��o que soma o valor da avalia��o das
     * condi��es dadas.
     */
    public static Condicao.Numerica somar(Iterable<Condicao.Numerica> condicoes) {
        return new CondicaoSoma(condicoes);
    }

    /**
     * Cria uma condi��o num�rica que combina diversas condi��es
     * num�ricas dadas somando o valor dado pela avalia��o delas.
     * @param condicoes As condi��es a serem combinadas.
     * @return Uma condi��o que soma o valor da avalia��o das
     * condi��es dadas.
     */
    public static Condicao.Numerica somar(Condicao.Numerica... condicoes) {
        return somar(Arrays.asList(condicoes));
    }

    private static final class CondicaoMenos implements Condicao.Numerica {

        private final Condicao.Numerica condicao;

        public CondicaoMenos(Condicao.Numerica condicao) {
            this.condicao = condicao;
        }

        @Override
        public BigDecimal avaliar(Grade grade) {
            return condicao.avaliar(grade).negate();
        }
    }

    /**
     * Cria uma condi��o num�rica que quando avaliada, inverte o sinal
     * da avalia��o de uma outra condi��o num�rica dada.
     * @param condicoes A condi��o dada.
     * @return Uma condi��o que inverte a avalia��o de uma outra
     * condi��o.
     */
    public static Condicao.Numerica negar(Condicao.Numerica condicao) {
        return new CondicaoMenos(condicao);
    }

    private static final class ConstanteNumerica implements Condicao.Numerica {

        private final BigDecimal constante;

        public ConstanteNumerica(BigDecimal constante) {
            this.constante = constante;
        }

        @Override
        public BigDecimal avaliar(Grade grade) {
            return constante;
        }
    }

    /**
     * Cria uma condi��o num�rica que quando avaliada, retorna sempre
     * um mesmo valor. Tal valor � informado pelo par�metro.
     * @param constante O valor a ser retornado quando a condi��o
     * retornada � avaliada.
     * @return Uma condi��o que quando avaliada, retorna o valor
     * informado no par�metro.
     */
    public static Condicao.Numerica valor(BigDecimal constante) {
        return new ConstanteNumerica(constante);
    }
}