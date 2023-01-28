package designpattens.state.example2;

public class VibrateState implements MobileAlertState{

    @Override
    public void alert(){
        System.out.println("Mobile is vibrating mode ");
    }
}
