package me.virustotal.gridworldtest.utils;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

public class GridUtils {


	/* 
	 * Instead of creating a new grid object we can just reset the grid size by accessing the array in the grid instance of world
	 * After we get the grid instance we can just set it to a new 2d array of type object and repaint the world to refresh the grid
	 *
	 */
	
	public static void setGridSize(World<?> world, int rows, int cols)
	{
		if(world.getGrid() instanceof BoundedGrid) //Check if the grid is of type BoundedGrid to not set the size for an unbounded grid
		{
			try {
				Field arrayField = world.getGrid().getClass().getDeclaredField("occupantArray"); //get the variable occupantArray in the grid class
				arrayField.setAccessible(true); //Since the variable is declared as private we need to set it to accessible to modify it or get data from it
				arrayField.set(world.getGrid(), new Object[rows][cols]); //set the field with parameters of the world grid instance and our new 2d array
				GridUtils.repaint(world); //Grid needs to be updated so we will call repaint
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Same effect can be done by calling world.show()
	 * world.show() does a check to see if the grid is null and if it is not then it calls repaint
	 * I decided for convenience sake just to access the method through reflection
	 * 
	 */
	
	public static void repaint(World<?> world)
	{
		try {
			Method method = world.getClass().getDeclaredMethod("repaint"); //get the method repair from the world class
			method.setAccessible(true); //since it is private it needs to be declared accessible
			method.invoke(world); //we will then invoke paint with the parameter of our world
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Gets a random unocuppied location on the grid
	 * 
	 */
	
	public static Location getRandomUnoccupiedLocation(Grid<?> grid)
	{
		int cols = grid.getNumCols();
		int rows = grid.getNumRows();
		int rCol = -1;
		int rRow = -1;
		ArrayList<Location> occupiedLocations = grid.getOccupiedLocations();
		Random r = new Random();
		r.setSeed(System.nanoTime());
		while(!occupiedLocations.contains(new Location(rCol = r.nextInt(cols), rRow = r.nextInt(rows))))
		{
			break;
		}
		
		return new Location(rCol,rRow);
	}
}
