/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoosim;

/**
 *
 * @author hhwl
 */
public class IOther implements IObject {

	private double direction; // degrees
	private double xPos;
	private double yPos;
	private double xSize;
	private double ySize;
	private int id;
	private String name;
	private String image;

	/**
	 *
	 * @param degrees
	 */
	@Override
	public void turn(int degrees) {
		setDirection(getDirection() + degrees);
	}

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

}
