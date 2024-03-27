/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoosim;

/**
 *
 * @author hhwl
 */
public abstract class BirdAnim extends Animal implements IFlyable {

	/**
	 *
	 * @param id
	 * @param name
	 * @param species
	 * @param sex
	 * @param xPos
	 * @param yPos
	 * @param xSize
	 * @param ySize
	 * @param speed
	 * @param direction
	 * @param hunger
	 * @param fatigue
	 * @param image
	 * @param sound
	 * @param terrain
	 */
	public BirdAnim(int id, String name, String species, Sex sex, double xPos, double yPos, double xSize, double ySize, double speed, double direction, double hunger, double fatigue, Image image, String sound, Terrain terrain) {
		super(id, name, species, sex, xPos, yPos, xSize, ySize, speed, direction, hunger, fatigue, image, sound, terrain);
	}

	/**
	 *
	 */
	@Override
	public void fly() {
		if (getTerrain() == Terrain.AIR) {
			return;
		}
		setTerrain(Terrain.AIR);
	}

	/**
	 *
	 */
	@Override
	public void land() {
		if (getTerrain() != Terrain.AIR) {
			return;
		}
		setTerrain(Terrain.GROUND);
	}

	/**
	 *
	 * @return
	 */
	@Override
	public boolean isFlying() {
		return (getTerrain() == Terrain.AIR);
	}

}
