package designpattens.command;

public class SetTopBoxOffCommand implements Command {

    SetTopBox setTopBox;

    public SetTopBoxOffCommand(SetTopBox setTopBox) {
        this.setTopBox = setTopBox;
    }

    @Override
    public void execute() {
        setTopBox.off();
    }
}
