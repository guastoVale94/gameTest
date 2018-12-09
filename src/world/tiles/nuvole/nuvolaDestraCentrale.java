package world.tiles.nuvole;

import world.Assets;
import world.tiles.Tile;


public class nuvolaDestraCentrale extends Tile {

	public nuvolaDestraCentrale(int id) {
		super(Assets.nuvolaDestraCentrale, id);
	}
@Override
        public boolean isSolid(){
		return true;
	}
}
