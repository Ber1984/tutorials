package designpattens.factory;

import java.util.Optional;

import static java.util.Optional.of;

public class LaptopFactory {
    public static Optional<Laptop> getLaptop(LaptopType laptopType){
        switch (laptopType){
            case DELL:
                return of(new Dell("8gb", "Intel"));
            case HP:
                return of(new Hp("12gb", "Intel"));
            case MAC:
                return of(new Mac("16gb", "Amd","Amd"));
            default:
                System.out.println("No found");
        }
        return Optional.empty();
    }
}
