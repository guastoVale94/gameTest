package world.tiles.nuvole;

import world.Assets;
import world.tiles.Tile;


public class nuvolaDestraBasso extends Tile {

	public nuvolaDestraBasso(int id) {
		super(Assets.nuvolaDestraBasso, id);
	}
@Override
        public boolean isSolid(){
		return true;
	}
}
