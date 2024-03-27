/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoosim;

/**
 *
 * @author hhwl
 */
public class Tuna extends WaterAnim {

	/**
	 *
	 * @param id
	 * @param name
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
	 * @param terrain
	 */
	public Tuna(int id, String name, Sex sex, double xPos, double yPos, double xSize, double ySize, double speed, double direction, double hunger, double fatigue, Image image, Terrain terrain) {
		super(id, name, "Tuna", sex, xPos, yPos, xSize, ySize, speed, direction, hunger, fatigue, image, "blub!", terrain);
	}

}
