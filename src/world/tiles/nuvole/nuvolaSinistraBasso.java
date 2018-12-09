package world.tiles.nuvole;

import world.Assets;
import world.tiles.Tile;


public class nuvolaSinistraBasso extends Tile {

	public nuvolaSinistraBasso(int id) {
		super(Assets.nuvolaSinistraBasso, id);
	}
@Override
        public boolean isSolid(){
		return true;
	}
}
