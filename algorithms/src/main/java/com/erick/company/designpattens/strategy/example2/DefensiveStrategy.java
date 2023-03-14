package com.erick.company.designpattens.strategy.example2;

public class DefensiveStrategy implements IStratergy{
    @Override
    public void actionCommand() {
        System.out.println("Defensive strategy. Protect self and teammate");
    }
}
