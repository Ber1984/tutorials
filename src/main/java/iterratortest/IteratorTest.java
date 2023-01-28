package iterratortest;

import java.util.Iterator;


public class IteratorTest {
    public static void main(String[] args) {
        Persona p1 = new Persona(749999999,35);
        Persona p2 = new Persona(72759474,30);
        Persona p3 = new Persona(74853735,25);
        Persona[] pp = {p1,p2,p3};

        ConjuntoPersonas cp = new ConjuntoPersonas(pp);
        for(Persona p : cp){
            System.out.println("la persona:" +p.dni + "tiene una edad de:" + p.edad);
        }

        Iterator<Persona> it1 = cp.iterator();
        while(it1.hasNext()){
            Persona tmp = it1.next();
            System.out.println("la persona:" +tmp.dni + "tiene una edad de:" + tmp.edad);
        }

    }
}
