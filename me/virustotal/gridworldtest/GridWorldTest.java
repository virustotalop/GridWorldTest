package me.virustotal.gridworldtest;

import me.virustotal.gridworldtest.objects.BetterActor;
import me.virustotal.gridworldtest.objects.BetterBug;
import me.virustotal.gridworldtest.utils.GridUtils;
import info.gridworld.actor.Actor;
import info.gridworld.world.World;

public class GridWorldTest {

	public static void main(String [] args)
	{
		World<Actor> world = new World<Actor>();
		world.show();
		GridUtils.setGridSize(world, 40, 40);
		
		BetterActor actor = new BetterActor(world);
		//A better implementation of actor, mainly consists of overloaded constructors to accomplish certain tasks more quickly
		BetterBug bug = new BetterBug(world);
	
	}

}
