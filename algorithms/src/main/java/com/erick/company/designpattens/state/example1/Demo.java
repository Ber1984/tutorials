package com.erick.company.designpattens.state.example1;


import com.erick.company.designpattens.state.example1.ui.PlayerContext;
import com.erick.company.designpattens.state.example1.ui.UI;

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
