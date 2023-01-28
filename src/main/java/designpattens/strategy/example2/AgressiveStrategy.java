package designpattens.strategy.example2;

public class AgressiveStrategy implements IStratergy {
    @Override
    public void actionCommand() {
        System.out.println("Agrresive Strategy. Find and kill opponent");
    }
}
