package org.project.object.armors;

public class KnightArmor extends Armor
{
    public KnightArmor()
    {
        super(30, 50);
    }

    @Override
    public String toString()
    {
        return "Knight's Shielded Armor - " + super.toString();
    }
}
