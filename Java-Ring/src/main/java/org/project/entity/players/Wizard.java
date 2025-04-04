package org.project.entity.players;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;
import org.project.object.consumables.Consumable;

public class Wizard extends Player
{
    public Wizard(String name, int hp, int mp, Weapon weapon, Armor armor, Consumable consumable)
    {
        super(name, hp, mp, weapon, armor, consumable);
    }

    public void castSpell(Enemy target)
    {
        if (this.getMp() >= 20)
        {
            int health = 10;
            int damage = 20;
            this.heal(health);
            target.takeDamage(damage);
            castingSpell();
            System.out.println(this.name + " invokes a healing incantation! Restores " + health + " HP and inflicts " + damage + " damage.");
        }
        else
        {
            System.out.println(this.name + " lacks sufficient mana to perform the spell!");
        }
    }

    @Override
    public void attack(Entity target)
    {
        super.attack(target);
    }
}
