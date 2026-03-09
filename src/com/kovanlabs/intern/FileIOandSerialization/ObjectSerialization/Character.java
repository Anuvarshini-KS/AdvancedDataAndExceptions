package com.kovanlabs.intern.FileIOandSerialization.ObjectSerialization;

import java.io.Serial;
import java.io.Serializable;

abstract class Character implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    String name;
    int health;
    int strength;

    Character(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
    }

    abstract void attack(Character enemy);

    boolean isAlive() {
        return health > 0;
    }
}

    class Warrior extends Character {

        @Serial
        private static final long serialVersionUID = 1L;

        Warrior(String name) {
            super(name, 120, 15);
        }

        @Override
        void attack(Character enemy) {
            int damage = strength + (int)(Math.random() * 10);
            enemy.health -= damage;
            System.out.println(name + " attacks and deals " + damage + " damage");
        }
    }

    class Mage extends Character {

        @Serial
        private static final long serialVersionUID = 1L;

        Mage(String name) {
            super(name, 80, 25);
        }

        @Override
        void attack(Character enemy) {
            int damage = strength + (int)(Math.random() * 5);
            enemy.health -= damage;
            System.out.println(name + " attacks and deals " + damage + " damage");
        }
    }

