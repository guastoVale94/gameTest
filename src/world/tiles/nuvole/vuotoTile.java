package world.tiles.nuvole;

import world.Assets;
import world.tiles.Tile;


public class vuotoTile extends Tile {

	public vuotoTile(int id) {
		super(Assets.vuoto, id);
	}
@Override
        public boolean isSolid(){
		return true;
	}
}
