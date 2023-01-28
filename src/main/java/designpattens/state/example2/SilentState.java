package designpattens.state.example2;

public class SilentState implements MobileAlertState {

    @Override
    public void alert(){
        System.out.println("Mobile is in silent mode");
    }
}
