package com.erick.company.solid.inheritance;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class OpenClosedPrincipal {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Greeter greeter = new Greeter(new PrintStream("", " "));
        greeter.greet();


        String nationality = "";
        switch (nationality) {
            case "French":
                FrenchGreeter frenchGreeter = new FrenchGreeter(new PrintStream("", " "));
                frenchGreeter.greet();
                break;
            case "German":
                GermanGreeter germanGreeter = new GermanGreeter(new PrintStream("", " "));
                germanGreeter.greet();
                break;
            default:
                System.out.println("No nationality");
                break;

        }
    }
}
