package com.erick.company.designpattens.state.example1.states;


import com.erick.company.designpattens.state.example1.ui.PlayerContext;

/**
     * Concrete states provide the special implementation for all interface methods.
     */
    public class LockedState extends State {

        LockedState(PlayerContext playerContext) {
            super(playerContext);
            playerContext.setPlaying(false);
        }

        @Override
        public String onLock() {
            if (playerContext.isPlaying()) {
                playerContext.changeState(new ReadyState(playerContext));
                return "Stop playing";
            } else {
                return "Locked...";
            }
        }

        @Override
        public String onPlay() {
            playerContext.changeState(new ReadyState(playerContext));
            return "Ready";
        }

        @Override
        public String onNext() {
            return "Locked...";
        }

        @Override
        public String onPrevious() {
            return "Locked...";
        }
}
