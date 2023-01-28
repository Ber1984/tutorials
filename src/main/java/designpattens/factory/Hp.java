package designpattens.factory;

public class Hp extends Laptop{
    private String ram;
    private String processor;

    public Hp(String ram, String processor) {
        this.ram = ram;
        this.processor = processor;
    }

    @Override
    public String getConfiguration() {
        return "Hp config is ram size: "+this.ram + " and processorType"+this.processor;
    }

    @Override
    public String toString() {
        return "Hp{" +
                "ram='" + ram + '\'' +
                ", processor='" + processor + '\'' +
                '}';
    }
}
