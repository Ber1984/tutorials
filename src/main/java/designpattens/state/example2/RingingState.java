package designpattens.state.example2;

public class RingingState implements MobileAlertState {
    @Override
    public void alert() {
        System.out.println("Mobile is ringing");
    }
}
