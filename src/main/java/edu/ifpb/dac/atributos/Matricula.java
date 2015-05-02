package edu.ifpb.dac.atributos;

import java.io.Serializable;

/**
 *
 * @author Ricardo Job
 */
class Matricula implements Serializable {

    private final String matricula;

    public Matricula(String matricula) {
        this.matricula = matricula;
    }

    protected String simples() {
        return this.matricula;
    }

    protected String formatada() {
        //Fazer algumas formação
        return "asd-dac-" + this.matricula;
    }

}
