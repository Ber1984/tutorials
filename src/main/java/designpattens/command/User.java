package designpattens.command;

public class User {
    public static void main(String[] args) {

        RemoteControl remote = new RemoteControl(); //remote command is not dependent on either SetTopBox or tv
        SetTopBox setTopBox = new SetTopBox();
        Tv tv = new Tv();

        remote.setCommand(new SetTopBoxOnCommand(setTopBox));
        remote.pressButton();

        remote.setCommand(new TvOnCommand(tv));
        remote.pressButton();

        remote.setCommand(new TvOffCommand(tv));
        remote.pressButton();
    }
}
