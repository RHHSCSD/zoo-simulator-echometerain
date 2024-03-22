/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoosim;

/**
 *
 * @author hhwl
 */
public class BirdAnim extends Animal implements IFlyable {

	public BirdAnim(int id, String name, String species, Sex sex, double xPos, double yPos, double xSize, double ySize, double speed, double direction, double hunger, double fatigue, String image, String sound) {
		super(id, name, species, sex, xPos, yPos, xSize, ySize, speed, direction, hunger, fatigue, image, sound);
	}

	@Override
	public void fly() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void land() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public boolean isFlying() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
