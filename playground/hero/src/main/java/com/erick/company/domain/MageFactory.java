package com.erick.company.domain;

import java.util.ArrayList;
import java.util.List;

public class MageFactory extends Hero {

    public MageFactory() {
        this.setValidWeaponTypes(loadWeapon());
        this.setValidArmorTypes(loadArmor());
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
}
