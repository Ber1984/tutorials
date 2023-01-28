package designpattens.command;

public class SetTopBoxOnCommand implements Command{

    SetTopBox setTopBox;

    public SetTopBoxOnCommand(SetTopBox setTopBox) {
        this.setTopBox = setTopBox;
    }

    @Override
    public void execute() {
        setTopBox.on();
        setTopBox.setChannel(23);
        setTopBox.setVolume(34);
    }
}
