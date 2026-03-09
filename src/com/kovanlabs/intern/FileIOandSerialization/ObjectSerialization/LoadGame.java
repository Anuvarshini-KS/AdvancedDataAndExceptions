package com.kovanlabs.intern.FileIOandSerialization.ObjectSerialization;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoadGame {

    public static void main(String[] args) {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("game.dat"))) {

            Character p1 = (Character) ois.readObject();
            Character p2 = (Character) ois.readObject();

            System.out.println("Game Resumed!");
            System.out.println(p1.name + " Health: " + p1.health);
            System.out.println(p2.name + " Health: " + p2.health);
            System.out.println("---------------------");

            while (p1.isAlive() && p2.isAlive()) {

                p1.attack(p2);
                if (!p2.isAlive()) break;

                p2.attack(p1);

                System.out.println(p1.name + " Health: " + p1.health);
                System.out.println(p2.name + " Health: " + p2.health);
                System.out.println("---------------------");
            }

            if (p1.isAlive())
                System.out.println(p1.name + " Wins!");
            else
                System.out.println(p2.name + " Wins!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
