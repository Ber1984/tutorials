package com.erick.company.iterratortest;

import java.util.Iterator;

public class ConjuntoPersonas implements Iterable<Persona> {

    public Persona[] conjuntoPersonas;

    public ConjuntoPersonas(Persona[] conjuntoPersonas) {
        this.conjuntoPersonas = conjuntoPersonas;
    }

    public Iterator<Persona> iterator() {
        Iterator it = new MiIterarorPersona();
        return it;
    }


    protected class MiIterarorPersona implements Iterator<Persona> {

        protected int posicionarray;

        public MiIterarorPersona() {
            this.posicionarray = 0;
        }


        public boolean hasNext() {
            boolean result;
            if (posicionarray < conjuntoPersonas.length) {
                result = true;
            } else {
                result = false;
            }
            return result;
        }


        public Persona next() {
            posicionarray++;
            return conjuntoPersonas[posicionarray - 1];
        }

        public void remove() {
            throw new UnsupportedOperationException("No soportado");
        }

    }
}
