package com.erick.company;

import com.erick.company.domain.Hero;
import com.erick.company.domain.Mage;
import com.erick.company.domain.Weapon;

public class HeroApp {
    public static void main(String[] args) {
        Hero mage = new Mage("Jesus");
        System.out.println("Hero name " + mage.getName());
        System.out.println("Hero level " + mage.getLevel());
        System.out.println("Hero valid armor" + mage.getValidArmorTypes());
        System.out.println("Hero valid weapon" + mage.getValidWeaponTypes());

        System.out.println("adding a new weapon");
        mage.addWeapon(Weapon.NEWWEAPON.name());
        System.out.println("Hero valid weapon" + mage.getValidWeaponTypes());

        System.out.println("Hello world!");
    }
}