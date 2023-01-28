package designpattens.strategy.example2;

public class Player {
    IStratergy behaviour;
    String type;

    public Player(String type){
        this.type = type;
    }

    public void setStrategy(IStratergy behaviour){
        this.behaviour = behaviour;
    }

    public void action(){
        System.out.println("Player: " + this.type);
        behaviour.actionCommand();
    }
}
