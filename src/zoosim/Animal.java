/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoosim;

/**
 *
 * @author hhwl
 */
public abstract class Animal implements IEntity {

	private Terrain terrain;
	private int id;
	private String name;
	private String species;
	private Sex sex;
	// in meters from bottom left corner
	private double xPos;
	private double yPos;
	// in meters
	private double xSize;
	private double ySize;
	private double speed; // meters/second
	private double direction; // degrees
	private double hunger; // from 0 to 100
	private double fatigue; // from 0 to 100
	private Image image;
	private String sound;

	/**
	 * Shortcut function to convert degrees to radians
	 *
	 * @param degrees
	 * @return radians
	 */
	protected static double rad(double degrees) {
		return Math.toRadians(degrees);
	}

	/**
	 * Default constructor to create an animal
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
	public Animal(int id, String name, String species, Sex sex, double xPos, double yPos, double xSize, double ySize, double speed, double direction, double hunger, double fatigue, Image image, String sound, Terrain terrain) {
		this.id = id;
		this.name = name;
		this.species = species;
		this.sex = sex;
		this.xPos = xPos;
		this.yPos = yPos;
		this.xSize = xSize;
		this.ySize = ySize;
		this.speed = speed;
		this.direction = direction;
		this.hunger = hunger;
		this.fatigue = fatigue;
		this.image = image;
		this.sound = sound;
		this.terrain = terrain;
	}

	/**
	 * Check if no stamina left
	 *
	 * @return
	 */
	public boolean noStamina() {
		if (hunger == 100) {
			System.out.println(name + " is too hungry to perform action!!!");
			return true;
		} else if (fatigue == 100) {
			System.out.println(name + " is too tired to perform action!!!");
			return true;
		}
		return false;
	}

	/**
	 * Move an animal by the vector specified (in its own coordinate system)
	 *
	 * @param x
	 * @param y
	 */
	@Override
	public void move(double x, double y) {
		if (noStamina()) {
			return;
		}
		// real direction
		double newAngle = getDirection() + Math.atan2(y, x);
		if (x < 0) { // arctan angle adjustment
			newAngle += 180;
		}
		newAngle %= 360;

		// real distance
		double dist = Math.hypot(x, y);

		// calculate how many frames to get to delta using only x coordinate
		double cycles = dist / (getSpeed() * ZooSim.DELTA);

		// using a for loop in case we're implementing it in real time
		for (int i = 0; i < Math.floor(cycles); i++) {
			// actually move
			setxPos(getxPos() + getSpeed() * Math.cos(rad(newAngle)));
			setyPos(getyPos() + getSpeed() * Math.sin(rad(newAngle)));
			// adjust hunger and fatigue
			setHunger(Math.min(100, getHunger() + dist / getSpeed() / 100));
			setFatigue(Math.min(100, getFatigue() + dist / getSpeed() / 100));
			if (noStamina()) {
				return;
			}
		}
	}

	/**
	 * Make the sound that the animal usually makes
	 */
	@Override
	public void makeSound() {
		if (noStamina()) {
			return;
		}
		System.out.println(getSound());
	}

	/**
	 * Eat an amount of food
	 *
	 * @param food
	 */
	@Override
	public void eat(String food) {
		setHunger(Math.max(0, getHunger() - 10));
		System.out.println("Yummy " + food + "!");
	}

	/**
	 * Sleep a number of hours
	 *
	 * @param hours
	 */
	@Override
	public void sleep(double hours) {
		setFatigue(Math.max(0, getFatigue() - 10 * hours));

	}

	/**
	 * Turn the animal a specific number of degrees
	 *
	 * @param degrees
	 */
	@Override
	public void turn(int degrees) {
		if (noStamina()) {
			return;
		}
		setDirection(getDirection() + degrees);
	}

	// place the animal at a particular location
	/**
	 *
	 * @param x
	 * @param y
	 */
	@Override
	public void place(int x, int y) {
		setxPos((double) x);
		setyPos((double) y);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * @return the sex
	 */
	public Sex getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(Sex sex) {
		this.sex = sex;
	}

	/**
	 * @return the xPos
	 */
	public double getxPos() {
		return xPos;
	}

	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	/**
	 * @return the yPos
	 */
	public double getyPos() {
		return yPos;
	}

	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(double yPos) {
		this.yPos = yPos;
	}

	/**
	 * @return the xSize
	 */
	public double getxSize() {
		return xSize;
	}

	/**
	 * @param xSize the xSize to set
	 */
	public void setxSize(double xSize) {
		this.xSize = xSize;
	}

	/**
	 * @return the ySize
	 */
	public double getySize() {
		return ySize;
	}

	/**
	 * @param ySize the ySize to set
	 */
	public void setySize(double ySize) {
		this.ySize = ySize;
	}

	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * @return the direction
	 */
	public double getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(double direction) {
		this.direction = direction % 360;
	}

	/**
	 * @return the hunger
	 */
	public double getHunger() {
		return hunger;
	}

	/**
	 * @param hunger the hunger to set
	 */
	public void setHunger(double hunger) {
		this.hunger = hunger;
	}

	/**
	 * @return the fatigue
	 */
	public double getFatigue() {
		return fatigue;
	}

	/**
	 * @param fatigue the fatigue to set
	 */
	public void setFatigue(double fatigue) {
		this.fatigue = fatigue;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * @return the sound
	 */
	public String getSound() {
		return sound;
	}

	/**
	 * @param sound the sound to set
	 */
	public void setSound(String sound) {
		this.sound = sound;
	}

	/**
	 * @return the terrain
	 */
	public Terrain getTerrain() {
		return terrain;
	}

	/**
	 * @param terrain the terrain to set
	 */
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
}
