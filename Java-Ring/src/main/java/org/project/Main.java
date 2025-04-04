package org.project;

import org.project.entity.enemies.Dragon;
import org.project.entity.enemies.Enemy;
import org.project.entity.enemies.Goblin;
import org.project.entity.enemies.Skeleton;
import org.project.entity.players.Assassin;
import org.project.entity.players.Knight;
import org.project.entity.players.Player;
import org.project.entity.players.Wizard;
import org.project.location.Location;
import org.project.object.armors.Armor;
import org.project.object.armors.KnightArmor;
import org.project.object.consumables.Flask;
import org.project.object.weapons.Sword;
import org.project.object.consumables.Consumable;
import org.project.object.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        boolean isGameOver = false;

        List<Location> places = new ArrayList<>();
        List<Enemy> jungleEnemies = new ArrayList<>();
        jungleEnemies.add(new Dragon("Blazing Dragon", 100, 80, new Sword()));
        jungleEnemies.add(new Goblin("Venomous Goblin", 80, 60, new Sword()));

        List<Enemy> oasisEnemies = new ArrayList<>();
        oasisEnemies.add(new Skeleton("Water Skeleton", 150, 120, new Sword()));
        oasisEnemies.add(new Goblin("Desert Goblin", 80, 60, new Sword()));

        List<Enemy> ruinsEnemies = new ArrayList<>();
        ruinsEnemies.add(new Skeleton("Ancient Warrior", 150, 120, new Sword()));
        ruinsEnemies.add(new Dragon("Ocean Dragon", 100, 80, new Sword()));

        places.add(new Location("Mystic Jungle", "A dark and mysterious jungle where shadows move and danger lurks at every corner.", jungleEnemies));
        places.add(new Location("Shimmering Oasis", "A magical oasis in the heart of the desert, glowing with an otherworldly light and surrounded by danger.", oasisEnemies));
        places.add(new Location("Sunken Ruins", "An ancient underwater city, filled with ruins and forgotten treasures.", ruinsEnemies));

        System.out.println("Welcome to the Adventure Game!");

        System.out.println("\nSelect your hero:");
        System.out.println("1. Stealthy Assassin");
        System.out.println("2. Wise Wizard");
        System.out.println("3. Brave Knight");

        Player hero = null;

        Scanner inputScanner = new Scanner(System.in);
        int playerChoice = inputScanner.nextInt();
        switch (playerChoice)
        {
            case 1:
                hero = new Assassin("Silent Blade", 100, 50, new Sword(), new KnightArmor(), new Flask());
                System.out.println("You have chosen the Assassin: " + hero.getName());
                break;

            case 2:
                hero = new Wizard("Arcane Magus", 100, 50, new Sword(), new KnightArmor(), new Flask());
                System.out.println("You have chosen the Wizard: " + hero.getName());
                break;

            case 3:
                hero = new Knight("Lord Arthur", 120, 20, new Sword(), new KnightArmor(), new Flask());
                System.out.println("You have chosen the Knight: " + hero.getName());
                break;

            default:
                System.out.println("Invalid choice, please select a valid hero.");
                return;
        }

        while (!isGameOver)
        {
            System.out.println("\nSelect your next location:");
            for (int i = 0; i < places.size(); i++)
            {
                if (!places.get(i).isVisited())
                {
                    System.out.println((i + 1) + ". " + places.get(i).getName());
                }
            }

            int locationChoice = inputScanner.nextInt();
            if (locationChoice < 1 || locationChoice > places.size())
            {
                System.out.println("Invalid choice. Please choose a valid location.");
                continue;
            }

            Location currentPlace = places.get(locationChoice - 1);
            if (currentPlace.isVisited())
            {
                System.out.println("You have already explored this place. Choose another.");
                continue;
            }

            currentPlace.setVisited(true);

            List<Enemy> currentEnemies = currentPlace.getEnemies();
            System.out.println("You have arrived at " + currentPlace.getName() + "!");
            System.out.println(currentPlace.getDescription());
            System.out.println();

            boolean heroDefeated = false;
            boolean leftPlace = false;
            for (Enemy enemy : currentEnemies)
            {
                if (!heroDefeated)
                {
                    System.out.println("A wild " + enemy.getName() + " appears!");
                    boolean enemyDefeated = false;

                    while (!enemyDefeated && !heroDefeated && !leftPlace)
                    {
                        System.out.println("Current status: " + hero.getHp() + " HP and " + hero.getMp() + " MP. The " + enemy.getName() + " has " + enemy.getHp() + " HP.");
                        System.out.println();
                        System.out.println("What would you like to do?");
                        System.out.println("1. Attack");
                        System.out.println("2. Use Special Ability");
                        System.out.println("3. Flee");
                        System.out.println("4. Change Location");
                        int actionChoice = inputScanner.nextInt();

                        switch (actionChoice)
                        {
                            case 1:
                                System.out.println("You attack the " + enemy.getName() + "!");
                                hero.attack(enemy);
                                if (enemy.getHp() <= 0)
                                {
                                    System.out.println("You have defeated the " + enemy.getName() + "!");
                                    hero.getEnemyHp();
                                    enemyDefeated = true;
                                }
                                else
                                {
                                    System.out.println("The " + enemy.getName() + " is still standing!");
                                    System.out.println("The " + enemy.getName() + " strikes back!");
                                    enemy.attack(hero);
                                    hero.takeDamage(20);
                                    if (hero.getHp() <= 0)
                                    {
                                        System.out.println("You have been defeated by the " + enemy.getName() + "!");
                                        heroDefeated = true;
                                        isGameOver = true;
                                        break;
                                    }
                                }
                                break;

                            case 2:
                                if (hero instanceof Assassin)
                                {
                                    ((Assassin) hero).becomesInvisible();
                                }
                                else if (hero instanceof Wizard)
                                {
                                    ((Wizard) hero).castSpell(enemy);
                                }
                                else if (hero instanceof Knight)
                                {
                                    ((Knight) hero).strongKick(enemy);
                                }
                                if (enemy.getHp() <= 0)
                                {
                                    System.out.println("You have defeated the " + enemy.getName() + "!");
                                    enemyDefeated = true;
                                }
                                else
                                {
                                    System.out.println("The " + enemy.getName() + " is still standing strong!");
                                }
                                break;

                            case 3:
                                if (hero.getMp() >= 15 && hero.getHp() >= 50)
                                {
                                    System.out.println("You flee from the " + enemy.getName() + "!");
                                    hero.runAway();
                                    enemyDefeated = true;
                                }
                                else
                                {
                                    System.out.println("You don't have enough resources to flee!");
                                }
                                break;

                            case 4:
                                System.out.println("You decide to leave the " + currentPlace.getName() + " and choose another location.");
                                leftPlace = true;
                                enemyDefeated = true;
                                break;

                            default:
                                System.out.println("Invalid choice. Please select a valid action.");
                        }
                    }

                    if (places.stream().allMatch(Location::isVisited))
                    {
                        System.out.println("You have explored all locations. Game over!");
                        isGameOver = true;
                    }
                }
            }
        }
    }
}
