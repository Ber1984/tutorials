package com.erick.company.designpattens.command;

public class TvOffCommand implements Command{
    Tv tv;

    public TvOffCommand(Tv tv) {
        this.tv = tv;
    }
    public void execute(){
        tv.off();
    }
}
