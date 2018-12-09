package stati;

import avvio.Handler;
import entita.Player;
import java.awt.Graphics;
import item.Potion;
import world.World;


public class GameState extends State {
	
	private World world;
        
        
        
	public GameState(Handler handler){
		super(handler);
                
                world = new World(handler,"src/res/heaven/nuvoleLast.txt");//cambia qui per caricare inferno e paradiso                
                
                handler.setWorld(world);
		
	}
	
	@Override
	public void tick() {
		
                world.tick();
               
	}

	@Override
	public void render(Graphics g) {
            
                world.render(g);
             
        }
        public World getWorld(){
            return world;
        }

}
