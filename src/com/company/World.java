package com.company;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class World {

    private static Hero myCharacter;

    enum Enemy {
        SKELETON,
        MUMMY;

    }

    public static void logResult(Hero hero){
        myCharacter= hero;
    }


    public static void main(String[] args) throws FileNotFoundException {
        // write your code here

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя персонажа");
        String charName = "s";
        // charName = scanner.nextLine();

         myCharacter = Hero.createHero(charName, 30, 25, 100);

        System.out.println("choose your pass:\n"
                + "1: path to the peddler\n"
                + "2: path into the  gloomy forest\n"
                + "3: path to home\n"
                + "4: show stats");
        boolean isntEnd = true;
        while (isntEnd && !myCharacter.isDead()) {

            switch (scanner.nextInt()) {
                //peddler's case done
                case 1: {
                    System.out.println("Greeting traveller, do you wanna buy my potion?\n"
                            + "1: Buy potion for 100g and restore full health\n"
                            + "2: Leave the shop\n");
                    switch (scanner.nextInt()) {
                        case 1:
                            Peddler.sellPotion(myCharacter);
                            break;
                        case 2:

                            break;
                    }
                    break;
                }
                case 2: {
                    Enemy value = Enemy.values()[(int) (Math.random() * 2)];
                    System.out.println("your chose the path of pain, get ready to fight with " + value);
                    switch (value) {
                        case SKELETON -> {
                        new Encounter(myCharacter, new Skeleton()).start();
                            break;
                        }
                        case MUMMY -> {
                            new Encounter(myCharacter, new Mummy()).start();
                            break;
                        }
                    }
                    break;

                }
                //done
                case 3: {
                    System.out.println("game over");
                    isntEnd = false;
                    break;
                }
                //done
                case 4: {
                    System.out.println(myCharacter + "\n");
                    break;
                }
                //done
                default:
                    System.out.println("incorrect command");
                    break;

            }
        }


    }
}
