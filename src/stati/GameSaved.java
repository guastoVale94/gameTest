package stati;

import avvio.Handler;
import entita.Player;
import java.awt.Graphics;
import item.Potion;
import world.World;


public class GameSaved extends State {

 
	public GameSaved(Handler handler){
		super(handler);
		
	}
	
	@Override
	public void tick() {
		
               handler.getWorld().tick();
               
	}

	@Override
	public void render(Graphics g) {
            
               handler.getWorld().render(g);
             
        }
        public World getWorld(){
            return handler.getWorld();
        }

}
