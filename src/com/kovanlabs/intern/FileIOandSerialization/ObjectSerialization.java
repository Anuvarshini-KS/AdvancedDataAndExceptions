package com.kovanlabs.intern.FileIOandSerialization;

import java.io.*;

abstract class Character implements Serializable
{
    private static final long serialVersionUID = 1L;
    String name;
    int health,strength;
    Character(String name,int health,int strength)
    {
        this.name=name;
        this.health=health;
        this.strength=strength;
    }
    abstract void attack(Character enemy);
    boolean isAlive()
    {
        return health>0;
    }
}
class Warrior extends Character {

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
class Rouge extends Character {

    Rouge(String name) {
        super(name, 100, 18);
    }

    @Override
    void attack(Character enemy) {
        if (Math.random() < 0.3) {
            System.out.println(name + " dodged the attack!");
            return;
        }
        int damage = strength + (int)(Math.random() * 5);
        enemy.health -= damage;
        System.out.println(name + " attacks and deals " + damage + " damage");
    }
}

public class ObjectSerialization {
    public static void main(String[] args) {

        Character p1 = new Warrior("Warrior");
        Character p2 = new Mage("Mage");

        System.out.println("Battle Started!");

        while (p1.isAlive() && p2.isAlive()) {

            p1.attack(p2);
            if (!p2.isAlive()) break;

            p2.attack(p1);

            System.out.println(p1.name + " Health: " + p1.health);
            System.out.println(p2.name + " Health: " + p2.health);
            System.out.println("------------------------");
        }

        if (p1.isAlive())
            System.out.println(p1.name + " wins!");
        else
            System.out.println(p2.name + " wins!");
    }
}
class SaveGame
{
    public static void main(String[]args)
    {
        Character p1 = new Warrior("Warrior");
        Character p2 = new Mage("Mage");
        p1.health = 55;
        p2.health = 35;
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("game.dat"));
            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.close();
            System.out.println("Game saved Successfully");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
class LoadGame
{
    public static void main(String[]args)
    {
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("game.dat"));
            Character p1 = (Character) ois.readObject();
            Character p2 = (Character) ois.readObject();
            ois.close();
            System.out.println("Game resumed");
            System.out.println(p1.name+" Health "+p1.health);
            System.out.println(p2.health+" Health "+p2.health);
            System.out.println("---------------------");
            while(p1.isAlive() && p2.isAlive())
            {
                p1.attack(p2);
                if(!p2.isAlive())  break;
                p2.attack(p1);
                System.out.println(p1.name+" Health "+p1.health);
                System.out.println(p2.health+" Health "+p2.health);
                System.out.println("---------------------");
                if(p1.isAlive())
                {
                    System.out.println(p1.name+" Wins!");
                }
                else
                {
                    System.out.println(p2.name+" Wins!");
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
