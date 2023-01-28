package designpattens.factory;

public class Dell extends Laptop{
    private String ram;
    private String processor;

    public Dell(String ram, String processor) {
        this.ram = ram;
        this.processor = processor;
    }

    @Override
    public String getConfiguration() {
        return "Dell config is ram size: "+this.ram + " and processorType"+this.processor;
    }

    @Override
    public String toString() {
        return "Dell{" +
                "ram='" + ram + '\'' +
                ", processor='" + processor + '\'' +
                '}';
    }
}
