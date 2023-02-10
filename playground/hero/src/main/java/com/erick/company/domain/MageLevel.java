package com.erick.company.domain;

public class MageLevel extends Level {

    public MageLevel(int strength, int dexterity, int intelligence) {
        super(strength, dexterity, intelligence);
    }
    @Override
    public Level levelUp(Level currentLevel, int strength, int dexterity, int intelligence) {
        if(!isInLevelRange(currentLevel.getCurrentLevel())) {
            throw new IllegalArgumentException("Level is not in the desired range");
        }
        return setNewLevelAttributes(currentLevel, strength, dexterity , intelligence);
    }
    private Boolean isInLevelRange(int currentLevel) {
        return currentLevel >= 2 && currentLevel <= 6;
    }

    private Level setNewLevelAttributes(Level currentLevel, int strength, int dexterity, int intelligence) {
        currentLevel.setStrength(currentLevel.getStrength()+ strength);
        currentLevel.setDexterity(currentLevel.getDexterity() + dexterity);
        currentLevel.setIntelligence(currentLevel.getIntelligence() + intelligence);
        return currentLevel;
    }
}
