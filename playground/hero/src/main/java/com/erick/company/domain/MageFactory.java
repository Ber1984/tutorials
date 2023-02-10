package com.erick.company.domain;

import java.util.ArrayList;
import java.util.List;

public class MageFactory extends Hero {

    private MageLevel level;

    public MageLevel getLevel() {
        return level;
    }

    public void setLevel(MageLevel level) {
        this.level = level;
    }

    public MageFactory() {
        this.setValidWeaponTypes(loadWeapon());
        this.setValidArmorTypes(loadArmor());
        this.level = loadLevel();
    }

    private List<String> loadWeapon() {
        List<String> weapons = new ArrayList<>();
        weapons.add("weapon1");
        weapons.add("weapon2");
        weapons.add("weapon3");
        return weapons;
    }

    private List<String> loadArmor() {
        List<String> armors = new ArrayList<>();
        armors.add("armor1");
        armors.add("armor2");
        armors.add("armor3");
        return armors;
    }

    private MageLevel loadLevel() {
        return new MageLevel(1, 7, 1);
    }
}
