package org.project.location;

import org.project.entity.enemies.Enemy;
import org.project.entity.enemies.Skeleton;
import org.project.entity.enemies.Dragon;
import org.project.entity.enemies.Goblin;

import java.util.ArrayList;
import java.util.List;

public class Location
{
    private String name;
    private String description;
    private List<Enemy> enemies;
    private boolean isVisited = false;
    private List<Location> connectedLocations;

    public Location(String name, String description, List<Enemy> enemies)
    {
        this.name = name;
        this.description = description;
        this.isVisited = false;
        this.enemies = new ArrayList<>(enemies);;
        this.connectedLocations = new ArrayList<>();
    }

    public void addEnemy(Enemy enemy)
    {
        this.enemies.add(enemy);
    }

    public void addConnectedLocation(Location location)
    {
        this.connectedLocations.add(location);
    }

    public boolean isVisited()
    {
        return isVisited;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public List<Enemy> getEnemies()
    {
        return enemies;
    }

    public List<Location> getConnectedLocations()
    {
        return connectedLocations;
    }

    @Override
    public String toString()
    {
        return name + " - " + description;
    }

    public void setVisited(boolean visited)
    {
        isVisited = visited;
    }
}