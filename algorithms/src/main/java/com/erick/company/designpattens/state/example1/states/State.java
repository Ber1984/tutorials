package com.erick.company.designpattens.state.example1.states;


import com.erick.company.designpattens.state.example1.ui.PlayerContext;

public abstract class State {
    PlayerContext playerContext;

    /**
     * Context passes itself through the state constructor. This may help a
     * state to fetch some useful context data if needed.
     */
    State(PlayerContext playerContext) {
        this.playerContext = playerContext;
    }

    public abstract String onLock();
    public abstract String onPlay();
    public abstract String onNext();
    public abstract String onPrevious();
}
