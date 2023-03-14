package com.erick.company.Prodigious;

public class Processor {
    public boolean processPurchaseOrder(PurchaseOrder... orders) {
        boolean success = false;
        return false;
    }


    public static void main(String[] args) {
        Processor processor = new Processor();
        PurchaseOrder po1 = new PurchaseOrder("Hola", "como estas", 2);
        PurchaseOrder po2 = new PurchaseOrder("aja", "que haces", 3);
        PurchaseOrder[] poArray = new PurchaseOrder[]{po1, po2};

        processor.processPurchaseOrder(poArray);
    }

}

class PurchaseOrder {
    String name;
    String type;
    int number;

    public PurchaseOrder(String name, String type, int number) {
        this.name = name;
        this.type = type;
        this.number = number;
    }
}
