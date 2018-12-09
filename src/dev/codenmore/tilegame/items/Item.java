package dev.codenmore.tilegame.items;

import static avvio.Game.hearts;
import avvio.Handler;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import world.Assets;



public class Item {
	
	// Handler
	
	public static Item[] items = new Item[256];
	public static Item potionItem = new Item(Assets.potion, "Potion", 0);
        //public static Item fioriBianchiItem = new Item(Assets.fioriBianchi, "Fiori", 1);
        
	protected boolean pickedUp;
	
	// Class
	
	public static final int ITEMWIDTH = 10, ITEMHEIGHT = 10;
	
	protected Handler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id;
	
	protected int x, y;
	protected Rectangle bounds;

	public Item(BufferedImage texture, String name, int id){
		this.texture = texture;
		this.name = name;
		this.id = id;
		pickedUp=false;
		bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);
		items[id] = this;
	}
	
	public void tick(){
            if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)){
                        if(hearts != 10){
                          hearts += 1;
                          pickedUp = true;
                        }
		}else
                    pickedUp=false;
        }
	
	public void render(Graphics g){
		if(handler == null)
			return;
		render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
	}
	
	public Item createNew(int x, int y){
		Item i = new Item(texture, name, id);
		i.setPosition(x, y);
		return i;
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}
	
	// Getters and Setters
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	

	public int getId() {
		return id;
	}
        public boolean isPickedUp() {
		return pickedUp;
	}
}
