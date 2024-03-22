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
	private String image;
	private String sound;

	protected static double rad(double degrees) {
		return Math.toRadians(degrees);
	}

	public Animal(int id, String name, String species, Sex sex, double xPos, double yPos, double xSize, double ySize, double speed, double direction, double hunger, double fatigue, String image, String sound) {
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
	}

	protected static double[] matrixMultiply(double[][] A, double[] v) {
		double[] result = {A[0][0] * v[0] + A[0][1] * v[1], A[1][0] * v[0] + A[1][1] * v[1]};
		return result;
	}

	@Override
	public void move(double x, double y) {
		// degree arm = x unit vector
		double[] xUnit = {Math.cos(rad(direction)), Math.sin(rad(direction))};
		double[] yUnit = {Math.cos(rad(direction + 90)), Math.sin(rad(direction + 90))};
		double[][] matrix = {{xUnit[0], yUnit[0]}, {xUnit[1], yUnit[1]}};

		// calculate displacement
		double[] displace = matrixMultiply(matrix, new double[]{x, y});
		double newAngle = direction + Math.atan2(y, x);
		if (x < 0) { // arctan angle adjustment
			newAngle += 180;
		}

		// calculate how many frames to get to delta using only x coordinate
		double cycles = (getSpeed() * ZooSim.getDelta());

		for (int i = 0; i < Math.floor(cycles); i++) {
			setxPos(getxPos() + getSpeed());
			setyPos(getyPos() + displace[1]);
			setHunger(Math.min(100, getHunger() + Math.hypot(x, y) / getSpeed() / 100));
			setFatigue(Math.min(100, getFatigue() + Math.hypot(x, y) / getSpeed() / 100));
		}
	}

	@Override
	public void makeSound() {
		System.out.println(getSound());
	}

	@Override
	public void eat(String foo) {
		setHunger(Math.max(0, getHunger() - 10));
		System.out.println("Yummy " + foo + "!");
	}

	@Override
	public void sleep(double hours) {
		setFatigue(Math.max(0, getFatigue() - 10 * hours));

	}

	@Override
	public void turn(int degrees) {
		setDirection(getDirection() + degrees);
	}

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
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
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
}
