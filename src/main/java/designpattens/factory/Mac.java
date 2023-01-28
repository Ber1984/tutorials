package designpattens.factory;

public class Mac extends Laptop{
    private String ram;
    private String processor;
    private String gpuType;

    public Mac(String ram, String processor,String gpuType) {
        this.ram = ram;
        this.processor = processor;
        this.gpuType = gpuType;
    }

    @Override
    public String getConfiguration() {
        return "Mac config is ram size: "+this.ram + "  processorType"+this.processor + "and gputype" + gpuType;
    }

    @Override
    public String toString() {
        return "Mac{" +
                "ram='" + ram + '\'' +
                ", processor='" + processor + '\'' +
                ", gputype='" + gpuType + '\'' +
                '}';
    }
}
