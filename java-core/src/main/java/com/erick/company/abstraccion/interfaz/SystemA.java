package com.erick.company.abstraccion.interfaz;

public class SystemA implements UnknownAPI {
    @Override
    public void getData() {
        System.out.println("Getting data from System A");
    }

    @Override
    public void postData() {
        System.out.println("Posting data from System A");
    }
}
