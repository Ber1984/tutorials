package com.erick.company.abstraccion.interfaz;

public class SystemApp {
    public static void main(String[] args) {
        var systemA = new SystemA();
        systemA.getData();
        var systemB = new SystemB();
        systemB.postData();
    }
}
