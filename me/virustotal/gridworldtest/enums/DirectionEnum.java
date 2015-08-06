package me.virustotal.gridworldtest.enums;

public enum DirectionEnum {
    
	//enum aliases for most of the angles for convenience sake while reading through code
	
	ACUTEANGLE(45),
	RIGHTANGLE(90),
	OBTUSEANGLE(135),
	STRAIGHTANGLE(180),
	REFLEXANGLE(235);

	private final int direction;

	DirectionEnum(int direction)
	{
		this.direction = direction;
	}

	public int direction()
	{
		return this.direction;
	}
}
