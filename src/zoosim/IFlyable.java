/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package zoosim;

/**
 *
 * @author hhwl
 */
public interface IFlyable extends IEntity {

	/**
	 * Make animal fly
	 */
	void fly();

	/**
	 * Make animal land
	 */
	void land();

	/**
	 *
	 * @return If the animal is flying or not
	 */
	boolean isFlying();
}
