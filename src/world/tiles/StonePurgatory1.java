package world.tiles;

import world.Assets;


public class StonePurgatory1 extends Tile {

	public StonePurgatory1(int id) {
		super(Assets.stone1, id);
	}
        @Override
	public boolean isSolid(){
		return true;
	}
}
