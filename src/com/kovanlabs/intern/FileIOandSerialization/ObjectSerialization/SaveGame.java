package com.kovanlabs.intern.FileIOandSerialization.ObjectSerialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveGame {

    public static void main(String[] args) {

        Character p1 = new Warrior("Warrior");
        Character p2 = new Mage("Mage");

        p1.health = 55;
        p2.health = 35;

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("game.dat"))) {

            oos.writeObject(p1);
            oos.writeObject(p2);

            System.out.println("Game saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
