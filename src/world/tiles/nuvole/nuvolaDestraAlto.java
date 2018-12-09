package world.tiles.nuvole;

import world.Assets;
import world.tiles.Tile;


public class nuvolaDestraAlto extends Tile {

	public nuvolaDestraAlto(int id) {
		super(Assets.nuvolaDestraAlto, id);
	}
@Override
        public boolean isSolid(){
		return true;
	}
}
