package world.tiles;

import world.tiles.nuvole.vuotoTile;
import world.tiles.nuvole.nuvolaDestraCentrale;
import world.tiles.nuvole.nuvolaSinistraBasso;
import world.tiles.nuvole.nuvolaSinistraAlto;
import world.tiles.nuvole.nuvolaCentraleBasso;
import world.tiles.nuvole.nuvolaDestraBasso;
import world.tiles.nuvole.nuvolaCentraleCentraleDue;
import world.tiles.nuvole.nuvolaCentraleCentrale;
import world.tiles.nuvole.nuvolaCentraleAlto;
import world.tiles.nuvole.nuvolaSinistraCentrale;
import world.tiles.nuvole.nuvolaDestraAlto;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static world.Assets.vuoto;

public class Tile {
	
	//STATIC STUFF HERE
	//una volta tagliate le tile dal file,non serve piu rileggere da file,sono già disponibili nel vettore
        // basta cambiare i numeri del file txt
	public static Tile[] tiles = new Tile[256];
        
        // tile per inferno
        
        // tile per paradiso NON USATE
	
        // nuvole per paradiso
        public static Tile  nuvolaSinistraAlto = new nuvolaSinistraAlto(11);
        public static Tile  nuvolaCentraleAlto = new nuvolaCentraleAlto(12);
        public static Tile  nuvolaDestraAlto = new nuvolaDestraAlto(13);
        
        public static Tile  nuvolaSinistraCentrale = new nuvolaSinistraCentrale(14);
        public static Tile  nuvolaCentraleCentrale = new nuvolaCentraleCentrale(15);
        public static Tile  nuvolaDestraCentrale = new nuvolaDestraCentrale(16);
        
        
        public static Tile  nuvolaSinistraBasso = new nuvolaSinistraBasso(17);
        public static Tile  nuvolaCentraleBasso = new nuvolaCentraleBasso(18);
        public static Tile  nuvolaDestraBasso = new nuvolaDestraBasso(19);
        
        public static Tile  nuvolaCentraleCentraleDue = new nuvolaCentraleCentraleDue(20);
        public static Tile  vuotoTile = new vuotoTile(21);

        
        
        // tile per purgatorio
        public static Tile stone1 = new StonePurgatory1(0);
        public static Tile stone2 = new StonePurgatory2(1);
        // tile per inferno
	public static Tile magmaTile = new MagmaTile(3);
        public static Tile dirtTile = new DirtTile(4);
	public static Tile rocciaFuocoTile = new RocciaFuocoTile(7);
	//CLASS
	
	public static final int TILEWIDTH = 16, TILEHEIGHT = 16;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
	
}
