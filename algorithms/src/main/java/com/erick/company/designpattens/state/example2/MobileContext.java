package com.erick.company.designpattens.state.example2;

public class MobileContext {
    private MobileAlertState currentState;

    public MobileContext(){
        currentState = new RingingState(); //default state
    }

    public void setState(MobileAlertState state){
        currentState = state;
    }

    public void alert(){
        currentState.alert();
    }
}
