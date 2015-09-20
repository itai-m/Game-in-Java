import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Shot extends Sprite{

	private final String PATH =  System.getProperty("user.dir") + "\\image\\";
	private final static int SPEED = 10;
	private final int[] SPRITE_WIDTH = {0, 50, 95, 145, 224, 307, 374};
	private final int STEP_PER_PIC = 14;
	private final int SPRITE_HEIGHT = 48;
	private final int MAX_STEP = STEP_PER_PIC * 8;
	
	private BufferedImage imag;
	private int height;
	private int width;
	private int step;
	
	public Shot(){
		super();
		initImages();
	}
	
	public Shot(float posX, float posY, float dirX, float dirY, int width, int height, int boardWidth, int boardHeight){
		super(posX, posY, dirX, dirY, SPEED, boardWidth, boardHeight);
		this.height = height;
		this.width = width;
		step = 0;
		initImages();
	}
	
	///Initialization the images
	private void initImages(){
		try {
			if (getDirection().getY() != 0){
				imag = ImageIO.read( new File( PATH + "shot.png" ) );
			}
			else{
				imag = ImageIO.read( new File( PATH + "shot.png" ) );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	///Check if the shot pass is time
	public boolean isOver(){
		if (step >= MAX_STEP)
			return true;
		return false;
	}
	
	///Draw the shot
	public void draw(Graphics2D g, ImageObserver ob){
		int x1 = (int)getPosition().getX();
		int y1 = (int)getPosition().getY();
		int x2 = (int)getPosition().getX();
		int y2 = (int)getPosition().getY();
		if (getDirection().getX() != 0){
			y1 -= height / 2;
			y2 += height /2;
			if (getDirection().getX() == 1){
				x1 -= width / 2;
				x2 += width / 2;
			}
			else{
				x1 += width / 2;
				x2 -= width / 2;
			}
			if (step < STEP_PER_PIC){
				g.drawImage(imag, x1, y1, x2, y2, SPRITE_WIDTH[0], 0, SPRITE_WIDTH[1], SPRITE_HEIGHT, ob);
			}
			else if (step < STEP_PER_PIC * 2){
				g.drawImage(imag, x1, y1, x2, y2, SPRITE_WIDTH[1], 0, SPRITE_WIDTH[2], SPRITE_HEIGHT, ob);
			}
			else if (step < STEP_PER_PIC * 3){
				g.drawImage(imag, x1, y1, x2, y2, SPRITE_WIDTH[2], 0, SPRITE_WIDTH[3], SPRITE_HEIGHT, ob);
			}
			else if (step < STEP_PER_PIC * 4){
				g.drawImage(imag, x1, y1, x2, y2, SPRITE_WIDTH[3], 0, SPRITE_WIDTH[4], SPRITE_HEIGHT, ob);
			}
			else if (step < STEP_PER_PIC * 5){
				g.drawImage(imag, x1, y1, x2, y2, SPRITE_WIDTH[4], 0, SPRITE_WIDTH[5], SPRITE_HEIGHT, ob);
			}
			else if (step >= STEP_PER_PIC * 5){
				g.drawImage(imag, x1, y1, x2, y2, SPRITE_WIDTH[5], 0, SPRITE_WIDTH[6], SPRITE_HEIGHT, ob);
			}
			
		}
		else{ 
			x1 -= width / 2;
			y1 -= height / 2 ;
			x2 += width / 2;
			y2 += height /2;
			if (getDirection().getY() == -1){
				
			}
			
			if (step < STEP_PER_PIC){
				//g.drawImage(imag, x1, y1, ob);
				g.drawImage(imag, x1, y1, x2, y2, 0, SPRITE_WIDTH[0], SPRITE_HEIGHT, SPRITE_WIDTH[1], ob);
			}
			else if (step < STEP_PER_PIC * 2){
				g.drawImage(imag, x1, y1, x2, y2, 0, SPRITE_WIDTH[1], SPRITE_HEIGHT, SPRITE_WIDTH[2], ob);
			}
			else if (step < STEP_PER_PIC * 3){
				g.drawImage(imag, x1, y1, x2, y2, 0, SPRITE_WIDTH[2], SPRITE_HEIGHT, SPRITE_WIDTH[3], ob);
			}
			else if (step < STEP_PER_PIC * 4){
				g.drawImage(imag, x1, y1, x2, y2, 0, SPRITE_WIDTH[3], SPRITE_HEIGHT, SPRITE_WIDTH[4], ob);
			}
			else if (step < STEP_PER_PIC * 5){
				g.drawImage(imag, x1, y1, x2, y2, 0, SPRITE_WIDTH[4], SPRITE_HEIGHT, SPRITE_WIDTH[5], ob);
			}
			else if (step >= STEP_PER_PIC * 5){
				g.drawImage(imag, x1, y1, x2, y2, 0, SPRITE_WIDTH[5], SPRITE_HEIGHT, SPRITE_WIDTH[6], ob);
			}
		}
		
	}

	///Get the height
	public int getHeight() {
		return height;
	}

	///Set the height
	public void setHeight(int height) {
		this.height = height;
	}

	///Get the width
	public int getWidth() {
		return width;
	}

	///Set the width
	public void setWidth(int width) {
		this.width = width;
	}
	
	///Move the shot
	public void move(){
		super.move();
		step++;
	}
	
	///Resizing the board size
	public void setBoardSize(int boardWidth, int boardHeight){
		super.setBoardSize(boardWidth, boardHeight);
	}
}
