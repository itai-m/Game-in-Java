import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

public class GameEngine {

	private Board board;
	private Player player;
	
	///Default constructor
	public GameEngine(){
		board = new Board();
		player = new Player();
	}
	
	///Constructors
	public GameEngine(int boardWidth, int boardHeight){
		board = new Board(10, 10, boardWidth, boardHeight);
		player = new Player(2, 2, boardWidth / 10, boardHeight / 10, boardWidth, boardHeight);
	}
	
	///Update the game
	public void update(){
		
	}
	
	///Resize the game
	public void setBoardSize(int boardWidth, int boardHeight){
		
	}
	
	///Player shot
	public void shot(){
		
	}
	
	///Draw the game
	public void draw(Graphics2D g, ImageObserver ob){
		
	}
	
	///Move the player to the right
	public void MoveRight(){
		
	}
	
	//Move the player to the up
	public void MoveUp(){
		
	}
		
	//Move the player to the left
	public void MoveLeft(){
		
	}
	
	//Move the player to the down
	public void MoveDown(){
		
	}
	
	///Get the board width
	public int getBoardWidth() {
		return board.getBoardWidth();
	}
	
	///Get the board height
	public int getBoardHeight() {
		return board.getBoardHeight();
	}
}
