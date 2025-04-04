package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

// TODO: UPDATE IMPLEMENTATION
public abstract class Enemy implements Entity
{
    Weapon weapon;
    private int hp;
    private int mp;
    protected String name;

    public Enemy(String name,int hp, int mp, Weapon weapon)
    {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.weapon = weapon;
    }

    // TODO: (BONUS) UPDATE THE FORMULA OF TAKING DAMAGE
    @Override
    public void takeDamage(int damage)
    {
        hp -= damage;
    }


    public void attack(Entity target)
    {
        target.takeDamage(20);
    }

    public int getHp()
    {
        return hp;
    }

    public int getMp()
    {
        return mp;
    }

    public Weapon getWeapon()
    {
        return weapon;
    }

    public abstract void useAbility(Entity target);

    public void resurrectSkeleton()
    {
        hp = mp / 2;
    }

    public String getName()
    {
        return name;
    }
}