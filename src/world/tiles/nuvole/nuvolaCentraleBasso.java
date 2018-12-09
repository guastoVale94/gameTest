package world.tiles.nuvole;

import world.Assets;
import world.tiles.Tile;


public class nuvolaCentraleBasso extends Tile {

	public nuvolaCentraleBasso(int id) {
		super(Assets.nuvolaCentraleBasso, id);
	}
@Override
        public boolean isSolid(){
		return true;
	}
}
