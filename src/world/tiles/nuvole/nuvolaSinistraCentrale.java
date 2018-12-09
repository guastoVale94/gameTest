package world.tiles.nuvole;

import world.Assets;
import world.tiles.Tile;


public class nuvolaSinistraCentrale extends Tile {

	public nuvolaSinistraCentrale(int id) {
		super(Assets.nuvolaSinistraCentrale, id);
	}
@Override
        public boolean isSolid(){
		return true;
	}
}
