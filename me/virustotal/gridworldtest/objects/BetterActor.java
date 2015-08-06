package me.virustotal.gridworldtest.objects;

import java.awt.Color;

import me.virustotal.gridworldtest.utils.GridUtils;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class BetterActor extends Actor {
	
	public BetterActor(World<Actor> world)
	{
		super();
		Grid<Actor> grid = world.getGrid();
		this.putSelfInGrid(grid, GridUtils.getRandomUnoccupiedLocation(grid));
	}
	
	public BetterActor(World<Actor> world, Location loc)
	{
		super();
		this.putSelfInGrid(world.getGrid(), loc);
	}
	
	public BetterActor(World<Actor> world, int direction)
	{
		new BetterActor(world);
		this.setDirection(170);
	}
	
	public BetterActor(World<Actor> world, Location loc, Color color)
	{
		super();
		this.setColor(color);
		this.putSelfInGrid(world.getGrid(), loc);
	}
	
}
