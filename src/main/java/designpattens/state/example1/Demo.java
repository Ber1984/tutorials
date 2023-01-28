package designpattens.state.example1;

import designpattens.state.example1.ui.PlayerContext;
import designpattens.state.example1.ui.UI;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {
    public static void main(String[] args) {
        PlayerContext playerContext = new PlayerContext();
        UI ui = new UI(playerContext);
        ui.init();
    }
}
