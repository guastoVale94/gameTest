package world.tiles.nuvole;

import world.Assets;
import world.tiles.Tile;


public class nuvolaSinistraAlto extends Tile {

	public nuvolaSinistraAlto(int id) {
		super(Assets.nuvolaSinistraAlto, id);
	}
@Override
        public boolean isSolid(){
		return true;
	}
}
