package com.erick.company.domain;

import java.util.List;

public abstract class Hero {

    private String name;
    private List<String> validWeaponTypes;
    private List<String> validArmorTypes;
    private static final int level = 1;
    private static int num = 20;
    public int getLevel(){ return level; }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValidWeaponTypes() {
        return validWeaponTypes;
    }

    public void setValidWeaponTypes(List<String> validWeaponTypes) {
        this.validWeaponTypes = validWeaponTypes;
    }

    public List<String> getValidArmorTypes() {
        return validArmorTypes;
    }

    public void setValidArmorTypes(List<String> validArmorTypes) {
        this.validArmorTypes = validArmorTypes;
    }

    public static int getNum() {
        return num;
    }
    public void addWeapon(String weapon) {
        validWeaponTypes.add(weapon);
    }
}
