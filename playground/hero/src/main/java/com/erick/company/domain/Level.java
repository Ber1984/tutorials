package com.erick.company.domain;

public abstract class Level {

    private int strength;
    private int dexterity;
    private int intelligence;

    private int currentLevel;

    public Level(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.currentLevel = 1;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        return "Level{" +
                "strength=" + strength +
                ", dexterity=" + dexterity +
                ", intelligence=" + intelligence +
                '}';
    }

    public abstract Level levelUp(Level currentLevel, int strength, int dexterity, int intelligence);
}
