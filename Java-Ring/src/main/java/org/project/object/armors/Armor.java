package org.project.object.armors;

public abstract class Armor
{
    private int defense;
    private int maxDefense;
    private int durability;
    private int maxDurability;
    private boolean isBroke;

    public Armor(int defense, int durability)
    {
        this.defense = defense;
        this.maxDefense = defense;
        this.durability = durability;
        this.maxDurability = durability;
        this.isBroke = false;
    }

    public void checkBreak()
    {
        if (durability <= 0)
        {
            isBroke = true;
            defense = 0;
        }
    }

    public void repair()
    {
        if (isBroke) {
            isBroke = false;
            defense = maxDefense;
            durability = maxDurability;
            System.out.println("Your armor has been restored to full strength.");
        } else {
            System.out.println("The armor is still intact and doesn't require repairs.");
        }
    }

    public int getDefense()
    {
        return defense;
    }

    public int getDurability()
    {
        return durability;
    }

    public boolean isBroke()
    {
        return isBroke;
    }

    public void reduceDurability(int amount)
    {
        if (!isBroke)
        {
            System.out.println("The armor absorbs the impact of the attack.");
            durability -= amount;
            checkBreak();
            if (isBroke)
            {
                System.out.println("Your armor has shattered!");
            }
        }
    }

    @Override
    public String toString()
    {
        return "Defense: " + defense + ", Durability: " + durability + ", Broken: " + isBroke;
    }
}
