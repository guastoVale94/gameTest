package stati;

import avvio.Game;
import avvio.Handler;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import world.Assets;
import static world.tiles.Tile.TILEHEIGHT;
import static world.tiles.Tile.TILEWIDTH;


public class GameOver extends State {

	public GameOver(Handler handler){
		super(handler);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
            try {
                BufferedImage image1 = ImageIO.read(new File("./src/res/menu/gameOver.jpg"));
                g.drawImage(image1, 100,100, null);
            } catch (IOException ex) {
                Logger.getLogger(GameOver.class.getName()).log(Level.SEVERE, null, ex);
            }
                       
	}
	
}
