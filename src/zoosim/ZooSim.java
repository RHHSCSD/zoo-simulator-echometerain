/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zoosim;

import java.util.*;

/**
 *
 * @author michael.roy-diclemen
 */
public class ZooSim {

	/**
	 *
	 */
	public static final int DELTA = 1000 / 60; // 60fps frame stop time

	/**
	 *
	 */
	public static final int HUNGRY_TIRED = 80; // when the animal is hungry or tired
	private ArrayList<Animal> animals = new ArrayList<>();

	/**
	 * Test class
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		ZooSim zoo = new ZooSim();
		zoo.addAnimals(new Owl(0, "Dave", Sex.MALE, 0, 0, 0.3, 0.3, 10, 0, 0, 0, new Image(), Terrain.GROUND));
		zoo.addAnimals(new Horse(1, "Jose", Sex.MALE, 0, 0, 0.7, 2, 8, 0, 0, 0, new Image(), Terrain.GROUND));
		zoo.addAnimals(new Tuna(2, "Persephone", Sex.FEMALE, 0, 0, 0.2, 0.7, 12, 0, 0, 0, new Image(), Terrain.UNDERWATER));
		zoo.addAnimals(new Horse(3, "Jose2", Sex.MALE, 0, 0, 0.7, 2, 8, 0, 0, 0, new Image(), Terrain.GROUND));

		zoo.moveAll(10000, 10000);
		zoo.feedHungry();
		zoo.restTired();
		zoo.soundAll();
		zoo.showStats();
	}

	/**
	 * @return the animals
	 */
	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	/**
	 * @param animals the animals to set
	 */
	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}

	/**
	 * @param animal the animal to add
	 */
	public void addAnimals(Animal animal) {
		// make animals array if it is empty
		if (animals.isEmpty()) {
			setAnimals(new ArrayList<>());
		}
		animals.add(animal);
	}

	/**
	 * Feed all the hungry animals
	 */
	public void feedHungry() {
		for (Animal e : animals) {
			if (e.getHunger() > HUNGRY_TIRED) {
				e.eat("all purpose rations");
			}
		}
	}

	/**
	 * Rest all the tired animals
	 */
	public void restTired() {
		for (Animal e : animals) {
			if (e.getFatigue() > HUNGRY_TIRED) {
				e.sleep(Math.ceil(e.getFatigue() / 10.0));
			}
		}
	}

	/**
	 * Move all the animals by a vector
	 *
	 * @param x
	 * @param y
	 */
	public void moveAll(double x, double y) {
		for (Animal e : animals) {
			e.move(x, y);
		}
	}

	/**
	 * Show zoo statistics
	 */
	public void showStats() {
		// make variable to store counts
		int numBird = 0;
		int numLand = 0;
		int numWater = 0;
		// species count
		HashMap<String, Integer> species = new HashMap<>();
		for (Animal e : animals) {
			// count each species
			String specie = e.getSpecies();
			if (!species.containsKey(specie)) {
				species.put(specie, 1);
			} else {
				species.put(specie, species.get(specie) + 1);
			}
			// count animal type
			if (e instanceof LandAnim) {
				numLand++;
			} else if (e instanceof WaterAnim) {
				numWater++;
			} else {
				numBird++;
			}
		}

		// display type stats
		System.out.println("Animal Statistics:");
		System.out.println(numBird + " birds");
		System.out.println(numLand + " land animals");
		System.out.println(numWater + " aquatic creatures animals");

		// turn each specie into an output string
		String output = "";
		for (String e : species.keySet()) {
			output += e + ":" + species.get(e) + ", ";
		}
		output = output.substring(0, output.length() - 2);
		System.out.println(output);
	}

	/**
	 * Make all the animals make sound
	 */
	public void soundAll() {
		for (Animal e : animals) {
			System.out.println(e.getSound());
		}
	}
}
