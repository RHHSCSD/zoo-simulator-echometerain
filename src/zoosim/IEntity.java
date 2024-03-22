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

	void move(double x, double y);

	void makeSound();

	void eat(String foo);

	void sleep(double hours);
}
