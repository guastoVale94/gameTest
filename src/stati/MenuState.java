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


public class MenuState extends State {

    private boolean menu=true;
        
	public MenuState(Handler handler){
		super(handler);
	}

	@Override
	public void tick() {
             //System.out.println("tick del menu");

		getInput();
                if(!menu){
                    handler.getGame().setPause(false);
                    State.setState(handler.getGame().gameStateDue);
                }
	}
        private void getInput(){
              if(handler.getKeyManager().r)
                        menu=false;
              
            
	}
	@Override
	public void render(Graphics g) {
            //System.out.println("render del menu");

            try {
                if(menu){
                    //System.out.println("stampa del menu");
                    BufferedImage image1 = ImageIO.read(new File("./src/res/menu/pausa.jpeg"));
                    g.drawImage(image1, 0,0, null);
                }

                
            } catch (IOException ex) {
                Logger.getLogger(GameOver.class.getName()).log(Level.SEVERE, null, ex);
            }	
        }
	
}
