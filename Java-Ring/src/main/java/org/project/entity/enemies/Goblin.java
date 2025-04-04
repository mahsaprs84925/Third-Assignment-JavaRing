package org.project.entity.enemies;
import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

public class Goblin extends Enemy
{

    // Constructor to initialize the Goblin with name, HP, MP, and weapon
    public Goblin(String name, int hp, int mp, Weapon weapon)
    {
        super(name, hp, mp, weapon);
    }

    // Goblin's ability to attack with its weapon
    @Override
    public void useAbility(Entity target)
    {
        System.out.println("The Goblin swings its weapon fiercely, ready for battle! ");
    }

    @Override
    public void defend()
    {
    }

    @Override
    public void heal(int health)
    {
    }

    @Override
    public void fillMana(int mana)
    {
    }

    @Override
    public int getMaxHP()
    {
        return 0;
    }

    @Override
    public int getMaxMP()
    {
        return 0;
    }
}
