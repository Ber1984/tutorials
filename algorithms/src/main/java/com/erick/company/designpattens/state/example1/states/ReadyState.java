package com.erick.company.designpattens.state.example1.states;


import com.erick.company.designpattens.state.example1.ui.PlayerContext;

/**
 * They can also trigger state transitions in the context.
 */
public class ReadyState extends State {

    public ReadyState(PlayerContext playerContext) {
        super(playerContext);
    }

    @Override
    public String onLock() {
        playerContext.changeState(new LockedState(playerContext));
        return "Locked...";
    }

    @Override
    public String onPlay() {
        String action = playerContext.startPlayback();
        playerContext.changeState(new PlayingState(playerContext));
        return action;
    }

    @Override
    public String onNext() {
        return "Locked...";
    }

    @Override
    public String onPrevious() {
        return "Locked...";
    }

    public String toString(){
        return "State" + super.toString();
    }
}

