package world.tiles.nuvole;

import world.Assets;
import world.tiles.Tile;


public class nuvolaCentraleAlto extends Tile {

	public nuvolaCentraleAlto(int id) {
		super(Assets.nuvolaCentraleAlto, id);
	}
@Override
        public boolean isSolid(){
		return true;
	}
}
