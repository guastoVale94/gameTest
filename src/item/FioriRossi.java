package item;

import avvio.Handler;
import dev.codenmore.tilegame.items.Item;
import java.awt.Graphics;
import world.Assets;
import world.tiles.Tile;


public class FioriRossi extends StaticEntity {

	public FioriRossi(Handler handler, float x, float y) {
            //nemici prendo più grandi
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
                bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
	}

   
        
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
            	g.drawImage(Assets.fioriRossi, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
        @Override
	public void die(){

	}
}
