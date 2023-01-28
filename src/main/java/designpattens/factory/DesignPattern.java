package designpattens.factory;

import java.util.Optional;

public class DesignPattern {
    public static void main(String[] args) {
        Optional<Laptop> dell = LaptopFactory.getLaptop(LaptopType.DELL);
        Optional<Laptop> hp = LaptopFactory.getLaptop(LaptopType.HP);
        Optional<Laptop> macbook = LaptopFactory.getLaptop(LaptopType.MAC);


        dell.ifPresent(x -> System.out.println(x.getConfiguration()));
        dell.ifPresent(x -> System.out.println(x.getConfiguration()));
        hp.ifPresent(x -> System.out.println(x.getConfiguration()));
        hp.ifPresent(x -> System.out.println(x.getConfiguration()));
        macbook.ifPresent(x -> System.out.println(x.getConfiguration()));
    }


}
