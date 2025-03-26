package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.consumables.Consumable;
import org.project.object.weapons.Weapon;

public class Assassin extends Player
{
    private boolean isvisibility = true;
    public Assassin(String name, int hp, int mp, Weapon weapon, Armor armor, Consumable consumable)
    {
        super(name, hp, mp, weapon, armor, consumable);
    }

    public void becomesInvisible ()
    {
        if (this.getMp() >= 15)
        {
            this.isvisibility = false;
            this.visibilityMp();
            System.out.println(this.name + " fades into the shadows, becoming undetectable for the next strike.");
        }
        else
        {
            System.out.println(this.name + " lacks sufficient mana to vanish!");
        }
    }

    @Override
    public void attack(Entity target)
    {
        if (!isvisibility)
        {
            int increasedDamage = 10;
            target.takeDamage(30);
            System.out.println(this.name + " strikes from the darkness, inflicting " + increasedDamage + " damage!");
            this.isvisibility = true;
        }
        else
        {
            super.attack(target);
        }
    }

    @Override
    public void takeDamage(int damage)
    {
        if (!isvisibility)
        {
            System.out.println(this.name + " is hidden and dodges the attack!");
        }
        else
        {
            super.takeDamage(damage);
        }
    }
}
