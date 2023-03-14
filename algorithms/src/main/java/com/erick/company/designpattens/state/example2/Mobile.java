package com.erick.company.designpattens.state.example2;

import java.util.Scanner;

public class Mobile {
    public static void main(String[] args) {
        MobileContext mobileContext = new MobileContext();
        mobileContext.alert();  /*  we're calling mobileContext.RingingState.alert() */

        //changing state
        mobileContext.setState(new SilentState()); /*  we're calling mobileContext.SilentState.alert() */
        mobileContext.alert();

        System.out.println("----set to ringing again");

        mobileContext.setState(new VibrateState());
        mobileContext.alert();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option : " +
                 "\n 1. Ringing State" +
                "\n 2. SilentState" +
                "\n 3. VibrateState ") ;
        int option =  scanner.nextInt();
        switch (option) {
            case 1 : {
                mobileContext.setState(new RingingState());
                mobileContext.alert();
                break;
            }
            case 2 : {
                mobileContext.setState(new SilentState()); /*  we're calling mobileContext.SilentState.alert() */
                mobileContext.alert();
                break;
            }
            case 3 : {
                mobileContext.setState(new VibrateState());
                mobileContext.alert();
                break;
            }
        }

    }
}
