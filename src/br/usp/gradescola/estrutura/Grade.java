/*
 * Grade.java
 * Criado em 2009/11/12 - 03:18
 */
package br.usp.gradescola.estrutura;

import java.math.BigDecimal;

import java.util.List;
import java.util.Set;

/**
 * @author Victor Williams Stafusa da Silva
 */
public interface Grade extends Cloneable, Comparable<Grade> {

    /**
     * Altera a grade atribuindo um professor a uma disciplina. Caso
     * a disciplina j� tenha um outro professor, este � "desatribu�do"
     * da disciplina.
     * @param disciplina A disciplina cujo professor � atribu�do.
     * @param professor O professor que � atribu�do � disciplina.
     */
    public void atribuir(Disciplina disciplina, Professor professor);

    /**
     * Altera a grade atribuindo a uma disciplina, um conjunto de
     * hor�rios. Caso a disciplina j� tenha outros hor�rios definidos,
     * estes ser�o redefinidos.
     * @param disciplina A disciplina cujo conjunto de hor�rios �
     * definido.
     * @param horarios Os hor�rios a serem atribu�dos para a
     * disciplina.
     */
    public void atribuir(Disciplina disciplina, Iterable<Horario> horarios);

    // N�o suportado!
    //public void atribuir(Disciplina disciplina, Horario horario, Sala sala);

    public List<Disciplina> disciplinasPorHorario(Horario horario);

    // N�o suportado!
    //public Sala salaLocada(Disciplina disciplina, Horario horario);

    public Professor professorDaDisciplina(Disciplina disciplina);

    public List<Horario> horariosPorDisciplina(Disciplina disciplina);

    public Set<Disciplina> disciplinasPorProfessor(Professor professor);

    public List<Horario> horariosPorProfessor(Professor professor);

    public void permutar(Horario horario1, Horario horario2);

    //public void permutar(Disciplina disciplina1, Disciplina disciplina2);

    public void permutar(Professor professor1, Professor professor2);

    // N�o suportado!
    //public void permutar(Sala sala1, Sala sala2);

    public BigDecimal avaliar();

    public Problema getProblema();

    public Grade clone();
}