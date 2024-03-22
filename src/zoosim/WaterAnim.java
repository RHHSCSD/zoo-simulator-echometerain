/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoosim;

/**
 *
 * @author hhwl
 */
public class WaterAnim extends Animal implements ISwimmable {

	public WaterAnim(int id, String name, String species, Sex sex, double xPos, double yPos, double xSize, double ySize, double speed, double direction, double hunger, double fatigue, String image, String sound) {
		super(id, name, species, sex, xPos, yPos, xSize, ySize, speed, direction, hunger, fatigue, image, sound);
	}

	@Override
	public boolean canSurface() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
