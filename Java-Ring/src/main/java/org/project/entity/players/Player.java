package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;
import org.project.object.consumables.Consumable;

public abstract class Player implements Entity
{
    protected String name;
    Weapon weapon;
    Armor armor;
    Consumable consumable;
    private int hp;
    private int maxHP = 120;
    private int mp;
    private int maxMP = 60;

    public Player(String name, int hp, int mp, Weapon weapon, Armor armor, Consumable consumable)
    {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.weapon = weapon;
        this.armor = armor;
        this.consumable = consumable;
    }

    @Override
    public void attack(Entity target)
    {
        weapon.use(target);
        target.takeDamage(weapon.getDamage());
        this.mp += 7;
    }

    @Override
    public void defend()
    {
        // TODO: (BONUS) IMPLEMENT A DEFENSE METHOD FOR SHIELDS
    }

    @Override
    public void takeDamage(int damage)
    {
        if (!armor.isBroke())
        {
            armor.reduceDurability(damage);
        } else
        {
            hp -= damage;
        }
    }

    @Override
    public void heal(int health)
    {
        hp += health;
        if (hp > 120)
        {
            hp = 120;
        }
    }

    @Override
    public void fillMana(int mana)
    {
        mp += mana;
        if (mp > maxMP)
        {
            mp = maxMP;
        }
    }

    public String getName()
    {
        return name;
    }

    public int getHp()
    {
        return hp;
    }

    @Override
    public int getMaxHP()
    {
        return maxHP;
    }

    public int getMp()
    {
        return mp;
    }

    @Override
    public int getMaxMP()
    {
        return maxMP;
    }

    public Weapon getWeapon()
    {
        return weapon;
    }

    public Armor getArmor()
    {
        return armor;
    }

    public void castingSpell()
    {
        this.hp += 12;
        this.mp -= 22;
    }

    public void visibilityMp()
    {
        this.mp -= 18;
    }

    public void runAway()
    {
        this.hp -= 35;
        this.mp -= 20;
    }

    public void getEnemyHp()
    {
        this.hp += 65;
        this.mp += 18;
    }
}
