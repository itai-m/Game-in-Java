import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Font {
	
	private final static int FONT_WIDTH = 61;
	private final static int FONT_HEIGHT = 52;
	private final static int HASKII_CAP_DIFF = 'a' - 'A';
	private final static int HASKII_NUM_0 = '0';
	
	private static Image img;
	
	///Constructor
	public static void init(){
		img  = Toolkit.getDefaultToolkit().getImage(TemplateHandler.getPath() + "font.png");
	}
	
	///Draw a letter with picture
	public static void drawLetter(char letter, int x, int y, int width, int height, Graphics g){
		if (('A' <= letter) && ('Z' >= letter)){
			letter += HASKII_CAP_DIFF;
		}
		if (('a' <= letter) && ('z' >= letter)){
			int col = (letter - 'a') / 25;
			int row = (letter - 'a') % 25;
			drawPartOfPic(col, row, x, y, width, height, g);
		}
		else if (('0' <= letter) && ('9' >= letter)){
			int row = letter - HASKII_NUM_0;
			drawPartOfPic(5, row, x, y, width, height, g);
		}
		else{
			switch (letter) {
			case ':':
				drawPartOfPic(4, 0, x, y, width, height, g);
				break;
			case '|':
				drawPartOfPic(4, 3, x, y, width, height, g);
				break;
			case '-':
				drawPartOfPic(4, 1, x, y, width, height, g);
				break;
			case '+':
				drawPartOfPic(4, 4, x, y, width, height, g);
				break;
			case '!':
				drawPartOfPic(4, 5, x, y, width, height, g);
				break;
			default:
				break;
			}
		}
	}
	
	//Draw just a part form the full picture
	private static void drawPartOfPic(int col, int row, int x, int y, int width, int height, Graphics g){
		g.drawImage(img, x, y, x + width, y + height, FONT_WIDTH * row, FONT_HEIGHT * col, FONT_WIDTH * (row + 1), FONT_HEIGHT * (col + 1), null);
	}
	
	///Draw a full string
	public static void drawString(String msg, int x, int y, int width, int height, Graphics g ){
		int strSize = msg.length();
		if (strSize == 0){
			return;
		}
		int letterSize = width / strSize;
		for (int i = 0; i < strSize ; i ++){
			Font.drawLetter(msg.charAt(i), x + i * letterSize, y, letterSize, height, g);
		}
	}
}
