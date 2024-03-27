/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoosim;

/**
 *
 * @author hhwl
 */
public interface IEntity extends IObject {

	/**
	 *
	 * @param x
	 * @param y
	 */
	void move(double x, double y);

	/**
	 *
	 */
	void makeSound();

	/**
	 *
	 * @param foo
	 */
	void eat(String foo);

	/**
	 *
	 * @param hours
	 */
	void sleep(double hours);
}
