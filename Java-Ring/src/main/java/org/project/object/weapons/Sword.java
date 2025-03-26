package org.project.object.weapons;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;

import java.util.ArrayList;

public class Sword extends Weapon
{
    private int abilityCharge;

    public Sword()
    {
        super(10, 5, 10);
        this.abilityCharge = 0;
    }

    public void uniqueAbility(ArrayList<Enemy> targets)
    {
        if (getDurability() > 0)
        {
            abilityCharge += 2;
            for (Enemy target : targets)
            {
                target.takeDamage(getDamage());
            }
            System.out.println("The sword channels its power, dealing extra damage with each strike! Charge increased by " + abilityCharge);
        }
        else
        {
            System.out.println("The sword has shattered and can no longer unleash its power.");
        }
    }

    @Override
    public int getDamage()
    {
        return super.getDamage() + abilityCharge;
    }

    @Override
    public void use(Entity target)
    {
        if (getDurability() > 0)
        {
            super.use(target);
            System.out.println("The sword strikes " + target.getName() + ", delivering a powerful blow!");
        }
        else
        {
            System.out.println("The sword is broken and cannot be wielded.");
        }
    }
}
