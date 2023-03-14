package com.erick.company.olssoftware;

public class TestFor {
    public static void main(String[] args) {
        int[] datos = {0, 1, 2, 3, 4, 5};
        TestFor t = new TestFor();
        t.printStuff(datos, datos[2]);
    }

    public void printStuff(int[] datosParam, int pos) {
        for (int j = 0; j < datosParam.length; j++) {
            System.out.println(datosParam[j]);
            if (j > datosParam.length) j = pos--;


        }
    }
}
