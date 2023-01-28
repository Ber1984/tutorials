package designpattens.command;

public class TvOnCommand implements Command{
    Tv tv;

    public TvOnCommand(Tv tv) {
        this.tv = tv;
    }
    public void execute(){
        tv.on();
    }
}
