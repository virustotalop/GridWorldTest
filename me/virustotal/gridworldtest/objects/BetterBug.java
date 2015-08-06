package me.virustotal.gridworldtest.objects;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class BetterBug extends BetterActor {

	
	public BetterBug(World<Actor> world) {
		super(world);
	}
	
	//Default implementation of bug is below
	
    public void act() {
        if (this.canMove()) {
            this.move();
        }
        else {
            this.turn();
        }
    }
    
    public void turn() {
        this.setDirection(this.getDirection() + 45);
    }
    
    public void move() {
        final Grid<Actor> gr = this.getGrid();
        if (gr == null) {
            return;
        }
        final Location loc = this.getLocation();
        final Location next = loc.getAdjacentLocation(this.getDirection());
        if (gr.isValid(next)) {
            this.moveTo(next);
        }
        else {
            this.removeSelfFromGrid();
        }
        final Flower flower = new Flower(this.getColor());
        flower.putSelfInGrid(gr, loc);
    }
    
    public boolean canMove() {
        final Grid<Actor> gr = this.getGrid();
        if (gr == null) {
            return false;
        }
        final Location loc = this.getLocation();
        final Location next = loc.getAdjacentLocation(this.getDirection());
        if (!gr.isValid(next)) {
            return false;
        }
        final Actor neighbor = gr.get(next);
        return neighbor == null || neighbor instanceof Flower;
    }

}
