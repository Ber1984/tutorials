package com.erick.company;

import com.erick.company.domain.Hero;
import com.erick.company.domain.Mage;
import com.erick.company.domain.MageFactory;
import com.erick.company.domain.Weapon;

public class HeroApp {
    public static void main(String[] args) {
        MageFactory mage = new Mage("Ranger");
        System.out.println("Hero name " + mage.getName());
        System.out.println(mage.getName() + " " + mage.getLevel().getCurrentLevel());
        System.out.println("Level attributes" + mage.getLevel());
       /* System.out.println("Hero valid armor" + mage.getValidArmorTypes());
        System.out.println("Hero valid weapon" + mage.getValidWeaponTypes());

        System.out.println("adding a new weapon");
        mage.addWeapon(Weapon.NEWWEAPON.name());
        System.out.println("Hero valid weapon" + mage.getValidWeaponTypes());*/

        //--------Hero levels up to level 2 ------
        mage.getLevel().setCurrentLevel(2);
        mage.getLevel().levelUp(mage.getLevel(), 1, 5, 1);

        //------new level ------
        System.out.println("Hero name" +  mage.getName() + "\n" + " new level is " + mage.getLevel().getCurrentLevel() + "\n" + "" +
                "new attributes" + mage.getLevel());


    }
}