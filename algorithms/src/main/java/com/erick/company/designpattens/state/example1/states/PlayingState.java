package com.erick.company.designpattens.state.example1.states;


import com.erick.company.designpattens.state.example1.ui.PlayerContext;

public class PlayingState extends State {

    PlayingState(PlayerContext playerContext) {
        super(playerContext);
    }

    @Override
    public String onLock() {
        playerContext.changeState(new LockedState(playerContext));
        playerContext.setCurrentTrackAfterStop();
        return "Stop playing";
    }

    @Override
    public String onPlay() {
        playerContext.changeState(new ReadyState(playerContext));
        return "Paused...";
    }

    @Override
    public String onNext() {
        return playerContext.nextTrack();
    }

    @Override
    public String onPrevious() {
        return playerContext.previousTrack();
    }
}
